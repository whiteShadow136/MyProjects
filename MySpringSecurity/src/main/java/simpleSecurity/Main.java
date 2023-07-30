package simpleSecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import simpleSecurity.util.ApplicationContextUtil;

/**
 * @Description:simpleSecurity
 * @Date:2023/7/26
 * @Author:谢锦创
 */
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Main.class);
        ApplicationContextUtil.applicationContext = run;
        System.out.println(111);
    }
}
