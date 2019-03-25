package com.reechauto.cloud.news.service.privilege;

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
	public ResponseData queryRoles(String roleId,String roleName) {
		SysRoleExample example = new SysRoleExample();
		Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(roleId)) {
			criteria.andRoleIdLike("%"+roleId.trim()+"%");
		}
		if (StringUtils.isNotBlank(roleName)) {
			criteria.andRoleNameLike("%"+roleName.trim()+"%");
		}
		Long total = SysRoleMapper.countByExample(example);
		List<SysRole> list = SysRoleMapper.selectByExample(example);
		return ResponseData.ok().data(list).data("total", total);
	}
}
