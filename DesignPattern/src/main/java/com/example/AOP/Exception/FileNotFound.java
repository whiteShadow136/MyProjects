package com.example.AOP.Exception;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import sun.nio.fs.*;

/**
 * @Author:谢锦创
 * @Date:2023/7/17
 * @Description:com.example.AOP.Exception
 * @VERSION:1.0
 */
//@Slf4j
@Component
public class FileNotFound {
    public static void main(String[] args) {

    }

    public void play() throws FileNotFoundException {
        Logger logger = LoggerFactory.getLogger(FileNotFound.class);
        File file = new File("D://sdgasdg");
//        try {
            FileInputStream fileInputStream = new FileInputStream(file);
//        } catch (FileNotFoundException e) {
//            logger.error(e.getMessage());
//        }
    }
}
