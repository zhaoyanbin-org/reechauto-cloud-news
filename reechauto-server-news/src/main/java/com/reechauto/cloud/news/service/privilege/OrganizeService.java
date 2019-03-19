package com.reechauto.cloud.news.service.privilege;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reechauto.cloud.common.utils.code.IdGenerator;
import com.reechauto.cloud.news.bean.organize.SysOrganizeBean;
import com.reechauto.cloud.news.entity.SysOrganize;
import com.reechauto.cloud.news.entity.SysOrganizeExample;
import com.reechauto.cloud.news.entity.SysOrganizeExample.Criteria;
import com.reechauto.cloud.news.mapper.SysOrganizeMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrganizeService {
	@Autowired
	private SysOrganizeMapper sysOrganizeMapper;

	/**
	 * 新增加组织
	 * 
	 * @param orgName
	 * @param parentOrgId
	 * @return
	 */
	public boolean addOrganize(String orgName, Long parentOrgId, int sort) {
		log.info("添加组织");
		int n = queryOrgName(orgName.trim());
		if (n > 0) {
			throw new RuntimeException("组织名'" + orgName + "'已被占用");
		}
		SysOrganize record = new SysOrganize();
		Long orgId = IdGenerator.getInstance().nextId();
		if (parentOrgId <= 0) {
			parentOrgId = 0L;
			// 第一级组织
			record.setIsEnable("Y");
			record.setOrgId(orgId);
			record.setOrgName(orgName);
			record.setParentOrgId(parentOrgId);
			record.setOrgLevel(1);
			record.setSort(sort);
		} else {
			// 查询上一级组织
			SysOrganize parent = this.sysOrganizeMapper.selectByPrimaryKey(parentOrgId);
			if (parent == null) {
				throw new RuntimeException("不存在的上级组织ID'" + parentOrgId + "'");
			}
			int orgLevel = parent.getOrgLevel() + 1;
			record.setIsEnable("Y");
			record.setOrgId(orgId);
			record.setOrgName(orgName);
			record.setParentOrgId(parentOrgId);
			record.setOrgLevel(orgLevel);
			record.setSort(sort);
		}
		return this.sysOrganizeMapper.insertSelective(record) > 0;
	}

	/**
	 * 修改组织
	 * 
	 * @param orgId
	 * @param orgName
	 * @param parentOrgId
	 * @param sort
	 * @return
	 */
	public boolean updateOrganizeByOrgId(Long orgId, String orgName, Long parentOrgId, int sort) {
		SysOrganize sysOrganize = this.sysOrganizeMapper.selectByPrimaryKey(orgId);
		if (sysOrganize == null) {
			throw new RuntimeException("不存在的组织ID'" + orgId + "'");
		}
		if (StringUtils.isNotBlank(orgName)) {
			sysOrganize.setOrgName(orgName);
		}
		boolean flag = false;
		if (parentOrgId != null && parentOrgId >= 0) {
			sysOrganize.setParentOrgId(parentOrgId);
			flag=true;
		}
		if (sort >= 0) {
			sysOrganize.setSort(sort);
		}
		boolean ret = this.sysOrganizeMapper.updateByPrimaryKey(sysOrganize) > 0;
		if(ret&&flag) {
			int orgLevel=0;
			if(parentOrgId!=0) {
				SysOrganize parent =this.sysOrganizeMapper.selectByPrimaryKey(parentOrgId);
				orgLevel = parent.getOrgLevel();
			}
			resetOrganizeLevel(parentOrgId,orgLevel);
		}
		return ret;
	}

	/**
	 * 删除当前组织及其下级组织
	 * 
	 * @param orgId
	 */
	@Transactional
	public void delOrg(Long orgId) {
		SysOrganize sysOrganize = this.sysOrganizeMapper.selectByPrimaryKey(orgId);
		if (sysOrganize == null) {
			throw new RuntimeException("不存在的组织ID'" + orgId + "'");
		}
		sysOrganize.setIsEnable("N");
		this.sysOrganizeMapper.updateByPrimaryKeySelective(sysOrganize);
		delOrgByParentOrgId(orgId);
	}

	/**
	 * 根据父ID删除组织
	 * 
	 * @param parentOrgId
	 */
	@Transactional
	public void delOrgByParentOrgId(Long parentOrgId) {
		SysOrganizeExample example = new SysOrganizeExample();
		example.createCriteria().andParentOrgIdEqualTo(parentOrgId);
		List<SysOrganize> orglist = this.sysOrganizeMapper.selectByExample(example);
		if (CollectionUtils.isNotEmpty(orglist)) {
			orglist.forEach(item -> {
				SysOrganize sysOrganize = this.sysOrganizeMapper.selectByPrimaryKey(item.getOrgId());
				sysOrganize.setIsEnable("N");
				this.sysOrganizeMapper.updateByPrimaryKeySelective(sysOrganize);
				delOrgByParentOrgId(item.getOrgId());
			});
		}
	}

	/**
	 * 根据parentOrgId查询组织
	 * 
	 * @param parentOrgId
	 * @return
	 */
	public List<SysOrganizeBean> queryOrgByParentOrgId(Long parentOrgId, Boolean isAll) {
		List<SysOrganizeBean> list = new ArrayList<SysOrganizeBean>();
		SysOrganizeExample example = new SysOrganizeExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentOrgIdEqualTo(parentOrgId);
		if (!isAll) {
			criteria.andIsEnableEqualTo("Y");
		}
		example.setOrderByClause(" sort ASC");
		List<SysOrganize> orglist = this.sysOrganizeMapper.selectByExample(example);
		if (CollectionUtils.isNotEmpty(orglist)) {
			orglist.forEach(item -> {
				SysOrganizeBean bean = new SysOrganizeBean();
				BeanUtils.copyProperties(item, bean);
				List<SysOrganizeBean> childOrg = queryOrgByParentOrgId(item.getOrgId(), isAll);
				bean.setChildOrg(childOrg);
				list.add(bean);
			});
		}
		return list;
	}

	/**
	 * 查询当前组织及其子组织
	 * 
	 * @param orgId
	 * @return
	 */
	public SysOrganizeBean queryOrgByOrgId(Long orgId, Boolean isAll) {
		SysOrganizeBean bean = new SysOrganizeBean();
		SysOrganize sysOrganize = this.sysOrganizeMapper.selectByPrimaryKey(orgId);
		if (sysOrganize == null) {
			throw new RuntimeException("不存在的组织ID'" + orgId + "'");
		}
		BeanUtils.copyProperties(sysOrganize, bean);
		List<SysOrganizeBean> childOrg = queryOrgByParentOrgId(orgId, isAll);
		bean.setChildOrg(childOrg);
		return bean;
	}

	private int queryOrgName(String orgName) {
		SysOrganizeExample example = new SysOrganizeExample();
		example.createCriteria().andOrgNameEqualTo(orgName);
		return (int) this.sysOrganizeMapper.countByExample(example);
	}
	


	/**
	 * 重置OrgLevel
	 * @param parentOrgId
	 * @param parentOrgLevel
	 */
	private void resetOrganizeLevel(Long parentOrgId,int parentOrgLevel) {
		SysOrganizeExample example = new SysOrganizeExample();
		example.createCriteria().andParentOrgIdEqualTo(parentOrgId);
		List<SysOrganize> orglist = this.sysOrganizeMapper.selectByExample(example);
		if (CollectionUtils.isNotEmpty(orglist)) {
			for (SysOrganize sysOrganize : orglist) {
				int orgLevel = parentOrgLevel+1;
				sysOrganize.setOrgLevel(orgLevel);
				this.sysOrganizeMapper.updateByPrimaryKeySelective(sysOrganize);
				resetOrganizeLevel(sysOrganize.getOrgId(),orgLevel);
			}
		} 
	}

	/**
	 * 组织orgId
	 * 
	 * @param parentOrgId
	 * @return
	 */
	private Long getOrgId(Long parentOrgId) {
		if (parentOrgId <= 0) {
			parentOrgId = 0L;
		}
		SysOrganizeExample example = new SysOrganizeExample();
		example.createCriteria().andParentOrgIdEqualTo(parentOrgId);
		example.setOrderByClause(" org_id desc");
		List<SysOrganize> list = this.sysOrganizeMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(list)) {
			// 没有子组织,父组织Id后加10;
			if (parentOrgId == 0) {
				return 10L;
			} else {
				return Long.valueOf(parentOrgId + "10");
			}
		}
		return list.get(0).getOrgId() + 1;
	}

}
