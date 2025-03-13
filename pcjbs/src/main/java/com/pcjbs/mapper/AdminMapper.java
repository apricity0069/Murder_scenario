package com.pcjbs.mapper;
import com.pcjbs.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AdminMapper {
    @Select("select * from admin where admin_zh = #{adminZH} and admin_pwd = #{adminPWD}")
        //调用select语句，返回到StuInfoService,再返回到H5StuInfoController,再返回到前端,将2两个参数传给，adminZH,adminPWD
    Admin checkLogin(@Param("adminZH") String admin_zh, @Param("adminPWD") String admin_pwd);

}

