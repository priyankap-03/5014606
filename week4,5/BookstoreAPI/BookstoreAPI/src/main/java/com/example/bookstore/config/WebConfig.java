package com.example.bookstore.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer
                .favorParameter(true) // Enable query parameter-based negotiation
                .parameterName("mediaType");
                  	 
//                .mediaType("json", MediaType.APPLICATION_JSON)
//                .mediaType("xml", MediaType.Application.XML);
    }
}
