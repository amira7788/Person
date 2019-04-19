package com.person.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.AuthorizationCodeGrantBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.service.Tag;
import springfox.documentation.service.TokenEndpoint;
import springfox.documentation.service.TokenRequestEndpoint;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket api() {

    return new Docket(DocumentationType.SWAGGER_2)
        .tags(new Tag("api", "api person"))
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.person"))
        .paths(PathSelectors.any())
        .build()
        .apiInfo(getApiInfo());
  }

  private ApiInfo getApiInfo() {
    return new ApiInfoBuilder()
        .title("API person")
        .description("API person")
        .version("v1")
        .build();
  }

 /* @Bean
  public SecurityConfiguration security() {
    return SecurityConfigurationBuilder.builder()
        .clientId("admin")
        .clientSecret("admin")
        .scopeSeparator(" ")
        .useBasicAuthenticationWithAccessCodeGrant(true)
        .build();
  }
*/
  private SecurityScheme securityScheme() {
    GrantType grantType = new AuthorizationCodeGrantBuilder()
        .tokenEndpoint(new TokenEndpoint("api" + "/token", "oauthtoken"))
        .tokenRequestEndpoint(
            new TokenRequestEndpoint("api" + "/authorize", "admin", "admin"))
        .build();

    SecurityScheme oauth = new OAuthBuilder().name("spring_oauth")
        .grantTypes(Arrays.asList(grantType))
        .scopes(Arrays.asList(scopes()))
        .build();
    return oauth;
  }

  private AuthorizationScope[] scopes() {
    AuthorizationScope[] scopes = {
        new AuthorizationScope("read", "for read operations"),
        new AuthorizationScope("write", "for write operations"),
        new AuthorizationScope("foo", "Access foo API") };
    return scopes;
  }

  private SecurityContext securityContext() {
    return SecurityContext.builder()
        .securityReferences(
            Arrays.asList(new SecurityReference("spring_oauth", scopes())))
        .forPaths(PathSelectors.regex("/foos.*"))
        .build();
  }

}
