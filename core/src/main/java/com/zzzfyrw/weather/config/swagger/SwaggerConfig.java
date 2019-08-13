package com.zzzfyrw.weather.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket createApi(){

        ParameterBuilder headers = new ParameterBuilder();
        List<Parameter> params = new ArrayList<>();
        headers.name("token").description("登录令牌")
                .modelRef(new ModelRef("String")).parameterType("header")
                .required(false).build();
        params.add(headers.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zzzfyrw.weather.api"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(params);
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("天气小程序")
                .version("0.0.1")
                .build();
    }

}
