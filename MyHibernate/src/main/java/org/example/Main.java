package org.example;

import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entity.Calculator;
import org.example.entity.MyCalculator;
import org.example.entity.Users;
import org.example.proxy.CalculatorProxy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;

/**
 * @Description:org.example
 * @Date:${DATE}
 * @Author:谢锦创
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.test();

        String[] str= {"春眠不觉晓,","处处闻啼鸟,","夜来风雨声,","花落知多少,"};
                File file=new File("src\\cc.txt");
                FileOutputStream f=null;//创建文件写入对象
                BufferedWriter f1=null;//创建字符流写入对象

                try {
                    //这里把文件写入对象和字符流写入对象分开写了
                    f=new FileOutputStream("D:\\test\\cc.txt");//创建一个名为cc.txt的文件
                    for (String string : str) {
                        f.write(string.getBytes());
                        f.write("\\n".getBytes());
                    }
//                    f1=new BufferedWriter(f);
//                    //通过循环遍历上面的String 数组中的元素
//                    for (int i = 0; i < str.length; i++) {
//                        f1.write(str[i]);//把String中的字符写入文件
//                        f1.newLine();//换行操作
//                    }
                } catch (Exception e) {
                    throw new Exception(e);
                    // TODO: handle exception
                }finally {//如果没有catch 异常，程序最终会执行到这里
                    try {
//                        f1.close();
                        f.close();//关闭文件
                    } catch (Exception e2) {
                        // TODO: handle exception
                    }
                }



        String emoji = "\uD83D\uDE00";
        System.out.println("The emoji character is: " + emoji);


        JSONArray jsonValues = new JSONArray();
        jsonValues.add(new Users("xie", "qq"));
//        PersistObject persistObject = new PersistObject(1, jsonValues, new Student(1, "谢锦创"));


//        String s1 = JSON.toJSONString(persistObject);
//        System.out.println(s1);

        ObjectMapper objectMapper = new ObjectMapper();
//        String s = objectMapper.writeValueAsString(persistObject);
//        System.out.println(s);

        System.out.println("Hello world!");
    }

    void test() {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        CalculatorProxy calculatorProxy = new CalculatorProxy();
        Calculator proxy = calculatorProxy.getProxy(new MyCalculator());
        proxy.add(1, 1);
        System.out.println(proxy.getClass());
    }
}