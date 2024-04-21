package org.example;

import ch.qos.logback.core.net.server.Client;
import org.example.classes.MyClassLoader;

/**
 * @Description:org.example
 * @Date:${DATE}
 * @Author:谢锦创
 */
public class Main {
    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = Client.class.getClassLoader();
        System.out.println(classLoader.toString());
        Double salary = 2000.00;
        MyClassLoader myClassLoader = new MyClassLoader();
        callSalary(salary, myClassLoader);
        System.out.println("Hello world!");
    }

    static void callSalary(Double salary, ClassLoader classLoader) throws Exception {
        Class<?> aClass = classLoader.loadClass("com.example.SalaryCaller");
        System.out.println(aClass.getClassLoader());
        System.out.println(aClass.getClassLoader().getParent().getClass());
        Object object = aClass.newInstance();
        Double money = (Double)aClass.getMethod("cal", Double.class).invoke(object, salary);
        System.out.println(money);
    }

}