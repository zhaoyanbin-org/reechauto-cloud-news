package com.reechauto.cloud.news.mapper;

import com.reechauto.cloud.news.entity.SysResourceScope;
import com.reechauto.cloud.news.entity.SysResourceScopeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
* 绿驰汽车
* tableName: sys_resource_scope
* @author zhaoyb
*/
@Repository
public interface SysResourceScopeMapper {
    long countByExample(SysResourceScopeExample example);

    int deleteByExample(SysResourceScopeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysResourceScope record);

    int insertSelective(SysResourceScope record);

    List<SysResourceScope> selectByExample(SysResourceScopeExample example);

    SysResourceScope selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysResourceScope record, @Param("example") SysResourceScopeExample example);

    int updateByExample(@Param("record") SysResourceScope record, @Param("example") SysResourceScopeExample example);

    int updateByPrimaryKeySelective(SysResourceScope record);

    int updateByPrimaryKey(SysResourceScope record);
}