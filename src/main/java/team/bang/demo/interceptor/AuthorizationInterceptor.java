package team.bang.demo.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.MethodInvocationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import team.bang.demo.annotation.PassToken;
import team.bang.demo.annotation.UserLoginToken;
import team.bang.demo.model.pojo.User;
import team.bang.demo.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
public class AuthorizationInterceptor implements HandlerInterceptor {
    public static final String LOGIN_USER_KEY = "LOGIN_USER_KEY";
    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest
            , HttpServletResponse httpServletResponse, Object object) throws Exception {
        String token = httpServletRequest.getHeader("token");

        if(!(object instanceof HandlerMethod))
            return true;

        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        // 检查是否有ignore注释
        if(method.isAnnotationPresent(PassToken.class)){
            PassToken passToken = method.getAnnotation(PassToken.class);
            if(passToken.required())
                return true;
        }
        // 检查是否需要权限
        if (method.isAnnotationPresent(UserLoginToken.class)){
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if(token == null)
                throw new RuntimeException("无token，请重新登录");
            // 获取token中的userName
            String username = JWT.decode(token).getAudience().get(0);
            User user = userService.findUserByName(username);

            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPhone())).build();
            try{
                jwtVerifier.verify(token);
            }catch (JWTVerificationException e){
                throw new RuntimeException("401");
            }
            return true;
        }
        return true;
    }


}
