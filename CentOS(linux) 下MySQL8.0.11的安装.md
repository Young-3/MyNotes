## CentOS(linux) 下MySQL8.0.11的安装

------

系统
CentOS 7.4
安装软件
MySQL8.0.11

------

- 下载[MySQL yum源](https://dev.mysql.com/downloads/repo/yum/) 

```
wget https://dev.mysql.com/get/mysql80-community-release-el7-1.noarch.rpm
```

- 安装yum源

```
yum localinstall mysql80-community-release-el7-1.noarch.rpm
```

- 更新yum源

```
yum clean all
yum makecache
```

- 创建Mysql账户

```
groupadd mysql
useradd -g mysql mysql
```

- 开始安装MySQL

```
yum install mysql-community-server
```

- 启动MySQL

```
systemctl  start  mysqld
```

- 查看初始化密码

```
cat /var/log/mysqld.log | grep password
```

![图片描述](https://segmentfault.com/img/bVbdLgv?w=1130&h=29)

- 登录MySQL

```
mysql -u root -p
```

- 修改初始化密码（密码一定要大小写字母+数字+符号，如：Aa-123456789）

```
ALTER USER 'root'@'localhost' IDENTIFIED BY 'yourpassword';
```

- 远程设置

```
选择MySQL数据库，因为里面储存了用户信息的user表
use mysql;
更改'root'账号的访问权限
update user set host='%' where user='root';
```

- 在 mysql 数据库的 user 表中查看当前 root 用户的相关信息

```select host, user, authentication_string, plugin from user;```

查看表格中 root 用户的 host，默认应该显示的 localhost，只支持本地访问，不允许远程访问。

- 授权root用户可以远程登陆

```
GRANT ALL ON *.* TO 'root'@'%';      mysql8的用法，下面是5.7
FLUSH PRIVILEGES;
```

- 修改加密规则永不过期 mysql8

  ```
  ALTER USER 'root'@'%' IDENTIFIED BY 'yourpassword' PASSWORD EXPIRE NEVER;
  ```

- 更新密码规则mysql8

  ```
  ALTER USER 'root'@'%' IDENTIFIED WITH mysql_native_password BY 'yourpassword';
  ```

  

  

- mysql5.7

- 允许任何主机访问数据库

```
GRANT ALL PRIVILEGES ON *.* TO 'root'@'%'WITH GRANT OPTION;
FLUSH PRIVILEGES;
```

- 允许myuser用户使用mypassword密码从任何主机连接到mysql服务器

```
GRANT ALL PRIVILEGES ON *.* TO 'myuser'@'%'IDENTIFIED BY 'mypassword' WITH GRANT OPTION;
```

- 允许用户myuser从ip为192.168.1.6的主机连接到mysql服务器，并使用mypassword作为密码

```
GRANT ALL PRIVILEGES ON *.* TO 'myuser'@'192.168.1.3'IDENTIFIED BY 'mypassword' WITH GRANT OPTION;
```



- **端口**

- 在 Centos 7 或 RHEL 7 或 Fedora 中防火墙由 firewalld 来管理，而不是 iptables。
  一、firewalld 防火墙

  语法命令如下：启用区域端口和协议组合

  ```
  firewall-cmd [--zone=<zone>] --add-port=<port>[-<port>]/<protocol> [--timeout=<seconds>]
  ```

  此举将启用端口和协议的组合。
  端口可以是一个单独的端口 <port> 或者是一个端口范围 <port>-<port>。
  协议可以是 tcp 或 udp。

  查看 firewalld 状态

  ```systemctl status firewalld```

   

  开启 firewalld

      systemctl start firewalld

  
  开放端口

      // --permanent 永久生效,没有此参数重启后失效
      
      firewall-cmd --zone=public --add-port=80/tcp --permanent 
      
      firewall-cmd --zone=public --add-port=1000-2000/tcp --permanent 
  

  
  重新载入

      firewall-cmd --reload

  
  查看

      firewall-cmd --zone=public --query-port=80/tcp

  
  删除

      firewall-cmd --zone=public --remove-port=80/tcp --permanent

  二、iptables 防火墙

  也可以还原传统的管理方式使用 iptables

      systemctl stop firewalld  
      
      systemctl mask firewalld  
  

  安装 iptables-services

      yum install iptables-services  

  设置开机启动

      systemctl enable iptables

  操作命令

      systemctl stop iptables  
      
      systemctl start iptables  
      
      systemctl restart iptables  
      
      systemctl reload iptables 
  

  保存设置

      service iptables save

  开放某个端口 在 /etc/sysconfig/iptables 里添加

  ```A RH-Firewall-1-INPUT -m state --state NEW -m tcp -p tcp --dport 8080 -j ACCEPT```

  
