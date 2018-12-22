package com.git.business.sys.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.git.business.sys.Org;
import com.git.business.sys.OrgConditionVO;
import com.git.business.sys.OrgServiceMgr;
import com.git.db.BaseConditionVO;
import com.git.db.beans.SysCode;
import com.git.db.beans.SysGroup;
import com.git.db.mapper.SysCodeMapper;
import com.git.db.mapper.SysGroupMapper;
import com.git.enums.OrgLevel;
import com.git.enums.OrgType;
import com.git.enums.Status;
import com.git.util.Jutil;
import com.git.util.PubDateUtil;
import com.git.util.service.SequenceService;

import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;

@Transactional(rollbackFor = Exception.class)
@Service(OrgServiceMgr.SERVICE_NAME)
public class OrgServiceMgrImpl extends AbstractBusinessObjectServiceMgr
		implements OrgServiceMgr {
	
	@Autowired
	private SysGroupMapper orgMapper;
	
	@Autowired
	private SysCodeMapper sysCodeMapper;
	
	@Autowired
	private SequenceService sequenceService;
		
	public void addOrg(Org org){

		//根据上级机构生成本次新增组织的代码
		String newOrgCode = org.getOrgCode().concat(sequenceService.getSequence("orgCode", org.getOrgLevel()+"", "", 3, '0', 'L'));
		
		org.setId(sequenceService.getSequence("org_id"));
		org.setOrgCode(newOrgCode);
		org.setOrgStatus(Status.Normal.getCode()+"");
		
		if(String.valueOf(OrgType.D).equals(org.getOrgType().toString()))
		{
			org.setOrgLevel(org.getOrgLevel().getCode() - 1);//如果是部门,则层级与父机构层级保持一致
		}
		
		
		Date now = new Date();
		SysGroup po = org.getSysGroup();
		po.setCreateTime(now);
		po.setModifyTime(now);
				
		orgMapper.insert(po);
	}
	
	public int syncAddOrg(SysGroup sysGroup){
		return orgMapper.insert(sysGroup);
	}
	
	public int sysUpdOrg(SysGroup sysGroup){
		return orgMapper.updateByPrimaryKeySelective(sysGroup);
	}

	public void updOrg(Org org) {

		Date now = new Date();
		SysGroup po = org.getSysGroup();
		po.setModifyTime(now);
		
		orgMapper.updateByPrimaryKey(po);
	}
	
	public void delOrg(Long id){
		orgMapper.deleteByPrimaryKey(id);
	}

	public Org getOrg(Long id) {
		SysGroup po = orgMapper.selectByPrimaryKey(id);
		if (po == null) return null;
		
		return new Org(po);
	}
	
	public List<Org> searchOrg(OrgConditionVO vo,
			int startIndex, int count){
		List<Org> orgResult = new ArrayList<Org>();		
		RowBounds rb = new RowBounds(startIndex, count);
		
		try
		{
			List<SysGroup> pos = orgMapper.findPageBreakByCondition(vo.getKeywords(), vo.getOrgType(), rb);
			for (SysGroup po : pos) 
			{
				orgResult.add(new Org(po));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
				
		return orgResult;
	}
	
	public Map searchOrg(Map criterias,OrgConditionVO vo){
		Map<Object, Object> search = new HashMap<Object, Object>();
		StringBuffer sql = new StringBuffer("select * from sys_group c where 2 >1 ");
		
		if(criterias.get("keywords") != null && !"".equals(criterias.get("keywords"))){
			sql.append(" and (c.Org_Sname LIKE '%"+criterias.get("keywords")+"%'   	or c.Org_Name LIKE '%"+criterias.get("keywords")+"%' or c.Org_EName LIKE '%"+criterias.get("keywords")+"%') ");
		}
		
		if(criterias.get("orgStatus") != null && !"".equals(criterias.get("orgStatus"))){
			sql.append(" and c.Org_Status = '"+criterias.get("orgStatus")+"'");
		}
		
		if(criterias.get("orgType") != null && !"".equals(criterias.get("orgType"))){
			sql.append(" and c.`Parent_Id` in( select c.`Org_Id` from sys_group c where c.`Parent_Id`='767') ");
		}
		
		sql.append(" order by c.Org_Id desc");
		
		List orgList = Jutil.executeSQL(sql.toString(), vo.getStartIndex(), vo.getPageSize());
		String count = Jutil.getOneValue(sql.toString().replace("*", "count(1) as count"),"count");
		search.put("orgList", orgList);
		search.put("count", Integer.valueOf(count));
		
		return search;
	}
	
	public int searchOrgNum(){
		String sql = "select * from sys_group g where g.`Org_Id` in (select u.`Org_Id` from sys_user u)";
		return Jutil.executeSQL(sql).size();
	}
	/**
	 * 查找数量
	 */
	public int searchOrgNum(OrgConditionVO vo){
		int count = orgMapper.findNumberByCondition(vo.getKeywords(), vo.getOrgType());
		return count;
	}
	
	/**
	 * 获取同步码
	 * */
	public SysCode getSysCode(String codeid){
		return sysCodeMapper.selectByPrimaryKey(codeid);
	}
	
	/**
	 * 更新同步码
	 * */
	public int updateSysCode(SysCode sysCode){
		sysCode.setBackup(PubDateUtil.dateFormat(new Date()));
		return sysCodeMapper.updateByPrimaryKeySelective(sysCode);
	}

	@Override
	public List<SysGroup> searchOrg(OrgConditionVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
