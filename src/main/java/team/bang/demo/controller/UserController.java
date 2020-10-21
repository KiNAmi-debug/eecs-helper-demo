package team.bang.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team.bang.demo.annotation.PassToken;
import team.bang.demo.annotation.UserLoginToken;
import team.bang.demo.model.dto.UserRegisterDTO;
import team.bang.demo.model.pojo.User;
import team.bang.demo.service.UserService;
import team.bang.demo.utils.TokenUtil;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     *
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public boolean addUser(@RequestBody UserRegisterDTO user){
        System.out.println("新增了一个用户");
        System.out.println(user.getUsername());
        return userService.addUser(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public boolean updateUser(@RequestBody User user){
        System.out.println("开始更新");
        return userService.updateUser(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public boolean deleteUser(@RequestBody User user){
        System.out.println("开始删除");

        return userService.deleteUser(user.getUid());
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User findByUserName(@RequestParam("username") String username) {
        System.out.println("开始查询...");
        return userService.findUserByName(username);
    }

    @UserLoginToken
    @RequestMapping(value = "/userAll", method = RequestMethod.GET)
    public List<User> findByUserAge() {
        System.out.println("开始查询所有数据...");
        return userService.findAll();
    }

    @PassToken
    @RequestMapping(value = "/token", method = RequestMethod.GET)
    public String getToken(@RequestParam("username") String username){
        return TokenUtil.createToken(userService.findUserByName(username));
    }
}
