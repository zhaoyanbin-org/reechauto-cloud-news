package com.reechauto.cloud.news.mapper;

import com.reechauto.cloud.news.entity.SysPrivilege;
import com.reechauto.cloud.news.entity.SysPrivilegeExample;
import com.reechauto.cloud.news.entity.SysPrivilegeKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
* 绿驰汽车
* tableName: sys_privilege
* @author zhaoyb
*/
@Repository
public interface SysPrivilegeMapper {
    long countByExample(SysPrivilegeExample example);

    int deleteByExample(SysPrivilegeExample example);

    int deleteByPrimaryKey(SysPrivilegeKey key);

    int insert(SysPrivilege record);

    int insertSelective(SysPrivilege record);

    List<SysPrivilege> selectByExample(SysPrivilegeExample example);

    SysPrivilege selectByPrimaryKey(SysPrivilegeKey key);

    int updateByExampleSelective(@Param("record") SysPrivilege record, @Param("example") SysPrivilegeExample example);

    int updateByExample(@Param("record") SysPrivilege record, @Param("example") SysPrivilegeExample example);

    int updateByPrimaryKeySelective(SysPrivilege record);

    int updateByPrimaryKey(SysPrivilege record);
}