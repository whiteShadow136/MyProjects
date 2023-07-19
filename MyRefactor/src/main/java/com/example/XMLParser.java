package com.example;//package com.example;
//
//import org.w3c.dom.Document;
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.URL;
//
//public class XMLParser {
//    public static void main(String[] args) {
//        try {
//            // 创建解析器工厂
//            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//            // 禁用外部实体引用
//            factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", true);
//            // 创建解析器
//            DocumentBuilder builder = factory.newDocumentBuilder();
//
//            // 从远程URL加载XML文件
//            File file = new File("D:\\develop_tools\\IntelliJ IDEA 2022.2.2\\ideaProjects\\MyProjects\\MyRefactor\\src\\main\\resources\\users.xml");
//
//            // 解析XML文件
//            Document document = builder.parse(file);
//
//            // 处理XML文档...
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}


import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
public class XMLParser {
    public static void main(String[] args) {
        try {
            // 创建解析器工厂
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // 启用外部实体引用
            factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            // 创建解析器
            DocumentBuilder builder = factory.newDocumentBuilder();

            // 恶意的XML输入数据
            String maliciousXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                    "<!DOCTYPE users [" +
                    "<!ENTITY % malicious SYSTEM \"file:///etc/passwd\">" +
                    "%all;" +
                    "]>" +
                    "<users>" +
                    "   <user>" +
                    "      <name>John Doe</name>" +
                    "      <email>john@example.com</email>" +
                    "   </user>" +
                    "</users>";

            // 加载恶意XML数据
            Document document = builder.parse(new ByteArrayInputStream(maliciousXml.getBytes()));
            System.out.println(111);
            System.out.println(111);
            System.out.println(111);
            // 处理XML文档...
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
