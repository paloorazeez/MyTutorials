package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableDiscoveryClient
@CrossOrigin
@EnableZuulProxy
public class SpringcloudTollusageApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudTollusageApiGatewayApplication.class, args);
	}
}
