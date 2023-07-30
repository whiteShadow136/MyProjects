package simpleSecurity.util;

import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Description:simpleSecurity.util
 * @Date:2023/7/28
 * @Author:谢锦创
 */
public class ApplicationContextUtil {
    public static ConfigurableApplicationContext applicationContext= null;


    Object getBean(String fullClazz) {
        return applicationContext.getBean(fullClazz);
    }

    Object getBean(Class clazz) {
        return applicationContext.getBean(clazz);
    }
}
