package com.example.filter;

import com.example.context.RequestContext;
import com.example.context.RequestContextManagerImpl;
import org.example.entity.SysUser;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Description:com.example.filter
 * @Date:2023/11/21
 * @Author:谢锦创
 */
@Component
@WebFilter("/*")
public class RequestContextFilter1 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Object idAttribute = request.getParameter("id");
        Object nameAttribute = request.getParameter("userName");
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
        SysUser sysUser = new SysUser();
        sysUser.setId(id);
        sysUser.setUserName(userName);
        requestContext.setUser(sysUser);
        requestContextManager.setRequest(requestContext);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
