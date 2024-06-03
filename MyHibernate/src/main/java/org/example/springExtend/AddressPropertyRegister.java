package org.example.springExtend;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

/**
 * @Description:org.example.springExtend
 * @Date:2024/5/27
 * @Author:谢锦创
 */
public class AddressPropertyRegister implements PropertyEditorRegistrar {
    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        registry.registerCustomEditor(Address.class, new AddressPropertyEditor());
    }
}
