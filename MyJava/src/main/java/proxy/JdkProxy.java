package proxy;

import com.squareup.javapoet.*;
import com.sun.org.apache.bcel.internal.classfile.Code;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import sun.misc.ProxyGenerator;

import javax.lang.model.element.Modifier;
import java.io.*;
import java.lang.reflect.*;
import java.util.*;
// 动态代理文章 https://blog.csdn.net/qq_41358574/article/details/121800405
/**
 * @Description:proxy
 * @Date:2023/9/9
 * @Author:谢锦创
 */
@Slf4j
public class JdkProxy {
    private final static String filePath = "D:\\develop_tools\\IntelliJ IDEA 2022.2.2\\ideaProjects\\MyProjects\\MyJava\\src\\main\\java\\";

    public static void main(String[] args) throws IOException {
        JdkProxy jdkProxy = new JdkProxy();
        MyInterface myInterface = jdkProxy.getProxy(MyInterface.class, new EnhanceMethod());
        myInterface.play();
        jdkProxy.persistObjectToFile(myInterface);
//                String classPath = jdkProxy.generateClass(MyInterface.class, new EnhanceMethod());
//        MyInterface instance = jdkProxy.getInstanceFromPath(classPath, MyInterface.class);
//        instance.play();
    }

    <T>T getProxy(Class<T> interfaceClass, InvocationHandler invocationHandler) {
        T instance = (T)Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{interfaceClass}, invocationHandler);
        return instance;
    }

    void persistObjectToByte(Object object) {
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath +
                  "jdkProxyClass"))) {
            objectOutputStream.writeObject(object);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void persistObjectToFile(Object object) {
        byte[] bytes = ProxyGenerator.generateProxyClass(object.getClass().getName(), object.getClass().getInterfaces());
        try(FileOutputStream fileOutputStream = new FileOutputStream(filePath + "proxy" + "jdkProxyClass1")) {
            fileOutputStream.write(bytes);
        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T getInstanceFromPath(String classPath, Class<T> clazz) {
        Class<?> loadClass = null;
        Object instance = null;
        try {
            loadClass = Class.forName(classPath);
//            Constructor constructor = loadClass.getConstructor();
            instance = loadClass.newInstance();
        } catch (ClassNotFoundException e) {
            log.error("加载不到类");
//            throw new RuntimeException(e);
//        } catch (NoSuchMethodException e) {
//            log.error("没有这个构造器");
////            throw new RuntimeException(e);
//        } catch (InvocationTargetException e) {
//            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return (T)instance;
    }

    public String generateClass(Class interfaceClass, InvocationHandler enhanceClass) throws IOException {
//        Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{MyInterface.class)
//    , )

        List<MethodSpec> method = getImplementMethod(interfaceClass);
        List<MethodSpec> invokeMethod = getImplementMethod(enhanceClass.getClass());
        String className = "GeneratedClass";
        TypeSpec generatedClass = TypeSpec.classBuilder(className)
                .addSuperinterface(MyInterface.class)
                .superclass(EnhanceMethod.class)
                .addMethods(method)
                .addMethods(invokeMethod)
                .build();

        JavaFile javaFile = JavaFile.builder("proxy", generatedClass)
                .build();
//        javaFile.writeTo(System.out);
//        String path = this.getClass().getResource("").getPath();
        javaFile.writeTo(new File(filePath));

        return javaFile.packageName + "." + className;
    }

    private List<MethodSpec> getImplementMethod(Class clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        List<MethodSpec> methodSpecList = new ArrayList<>();
        String modifier = "";
        Class returnType = null;
        String methodName = "";
        Parameter[] parameters = null;
        Class<?>[] exceptionTypes;
        for (Method method : methods) {
            modifier = "public";
            returnType = method.getReturnType();
            methodName = method.getName();
            parameters = method.getParameters();
            exceptionTypes = method.getExceptionTypes();
            CodeBlock methodCodeBlock = getMethodCodeBlock(clazz, methodName, parameters);
            MethodSpec.Builder methodBuilder = MethodSpec.methodBuilder(methodName)
                    .addModifiers(Modifier.valueOf(modifier.toUpperCase(Locale.ROOT)))
                    .addAnnotation(Override.class)
                    .addCode(methodCodeBlock)
                    .returns(returnType);
            for (Parameter parameter : parameters) {
                ParameterSpec parameterSpec = ParameterSpec.builder(parameter.getType(), parameter.getName()).build();
                methodBuilder.addParameter(parameterSpec);
            }
            for (Class<?> exceptionType : exceptionTypes) {
                methodBuilder.addException(exceptionType);
            }
            methodSpecList.add(methodBuilder.build());
        }
        return methodSpecList;
    }

    CodeBlock getMethodCodeBlock(Class clazz, String methodName, Parameter[] methodParameters) {
        if (clazz.isInterface()) {
            // 自己增加实现的方法
            return getMethodImpl(methodParameters);
        } else {
            // 直接return父类的实现
            CodeBlock.Builder codeBlockBuilder = CodeBlock.builder()
                    .add("return super.$L(", methodName);
//             获取调用的方法的参数
//            Map<String, String> methodParamMap = getMethodParam(methodParameters);
            // 添加入数
            int index = 1;
            for (Parameter parameter: methodParameters) {
                if (index != 1) {
                    codeBlockBuilder.add(", ");
                }
//                codeBlockBuilder.add(entry.getKey());
//                codeBlockBuilder.add(" ");
                codeBlockBuilder.add(parameter.getName());
                index++;
            }
            codeBlockBuilder.add(");");

            return codeBlockBuilder.build();
        }
    }

    CodeBlock getMethodImpl(Parameter[] methodParameters) {

        CodeBlock.Builder codeBuilder = CodeBlock.builder()
                .add("this.invoke(");
        int index = 1;
        for (Parameter methodParameter : methodParameters) {
            if (index != 1) {
                codeBuilder.add(", ");
            }
            codeBuilder.add(methodParameter.getName());
        }
        codeBuilder.add(");");
        return codeBuilder.build();
    }
}
