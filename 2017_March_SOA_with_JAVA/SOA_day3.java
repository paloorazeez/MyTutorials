											Day3
										============
										
Creating a CustomLoadBalancer
	IClientConfig - ribbon provides the implementation
	@RibbonClient(name="LB1",configuration=CustomLoadBalancer.class) in the main class
	
Resilience
	Circuit Breaker: Hystrix (by netflix)
	Hystrix default: 20 failures in 5 seconds
	-add hystrix dependency in the pom
	@EnableHystrix
	@HystrixCommand(fallbackMethod="fallbackMethodName")
		fallbackMethod should contain the same parameters and return type
	Commands can be called various ways
		* Asynchronously
		* Synchronously
		* Reactively
	Its mandatory to create interface if you are using feignclient for hystrix	
	
	
	
	ZUUL (by netflix acts as a gateway API)
	=====
	Facade: routing
	CORS-Cross Origin Resource Sharing
	reduces # remote calls
	routes calls to specific servers
	handles security/SSO
	handles caching
	protocol transaction
	optimized calls/Link expansion
	ZUUL also should be registered as MS
	
	
Dynamic Configuration Changes
=============================

Spring Cloud Bus
	Push configuration changes to client applications via messaging technology, like AMQP
	Broadcasts configuration changes to clients
		- Eliminate need for client pooling
	RabbitMq - is a messaging server(erlang is a dependency) (AMQP)
	
	1. make changes to your config file
		>
	2. post /bus/refresh to your config server
	3. broker ensures message delivery to client
	4. clients receive message and refresh themselves
	
	
	
	
		
	