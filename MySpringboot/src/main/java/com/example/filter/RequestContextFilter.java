package com.example.filter;

import com.example.context.RequestContext;
import com.example.context.RequestContextManager;
import com.example.context.RequestContextManagerImpl;
import org.example.entity.SysUser;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Description:com.example.filter
 * @Date:2023/11/21
 * @Author:谢锦创
 */
public class RequestContextFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Object idAttribute = request.getAttribute("id");
        Object nameAttribute = request.getAttribute("userName");
        String id = "";
        if (idAttribute != null) {
            id = (String) idAttribute;
        }
        String userName = "";
        if (nameAttribute != null) {
            userName = (String) nameAttribute;
        }
        RequestContextManagerImpl requestContextManager = new RequestContextManagerImpl();
        RequestContext requestContext = new RequestContext();
        SysUser sysUser = SysUser.builder().id(id).userName(userName).build();
        requestContext.setUser(sysUser);
        requestContextManager.setRequest(requestContext);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
