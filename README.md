# Spring Cloud Netflix Playground

[![Build Status](https://travis-ci.org/fpjunqueira/spring-cloud-netflix-playground.svg?branch=master)](https://travis-ci.org/fpjunqueira/spring-cloud-netflix-playground)

_Just playing around microservices based on spring-cloud-netflix_

The intention of this project is to provide with a help of Spring Cloud Netflix a basic configuration of the main communication patterns between micro-services such as API gateway (Zull), service discovery (Eureka), circuit breaker (Hystrix) and load balancer (Ribbon), as well as a configuration server module (Spring Cloud Config) and another module for authentication based on OAuth2.

**Build Projects**

`$ ./mvnw clean install
`

**RUN**

`$ docker-compose up --scale eureka-client=2`

`$ curl http://localhost:8080/api/hystrix-service/eureka-client-repository-url/eureka-client`

**Eureka Dashboard**

http://localhost:8010/


**TODO Modules**

- Swagger
- Server resource A
- Server resource B
- Oauth2/JWT 
- Sleuth
- Zipkin
- Turbine
- Spring Boot Admin

**TODO Resources**

- Create Resource Server A
- Create Resource Server B
- Register both servers in eureka
- Intercomunicate with feign calls
- Enable Ribbon Client
- Enable Hystrix
- Config Zull Gateway
- Config swagger
- Eureka dashboard Image/link
- Swagger Image/link
- Replication eureka

**TODO Docker Compose**

- Dspring.active.profile=docker
- docker-compose build
- expose hystrix dashboard port
- spring cloud bus docker-compose
- rabbit-mq docker-compose
- push to dockerhub
- docker mvn plugin

**Cloud**

- AWS EC2/ECS
- Kubernetes
- Terraform
