# 线上剧本杀预约系统

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

基于微信开发者工具 + SpringBoot + Mysql的线上剧本杀预约系统，包含用户端小程序和商家管理后台。

## 功能列表

### 用户端（微信小程序）
- 用户注册/登录
- 剧本浏览与搜索
  - 多条件筛选（类型、难度、人数等）
  - 关键词搜索
  - 剧本排行榜
- 预约管理
  - 预约/取消剧本
  - 历史订单查看
- 收藏功能
  - 收藏/取消收藏剧本
- 组队情况
  - 组队情况
  - 取消约车
- 剧本详情查看
  - 剧本介绍
  - 剧本评分
  - 剧本创作团队

### 商家端（Web管理后台）
- 剧本管理
  - 剧本CRUD操作
  - 剧本状态管理
- 订单管理
  - 订单状态管理
  - 订单统计
- 用户管理
  - 用户信息查看
  - 用户状态管理
- 数据统计
  - 热门剧本分析
  - 用户活跃度统计
  - 营收数据可视化

## 技术栈

- **前端**: 微信开发者工具 (用于开发微信小程序)
- **后端**: Spring Boot
- **数据库**: MySQL
- **其他**: 使用RESTful API进行前后端交互

### 前端
-  微信开发者工具 (用于开发微信小程序)
- WXML/WXSS
- JavaScript

### 后端
- Spring Boot
- MySQL 
- MyBatis

### 基础设施
- Maven

## 快速开始

### 环境要求
- JDK 1.8+
- MySQL 8.0+
- 微信开发者工具

### 克隆仓库
`git clone https://github.com/apricity0069/Murder_scenario.git`<br>
`cd Murder_scenario`

### 数据库配置
- 创建数据库并导入提供的SQL文件。
- 修改`src/main/resources/application.properties`中的数据库连接设置。

### 后端启动
`mvn clean install `<br>
`mvn spring-boot:run`

### 微信小程序端
- 使用微信开发者工具打开项目中的小程序目录。
- 根据需要修改'app.js'中的服务器地址。<br>
``` const baseUrl = 'http://127.0.0.1:8080/api/v1';```

 ### 访问商家端
打开浏览器，输入部署的服务器地址加上相应的路径即可访问商家管理界面。

## 项目页面展示
### 用户端（微信小程序）
![用户登录界面](/images/login.png) ![首页界面](/images/index.jpg)  
![剧本库界面](/images/jb.jpg) ![详情界面](/images/detail.jpg) 
![个人界面](/images/personal.jpg)  ![剧本排行榜界面](/images/ranking.jpg) 
![组队界面](/images/teamUp.jpg)  


### 商家端（Web管理后台）
![剧本管理界面](/images/jbManage.jpg) ![用户管理界面](/images/usersManage.jpg) 
![订单管理界面](/images/ddManage.jpg) ![数据统计界面](/images/data_stat.jpg) 

