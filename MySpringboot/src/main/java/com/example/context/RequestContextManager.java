package com.example.context;

/**
 * @Description:com.example.context
 * @Date:2023/11/21
 * @Author:谢锦创
 */
public interface RequestContextManager {

    public void setRequest(RequestContext request);

    public RequestContext getRequest();

}
