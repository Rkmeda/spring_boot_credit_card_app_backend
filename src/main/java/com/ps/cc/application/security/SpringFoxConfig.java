package com.ps.cc.application.security;


import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.ps.cc.application"))
				.paths(PathSelectors.regex("/creditCard.*")).build().apiInfo(apiInfo()).useDefaultResponseMessages(false)
				.globalResponses(HttpMethod.GET,
						Arrays.asList(new ResponseBuilder().code("500").description("Internal Server Error").build(),
								new ResponseBuilder().code("403").description("Forbidden!!!!!").build()))
				.globalResponses(HttpMethod.POST,
						Arrays.asList(new ResponseBuilder().code("500").description("Internal Server Error").build(),
								new ResponseBuilder().code("403").description("Forbidden!!!!!").build()));

	}

	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo("My REST API", "Credit Card Application functionality ", "API TOS", "Terms of service",
				new Contact("RamaKrishna", "www.example.com", "ramakrishnameda22@gmail.com"), "License of API",
				"API license URL", Collections.emptyList());
		return apiInfo;
	}
}
