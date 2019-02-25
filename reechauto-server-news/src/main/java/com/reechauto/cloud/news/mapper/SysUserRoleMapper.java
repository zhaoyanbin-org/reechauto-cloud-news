package com.reechauto.cloud.news.mapper;

import com.reechauto.cloud.news.entity.SysUserRole;
import com.reechauto.cloud.news.entity.SysUserRoleExample;
import com.reechauto.cloud.news.entity.SysUserRoleKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
* 绿驰汽车
* tableName: sys_user_role
* @author zhaoyb
*/
@Repository
public interface SysUserRoleMapper {
    long countByExample(SysUserRoleExample example);

    int deleteByExample(SysUserRoleExample example);

    int deleteByPrimaryKey(SysUserRoleKey key);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    List<SysUserRole> selectByExample(SysUserRoleExample example);

    SysUserRole selectByPrimaryKey(SysUserRoleKey key);

    int updateByExampleSelective(@Param("record") SysUserRole record, @Param("example") SysUserRoleExample example);

    int updateByExample(@Param("record") SysUserRole record, @Param("example") SysUserRoleExample example);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);
}