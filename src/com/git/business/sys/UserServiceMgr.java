package com.git.business.sys;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.httpclient.HttpException;
import org.dom4j.DocumentException;

import com.git.db.BaseConditionVO;
import com.git.db.beans.SysUser;

import dwz.framework.sys.business.BusinessObjectServiceMgr;
import dwz.framework.sys.exception.ServiceException;

public interface UserServiceMgr extends BusinessObjectServiceMgr {
	String SERVICE_NAME = "userServiceMgr";
	
	/**
	 * 后台添加用户
	 * 
	 * @param user
	 */
	void addUser(User user,String roleId) throws ServiceException;
	
	public int syncAddUser(SysUser sysUser);
	
	public int syncUpdUser(SysUser sysUser);
	
	public int syncUserRole(SysUser user,String roleId);

	void updUser(User user,String roleId);
	
	void delUser(Long id);

	User getUser(Long id);

	User getUserByUserCode(String usercode);
   
	boolean isUniqueUserCode(User user);
	
	List<User> searchUser(UserConditionVO vo);

	int searchUserNum(UserConditionVO vo);
	
	void inactiveUser(Long id);
	
	void normalUser(Long id);
	
	boolean updPassword(Long id,String pwd);
	
	public List searchUserGroup();
	
	public Map searchUser(Map criterias,UserConditionVO vo);
	
    String getRemoteKey(String rootXML, HttpServletRequest req)
	throws HttpException, IOException, DocumentException;
}
