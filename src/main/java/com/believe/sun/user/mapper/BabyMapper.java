package com.believe.sun.user.mapper;

import com.believe.sun.user.model.Baby;
import com.believe.sun.user.model.BabyExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface BabyMapper {
    long countByExample(BabyExample example);

    int deleteByExample(BabyExample example);

    @Delete({
        "delete from baby",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into baby (baby_name, baby_age, ",
        "baby_sex, baby_nickName, ",
        "baby_headimage, photo)",
        "values (#{babyName,jdbcType=VARCHAR}, #{babyAge,jdbcType=INTEGER}, ",
        "#{babySex,jdbcType=INTEGER}, #{babyNickname,jdbcType=VARCHAR}, ",
        "#{babyHeadimage,jdbcType=VARCHAR}, #{photo,jdbcType=CHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Baby record);

    int insertSelective(Baby record);

    List<Baby> selectByExample(BabyExample example);

    @Select({
        "select",
        "id, baby_name, baby_age, baby_sex, baby_nickName, baby_headimage, photo",
        "from baby",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.believe.sun.user.mapper.BabyMapper.BaseResultMap")
    Baby selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Baby record, @Param("example") BabyExample example);

    int updateByExample(@Param("record") Baby record, @Param("example") BabyExample example);

    int updateByPrimaryKeySelective(Baby record);

    @Update({
        "update baby",
        "set baby_name = #{babyName,jdbcType=VARCHAR},",
          "baby_age = #{babyAge,jdbcType=INTEGER},",
          "baby_sex = #{babySex,jdbcType=INTEGER},",
          "baby_nickName = #{babyNickname,jdbcType=VARCHAR},",
          "baby_headimage = #{babyHeadimage,jdbcType=VARCHAR},",
          "photo = #{photo,jdbcType=CHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Baby record);
}