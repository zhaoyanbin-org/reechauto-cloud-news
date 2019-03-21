package com.reechauto.cloud.news.service.privilege;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.reechauto.cloud.news.bean.organize.UserOrganizeDetails;
import com.reechauto.cloud.news.entity.SysOrganizeUser;
import com.reechauto.cloud.news.entity.SysOrganizeUserExample;
import com.reechauto.cloud.news.entity.SysOrganizeUserKey;
import com.reechauto.cloud.news.mapper.SysOrganizeUserMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrganizeUserService {
	@Autowired
	private SysOrganizeUserMapper sysOrganizeUserMapper;
	@Autowired
	private OrganizeService organizeService;
	@Autowired
	private JdbcTemplate jdbcTemplate;


	/**
	 * 给组织添加用户
	 * @param orgId
	 * @param userId
	 * @param operBy
	 * @return
	 */
	public boolean organizeAddUser(Long orgId, Long userId, Long operBy) {
		/*
		 * 判断有没有下一级组织，人员只能添加到最低层节点
		 */
		log.info("给组织添加用户");
		boolean flag = organizeService.hasChildOrg(orgId);
		if (flag) {
			throw new RuntimeException("人员只能添加到叶子节点");
		}

		SysOrganizeUserKey key = new SysOrganizeUserKey();
		key.setOrgId(orgId);
		key.setUserId(userId);
		SysOrganizeUser sysOrganizeUser = this.sysOrganizeUserMapper.selectByPrimaryKey(key);
		if (sysOrganizeUser != null) {
			throw new RuntimeException("该组织中此用户已存在");
		}
		SysOrganizeUser record = new SysOrganizeUser();
		record.setCreateBy(operBy);
		record.setCreateTime(new Date());
		record.setOrgId(orgId);
		record.setUserId(userId);
		return this.sysOrganizeUserMapper.insertSelective(record) > 0;
	}

	/**
	 * 批量添加用户
	 * @param orgId
	 * @param UserIds
	 * @param operBy
	 * @return
	 */
	@Transactional
	public boolean organizeBatchAddUsers(Long orgId, String UserIds, Long operBy) {
		/*
		 * 判断有没有下一级组织，人员只能添加到最低层节点
		 */
		log.info("批量添加用户");
		boolean flag = organizeService.hasChildOrg(orgId);
		if (flag) {
			throw new RuntimeException("人员只能添加到叶子节点");
		}
		String[] userArr = UserIds.split(",");
		for (String userId : userArr) {
			SysOrganizeUser record = new SysOrganizeUser();
			record.setCreateBy(operBy);
			record.setCreateTime(new Date());
			record.setOrgId(orgId);
			record.setUserId(Long.parseLong(userId));
			this.sysOrganizeUserMapper.insertSelective(record);
		}
		return true;
	}
	
	/**
	 * 删除组织下的用户
	 * @param orgId
	 * @param userId
	 * @return
	 */
	public boolean organizeDelUser(Long orgId, Long userId) {
		/*
		 * 判断有没有下一级组织，人员只能添加到最低层节点
		 */
		log.info("删除组织下的用户");
		SysOrganizeUserKey key = new SysOrganizeUserKey();
		key.setOrgId(orgId);
		key.setUserId(userId);
		SysOrganizeUser sysOrganizeUser = this.sysOrganizeUserMapper.selectByPrimaryKey(key);
		if (sysOrganizeUser == null) {
			throw new RuntimeException("该组织中此用户不存在");
		}
		
		return this.sysOrganizeUserMapper.deleteByPrimaryKey(key)>0;
	}

	/**
	 * 判断组织下有没有人员
	 * 
	 * @param orgId
	 * @return
	 */
	public boolean hasUserOnOrganize(Long orgId) {
		SysOrganizeUserExample example = new SysOrganizeUserExample();
		example.createCriteria().andOrgIdEqualTo(orgId);
		return this.sysOrganizeUserMapper.countByExample(example) > 0;
	}

	/**
	 * 根据组织ID查询该组织下的用户
	 * @param orgId
	 * @return
	 */
	public List<UserOrganizeDetails> queryOrgUserByOrgId(Long orgId,int pageNum,int pageSize) {
		int start = (pageNum-1)*pageSize;
		List<String> list = new ArrayList<String>();
		organizeService.queryAllChildOrgId(orgId, list);
		if (CollectionUtils.isNotEmpty(list)) {
			String orgIds = String.join(",", list);
			String sql = "SELECT c.*,b.org_id,b.org_name FROM sys_organize_user a,sys_organize b,user_details c WHERE a.org_id=b.org_id AND a.user_Id=c.user_id AND a.org_id IN("
					+ orgIds + ")  ORDER BY a.org_id LIMIT "+start+","+pageSize;
			RowMapper<UserOrganizeDetails> rowMapper = new BeanPropertyRowMapper<UserOrganizeDetails>(
					UserOrganizeDetails.class);
			List<UserOrganizeDetails> userList = jdbcTemplate.query(sql, rowMapper);
			return userList;
		} else {
			return null;
		}
	}

}
