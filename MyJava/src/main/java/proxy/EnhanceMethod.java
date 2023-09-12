package proxy;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description:proxy
 * @Date:2023/9/9
 * @Author:谢锦创
 */
public class EnhanceMethod implements InvocationHandler, Serializable {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(1111);
//        method.invoke()
        return null;
    }
}
