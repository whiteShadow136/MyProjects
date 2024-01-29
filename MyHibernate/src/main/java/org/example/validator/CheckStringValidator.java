package org.example.validator;

/**
 * @Description:org.example.validator
 * @Date:2024/1/18
 * @Author:谢锦创
 */
import org.example.annotation.DynamicEnumCheck;
import org.example.entity.PersistObject;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckStringValidator implements ConstraintValidator<DynamicEnumCheck, PersistObject> {
    @Override
    public void initialize(DynamicEnumCheck constraintAnnotation) {
        // 初始化方法，可以根据需要实现，通常用于读取注解的属性
    }

    @Override
    public boolean isValid(PersistObject persistObject, ConstraintValidatorContext context) {
        // 在这里实现校验逻辑
        if (persistObject == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Entity cannot be null")
                    .addConstraintViolation();
            return false;
        } else {
            String nameEn = persistObject.getNameEn();
            Class<? extends PersistObject> clazz = persistObject.getClass();
//            clazz.getDeclaredField("rdmExtensionType")
            // 根据英文名称获取类型定义id
            // 根据id获取所有动态枚举属性
            // for循环动态枚举
            // 利用反射获取每个动态枚举的值
            // 获取每个动态枚举对应的类型
            // 获取每个类型下的所有值，获取为HashSet, 使用contains进行判断

        }

        return true;
//        int id = persistObject.getId();

//        return true;
        // 添加具体的校验逻辑，例如校验字符串是否满足某种格式
//        return value.matches("^[a-zA-Z0-9]+$"); // 仅示例，检查字符串是否只包含字母和数字
    }
}

