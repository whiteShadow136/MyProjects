package org.example.validator;

/**
 * @Description:org.example.validator
 * @Date:2024/1/18
 * @Author:谢锦创
 */
import org.example.annotation.DynamicEnumCheck;
import org.example.entity.PersistObject;
import org.example.entity.Users;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;
import java.util.UUID;

@Component
//@Transactional(propagation=Propagation.REQUIRES_NEW)
public class CheckStringValidator implements ConstraintValidator<DynamicEnumCheck, PersistObject> {

    @Override
    public void initialize(DynamicEnumCheck constraintAnnotation) {
        // 初始化方法，可以根据需要实现，通常用于读取注解的属性
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW)
    public boolean isValid(PersistObject persistObject, ConstraintValidatorContext context) {
//        SessionFactory sessionFactory = ApplicationContextUtil.getBean(SessionFactory.class);
        try {
//            EntityManager entityManager1 = ApplicationContextUtil.getBean(EntityManager.class);
//            sessionFactory.getCurrentSession().setFlushMode(FlushMode.MANUAL);
            // 在这里实现校验逻辑
            if (persistObject == null) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("Entity cannot be null")
                        .addConstraintViolation();
                return false;
            } else {
                String nameEn = persistObject.getNameEn();
//                if (StringUtils.isNotEmpty(nameEn)) {
//                    context.disableDefaultConstraintViolation();
//                    context.buildConstraintViolationWithTemplate("referecnce cannot be null")
//                            .addConstraintViolation();
//                    return false;
//                }
                for (int i = 0; i < 8000; i++) {
                    Field mulReference = ReflectionUtils.findField(persistObject.getClass(), "mulReference");
                    mulReference.getName();
                }
                Class<? extends PersistObject> clazz = persistObject.getClass();
                Users users = new Users();
                users.setId(UUID.randomUUID().toString());
                users.setName("test");
//                entityManager1.merge(users);
//                entityManager1.find(Users.class, "1");
                String hql = "from Users";
//                Query query = entityManager1.createQuery(hql);
//                List resultList = query.getResultList();
                //            entityManager1.flush();
//                System.out.println(resultList);
                //            clazz.getDeclaredField("rdmExtensionType")
                // 根据英文名称获取类型定义id
                // 根据id获取所有动态枚举属性
                // for循环动态枚举
                // 利用反射获取每个动态枚举的值
                // 获取每个动态枚举对应的类型
                // 获取每个类型下的所有值，获取为HashSet, 使用contains进行判断
            }
        }
        finally {
//                sessionFactory.getCurrentSession().setFlushMode(FlushMode.AUTO);
            }

        return true;
//        int id = persistObject.getId();

//        return true;
        // 添加具体的校验逻辑，例如校验字符串是否满足某种格式
//        return value.matches("^[a-zA-Z0-9]+$"); // 仅示例，检查字符串是否只包含字母和数字
    }
}

