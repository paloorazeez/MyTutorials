package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class SpringcloudOrdermsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudOrdermsApplication.class, args);
	}
	
	@Bean
	public Docket newApi()
	{
		return new Docket(DocumentationType.SWAGGER_2).groupName("tollusagems").apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("TollUsage MS").
				description("Toll Microservice")
				.termsOfServiceUrl("http://sg.com").contact("xyz")
				.license("Xyz license").version("3.0").build();
	}
}
