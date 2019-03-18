package com.reechauto.cloud.news.mapper;

import com.reechauto.cloud.news.entity.SysOrganizeUser;
import com.reechauto.cloud.news.entity.SysOrganizeUserExample;
import com.reechauto.cloud.news.entity.SysOrganizeUserKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
* 绿驰汽车
* tableName: sys_organize_user
* @author zhaoyb
*/
@Repository
public interface SysOrganizeUserMapper {
    long countByExample(SysOrganizeUserExample example);

    int deleteByExample(SysOrganizeUserExample example);

    int deleteByPrimaryKey(SysOrganizeUserKey key);

    int insert(SysOrganizeUser record);

    int insertSelective(SysOrganizeUser record);

    List<SysOrganizeUser> selectByExample(SysOrganizeUserExample example);

    SysOrganizeUser selectByPrimaryKey(SysOrganizeUserKey key);

    int updateByExampleSelective(@Param("record") SysOrganizeUser record, @Param("example") SysOrganizeUserExample example);

    int updateByExample(@Param("record") SysOrganizeUser record, @Param("example") SysOrganizeUserExample example);

    int updateByPrimaryKeySelective(SysOrganizeUser record);

    int updateByPrimaryKey(SysOrganizeUser record);
}