package org.example.config;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.apache.cxf.jaxrs.swagger.Swagger2Feature;
import org.example.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.cxf.bus.spring.SpringBus;

@Configuration
public class CxfConfig {

    @Autowired
    private HelloService helloService;

    @Bean
    public SpringBus cxf() {
        return new SpringBus();
    }

    @Bean
    public JAXRSServerFactoryBean jaxRsServer() {
        JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
        factoryBean.setProvider(new JacksonJsonProvider());
        factoryBean.setServiceBeanObjects(helloService);
        factoryBean.setAddress("/");
        factoryBean.setBus(cxf());
        factoryBean.setResourceClasses(HelloService.class);
        factoryBean.setResourceProvider(HelloService.class, new SingletonResourceProvider(helloService));
        factoryBean.getFeatures().add(new Swagger2Feature());
        return factoryBean;
    }
}
