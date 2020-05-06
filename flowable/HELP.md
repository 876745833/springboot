# flowable-demo基础

## 搭建flowable





## flowable-ui

### docker方式

```linux
#在docker中运行命令
docker run -p 8080:8080 flowable/all-in-one
```



### war包方式

1. 官方下载flowable6.5	下载地址：https://flowable.com/open-source/downloads/	

2. 把war包下边的项目放入tomcat中运行

   ​	**注意：放入之前要修改war包项目的几个地方**

   - **WEB-INF\classes里边的application-dev.properties和flowable-default.properties的数据库配置**
   - **WEB-INF\lib种放入对应数据库的jar包**

   



**注意：远程访问ip换成自己虚拟机地址**

|                     **应用名称**                     |                         **入口链接**                         |
| :--------------------------------------------------: | :----------------------------------------------------------: |
|                      后台管理：                      |             http://localhost:8080/flowable-admin             |
|                    流程定义管理：                    |            http://localhost:8080/flowable-modeler            |
|                   用户组权限管理：                   |              http://localhost:8080/flowable-idm              |
|                    用户任务管理：                    |             http://localhost:8080/flowable-task              |
|                         API                          | [http://localhost:8080/flowable-rest/docs/ ](http://localhost:8080/flowable-rest/docs/) |
| 后台管理、流程定义管理、用户组权限管理、用户任务管理 |                   账号：admin  密码：test                    |
|                         API                          |                 账号：rest-admin  密码：test                 |





## 绘制流程图



## 部署流程



## 走流程
