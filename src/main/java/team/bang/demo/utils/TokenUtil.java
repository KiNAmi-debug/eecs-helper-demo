package team.bang.demo.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import team.bang.demo.model.pojo.User;

public class TokenUtil {
    public static String createToken(User user) {
        return JWT.create().withAudience(user.getUsername()).sign(Algorithm.HMAC256(user.getPhone()));
    }

    public static String getUsernameByToken(String token){
        return null;
    }
}
