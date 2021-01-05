package com.kemyond.virus.config;

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
 * swagger 配置类
 * @Author zdl
 * @Date 2021/1/4 16:43
 * @Version 1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                // 指定构建api文档的详细信息的方法：apiInfo()
                .apiInfo(apiInfo()) .select()
                // 指定要生成api接口的包路径，这里把controller作为包路径，生成controller 中的所有接口
                .apis(RequestHandlerSelectors.basePackage("com.kemyond.virus.rest"))
                .paths(PathSelectors.any())
                .build();
    }
    /**
     *  构建api文档的详细信息
     *  @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 设置页面标题
                .title("病毒检测子系统线上文档")
                // 设置接口描述
                .description("为clamav提供一个管理程序")
                // 设置联系方式
                .contact(new Contact("kemyond","192.168.1.74:8888/main","zhaodalong@kemyond.com"))
                // 设置版本
                .version("1.0")
                .build();
    }
}
