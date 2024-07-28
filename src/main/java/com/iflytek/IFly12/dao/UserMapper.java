package com.iflytek.IFly12.dao;

import com.iflytek.IFly12.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 用户注册,插入用户数据
     */
    @Options(useGeneratedKeys = true, keyProperty = "userId") //回写自增的主键ID
    @Insert("insert into users (user_name,user_password)values(#{userName},#{password})")
    public Integer addUser(User user);


//    /**
//     * 通过id删除用户数据
//     * @param id
//     * @return
//     */
//    @Delete("delete from users where id=#{id}")
//    public Integer deleteUserById(Integer id);

//    @Update("update users set userId=#{userId},password=#{user_password},status=#{status} where id=#{id}")
//    public Integer updateUser(User user);


    @Select("select  id, user_name, user_password from users where id = #{userId}")
    @Results({
            @Result(id = true,property = "userId",column = "id"),
            @Result(property = "userName" , column = "user_name"),
            @Result(property = "password" , column = "user_password")
    })
    public User getUserById(Integer userId);

    /**
     * 查询所有用户信息
     * @return
     */
    @Select("select * from users")
    public List<User> queryUserList();

    /**
     * 根据用户名称查出用户信息
     */
    @Select("select  id, user_name, user_password from users where user_name = #{userName}")
    @Results({
            @Result(id = true,property = "userId",column = "id"),
            @Result(property = "userName" , column = "user_name"),
            @Result(property = "password" , column = "user_password")
    })
    public User getUserByUserName(String userName);

}
