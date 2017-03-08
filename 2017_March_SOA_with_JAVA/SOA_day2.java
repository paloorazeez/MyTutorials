													Day2
												=============

Platform As a Service - PAS
Microservices
-------------
actuator - gives you all dependencies
	
Centralized Config server
	- any application can use the config
	- Flat files or Git can be used 
	- communication is through REST
Thymeleaf -templating engine for UI
	bootstrap.properties: always contains the environment specific properties
	
	@EnableConfigurationServer
	server:
  port: 8888
spring:
  cloud:
    config:
      server:
        git:
          uri: https://github.com/krishnamurthypradeep/springcloud-config
          search-paths:
          - 'station*'
		  
		  
	
Service Registration and Service Discovery
	- Consul(), Zookeeper, eureka(netflix)
	- enables service to service communication
	-downloaded consul from hashicorp
	dependencies: actuator, config client, mongodb, consul discovery
	application name is mandatory and should be unique while registering microservice
	
	@Repository vs @RestResource(path="/tolls")
	@RestController: class annotated with this will be exposed as a REST webservice
	
	@EnableDiscoveryClient: registering as a microservice to consul
	
	changing the consul port
		consul agent --dev -http-port 8700
		
	config first approach
	Feign: declarative webservice (REST)client
	
	Ping: used to test if the service is up or down
	Load Balancer: ZoneAwareLoadBalancer (Clietnt side Load balancer)
	Rule: single module of intelligence that makes the decision on whether to call or not.
	
	
	
	
	
	
	
	
													
													