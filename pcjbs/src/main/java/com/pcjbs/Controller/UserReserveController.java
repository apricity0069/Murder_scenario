package com.pcjbs.Controller;

import com.pcjbs.entity.User;
import com.pcjbs.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Random;

@RestController
public class UserReserveController {
    @Autowired
    private UserService userInfoService;
    private String userid;



    @RequestMapping("user_enroll")
    public int enroll(HttpServletRequest request){
        String randomString = generateRandomString(8);
        String user_id=randomString;
        String user_name=request.getParameter("userName");
        String user_phone=request.getParameter("userPhone");
        String user_pwd=request.getParameter("userPwd");
        System.out.println(user_id+"---"+user_name+"---"+user_phone+"---"+user_pwd);


        int flag=0;
        if(user_name!=null&&user_phone!=null&&user_pwd!=null) {
            flag = userInfoService.enroll(user_id, user_name, user_phone, user_pwd);
        }
        return flag;
    }
    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            stringBuilder.append(characters.charAt(index));
        }

        return stringBuilder.toString();
    }



    @RequestMapping("user_login")
    public User login(HttpServletRequest request){
        String user_phone=request.getParameter("userPhone");
        String user_pwd=request.getParameter("userPwd");
        User userInfo=null;

        userInfo=userInfoService.login(user_phone,user_pwd);

        if(userInfo==null){
            return null;
        }else{
            userid=userInfo.getUser_id();
            return userInfo;
        }

    }




}