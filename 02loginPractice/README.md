## 功能
注册登陆
注册数据库插入用户密码(insert into table (..) values (..) )
登陆校验数据库中的用户(select where)
## 数据库创建：
CREATE DATABASE loginPrac;
USE loginPrac;
CREATE TABLE USER2(
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(32) UNIQUE NOT NULL,
    PASSWORD VARCHAR(32) NOT NULL
);
## 版本
junit 4.10
mysql 8.0.12
tomcat 9.0.38
jdk 1.8

