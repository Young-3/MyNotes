---
typora-root-url: images
---

# 		Spring



spring下载

`<https://repo.spring.io/list/libs-release-local/org/springframework/spring/>` 



问题

`Caused by: org.springframework.beans.BeanInstantiationException: Failed to instantiate [main.org.young.entity.Teacher]: No default constructor found; nested exception is java.lang.NoSuchMethodException: main.org.young.entity.Teacher.<init>()`

需要有一个无参构造器



spring 三种方式注入属性 'set'  'construction'  'p命名空间'

idea引入命名空间



注解方式 扫描器



```
<!--配置数据库相关-事务-->
<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">
    <property name="driverClassName" value="com.mysql.cj.jdbc.Driver"></property>
    <property name="url" value="jdbc:mysql://localhost:3306/user"></property>
    <property name="username" value="root"></property>
    <property name="password" value="10010.com"></property>
</bean>

<!--配置事务管理器transactionManager-->
<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
    <property name="dataSource" ref="dataSource"></property>
</bean>


<!--增加事务的支持-->
<tx:annotation-driven transaction-manager="transactionManager"></tx:annotation-driven>
```





`Exception in thread "main" org.springframework.beans.factory.xml.XmlBeanDefinitionStoreException: Line 157 in XML document from class path resource [applicationContext.xml] is invalid; nested exception is org.xml.sax.SAXParseException; lineNumber: 157; columnNumber: 7; The element type "aop:pointcut" must be terminated by the matching end-tag "</aop:pointcut>".`

正确`<aop:pointcut id="poincut1" expression="execution(public void main.org.young.service.serviceImpl.StudentServiceImpl.addStudent(main.org.young.entity.Student))"/>`

我犯的错误：后面加了`<aop:poincut/>`,`    以及前面加了/













1、问题描述
做项目时遇到这个问题`：Element 'beans' cannot have character [children],because the type's content type is element-only.`  翻译为：元素 'beans' 必须不含字符 [子级], 因为该类型的内容类型为“仅元素"。

2、问题原因
配置文件中的beans节点下面只能是元素节点，不能有字符或文本存在。



IDEA aop两次实例化问题

错误注解：`@Before("execution(public * addStudent(..))")//属性：定义切点`

正确注解：`@Before("execution(public * main.org.young.service.serviceImpl.StudentServiceImpl.addStudent(..))")//属性：定义切点`

原因：因为IDEA会识别dao的addStudent（）和service的addStudent（），所以会实例化两次

![](/idea实例化两次.png)