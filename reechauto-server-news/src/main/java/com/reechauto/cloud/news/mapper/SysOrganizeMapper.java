package com.reechauto.cloud.news.mapper;

import com.reechauto.cloud.news.entity.SysOrganize;
import com.reechauto.cloud.news.entity.SysOrganizeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
* 绿驰汽车
* tableName: sys_organize
* @author zhaoyb
*/
@Repository
public interface SysOrganizeMapper {
    long countByExample(SysOrganizeExample example);

    int deleteByExample(SysOrganizeExample example);

    int deleteByPrimaryKey(Long orgId);

    int insert(SysOrganize record);

    int insertSelective(SysOrganize record);

    List<SysOrganize> selectByExample(SysOrganizeExample example);

    SysOrganize selectByPrimaryKey(Long orgId);

    int updateByExampleSelective(@Param("record") SysOrganize record, @Param("example") SysOrganizeExample example);

    int updateByExample(@Param("record") SysOrganize record, @Param("example") SysOrganizeExample example);

    int updateByPrimaryKeySelective(SysOrganize record);

    int updateByPrimaryKey(SysOrganize record);
}