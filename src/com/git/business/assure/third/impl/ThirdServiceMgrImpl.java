package com.git.business.assure.third.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.git.business.assure.third.Third;
import com.git.business.assure.third.ThirdServiceMgr;
import com.git.business.sys.User;
import com.git.db.BaseConditionVO;
import com.git.db.beans.TblThirdParty;
import com.git.db.beans.TblThirdPartyExample;
import com.git.db.mapper.TblThirdPartyMapper;
import com.git.util.service.SequenceService;

import dwz.framework.config.Constants;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;

@Transactional(rollbackFor = Exception.class)
@Service("thirdServiceMgr")
public class ThirdServiceMgrImpl extends AbstractBusinessObjectServiceMgr
		implements ThirdServiceMgr {
	@Autowired
	private TblThirdPartyMapper thirdMapper;

	@Autowired
	private SequenceService sequenceService;
	
	// 按条件查找第三方记录
	@Override
	public List<Third> searchThird(BaseConditionVO vo, String orderField,
			int startIndex, int count) {
		List<Third> tlist = new ArrayList<Third>();

		RowBounds rb = new RowBounds(startIndex, count);
		List<TblThirdParty> tp = thirdMapper.selectByCondition(vo.getKeywords(), rb);
		for (TblThirdParty to : tp) {
			tlist.add(new Third(to));
		}
		return tlist;
	}

	// 按ID删除第三方信息
	@Override
	public void deleteByPrimaryKey(long oid) {
		thirdMapper.deleteByPrimaryKey(oid);
	}

	// 计算返回总条数
	@Override
	public int countByExample(TblThirdPartyExample example) {
		int total = thirdMapper.countByExample(example);
		return total;
	}
	
	//按条件查找返回总条数
	public int count(BaseConditionVO vo) {
		
		int size =thirdMapper.countByCondition(vo.getKeywords());
		return size;
	}

	// 添加第三方信息
	@Override
	public void add(Third third) {
		TblThirdParty ty = third.getThird();
		ty.setOid(sequenceService.getSequence("third_id"));
		User user = (User) request.getSession().getAttribute(
				Constants.AUTHENTICATION_KEY);
		ty.setCreateoperatorid(user.getId());
		ty.setModifyoperatorid(user.getId());
		ty.setCreatetime(new Date());
		ty.setModifytime(new Date());
		thirdMapper.insert(ty);
	}

	// 修改第三方信息
	@Override
	public void update(Third third) {
		TblThirdParty ttp = thirdMapper.selectByPrimaryKey(third.getOid());
		User u = (User) request.getSession().getAttribute(
				Constants.AUTHENTICATION_KEY);
		ttp.setNamecn(third.getNamecn());
		ttp.setNamecns(third.getNamecns());
		ttp.setNameen(third.getNameen());
		ttp.setNameens(third.getNameens());
		ttp.setType(third.getType());
		ttp.setProperty(third.getProperty());
		ttp.setAddress(third.getAddress());
		ttp.setTelephone(third.getTelephone());
		ttp.setAccountcode(third.getAccountcode());
		ttp.setAccountname(third.getAccountname());
		ttp.setAccountnum(third.getAccountnum());
		ttp.setSort(third.getSort());
		ttp.setSortname(third.getSortname());
		ttp.setCurrentcourse(third.getCurrentcourse());
		// 修改人通过Session中取得用户ID来进行修改
		ttp.setModifyoperatorid(u.getId());
		ttp.setModifytime(new Date());
		thirdMapper.updateByPrimaryKey(ttp);
	}

	// 修改记录时先通过oid获取Third对象
	@Override
	public Third getthird(long oid) {
		TblThirdParty t = thirdMapper.selectByPrimaryKey(oid);
		return new Third(t);
	}

}
