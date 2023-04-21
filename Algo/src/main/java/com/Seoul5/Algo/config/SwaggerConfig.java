package com.Seoul5.Algo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Controller
public class SwaggerConfig {

//	@Bean
//	public Docket api() {
//		final ApiInfo apiInfo = new ApiInfoBuilder().title("")
//				.description("")
//				.contact(new Contact("")).license("MIT License")
//				.version("1.0").build();
//		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo).select()
//				.apis(RequestHandlerSelectors.basePackage("com.Seoul5.Algo.controller"))
//				.paths(PathSelectors.ant("/**/*api/**")).build();
//	}
}
