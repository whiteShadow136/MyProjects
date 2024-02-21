package org.example.filter;

import org.apache.commons.lang3.StringUtils;
import org.example.entity.SysUser;
import org.example.util.RequestContext;
import org.example.util.RequestContextManager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Description:org.example.filter
 * @Date:2024/2/21
 * @Author:谢锦创
 */
@WebFilter("/*")
public class RequestFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String userId = request.getParameter("userId");
        if (StringUtils.isNotEmpty(userId)) {
            RequestContext requestContext = new RequestContext();
            SysUser sysUser = new SysUser();
            sysUser.setId(userId);
            requestContext.setSysUser(sysUser);
            RequestContextManager.setCurrent(requestContext);
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        RequestContextManager.remove();
    }
}
