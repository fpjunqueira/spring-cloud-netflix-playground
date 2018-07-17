# Spring Cloud Bus Client

A simple client that dynamically retrivies a message from config-server with a little help from spring cloud bus and amqp messaging.

**RUN**

`$ ./mvnw clean spring-boot:run`


**E.g.**

**Retrive a message based on DEFAULT profile:**<br>
`$ ./mvnw clean spring-boot:run
`

```
$ curl http://localhost:8080/message
hello spring cloud bus
```

Commit changes in default profile on config-server:

_/spring-cloud-netflix-playground/spring-cloud-bus-server/config/config-client.yml_

Before: <br>
_message: hello spring cloud bus_

After: <br>
_message: hello spring cloud bus with some changes !!!_


```
$ git add . && git commit -m"Testing Config Changes" && git push origin master

$ curl --request POST http://localhost:8002/actuator/bus-refresh

$ curl http://localhost:8080/message
hello spring cloud bus with some changes !!!
```



**Retrive message based on DEV profile:**<br>
`$ ./mvnw clean spring-boot:run -Dspring.profiles.active=dev
`

```
$ curl http://localhost:8080/message
hello spring cloud bus from dev profile
```

**Retrive message based on QA profile:**<br>
`$ ./mvnw clean spring-boot:run g.profiles.active=qa
`

```
$ curl http://localhost:8080/message
hello spring cloud bus from qa profile
```

**Retrive message based on PROD profile**:<br>
`$ ./mvnw clean spring-boot:run -Dspring.profiles.active=prod
`

```
$ curl http://localhost:8080/message
hello spring cloud bus from prod profile
```

