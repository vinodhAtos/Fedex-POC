package com.atos.dawg.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableWebMvc
public class DawgConfiguration  implements WebMvcConfigurer{

	
	  @Override 
	  public void addCorsMappings(CorsRegistry registry) {
		  registry.addMapping("/**").allowedMethods("GET","POST").allowedOrigins("http://localhost:8080");; 
	  }
	 
	 
	 @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {

	        registry
	                .addResourceHandler("swagger-ui.html")
	                .addResourceLocations("classpath:/META-INF/resources/");

	        registry
	                .addResourceHandler("/webjars/**")
	                .addResourceLocations("classpath:/META-INF/resources/webjars/");
	    }

	    @Bean
	    public Docket apiDocket() {

	        return new Docket(DocumentationType.SWAGGER_2)
	                .apiInfo(getApiInfo())
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("com.atos.dawg.controller"))
	                .paths(PathSelectors.any())
	                .build();
	    }

	    private ApiInfo getApiInfo() {

	        return new ApiInfoBuilder()
	                .title("Swagger API Doc")
	                .description("More description about the API")
	                .version("1.0.0")
	                .build();
	    }
	}
