package org.example.config;

import com.google.common.base.Predicates;
import org.example.annotation.MyAnnotationSwagger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Description:org.example.config
 * @Date:2023/8/22
 * @Author:谢锦创
 */
@Configuration
public class SwaggerConfiguration {

    /**
     * 相当于上下文
     * Swagger全局配置对象 可以当作swagger的展示界面上信息，界面的配置就在这个对象中。
     * @return
     */
    @Bean
    public Docket docket() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        ApiInfo apiInfo = new ApiInfoBuilder()
                .contact(new Contact("北京尚学堂swagger开发文档", "http://www.xjc.com", "844497663@qq.com"))
                .build();
        // 设置docket的上下文描述信息
        docket.apiInfo(apiInfo);

        Docket build = docket.select().apis(Predicates.not(RequestHandlerSelectors.withMethodAnnotation(MyAnnotationSwagger.class)))
                .apis(RequestHandlerSelectors.basePackage("org.example.controller")).build();
        System.out.println(docket.equals(build));

        return build;
    }
}
