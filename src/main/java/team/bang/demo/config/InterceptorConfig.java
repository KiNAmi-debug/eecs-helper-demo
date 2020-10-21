package team.bang.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import team.bang.demo.interceptor.AuthorizationInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private AuthorizationInterceptor authorizationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/**");
    }
//    @Bean
//    public AuthorizationInterceptor authorizationInterceptor(){
//        return new AuthorizationInterceptor();
//    }
}
