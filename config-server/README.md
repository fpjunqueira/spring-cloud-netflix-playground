# Spring Cloud Config Server

- Should typically run on several instances
- Client application can control policy of how to handle missing config server
- spring.cloud.config.facilFast=true (says that will not going to run without a configuration server)
- Config Server settings override local setting, so provide local fallback settings

