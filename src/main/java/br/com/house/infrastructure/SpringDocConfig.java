package br.com.house.infrastructure;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

  @Bean
  public OpenAPI popularHouseOpenAPI() {
    return new OpenAPI()
        .info(new Info().title("Popular House API")
            .description("Application for popular house")
            .version("v0.0.1")
            .license(new License().name("Apache 2.0").url("http://springdoc.org")))
        .externalDocs(new ExternalDocumentation()
            .description("Popular House Wiki Documentation")
            .url("https://github.com/isacaguiar/popular-house"));
  }

}
