package com.pcjbs.Controller;

import com.pcjbs.entity.JbInfo;
import com.pcjbs.service.JbInfoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class JbController {

    @Autowired
    private JbInfoService jbInfoService;


    @RequestMapping("show_all_jb")
    public List<JbInfo> showAllJb(){
        List<JbInfo> jbInfolist=null;
        jbInfolist=jbInfoService.showAllJb();
        System.out.println(jbInfolist);
        return jbInfolist;
    }

    @RequestMapping("show_appoint_jb")
    public List<JbInfo> showAppointJb(HttpServletRequest request){
        List<JbInfo> jbInfoList=null;
        String jbNum=request.getParameter("jbNum");
        String jb_nd=request.getParameter("jbNd");
        String jbPrice=request.getParameter("jbPrice");
        String jb_tag=request.getParameter("jbTag");
        System.out.println(jbNum+"----"+jb_nd+"---"+jbPrice+"---"+jb_tag);
        int jb_num = 0;
        if(jbNum.equals("全部")){
            jb_num=0;
        }else if (!jbNum.equals("null") && !jbNum.isEmpty()) {
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(jbNum);
            if (matcher.find()) {
                String numberStr = matcher.group();
                jb_num = Integer.parseInt(numberStr);
                System.out.println("提取的人数是: " + jb_num);
            } else {
                System.out.println("jbNum参数不合法");
            }
        }

        if(jb_nd.equals("全部")){
            jb_nd="null";
        }

        int jb_price = 0;
        if (jbPrice.equals("全部")){
            jb_price=0;
        }else if (!jbPrice.equals("null") && !jbPrice.isEmpty()) {
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(jbPrice);
            if (matcher.find()) {
                String numberStr = matcher.group();
                jb_price = Integer.parseInt(numberStr);
                System.out.println("提取的价格是: " + jb_price);
            } else {
                System.out.println("jbPrice参数不合法");
            }
        }

        if(jb_tag.equals("全部")){
            jb_tag="null";
        }
        jbInfoList=jbInfoService.showAppointJb(jb_num,jb_nd,jb_price,jb_tag);
        return jbInfoList;
    }

    @RequestMapping("show_name_jb")
    public List<JbInfo> showNameJb(HttpServletRequest request){
        String jb_name=request.getParameter("jbName");
        return jbInfoService.showNameJb(jb_name);
    }

    @RequestMapping("insert_user_jb_yy")
    public int insertUserYy(HttpServletRequest request){
        String jb_id=request.getParameter("jbId");
        String user_id=request.getParameter("userId");
        int result1=0;
        result1=jbInfoService.insertUserYy(jb_id,user_id);

        int result2=0;
        result2=jbInfoService.insertJbYy(jb_id);

        int jb_yy_id=jbInfoService.showJbYyId(jb_id);

        int result4=0;
        result4=jbInfoService.updateJbYyId(jb_yy_id,jb_id);

        return result1&result2&result4;
    }

    @RequestMapping("update_jb_yy_num")
    public int updateJbYyNun(HttpServletRequest request){
        String user_id=request.getParameter("userId");
        String jb_id=request.getParameter("jbId");
        int jb_yy_id=Integer.parseInt(request.getParameter("jbYyId"));
        System.out.println(user_id+"---"+jb_id+"---"+jb_yy_id);
        int result = jbInfoService.updateJbYyNun(jb_yy_id);
        int result2=jbInfoService.insertYy(user_id,jb_id,jb_yy_id);
        return result&result2;
    }

    @RequestMapping("show_all_yying_jb")
    public List<JbInfo> showAllYyingJb(){
        List<JbInfo> jbInfoList=null;
        jbInfoList=jbInfoService.showAllYyingJb();
        return jbInfoList;
    }

    @RequestMapping("is_show_jaru")
    public int isShowJaru(HttpServletRequest request){
        int result=0;
        String user_id=request.getParameter("userId");
        int jb_yy_id=Integer.parseInt(request.getParameter("jbYyId"));
        System.out.println(user_id+"----"+jb_yy_id);
        result=jbInfoService.isShowJaru(user_id,jb_yy_id);
        System.out.println(result);
        return result;
    }

    @RequestMapping("delete_yy")
    public int deleteYy(HttpServletRequest request){
        String user_id=request.getParameter("userId");
        int jb_yy_id=Integer.parseInt(request.getParameter("jbYyId"));
        int result1=0;
        result1=jbInfoService.deleteUserYy(user_id,jb_yy_id);
        int result2=0;
        result2=jbInfoService.updateJbYyNumD(jb_yy_id);
        return result1&result2;
    }

    @RequestMapping("show_all_yy_dd")
    public List<JbInfo> showAllYyDd(HttpServletRequest request){
        String user_id=request.getParameter("userId");
        System.out.println(user_id);
        List<JbInfo> jbInfoList=null;
        jbInfoList=jbInfoService.showAllYyDd(user_id);
        System.out.println(jbInfoList);
        return jbInfoList;
    }

    @RequestMapping("insert_sc")
    public int insertSc(HttpServletRequest request){
        String user_id=request.getParameter("userId");
        String jb_id=request.getParameter("jbId");
        System.out.println(user_id+"---"+jb_id);
        int result=0;
        result=jbInfoService.insertSc(user_id,jb_id);
        return result;
    }

    @RequestMapping("delete_sc")
    public int deleteSc(HttpServletRequest request){
        String user_id=request.getParameter("userId");
        String jb_id=request.getParameter("jbId");
        System.out.println(user_id+"---"+jb_id);
        int result=0;
        result=jbInfoService.deleteSc(user_id,jb_id);
        return result;
    }

    @RequestMapping("show_is_sc")
    public Integer showIsSc(HttpServletRequest request){
        String user_id=request.getParameter("userId");
        String jb_id=request.getParameter("jbId");
        System.out.println(user_id+"---"+jb_id);
        Integer result=0;
        result=jbInfoService.showIsSc(user_id,jb_id);
        return result;
    }

    @RequestMapping("show_all_sc")
    public List<JbInfo> showAllSc(HttpServletRequest request){
        String user_id=request.getParameter("userId");
        System.out.println(user_id);
        List<JbInfo> jbInfoList=null;
        jbInfoList=jbInfoService.showAllSc(user_id);
        return jbInfoList;
    }


}

