package org.example.classes;

import com.sun.xml.internal.ws.util.ByteArrayBuffer;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.SecureClassLoader;

/**
 * @Description:org.example.classes
 * @Date:2024/4/18
 * @Author:谢锦创
 */
public class MyClassLoader extends SecureClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String path = "D:\\tools\\repository\\org\\example\\MyRefactor\\1.0-SNAPSHOT\\MyRefactor-1.0-SNAPSHOT.jar"
        .replace("\\", "/");
        String classes = name.replace(".", "/").concat(".class");
        try {
            URL url = new URL("jar:file:/".concat(path).concat("!/").concat(classes));
            System.out.println(url.toString());
            InputStream inputStream = url.openStream();
            ByteArrayBuffer ba = new ByteArrayBuffer();
            int a;
            while((a = inputStream.read()) != -1) {
                ba.write(a);
            }
            byte[] byteArray = ba.toByteArray();
            return this.defineClass(name, byteArray, 0, byteArray.length);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        return super.findClass(name);
    }
}
