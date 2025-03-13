package com.pcjbs.service;

import com.pcjbs.entity.JbInfo;
import com.pcjbs.mapper.JbInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JbInfoService {
    @Autowired
    private JbInfoMapper jbInfoMapper;


    public int insertJbInfo(String jb_id,String jb_name,String jb_tag,int jb_num,String jb_jj,int jb_price,String jb_nd,String jb_wz) {
        return jbInfoMapper.insertJbInfo(jb_id,jb_name,jb_tag,jb_num,jb_jj,jb_price,jb_nd,jb_wz);
    }

    public List<JbInfo>getALLJb(){
        return jbInfoMapper.getALLJb();
    }

    public List<JbInfo>getXzJb(String jb_name){
        String whereCondition="where 1=1 ";
        if(!jb_name.equals("")){
            whereCondition+=" and jb_name like '%"+ jb_name+ "%'";
        }
        return jbInfoMapper.getXzJb(whereCondition);
    }
    public int deleteJbInfo(String jb_id){
        return jbInfoMapper.deleteJbInfo(jb_id);
    }

    public JbInfo getAInfo(String jbinfo){
        return jbInfoMapper.getAInfo(jbinfo);
    }
    public int updateJbInfo(String jb_id,String jb_name,String jb_tag,int jb_num,String jb_jj,int jb_price,String jb_nd,String jb_wz){
        return jbInfoMapper.updateJbInfo(jb_id,jb_name,jb_tag,jb_num,jb_jj,jb_price,jb_nd,jb_wz);
    }
    public List<JbInfo> getAllDd(){
        return jbInfoMapper.getAllDd();
    }
    public int deleteADd(int jb_yy_id){
        return jbInfoMapper.deleteADd(jb_yy_id);
    }

    public List<JbInfo> getXzDd(int jb_yy_id){
        String whereCondition=" ";
        if(jb_yy_id != 0){
            whereCondition+=" and jb_yy_id like '%"+jb_yy_id+"%'";
        }
        return jbInfoMapper.getXzDd(whereCondition);
    }


    public List<JbInfo> showAllJb(){
        List<JbInfo> jbInfoList=null;
        jbInfoList=jbInfoMapper.showAllJb();
        return jbInfoList;
    }

    public  List<JbInfo> showAppointJb(int jb_num,String jb_nd,int jb_price,String jb_tag){
        List<JbInfo> jbInfoList=null;
        String whereCondition = "where jb_status=1";
        if (jb_num != 0) {
            whereCondition=whereCondition+ "   and jb_num = "+jb_num;
        }
        if (!jb_nd.equals("null") && !jb_nd.isEmpty()) {
            whereCondition= whereCondition+"   and jb_nd = "+"'"+jb_nd+"'";
        }
        if (jb_price != 0) {
            whereCondition= whereCondition+"   and jb_price = "+jb_price;
        }
        if (!jb_tag.equals("null")&& !jb_tag.isEmpty()) {
            whereCondition = whereCondition + " AND jb_tag ="+"'"+jb_tag+"'";
        }
        System.out.println(whereCondition);
        jbInfoList=jbInfoMapper.showAppointJb(whereCondition);
        return jbInfoList;
    }

    public List<JbInfo> showNameJb(String jb_name){
        return jbInfoMapper.showNameJb(jb_name);
    }

    public int insertUserYy(String user_id,String jb_id){
        return jbInfoMapper.insertUserYy(user_id,jb_id);
    }

    public int insertJbYy(String jb_id){
        return jbInfoMapper.insertJbYy(jb_id);
    }

    public int showJbYyId(String jb_id){
        return jbInfoMapper.showJbYyId(jb_id);
    }

    public int updateJbYyId(int jb_yy_id,String jb_id){
        return jbInfoMapper.updateJbYyId(jb_yy_id,jb_id);
    }

    public int updateJbYyNun(int jb_yy_id){
        return jbInfoMapper.updateJbYyNun(jb_yy_id);
    }

    public int insertYy(String user_id,String jb_id,int jb_yy_id){
        return jbInfoMapper.insertYy(user_id,jb_id,jb_yy_id);
    }

    public List<JbInfo> showAllYyingJb(){
        return jbInfoMapper.showAllYyingJb();
    }

    public int isShowJaru(String user_id,int jb_yy_id){
        Integer result = jbInfoMapper.isShowJaru(user_id, jb_yy_id);
        int intValue = (result == null) ? 0 : result.intValue();
        return intValue;
    }

    public int deleteUserYy(String user_id,int jb_yy_id){
        return jbInfoMapper.deleteUserYy(user_id,jb_yy_id);
    }

    public int updateJbYyNumD(int jb_yy_id){
        return jbInfoMapper.updateJbYyNumD(jb_yy_id);
    }

    public List<JbInfo> showAllYyDd(String user_id){
        return jbInfoMapper.showAllYyDd(user_id);
    }

    public int insertSc(String user_id,String jb_id){
        return jbInfoMapper.insertSc(user_id,jb_id);
    }

    public int deleteSc(String user_id,String jb_id){
        return jbInfoMapper.deleteSc(user_id,jb_id);
    }

    public Integer showIsSc(String user_id,String jb_id){
        return jbInfoMapper.showIsSc(user_id,jb_id);
    }

    public List<JbInfo> showAllSc(String user_id){
        return jbInfoMapper.showAllSc(user_id);
    }

}