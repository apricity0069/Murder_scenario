package com.pcjbs.service;
import com.pcjbs.entity.Admin;
import com.pcjbs.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminMapper adminMapper;
    public Admin checkLogin(String admin_zh, String admin_pwd) {
        Admin admin=null;
        admin=adminMapper.checkLogin(admin_zh,admin_pwd);
        return admin;
    }

}
