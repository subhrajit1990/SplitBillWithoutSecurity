package biller.manager.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Troublem@ker
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket customImplementation() {
		return new Docket(DocumentationType.SWAGGER_2).forCodeGeneration(true).apiInfo(apiInfo())
                .useDefaultResponseMessages(false).select()
                .apis(RequestHandlerSelectors.basePackage("bill.manager.controller")).paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo()
    {
        return new ApiInfoBuilder().title("Bill Manager Services").description("Bill Manager Services")
                .contact(
                        new Contact("Subhrajit", " Sahu", "Subhrajitsahu1990@gmail.com"))
                .license("Proprietary").version("1.0.0").build();
    }
}
