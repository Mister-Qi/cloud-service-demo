package com.ms.robbin.config;

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
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author qi qi
 * @version 1.0
 * @created
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi(){
        /*
            // for some scenarios ,we need pass some fixed params every included in the header
         */

        ParameterBuilder parameterBuilder = new ParameterBuilder();
        ArrayList<Parameter> parameters = new ArrayList<>();
        Parameter build = parameterBuilder.name("token").description("set the security token")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build();
        parameters.add(build);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(createApiInfo())
                .select()// configure api/path selector
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(parameters); // add global parameters
    }

    private ApiInfo createApiInfo(){
        return new ApiInfoBuilder()
                .title("Cloud-service-Consumer-Feign/Ribbon Doc")
                .description("This is my cloud service api document.")
                .version("1.0").build();
    }

}
