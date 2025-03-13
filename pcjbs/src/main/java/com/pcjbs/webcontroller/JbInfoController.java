package com.pcjbs.webcontroller;


import com.pcjbs.entity.JbInfo;
import com.pcjbs.service.JbInfoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Random;

@Controller
public class JbInfoController {

    @Autowired
    private JbInfoService jbInfoService;

    @RequestMapping("insert_jbinfo")
    public String insertJbInfo(HttpServletRequest request, RedirectAttributes attributes) {
        // 从请求中获取剧本信息
        System.out.println("Method insertJbInfo is called.");

        String randomString = generateRandomString(8);
        String jb_id=randomString;
        String jb_name = request.getParameter("jb_name");
        String jb_tag = request.getParameter("jb_tag");
        int jb_num = Integer.parseInt(request.getParameter("jb_num"));
        String jb_jj = request.getParameter("jb_jj");
        int jb_price = Integer.parseInt(request.getParameter("jb_price"));
        String jb_nd = request.getParameter("jb_nd");
        String jb_wz = request.getParameter("jb_wz");
        System.out.println(jb_id+" "+jb_name+" "+jb_tag+" "+jb_num+" "+jb_jj+" "+jb_price+" "+jb_nd+" "+jb_wz);

        int result=0;
        result=jbInfoService.insertJbInfo(jb_id,jb_name,jb_tag,jb_num,jb_jj,jb_price,jb_nd,jb_wz);
        if(result>0){
            attributes.addAttribute("jb_id","");
            attributes.addAttribute("jb_name","");
            attributes.addAttribute("jb_tag","");
            attributes.addAttribute("jb_num","");
            attributes.addAttribute("jb_jj","");
            attributes.addAttribute("jb_price","");
            attributes.addAttribute("jb_nd","");
            attributes.addAttribute("jb_wz","");
            return "redirect:get_all_jb";

        }else{
            return "error_page";
        }
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
    @RequestMapping("get_all_jb")
    public String getALLJb( Model model){

        System.out.println("getalljb");
        List<JbInfo> jbInfos =null;
        jbInfos=jbInfoService.getALLJb();
        System.out.println(jbInfos);
        model.addAttribute("juben",jbInfos);
        return "juben";
    }

    @RequestMapping("get_xz_jb")
    public String getXzJb(HttpServletRequest request ,Model model){
        String jb_name = request.getParameter("jbName");
        System.out.println("chaxun"+jb_name);
        List<JbInfo> jbInfos=null;
        jbInfos=jbInfoService.getXzJb(jb_name);
        System.out.println(jbInfos);
        model.addAttribute("juben",jbInfos);
        return "juben";
    }


  @RequestMapping("delete_jb_info")
    public String deleteJbInfo(HttpServletRequest request,Model model){
        String jb_id=request.getParameter("jb_id");
        int flag=jbInfoService.deleteJbInfo(jb_id);
        if(flag>0){
            List<JbInfo> jbInfos =null;
            jbInfos=jbInfoService.getALLJb();
            System.out.println(jbInfos);
            model.addAttribute("juben",jbInfos);
            return "juben";
        }else {
            return "error_page";
        }
  }
  @RequestMapping("get_a_info")
    public String getAInfo(HttpServletRequest request,Model model){
        String jb_id=request.getParameter("jb_id");
        JbInfo jbInfo=jbInfoService.getAInfo(jb_id);
      model.addAttribute("jb_name", jbInfo.getJb_name());
      model.addAttribute("jb_tag", jbInfo.getJb_tag());
      model.addAttribute("jb_num", jbInfo.getJb_num());
      model.addAttribute("jb_jj", jbInfo.getJb_jj());
      model.addAttribute("jb_price", jbInfo.getJb_price());
      model.addAttribute("jb_nd", jbInfo.getJb_nd());
      model.addAttribute("jb_wz", jbInfo.getJb_wz());
        return "xiugai";
  }
  @RequestMapping("update_jbinfo")
    public String updateJbInfo(HttpServletRequest request){
      String jb_id=request.getParameter("jb_id");
      String jb_name = request.getParameter("jb_name");
      String jb_tag = request.getParameter("jb_tag");
      int jb_num = Integer.parseInt(request.getParameter("jb_num"));
      String jb_jj = request.getParameter("jb_jj");
      int jb_price = Integer.parseInt(request.getParameter("jb_price"));
      String jb_nd = request.getParameter("jb_nd");
      String jb_wz = request.getParameter("jb_wz");
      System.out.println(jb_id+" "+jb_name+" "+jb_tag+" "+jb_num+" "+jb_jj+" "+jb_price+" "+jb_nd+" "+jb_wz);

      int flag=jbInfoService.updateJbInfo(jb_id,jb_name,jb_tag,jb_num,jb_jj,jb_price,jb_nd,jb_wz);
      if(flag>0){
          return "redirect:get_all_jb";
      }else{
          return "error_page";
      }
  }

  @RequestMapping("get_all_dd")
  public String getAllDd(Model model){
      System.out.println("getalldd");
      List<JbInfo> jbInfos=null;
      jbInfos=jbInfoService.getAllDd();
      System.out.println(jbInfos);
      model.addAttribute("dd",jbInfos);
      return "order";
  }
  @RequestMapping("delete_a_dd")
    public String deleteADd(HttpServletRequest request,Model model){
        int jb_yy_id=Integer.parseInt(request.getParameter("jb_yy_id"));
        int flag=jbInfoService.deleteADd(jb_yy_id);
        if(flag>0){
            List<JbInfo> jbInfos=null;
            jbInfos=jbInfoService.getAllDd();
            System.out.println(jbInfos);
            model.addAttribute("dd",jbInfos);
            return "order";
        }else{
            return "error_page";
        }
  }

  @RequestMapping("get_xz_dd")
    public String getXzDd(HttpServletRequest request,Model model){
        int jb_yy_id=0;
        if(!request.getParameter("yyid").equals("")){
            jb_yy_id=Integer.parseInt(request.getParameter("yyid"));
        }
      System.out.println(jb_yy_id);
      List<JbInfo> jbInfos=null;
      jbInfos=jbInfoService.getXzDd(jb_yy_id);
      System.out.println(jbInfos);
      model.addAttribute("dd",jbInfos);
      return "order";
  }
  @RequestMapping("tiaozhuan")
    public String tiaoZhuan(Model model){
        model.addAttribute("gun");
        return "shuju";
  }



}
