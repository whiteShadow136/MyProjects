package org.example.annotation;

/**
 * @Description:org.example.annotation
 * @Date:2024/1/18
 * @Author:谢锦创
 */
import org.example.validator.CheckStringValidator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = CheckStringValidator.class)
@Target({ FIELD, TYPE})
@Retention(RUNTIME)
public @interface DynamicEnumCheck {
    String message() default "Invalid string"; // 默认错误消息
    Class<?>[] groups() default {}; // 用于分组校验
    Class<? extends Payload>[] payload() default {}; // 用于携带校验过程的元数据
}

