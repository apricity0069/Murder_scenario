package com.pcjbs.mapper;

import com.pcjbs.entity.JbInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface JbInfoMapper {
    @Insert("INSERT INTO jb(jb_id,jb_name,jb_tag,jb_num,jb_jj,jb_price,jb_nd,jb_wz) " + "VALUES(#{jb_id},#{jb_name}, #{jb_tag}, #{jb_num}, #{jb_jj}, #{jb_price}, #{jb_nd}, #{jb_wz})")
    int insertJbInfo(@Param("jb_id") String jb_id,
                     @Param("jb_name") String jb_name,
                     @Param("jb_tag") String jb_tag,
                     @Param("jb_num") int jb_num,
                     @Param("jb_jj") String jb_jj,
                     @Param("jb_price") int jb_price,
                     @Param("jb_nd") String jb_nd,
                     @Param("jb_wz") String jb_wz);

    @Select("select * from jb")
    List<JbInfo> getALLJb();

    @Select("select * from jb ${whereCondition} ")
    List<JbInfo> getXzJb(@Param("whereCondition") String whereCondition);

    @Delete("delete from jb where jb_id=#{jb_id}")
    int deleteJbInfo(@Param("jb_id") String jb_id);

    @Select("select * from jb where jb_id=#{jb_id}")
    JbInfo getAInfo(@Param("jb_id") String jb_id);

    @Update("update jb set jb_name=#{jb_name},jb_tag=#{jb_tag},jb_num=#{jb_num},jb_jj=#{jb_jj}, jb_price=#{jb_price},jb_nd=#{jb_nd}, jb_wz=#{jb_wz} where jb_id=#{jb_id}")
    int updateJbInfo(@Param("jb_id") String jb_id,@Param("jb_name") String jb_name,@Param("jb_tag") String jb_tag,@Param("jb_num") int jb_num,@Param("jb_jj") String jb_jj,@Param("jb_price") int jb_price ,@Param("jb_nd") String jb_nd , @Param("jb_wz")String jb_wz );

    @Select("SELECT * FROM jb_yy inner join jb where jb.jb_id=jb_yy.jb_id")
    List<JbInfo> getAllDd();

    @Delete("delete from jb_yy where jb_yy_id=#{jb_yy_id}")
    int deleteADd(@Param("jb_yy_id") int jb_yy_id);

    @Select("select * from jb_yy inner join jb where jb.jb_id=jb_yy.jb_id  ${whereCondition}")
    List<JbInfo> getXzDd(@Param("whereCondition") String whereCondition);



    @Select("select * from jb where jb_status=1")
    List<JbInfo> showAllJb();

    @Select("select * from jb ${whereCondition}")
    List<JbInfo> showAppointJb(@Param("whereCondition") String whereCondition);

    @Select("SELECT * FROM jb WHERE jb_name LIKE CONCAT('%', #{jb_name}, '%')")
    List<JbInfo> showNameJb(@Param("jb_name") String jb_name);

    @Insert("insert into user_jb_yy(user_id,jb_id,pay_status) values(#{user_id},#{jb_id},0)")
    int insertUserYy(@Param("jb_id") String jb_id,@Param("user_id") String user_id);


    @Insert("insert into jb_yy(jb_id,yy_num) values(#{jb_id},1)")
    int insertJbYy(@Param("jb_id") String jb_id);

    @Select("select jb_yy_id from jb_yy where jb_id=#{jb_id}")
    int showJbYyId(@Param("jb_id") String jb_id);

    @Update("update user_jb_yy set jb_yy_id=#{jb_yy_id} where jb_id=#{jb_id}")
    int updateJbYyId(@Param("jb_yy_id") int jb_yy_id,@Param("jb_id") String jb_id);

    @Update("update jb_yy set yy_num=yy_num+1 where jb_yy_id=#{jb_yy_id}")
    int updateJbYyNun(@Param("jb_yy_id") int jb_yy_id);

    @Insert("insert into user_jb_yy(user_id,jb_id,pay_status,jb_yy_id) values(#{user_id},#{jb_id},0,#{jb_yy_id})")
    int insertYy(@Param("user_id") String user_id,@Param("jb_id") String jb_id,@Param("jb_yy_id") int jb_yy_id);

    @Select("SELECT jb_yy.jb_yy_id, jb.jb_id, jb.jb_name, jb.jb_tag, jb.jb_nd, jb.jb_num, jb_yy.yy_num ,jb_wz\n" +
            "FROM jb_yy\n" +
            "INNER JOIN jb ON jb_yy.jb_id = jb.jb_id;")
    List<JbInfo> showAllYyingJb();

    @Select("SELECT IFNULL(jb_yy_id, 0) FROM user_jb_yy WHERE user_id=#{user_id} AND jb_yy_id=#{yy_jb_id}")
    Integer isShowJaru(@Param("user_id") String user_id, @Param("yy_jb_id") int yy_jb_id);

    @Delete("delete from user_jb_yy where user_id=#{user_id} and jb_yy_id=#{jb_yy_id}")
    int deleteUserYy(@Param("user_id") String user_id,@Param("jb_yy_id") int yy_jb_id);

    @Update("update jb_yy set yy_num=yy_num-1 where jb_yy_id=#{jb_yy_id} ")
    int updateJbYyNumD(@Param("jb_yy_id") int jb_yy_id);

    @Select("SELECT * FROM user_jb_yy INNER JOIN jb ON user_jb_yy.jb_id = jb.jb_id where user_id=#{user_id}")
    List<JbInfo> showAllYyDd(@Param("user_id") String user_id);

    @Insert("insert into user_sc(user_id,jb_id) values(#{user_id},#{jb_id}) ")
    int insertSc(@Param("user_id") String user_id,@Param("jb_id") String jb_id);

    @Delete("delete from user_sc where user_id=#{user_id} and jb_id=#{jb_id}")
    int deleteSc(@Param("user_id") String user_id,@Param("jb_id") String jb_id);

    @Select("select COALESCE(user_sc_id, 0) from user_sc where user_id=#{user_id} and jb_id=#{jb_id}")
    Integer showIsSc(@Param("user_id") String user_id, @Param("jb_id") String jb_id);

    @Select("select * from user_sc inner join jb on user_sc.jb_id=jb.jb_id where user_id=#{user_id}")
    List<JbInfo> showAllSc(@Param("user_id") String user_id);


}