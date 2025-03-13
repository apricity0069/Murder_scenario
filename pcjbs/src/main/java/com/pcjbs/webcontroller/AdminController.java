package com.pcjbs.webcontroller;
import com.pcjbs.entity.Admin;
import com.pcjbs.service.AdminService;
import com.pcjbs.service.JbInfoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;
    private JbInfoService jbInfoService;

    @RequestMapping("login")
    public String login() {
        return "login"; // 确保返回的视图名正确
    }


    @RequestMapping("check_login_web")
    public String checkloginWeb(HttpServletRequest request, Model model) {
        String admin_zh= request.getParameter("admin_zh");
        String admin_pwd=request.getParameter("admin_pwd");
        System.out.println(admin_zh+"---"+admin_pwd);

        Admin admin=null;
        HttpSession session=request.getSession();
        admin=adminService.checkLogin(String.valueOf(admin_zh),admin_pwd);
        if(admin==null){
            return "redirect:login";//重定向回login这个请求
        }else{
            session.setAttribute("adm",admin);//用来缓存一个登陆成功的用户信息
            return "redirect:get_all_jb";//重定向到显示主页的请求上
        }
    }

    @RequestMapping("juben")
    public String juben() {
        return "juben"; // 确保返回的视图名正确
    }

}