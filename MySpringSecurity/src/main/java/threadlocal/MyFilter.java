package threadlocal;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import springsecuritymvcinspect.model.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:threadlocal
 * @Date:2023/7/23
 * @Author:谢锦创
 */
@Component
@WebFilter(urlPatterns = "/user")
public class MyFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        User user = new User();
        user.setUserName(userName);
        UserContext.setCurrentUser(user);
        filterChain.doFilter(request, response);
    }
}
