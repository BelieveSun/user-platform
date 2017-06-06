package com.believe.sun.user.mapper;

import com.believe.sun.user.model.Roles;
import com.believe.sun.user.model.RolesExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface RolesMapper {
    long countByExample(RolesExample example);

    int deleteByExample(RolesExample example);

    @Delete({
        "delete from roles",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into roles (role, descriotion, ",
        "permission_id)",
        "values (#{role,jdbcType=VARCHAR}, #{descriotion,jdbcType=VARCHAR}, ",
        "#{permissionId,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Roles record);

    int insertSelective(Roles record);

    List<Roles> selectByExample(RolesExample example);

    @Select({
        "select",
        "id, role, descriotion, permission_id",
        "from roles",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.believe.sun.user.mapper.RolesMapper.BaseResultMap")
    Roles selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Roles record, @Param("example") RolesExample example);

    int updateByExample(@Param("record") Roles record, @Param("example") RolesExample example);

    int updateByPrimaryKeySelective(Roles record);

    @Update({
        "update roles",
        "set role = #{role,jdbcType=VARCHAR},",
          "descriotion = #{descriotion,jdbcType=VARCHAR},",
          "permission_id = #{permissionId,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Roles record);
}