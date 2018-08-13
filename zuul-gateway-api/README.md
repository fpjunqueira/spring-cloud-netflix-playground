# Zull API Gateway

**Gateway API**

- Provides a server side backend that's custom made for the needs of the client applications;
- It simplifies their access needs by providing a single point of contact for calling into the backend microservices;
- Provides a single place in the architeture where security can be applied (authentication);
- Potentially fewer trips to the backend;
- Link expansion (Hateoas integration);
- No CORS Required;
- Handles caching;
- Handles protocol translation;
- Etc.

**Zuul**

- Router and Load Balancer;
- Starter: spring-cloud-starter-zuul;
- Annotation: @EnableZuulProxy;
- Includes Ribbon and Hystrix;
- Eureka client ids become URIs

**Routes**

localhost:8080/hystrix-client --> localhost:44805/


**Docker**

`$ docker network create --driver bridge spring-cloud-network
`

`$ docker build -f Dockerfile -t fjunqueira/spring-cloud-playground-zuul-gateway-api .
`

`$ docker run -it --name zuul-gateway-api -p 8080:8080 --network spring-cloud-network fjunqueira/spring-cloud-playground-zuul-gateway-api
`

**Route to hystrix-client**

`$ curl http://localhost:8080/api/hystrix-service/eureka-client-repository-url/eureka-client`
