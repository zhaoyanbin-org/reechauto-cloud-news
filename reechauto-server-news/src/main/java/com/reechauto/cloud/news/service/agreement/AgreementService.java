package com.reechauto.cloud.news.service.agreement;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reechauto.cloud.news.entity.SysAgreement;
import com.reechauto.cloud.news.entity.SysAgreementExample;
import com.reechauto.cloud.news.mapper.SysAgreementMapper;

@Service
public class AgreementService {
	@Autowired
	private SysAgreementMapper sysAgreementMapper;

	/**
	 * 判断是否同意协议
	 * 
	 * @param userId
	 * @return
	 */
	public boolean isAgreement(Long userId) {
		SysAgreementExample example = new SysAgreementExample();
		example.createCriteria().andUserIdEqualTo(userId);
		return this.sysAgreementMapper.countByExample(example) > 0;
	}

	/**
	 * 同意协议
	 * 
	 * @param userId
	 * @return
	 */
	public boolean agreeAgreement(Long userId) {
		SysAgreement record = new SysAgreement();
		record.setUserId(userId);
		record.setCreateTime(new Date());
		return this.sysAgreementMapper.insertSelective(record) > 0;
	}
}
