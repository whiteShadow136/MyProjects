package org.example.annotation;

import java.lang.annotation.*;

/**
 * @Description:org.example.annotation
 * @Date:2023/8/22
 * @Author:谢锦创
 */
@Documented
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotationSwagger {
    String value() default "";


}
