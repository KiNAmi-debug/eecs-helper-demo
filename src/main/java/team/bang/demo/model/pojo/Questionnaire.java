package team.bang.demo.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Questionnaire {
    private int id;
    private int uid;
    private String name;
    private String email;
    private String phone;
    private String problemdescription;
    private String comment;
    private int status;
    private int helper_id;
}
