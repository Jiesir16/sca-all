
# SCA-ALL Microservices Project

## 简介 (Introduction)

这是一个基于 Spring Cloud 架构的微服务项目，包含订单服务和商品服务。

## 项目结构 (Project Structure)
    sca-all
    ├── services 
    │ 
    ├── service-order # 订单服务 (Order Service) 
    │ 
    └── service-product # 商品服务 (Product Service) 
    ├── pom.xml # 父工程 POM (Parent POM) 
    └── README.md


## 技术栈 (Tech Stack)

- **Language**: Java 21
- **Framework**: Spring Boot, Spring Cloud
- **Build Tool**: Maven
- **Other**: Jakarta EE, Lombok

## 快速开始 (Quick Start)

### 前置条件 (Prerequisites)

- JDK 21
- Maven 3.x
- Docker (可选，用于中间件 / Optional, for middleware)

### 构建 (Build)

在项目根目录下执行 Maven 构建命令：

### 启动服务 (Running Services)

1. **Service Product**:
   进入 `services/service-product` 目录或在 IDE 中运行 `jiesir.z.ProductApplication`。

2. **Service Order**:
   进入 `services/service-order` 目录或在 IDE 中运行 `jiesir.z.OrderApplication`。

### 配置 (Configuration)

各服务的配置文件位于 `src/main/resources/application.yml`。请根据本地环境修改数据库或其他中间件配置。

## 模块说明 (Modules)

### service-product
商品服务模块，负责管理商品信息。

### service-order
订单服务模块，负责处理订单逻辑。