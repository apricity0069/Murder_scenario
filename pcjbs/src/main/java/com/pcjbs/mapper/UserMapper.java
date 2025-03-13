package com.pcjbs.mapper;

import com.pcjbs.entity.JbInfo;
import com.pcjbs.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    @Select("select * from users")
    List<User> getAllUser();

    @Update("update users set user_pwd='123456' where user_id=#{user_id}")
    int updateAPwd(@Param("user_id") String user_id);

    @Select("select * from users ${whereCondition}")
    List<User> getXzUser(@Param("whereCondition") String whereCondition);

    @Insert("insert into users(user_id,user_name,user_phone,user_pwd) " + " values(#{user_id},#{user_name},#{user_phone},#{user_pwd})")
    int enroll(@Param("user_id") String user_id,
               @Param("user_name") String user_name,
               @Param("user_phone") String user_phone,
               @Param("user_pwd") String user_pwd);

    @Select("select * from users where user_phone=#{user_phone} and user_pwd=#{user_pwd}")
    User login(@Param("user_phone") String user_phone,@Param("user_pwd") String user_pwd);



}
