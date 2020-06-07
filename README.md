为了隐私，隐藏了AWS的access key和secret key，要想代码可以运行，必须要自己新建DynamoDB的数据库

修改src/main/resources/application-template.properties为application-template.properties，并且填写自己的access key和secret key

同时，GSI查询必须建立在GSI已经建立好了的情况，否则代码可能运行失败。

###SQL与NoSQL的区别:
https://docs.aws.amazon.com/zh_cn/amazondynamodb/latest/developerguide/SQLtoNoSQL.html

###DynamoDB 概念
https://docs.aws.amazon.com/zh_cn/amazondynamodb/latest/developerguide/HowItWorks.CoreComponents.html

###DynamoDB API
https://docs.aws.amazon.com/zh_cn/amazondynamodb/latest/developerguide/DynamoDBMapper.html
https://docs.aws.amazon.com/zh_cn/amazondynamodb/latest/developerguide/HowItWorks.API.html

###Practice
在console完成了如下：
projectName (S)	projectType (S)	active (BOOL)	binarytest (BS)	class (NS)	count (N)	hobby (M)	listtest (L)	text (SS)	memeberName (S)	startDate (S)
j	med	TRUE	{ 1000, 1010 } 	{ 3, 2, 1 } 	2	{  "lego" : { "S" : "1" }}	[  { "NULL" : true },  { "S" : "testl" }]	{ "1", "2" } 	jaden	20200228
m	short	TRUE	{ 1000, 1010 } 	{ 3, 2, 1 } 	2	{  "lego" : { "S" : "1" }}	[  { "NULL" : true },  { "S" : "testl" }]	{ "1", "2" } 		
p	long	FALSE	{ 1000, 1001 } 	{ 3, 2, 1 } 	2	{  "lego" : { "S" : "1" }}	[  { "NULL" : true },  { "S" : "testl" }]	{ "1", "2" } 	yongzhi	20200330
r	long	TRUE	{ 1000, 1010 } 	{ 3, 2, 1 } 	2	{  "lego" : { "S" : "1" }}	[  { "NULL" : true },  { "S" : "testl" }]	{ "1", "2" } 	jaden	20200330
t	long	FALSE	{ 1001, 1010 } 	{ 3, 2, 1 } 	2	{  "lego" : { "S" : "1" }}	[  { "NULL" : true },  { "S" : "testl" }]	{ "1", "2" } 	yongzhi	20200330

###Questions
1. NoSQL：
键值(Key-Value)存储数据库
列存储数据库。
文档型数据库
图形(Graph)数据库

2. 下面哪些场景SQL不能发挥作用?
数据不是结构化的

3. DynamoDB有哪两种类型的主键?
分区键,
分区键和排序键 – 称为复合主键
https://docs.aws.amazon.com/zh_cn/amazondynamodb/latest/developerguide/HowItWorks.CoreComponents.html

4. 不支持array

5. DynamoDB支持哪两种类型的索引,这两种索引的区别是什么?
在 DynamoDB 中使用全局二级索引
本地二级索引
https://docs.aws.amazon.com/zh_cn/amazondynamodb/latest/developerguide/SecondaryIndexes.html

6. Coding
Done in this repo

7. DynamoDB 事务 
Done in this repo

8. 备份与还原
https://docs.aws.amazon.com/zh_cn/amazondynamodb/latest/developerguide/BackupRestore.html
