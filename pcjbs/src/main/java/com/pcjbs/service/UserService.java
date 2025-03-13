package com.pcjbs.service;

import com.pcjbs.entity.User;
import com.pcjbs.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> getAllUser(){
        return userMapper.getAllUser();
    }

    public int updateAPwd(String user_id){
        return userMapper.updateAPwd(user_id);
    }

    public List<User> getXzUser(String user_id){
        String whereCondition="where 1=1 ";
        if(!user_id.equals("")){
            whereCondition+=" and user_id like '%"+user_id+"%'";
        }
        return userMapper.getXzUser(whereCondition);
    }

    public int enroll(String user_id,String user_name,String user_phone,String user_pwd){
        int flag=userMapper.enroll(user_id,user_name,user_phone,user_pwd);
        return flag;
    }

    public User login(String user_phone,String user_pwd){
        User userInfo=null;
        userInfo=userMapper.login(user_phone,user_pwd);
        return userInfo;
    }

}
