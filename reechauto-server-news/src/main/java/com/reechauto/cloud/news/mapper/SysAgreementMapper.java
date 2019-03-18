package com.reechauto.cloud.news.mapper;

import com.reechauto.cloud.news.entity.SysAgreement;
import com.reechauto.cloud.news.entity.SysAgreementExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
* 绿驰汽车
* tableName: sys_agreement
* @author zhaoyb
*/
@Repository
public interface SysAgreementMapper {
    long countByExample(SysAgreementExample example);

    int deleteByExample(SysAgreementExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(SysAgreement record);

    int insertSelective(SysAgreement record);

    List<SysAgreement> selectByExample(SysAgreementExample example);

    SysAgreement selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") SysAgreement record, @Param("example") SysAgreementExample example);

    int updateByExample(@Param("record") SysAgreement record, @Param("example") SysAgreementExample example);

    int updateByPrimaryKeySelective(SysAgreement record);

    int updateByPrimaryKey(SysAgreement record);
}