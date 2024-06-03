package org.example.springExtend;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:org.example.springExtend
 * @Date:2024/5/27
 * @Author:谢锦创
 */
@Configuration
public class CustomEditorConfigurerConfig {

    @Bean
    public CustomEditorConfigurer configurer() {
        CustomEditorConfigurer customEditorConfigurer = new CustomEditorConfigurer();
        AddressPropertyRegister addressPropertyEditor = new AddressPropertyRegister();
        PropertyEditorRegistrar[] addressPropertyEditors = new AddressPropertyRegister[]{addressPropertyEditor};
        customEditorConfigurer.setPropertyEditorRegistrars(addressPropertyEditors);
        return customEditorConfigurer;
    }

}
