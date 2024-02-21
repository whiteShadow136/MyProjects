package org.example.util;

/**
 * @Description:org.example.util
 * @Date:2024/2/21
 * @Author:谢锦创
 */
public class RequestContextManager {

    public static ThreadLocal<RequestContext> requestContextHolder = new ThreadLocal();
    public static RequestContext getCurrent() {
        if(requestContextHolder.get() != null) {
            return requestContextHolder.get();
        } else {
            return null;
        }
    }

    public static void setCurrent(RequestContext requestContext) {
        requestContextHolder.set(requestContext);
    }

    public static void remove() {
        requestContextHolder.remove();
    }
}
