package simpleSecurity.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Description:simpleSecurity.configuration
 * @Date:2023/7/27
 * @Author:谢锦创
 */
@Configuration
public class WebConfigure extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().mvcMatchers("/index").permitAll()
                .mvcMatchers("/login.html").permitAll()
//                .anyRequest().authenticated()
                .mvcMatchers("/hello").authenticated()
                        .and().formLogin()
                        .loginPage("/login.html")
                .loginProcessingUrl("/login")
                                .and()
                                        .csrf().disable();
        super.configure(http);
    }
}
