package 事务生成的代码类;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import sun.misc.ProxyGenerator;
import 事务生成的代码类.测试类.TransacationGenerate;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description:PACKAGE_NAME
 * @Date:2023/9/10
 * @Author:谢锦创
 */
@SpringBootApplication
public class Main {
    private final static String filePath = "D:\\develop_tools\\IntelliJ IDEA 2022.2.2\\ideaProjects\\MyProjects\\MySpringboot\\src\\main\\";

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class);
        TransacationGenerate bean = context.getBean(TransacationGenerate.class);
        Main main = new Main();
        main.persistObjectToFile(bean);
        System.out.println(bean);
    }

    void persistObjectToFile(Object object) {
        byte[] bytes = ProxyGenerator.generateProxyClass(object.getClass().getName(), object.getClass().getInterfaces());
        try(FileOutputStream fileOutputStream = new FileOutputStream(filePath + "jdkProxyClass.class")) {
            fileOutputStream.write(bytes);
            System.out.println(3333);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
