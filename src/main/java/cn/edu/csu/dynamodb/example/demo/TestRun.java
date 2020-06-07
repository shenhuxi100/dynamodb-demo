package cn.edu.csu.dynamodb.example.demo;

import cn.edu.csu.dynamodb.example.demo.entity.User;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.TransactionWriteRequest;
import cn.edu.csu.dynamodb.example.demo.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Data
public class TestRun implements InitializingBean {

    @Autowired
    UserRepository userRepository;

    static AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
    static DynamoDBMapper mapper = new DynamoDBMapper(client);;

    @Override
    @Transactional
    public void afterPropertiesSet() throws Exception{
        // 增加
        User adduser = new User();
        adduser.setSk("AddInfo");
        adduser.setFirstName("liuAdd");
        adduser.setLastName("yongzhiAdd");
        userRepository.save(adduser);
        System.out.println("保存用户成功");

        // 查询
        System.out.println(userRepository.findByFirstName("liu").get(0));
        System.out.println(userRepository.findByLastName("yongzhiTransaction").get(0));
        List<User> res = userRepository.findUsersByGSI("liu");
        for(User user: res) {
            System.out.println(user);
        }

        // 修改 和 事务
        TransactionWriteRequest transactionWriteRequest = new TransactionWriteRequest();
        User user = userRepository.findByLastName("yongzhiUpdated").get(0);
        user.setLastName("yongzhiTransaction");

        transactionWriteRequest.addUpdate(user);
        transactionWriteRequest.addUpdate(updateUser());
        mapper.transactionWrite(transactionWriteRequest);
    }

    private User updateUser() {
        User user = userRepository.findByLastName("yongzhiUpdated").get(1000);
        user.setLastName("yongzhiTransaction");
        int i = 1/0;
        return user;
    }
}
