package com.believe.sun.user.mapper;

import com.believe.sun.user.model.Permission;
import com.believe.sun.user.model.PermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface PermissionMapper {
    long countByExample(PermissionExample example);

    int deleteByExample(PermissionExample example);

    @Delete({
        "delete from permission",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into permission (parent_id, name, ",
        "descriotion, status)",
        "values (#{parentId,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{descriotion,jdbcType=VARCHAR}, #{status,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Permission record);

    int insertSelective(Permission record);

    List<Permission> selectByExample(PermissionExample example);

    @Select({
        "select",
        "id, parent_id, name, descriotion, status",
        "from permission",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.believe.sun.user.mapper.PermissionMapper.BaseResultMap")
    Permission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByExample(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByPrimaryKeySelective(Permission record);

    @Update({
        "update permission",
        "set parent_id = #{parentId,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR},",
          "descriotion = #{descriotion,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Permission record);
}