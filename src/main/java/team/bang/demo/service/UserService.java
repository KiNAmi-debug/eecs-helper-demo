package team.bang.demo.service;

import org.springframework.stereotype.Service;
import team.bang.demo.model.dto.UserRegisterDTO;
import team.bang.demo.model.pojo.User;

import java.util.List;

@Service
public interface UserService {
    boolean addUser(UserRegisterDTO user);

    boolean updateUser(User user);

    boolean deleteUser(int id);

    User findUserByName(String userName);

    List<User> findAll();
}
