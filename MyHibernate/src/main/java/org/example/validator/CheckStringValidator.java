package org.example.validator;

/**
 * @Description:org.example.validator
 * @Date:2024/1/18
 * @Author:谢锦创
 */
import org.example.annotation.CheckString;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckStringValidator implements ConstraintValidator<CheckString, String> {
    @Override
    public void initialize(CheckString constraintAnnotation) {
        // 初始化方法，可以根据需要实现，通常用于读取注解的属性
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // 在这里实现校验逻辑
        if (value == null) {
            return true; // null 时认为是合法的，也可以根据需求改为 false
        }
        // 添加具体的校验逻辑，例如校验字符串是否满足某种格式
        return value.matches("^[a-zA-Z0-9]+$"); // 仅示例，检查字符串是否只包含字母和数字
    }
}

