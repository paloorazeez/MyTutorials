package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RibbonClient(name="LB1",configuration=CustomLoadBalancer.class)
public class SpringcloudTollusageFeignClientmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudTollusageFeignClientmsApplication.class, args);
	}
}
