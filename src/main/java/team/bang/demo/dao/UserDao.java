package team.bang.demo.dao;

import org.apache.ibatis.annotations.*;
import team.bang.demo.model.dto.UserRegisterDTO;
import team.bang.demo.model.pojo.User;

import java.util.List;

@Mapper
public interface UserDao {
    /**
     * 用户注册
     */
    @Insert("insert into tb_user(username,password) values (#{username},#{password})")
    void addUser(UserRegisterDTO user);

//    @Insert("insert into tb_user(id,username,password,name,phone,email) " +
//            "values (#{id},#{username},#{password},#{name},#{phone},#{email})")
//    void addUser(UserRegisterDTO user);

    @Update("update tb_user set username=#{username}, name=#{name}, phone=#{phone}, email=#{email} where id=#{id}")
    void updateUser(User user);

    @Delete("delete from tb_user where id=#{id}")
    void deleteUser(int id);

    @Select("SELECT id,username,password,name,phone,email FROM tb_user where username=#{userName}")
    User findByName(@Param("userName")String userName);

    @Select("SELECT id,username,password,name,phone,email FROM tb_user")
    List<User> findAll();
}
