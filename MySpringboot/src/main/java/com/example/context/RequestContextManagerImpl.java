package com.example.context;

import org.example.entity.SysUser;
import org.springframework.stereotype.Component;

/**
 * @Description:com.example.context
 * @Date:2023/11/21
 * @Author:谢锦创
 */
@Component
public class RequestContextManagerImpl implements RequestContextManager{
    public static ThreadLocal<RequestContext> threadLocal = new ThreadLocal<>();

    @Override
    public void setRequest(RequestContext request) {
        threadLocal.set(request);
    }

    @Override
    public RequestContext getRequest() {
        if (threadLocal.get() != null) {
            return threadLocal.get();
        }
        return null;
    }
}
