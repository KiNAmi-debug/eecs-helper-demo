package team.bang.demo.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int uid;
    private String username;
    private String password;
    private String nickname;
    private String phone;
    private String email;
}
