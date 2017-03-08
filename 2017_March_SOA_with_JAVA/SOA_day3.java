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
	