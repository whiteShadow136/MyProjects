package com.example.AOP.CGLIB;

import com.squareup.javapoet.*;
import sun.reflect.Reflection;

import javax.lang.model.element.Modifier;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Types;

/**
 * @Author:谢锦创
 * @Date:2023/7/12
 * @Description:com.example.AOP.CGLIB
 * @VERSION:1.0
 */
public class GenerateProxy {
    public static void main(String[] args) throws Exception {
        // 入参，基础类(class), 要增强的方法(method)，准备增强的类(class1)，准备增强的类方法(method1)
        Class baseClass = SimpleMethod.class;
        String baseMethod = "play";
        Class enhanceCLass = EnhanceMethod.class;
        String enhanceMethod = "invoke";

        Class<SimpleMethod> simpleMethodClass = SimpleMethod.class;
        Method simpleMethod = simpleMethodClass.getDeclaredMethod(baseMethod);
        String modifier = java.lang.reflect.Modifier.toString(simpleMethod.getModifiers());
        System.out.println(modifier);
        String returnType = simpleMethod.getReturnType().toString();

        CodeBlock methodCodeBlock = CodeBlock.builder().addStatement("Object returnObject = invoke()").build();
        CodeBlock methodCodeBlock1 = CodeBlock.builder().addStatement("((SimpleMethod)realBean).play()").build();
        MethodSpec playMethod = MethodSpec.methodBuilder("play").
                addModifiers(Modifier.PUBLIC).
                returns(TypeName.VOID).
                addCode(methodCodeBlock)
                .addCode(methodCodeBlock1)
                .build();

        FieldSpec fieldSpec = FieldSpec.
                builder(TypeName.OBJECT, "realBean", Modifier.PUBLIC).
                initializer("new SimpleMethod()").
                build();

        TypeSpec classInstance = TypeSpec.classBuilder("ClassInstance")
                .addModifiers(Modifier.PUBLIC)
                .addMethod(playMethod)
                .addField(fieldSpec)
                .superclass(EnhanceMethod.class)
                .addSuperinterface(MethodInterface.class).build();

        JavaFile javaFile = JavaFile.builder("com.example", classInstance).build();
        javaFile.writeTo(new File("D://JavaPoetTest"));

    }

    public void testJavaPoet() throws IOException {
        MethodSpec main = MethodSpec.methodBuilder("main")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .returns(void.class)
                .addParameter(String[].class, "args")
                .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
                .build();

        TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addMethod(main)
                .build();

        JavaFile javaFile = JavaFile.builder("com.example.helloworld", helloWorld)
                .build();

        javaFile.writeTo(new File("D:/test/)"));
    }
}

