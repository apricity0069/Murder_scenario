package com.pcjbs.webcontroller;

import com.pcjbs.entity.User;
import com.pcjbs.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("get_all_user")
    public String getAllUser(Model model){
        System.out.println("getalluser");
        List<User> userList=null;
        userList=userService.getAllUser();
        System.out.println(userList);
        model.addAttribute("user",userList);
        return "user";

    }

    @RequestMapping("update_a_pwd")
    public String updateAPwd(HttpServletRequest request,Model model){
        String user_id=request.getParameter("user_id");
        int flag=userService.updateAPwd(user_id);
        if(flag>0){
            List<User> userList=null;
            userList=userService.getAllUser();
            System.out.println(userList);
            model.addAttribute("user",userList);
            return "user";
        }else {
            return "error_page";
        }
    }

    @RequestMapping("get_xz_user")
    public String getXzUser(HttpServletRequest request,Model model){
        String user_id=request.getParameter("user_id");
        System.out.println(user_id);
        List<User> userList=null;
        userList=userService.getXzUser(user_id);
        System.out.println(userList);
        model.addAttribute("user",userList);
        return "user";
    }



}
