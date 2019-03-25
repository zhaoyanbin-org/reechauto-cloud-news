package com.reechauto.cloud.news.service.privilege;

import java.util.Date;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reechauto.cloud.common.resp.ResponseData;
import com.reechauto.cloud.news.entity.SysRole;
import com.reechauto.cloud.news.entity.SysRoleExample;
import com.reechauto.cloud.news.entity.SysRoleExample.Criteria;
import com.reechauto.cloud.news.mapper.SysRoleMapper;

@Service
public class RoleService {

	@Autowired
	private SysRoleMapper SysRoleMapper;
	/**
	 * 根据条件查询角色
	 * @param roleId
	 * @param roleName
	 * @return
	 */
	public ResponseData queryRoles(String roleId,String roleName,Integer start,Integer pageNum) {
		SysRoleExample example = new SysRoleExample();
		Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(roleId)) {
			criteria.andRoleIdLike("%"+roleId.trim()+"%");
		}
		if (StringUtils.isNotBlank(roleName)) {
			criteria.andRoleNameLike("%"+roleName.trim()+"%");
		}
		Long total = SysRoleMapper.countByExample(example);
		example.setLimitStart(start);
		example.setOffset(pageNum);
		List<SysRole> list = SysRoleMapper.selectByExample(example);
		return ResponseData.ok().data(list).data("total", total);
	}
	
	public boolean updateRole(String roleId,String roleName,String tips,Long userId) {
		SysRole record = new SysRole();
		record.setRoleId(roleId.trim());
		if (StringUtils.isNotBlank(roleName)) {
			record.setRoleName(roleName.trim());
		}
		if (StringUtils.isNotBlank(tips)) {
			record.setTips(tips);
		}
		if (userId!=null) {
			record.setUpdateBy(userId);
		}
		record.setUpdateTime(new Date());
		return SysRoleMapper.updateByPrimaryKeySelective(record)>0;
	}
	public boolean deleteRole(String roleId) {
		SysRole record = new SysRole();
		record.setRoleId(roleId);
		record.setStatus("N");
		return SysRoleMapper.updateByPrimaryKeySelective(record)>0;
	}
	public boolean addRole(String roleId,String roleName,String tips,Long userId) {
		SysRole record = new SysRole();
		record.setRoleId(roleId.trim());
		record.setRoleName(roleName.trim());
		record.setTips(tips);
		record.setStatus("Y");
		record.setCreateBy(userId);
		record.setCreateTime(new Date());
		return SysRoleMapper.insertSelective(record)>0;
	}
}
