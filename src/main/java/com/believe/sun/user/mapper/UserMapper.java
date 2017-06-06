package com.believe.sun.user.mapper;

import com.believe.sun.user.model.User;
import com.believe.sun.user.model.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    @Delete({
        "delete from user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into user (account, cellphone, ",
        "email, password, ",
        "nickname, identity, ",
        "roles, headimage, ",
        "status, babyid, ",
        "sex, age, realname)",
        "values (#{account,jdbcType=VARCHAR}, #{cellphone,jdbcType=VARCHAR}, ",
        "#{email,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{nickname,jdbcType=VARCHAR}, #{identity,jdbcType=VARCHAR}, ",
        "#{roles,jdbcType=VARCHAR}, #{headimage,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=VARCHAR}, #{babyid,jdbcType=VARCHAR}, ",
        "#{sex,jdbcType=INTEGER}, #{age,jdbcType=VARCHAR}, #{realname,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    @Select({
        "select",
        "id, account, cellphone, email, password, nickname, identity, roles, headimage, ",
        "status, babyid, sex, age, realname",
        "from user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.believe.sun.user.mapper.UserMapper.BaseResultMap")
    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    @Update({
        "update user",
        "set account = #{account,jdbcType=VARCHAR},",
          "cellphone = #{cellphone,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "nickname = #{nickname,jdbcType=VARCHAR},",
          "identity = #{identity,jdbcType=VARCHAR},",
          "roles = #{roles,jdbcType=VARCHAR},",
          "headimage = #{headimage,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=VARCHAR},",
          "babyid = #{babyid,jdbcType=VARCHAR},",
          "sex = #{sex,jdbcType=INTEGER},",
          "age = #{age,jdbcType=VARCHAR},",
          "realname = #{realname,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);
}