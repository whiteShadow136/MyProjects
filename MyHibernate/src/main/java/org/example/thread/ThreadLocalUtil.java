package org.example.thread;

import org.example.entity.MyEntity;

/**
 * @Description:org.example.thread
 * @Date:2024/8/7
 * @Author:谢锦创
 */
public class ThreadLocalUtil {

    private static ThreadLocal<MyEntity> myEntityThreadLocal = new ThreadLocal<>();

    public static void set(MyEntity myEntity) {
        myEntityThreadLocal.set(myEntity);
    }

    public static MyEntity get() {
        return myEntityThreadLocal.get();
    }
}
