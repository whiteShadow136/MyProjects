package 国际化;

import org.springframework.context.MessageSource;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

/**
 * @Description:国际化
 * @Date:2023/8/11
 * @Author:谢锦创
 */

public class TestMessageSource {

    public static void main(String[] args) {
        GenericApplicationContext genericApplicationContext = new GenericApplicationContext();
        genericApplicationContext.registerBean("messageSource", MessageSource.class,
                () -> {
                    ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
                    ms.setDefaultEncoding("utf-8");
                    ms.setBasename("messages");
                    return ms;
                });

        genericApplicationContext.refresh();
        System.out.println(genericApplicationContext.getMessage("111", new Object[]{"fuck"}, Locale.ENGLISH));
        System.out.println(genericApplicationContext.getMessage("111", new Object[]{"fuck"}, Locale.JAPAN));
        System.out.println(genericApplicationContext.getMessage("111", new Object[]{"fuck"}, Locale.CHINA));
    }
    }
