package org.example.classes;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @Description:org.example.classes
 * @Date:2024/4/18
 * @Author:谢锦创
 */
public class MyClassLoader extends URLClassLoader {
    public MyClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }
}
