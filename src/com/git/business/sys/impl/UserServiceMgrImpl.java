package com.git.business.sys.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.ibatis.session.RowBounds;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.git.business.sys.User;
import com.git.business.sys.UserConditionVO;
import com.git.business.sys.UserServiceMgr;
import com.git.db.beans.SysUser;
import com.git.db.beans.SysUserExample;
import com.git.db.beans.SysUserRole;
import com.git.db.beans.SysUserRoleExample;
import com.git.db.mapper.SysUserMapper;
import com.git.db.mapper.SysUserRoleMapper;
import com.git.enums.UserStatus;
import com.git.util.Encrypt;
import com.git.util.Jutil;
import com.git.util.MD5;
import com.git.util.PropertiesFileLoad;
import com.git.util.service.SequenceService;

import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;
import dwz.framework.sys.exception.ServiceException;

@Transactional(rollbackFor = Exception.class)
@Service(UserServiceMgr.SERVICE_NAME)
public class UserServiceMgrImpl extends AbstractBusinessObjectServiceMgr
		implements UserServiceMgr {
	protected static Logger logger = Logger.getLogger(UserServiceMgrImpl.class);
	
	protected static String url = PropertiesFileLoad.getInstance().getP()
	.getProperty("htmis.sso.url");

	@Autowired
	private SysUserMapper userMapper;
	
	@Autowired
	private SequenceService sequenceService;
	
	@Autowired
	SysUserRoleMapper userRoleMapper;
	
	public boolean isUniqueUserCode(User user) {
		Long id = user.getId() != null ? user.getId() : 0;
		return userMapper.isUniqueUserCode(id, user.getUserCode()) < 1;
	}
	
	public int syncAddUser(SysUser sysUser){
		return userMapper.insert(sysUser);
	}
	
	public int syncUpdUser(SysUser sysUser){
		return userMapper.updateByPrimaryKeySelective(sysUser);
	}
	
	/**
	 * 分配初始化用户默认角色
	 * */
	public int syncUserRole(SysUser user,String roleId){
		SysUserRole record = new SysUserRole();
		
		record.setUserId(user.getUserId());
		record.setRoleId(Long.valueOf(roleId));
		record.setOperatorId(user.getOperatorId());
		
		return userRoleMapper.insert(record);
	}

	public void addUser(User user,String roleId) throws ServiceException{
		
		Date now = new Date();
		SysUser po = user.getSysUser();
		Long userId = sequenceService.getSequence("user_id");
		po.setUserId(userId);
		po.setUserPwd(MD5.getMD5ofStr("ht1375"));//新增用户默认密码六个0
		po.setUserStatus(String.valueOf(UserStatus.Normal.getCode()));//新增的用户状态默认为正常
		
//		//设置用户归属部门所在的机构，主要用来做后续的查询使用
//		String tSql = "SELECT ifnull(org_code,'') orgCode FROM sys_group WHERE org_id = (SELECT parent_id FROM sys_group WHERE org_id ="+user.getOrgId()+" ) ";
//		String tOrgCode = Jutil.getOneValue(tSql, "orgCode");
//		
//		po.setOrgCode(tOrgCode);
		po.setCreateTime(now);
		po.setModifyTime(now);
						
		userMapper.insert(po);
		
		if(roleId != null && !"".equals(roleId))
		{
			String [] roleArray = roleId.split(",");
			SysUserRole record;
			for(int i=0; i<roleArray.length;i++)
			{
				if(roleArray[i] == null || "".equals(roleArray[i]))
					continue;
				else
				{
					record = new SysUserRole();
					
					record.setUserId(userId);
					record.setRoleId(Long.valueOf(roleArray[i]));
					record.setOperatorId(user.getOperatorId());
					
					userRoleMapper.insert(record);
				}
			}
		}
	}

	public void updUser(User user,String roleId) {

		Date now = new Date();
		SysUser po = user.getSysUser();
		if(po.getUserStatus() == null)
		{
			po.setUserStatus(String.valueOf(UserStatus.Normal.getCode()));//新增的用户状态默认为正常
		}
		
		po.setModifyTime(now);
		
		userMapper.updateByPrimaryKey(po);
		
		if(roleId != null && !"".equals(roleId))
		{
			SysUserRoleExample example = new SysUserRoleExample();
			example.createCriteria().andUserIdEqualTo(user.getId());
			userRoleMapper.deleteByExample(example);
			
			String [] roleArray = roleId.split(",");
			SysUserRole record;
			for(int i=0; i<roleArray.length;i++)
			{
				if(roleArray[i] == null || "".equals(roleArray[i]))
					continue;
				else
				{
					record = new SysUserRole();
					
					record.setUserId(user.getId());
					record.setRoleId(Long.valueOf(roleArray[i]));
					record.setOperatorId(user.getModifyOperatorId());
					
					userRoleMapper.insert(record);
				}
			}
		}
	}

	public User getUser(Long id) {
		SysUser po = userMapper.selectByPrimaryKey(id);
		if (po == null) return null;
		
		return new User(po);
	}

	public User getUserByUserCode(String userCode){
		SysUser po = userMapper.findByUserCode(userCode);

		if (po == null) return null;
		
		return new User(po);
	}
	
	public SysUser getUserByUserName(String userName){
		SysUserExample example = new SysUserExample();
		example.createCriteria().andUserCodeEqualTo(userName);
		return userMapper.selectByExample(example).get(0);
	}
	
	public List searchUserGroup(){
		String sql = "select g.`Org_Id`,g.`Org_Name` from sys_group g where g.`Org_Id` in (select u.`Org_Id` from sys_user u where u.`User_Status` = '1')";
		return Jutil.executeSQL(sql); 
	}
	
	public Map searchUser(Map criterias,UserConditionVO vo){
		Map<Object, Object> search = new HashMap<Object, Object>();
		StringBuffer sql = new StringBuffer("select * from sys_user u where 2 >1");

		if(criterias.get("keywords") != null && !"".equals(criterias.get("keywords"))){
			sql.append(" and (Name LIKE CONCAT('%','"+criterias.get("keywords")+"','%' ) or S_Name LIKE CONCAT('%','"+criterias.get("keywords")+"','%' ) or en_Name LIKE CONCAT('%','"+criterias.get("keywords")+"','%' ) or User_Code LIKE CONCAT('%','"+criterias.get("keywords")+"','%' )) ");
		}
		
		if(criterias.get("userStatus") != null && !"".equals(criterias.get("userStatus"))){
			sql.append(" and User_Status = '"+criterias.get("userStatus")+"'");
		}
		
		if(criterias.get("userGroup") != null && !"".equals(criterias.get("userGroup"))){
			sql.append(" and Org_Id = '"+criterias.get("userGroup")+"'");
		}
		
		List userList =  Jutil.executeSQL(sql.toString(), vo.getStartIndex(), vo.getPageSize());
		
		String count = Jutil.getOneValue(sql.toString().replace("*", "count(1) as count"),"count");
		
		search.put("userList", userList);
		search.put("count", Integer.valueOf(count));
		
		return search;
	}
	
	public List<User> searchUser(UserConditionVO vo){
		List<User> userResult = new ArrayList<User>();		
		RowBounds rb = new RowBounds(vo.getStartIndex(), vo.getPageSize());
		
		SysUser sysUser = new SysUser();
		sysUser.setName(vo.getKeywords());
		sysUser.setUserStatus(vo.getUserStatus());
		
		if(vo.getOrgCode() !=null && !"".equals(vo.getOrgCode()))
		{
			sysUser.setOrgCode(vo.getOrgCode());
		}
		
		try
		{
			List<SysUser> pos = userMapper.selectByUserCondition(sysUser, rb);
			for (SysUser po : pos) 
			{
				userResult.add(new User(po));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
				
		return userResult;
	}
	
	/**
	 * 查找数量
	 */
	public int searchUserNum(UserConditionVO vo){
		
		SysUser sysUser = new SysUser();
		sysUser.setName(vo.getKeywords());
		sysUser.setUserStatus(vo.getUserStatus());
		if(vo.getOrgCode() !=null && !"".equals(vo.getOrgCode()))
		{
			sysUser.setOrgCode(vo.getOrgCode());
		}
		
		int count = userMapper.countByUserCondition(sysUser);
		return count;
	}
	
	/**
	 * 用户信息不能真正的从数据库中被删除，只能将其状态改为已删除（'4')
	 */
	public void delUser(Long id){
		
		SysUser sysUser = new SysUser();
		sysUser.setUserId(id);
		sysUser.setUserStatus("4");
		
		userMapper.changeUserStatus(sysUser);
		//userMapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * 冻结用户，将状态改为冻结（'3')
	 */
	public void inactiveUser(Long id){
		
		SysUser sysUser = new SysUser();
		sysUser.setUserId(id);
		sysUser.setUserStatus(String.valueOf(UserStatus.Inactive.getCode()));
		
		userMapper.changeUserStatus(sysUser);
		//userMapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * 让用户恢复正常，将状态改为正常（'1')
	 */
	public void normalUser(Long id){
		
		SysUser sysUser = new SysUser();
		sysUser.setUserId(id);
		sysUser.setUserStatus(String.valueOf(UserStatus.Normal.getCode()));
		
		userMapper.changeUserStatus(sysUser);
		//userMapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * 修改用户密码
	 */
	public boolean updPassword(Long id,String pwd)
	{
		SysUser sysUser = new SysUser();
		sysUser.setUserId(id);
		sysUser.setUserPwd(pwd);
		
		int result = userMapper.updatePassword(sysUser);
		if(result == 1)
			return true;
		else
			return false;
	}
	
	/**
	 * 通过远程URL调用取得id对应的用户key，如果没有则返回null。
	 * 
	 * @param url
	 * @param rootXML
	 * @param req
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 * @throws DocumentException
	 */
	public String getRemoteKey(String ticket, HttpServletRequest req)
			throws HttpException, IOException, DocumentException {
		Document requestDocument = DocumentHelper.createDocument();
		requestDocument.setXMLEncoding("UTF-8");
		Element rootElement = requestDocument.addElement("huatai");
		rootElement.addElement("businessType").setText("SSO_LOGIN");
		Element paramEle = rootElement.addElement("param");
		paramEle.addElement("ticket").setText(req.getParameter("ticket")==null?ticket:req.getParameter("ticket"));
		String xml = requestDocument.asXML();
		logger.info(xml);
		HttpClient client = new HttpClient();
		PostMethod httpMethod = new PostMethod(url);
		httpMethod.setRequestEntity(new StringRequestEntity(xml, "text/xlm",
				"utf-8"));
		client.executeMethod(httpMethod);
		String result = httpMethod.getResponseBodyAsString().trim();
		logger.info(result);
		Document responseDocument = DocumentHelper.parseText(result);
		Element huataiElement = responseDocument.getRootElement();
		String status = huataiElement.selectSingleNode("result/status")
				.getText();

		String key = null;
		if ("1".equals(status)) {
			// 成功
			key = huataiElement.selectSingleNode("responseData/userKey")
					.getStringValue();
		} else {
			logger.error("单点登录失败!["
					+ huataiElement.selectSingleNode("result/desc")
							.getStringValue() + "]");
		}
		if (key != null) {
			key = Encrypt.decode(key);
		}
		return key;
	}
}
