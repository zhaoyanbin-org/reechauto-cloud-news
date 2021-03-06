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
	@Autowired
	private OrganizeUserService organizeUserService;

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
		//判断组织下有没有人员，有人员不可以添加下一级组织
		boolean hasUser = organizeUserService.hasUserOnOrganize(parentOrgId);
		if(hasUser) {
			throw new RuntimeException("组织id为'"+parentOrgId+"'的组织下已分配人员，不可以添加下一级组织");
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
			record.setParentOrgIdAll(parentOrgId+",");
			record.setParentOrgNameAll("/");
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
			record.setParentOrgIdAll(parent.getParentOrgIdAll()+parentOrgId+",");
			record.setParentOrgNameAll(parent.getParentOrgNameAll()+parent.getOrgName()+"/");
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
			flag = true;
		}
		if (sort >= 0) {
			sysOrganize.setSort(sort);
		}
		boolean ret = this.sysOrganizeMapper.updateByPrimaryKey(sysOrganize) > 0;
		if (ret && flag) {
			resetOrganizeLevel(parentOrgId);
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

	/**
	 * 是否有子组织
	 * 
	 * @param orgId
	 * @return
	 */
	public boolean hasChildOrg(Long orgId) {
		SysOrganizeExample example = new SysOrganizeExample();
		example.createCriteria().andParentOrgIdEqualTo(orgId);
		return this.sysOrganizeMapper.countByExample(example) > 0;
	}
	
	/**
	 * 查询当前节点下的所有叶子节点
	 * @param orgId
	 * @param orgIds
	 */
	public void queryAllChildOrgId(Long orgId,List<String> list){
		SysOrganizeExample example=new SysOrganizeExample();
		example.createCriteria().andParentOrgIdEqualTo(orgId);
		List<SysOrganize> so = this.sysOrganizeMapper.selectByExample(example);
		if(CollectionUtils.isNotEmpty(so)) {
			so.forEach(item ->{
				queryAllChildOrgId(item.getOrgId(),list);
			});
		}
		else {
			list.add(orgId+"");
		}
	}

	private int queryOrgName(String orgName) {
		SysOrganizeExample example = new SysOrganizeExample();
		example.createCriteria().andOrgNameEqualTo(orgName);
		return (int) this.sysOrganizeMapper.countByExample(example);
	}

	
	/**
	 * 重置OrgLevel
	 * @param parentOrgId
	 */
	private void resetOrganizeLevel(Long parentOrgId) {
		SysOrganize parentOrg =null;
		if(parentOrgId!=0) {
			parentOrg = this.sysOrganizeMapper.selectByPrimaryKey(parentOrgId);
		}
		SysOrganizeExample example = new SysOrganizeExample();
		example.createCriteria().andParentOrgIdEqualTo(parentOrgId);
		List<SysOrganize> orglist = this.sysOrganizeMapper.selectByExample(example);
		if (CollectionUtils.isNotEmpty(orglist)) {
			for (SysOrganize sysOrganize : orglist) {
				if(parentOrgId==0) {
					sysOrganize.setOrgLevel(1);
					sysOrganize.setParentOrgIdAll("0,");
					sysOrganize.setParentOrgNameAll("/");
				}
				else {
					sysOrganize.setOrgLevel(parentOrg.getOrgLevel()+1);
					sysOrganize.setParentOrgIdAll(parentOrg.getParentOrgIdAll()+parentOrg.getOrgId()+",");
					sysOrganize.setParentOrgNameAll(parentOrg.getParentOrgNameAll()+parentOrg.getOrgName()+"/");
				}
				
				this.sysOrganizeMapper.updateByPrimaryKeySelective(sysOrganize);
				resetOrganizeLevel(sysOrganize.getOrgId());
			}
		}
	}

}
