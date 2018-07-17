# Spring Cloud Bus Server

Dynamic configuration updates.

Spring Cloud Bus is a solution that enables the spring cloud config server to broadcast changes to spring cloud clients.

- Eliminates any need for clients to poll the config server periodically or push the actuator endpoint to refresh each client 
because the spring cloud bus will do it (post on refresh endpoint) automatically.
- Based on Messaging Technology (AMQP -> RabbitMQ or Apache Kafka) where clients become subscribers to configuration changes.
- Spring Cloud Bus works automatically with RabbitMQ on localhost.

Obs: The refresh only affects the log level and beans that are marked with at configuration properties or at refresh scope 
(singleton scope). It doesn't reload all the application context to prevent failures.

Starter: _spring-cloud-config-bus-amqp_ 


**RUN**

Run RabbitMQ with docker:

`$ docker run -p 5672:5672 rabbitmq`

Run the config server:

`$ ./mvnw clean spring-boot:run`


**E.g.**

**Retrive DEFAULT profile properties:**<br>
`$ curl http://localhost:8002/config-client/default
`

```json
{  
   name:"config-client",
   profiles:[  
      "default"
   ],
   label:null,
   version:"24b0b5240cf0d900235aeb745476c46928ed1137",
   state:null,
   propertySources:[  
      {  
         name:"https://github.com/fpjunqueira/spring-cloud-netflix-playground/spring-cloud-bus-server/config/config-client.yml",
         source:{  
            message:"hello spring cloud bus"
         }
      }
   ]
}
```

**Retrive DEV profile properties:**<br>
`$ curl http://localhost:8002/config-client/dev
`

```json
{  
   name:"config-client",
   profiles:[  
      "dev"
   ],
   label:null,
   version:"24b0b5240cf0d900235aeb745476c46928ed1137",
   state:null,
   propertySources:[  
      {  
         name:"https://github.com/fpjunqueira/spring-cloud-netflix-playground/spring-cloud-bus-server/config/config-client-dev.yml",
         source:{  
            message:"hello spring cloud bus from dev profile"
         }
      },
      {  
         name:"https://github.com/fpjunqueira/spring-cloud-netflix-playground/spring-cloud-bus-server/config/config-client.yml",
         source:{  
            message:"hello spring cloud bus"
         }
      }
   ]
}
```

**Retrive QA profile properties:**<br>
`$ curl http://localhost:8002/config-client/qa
`

```json
{  
   name:"config-client",
   profiles:[  
      "qa"
   ],
   label:null,
   version:"24b0b5240cf0d900235aeb745476c46928ed1137",
   state:null,
   propertySources:[  
      {  
         name:"https://github.com/fpjunqueira/spring-cloud-netflix-playground/spring-cloud-bus-server/config/config-client-qa.yml",
         source:{  
            message:"hello spring cloud bus from qa profile"
         }
      },
      {  
         name:"https://github.com/fpjunqueira/spring-cloud-netflix-playground/spring-cloud-bus-server/config/config-client.yml",
         source:{  
            message:"hello spring cloud bus"
         }
      }
   ]
}
```

**Retrive PROD profile properties**:<br>
`$ curl http://localhost:8002/config-client/prod`

```json
{  
   name:"config-client",
   profiles:[  
      "prod"
   ],
   label:null,
   version:"24b0b5240cf0d900235aeb745476c46928ed1137",
   state:null,
   propertySources:[  
      {  
         name:"https://github.com/fpjunqueira/spring-cloud-netflix-playground/spring-cloud-bus-server/config/config-client-prod.yml",
         source:{  
            message:"hello spring cloud bus from prod profile"
         }
      },
      {  
         name:"https://github.com/fpjunqueira/spring-cloud-netflix-playground/spring-cloud-bus-server/config/config-client.yml",
         source:{  
            message:"hello spring cloud bus"
         }
      }
   ]
}
```

**Refresh Clients** <br>

Refresh config-clients after commit changes on config-server:

`$ curl --request POST http://localhost:8002/actuator/bus-refresh
`


**TODO**

-> post changes to a specific client
