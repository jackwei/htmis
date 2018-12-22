package com.git.business.assure.rewarranter.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.git.business.assure.rewarranter.Rewarranter;
import com.git.business.assure.rewarranter.RewarranterServiceMgr;
import com.git.business.sys.User;
import com.git.db.BaseConditionVO;
import com.git.db.beans.TblConsignor;
import com.git.db.beans.TblRewarranter;
import com.git.db.beans.TblRewarranterExample;
import com.git.db.mapper.TblConsignorMapper;
import com.git.db.mapper.TblRewarranterMapper;
import com.git.util.service.SequenceService;

import dwz.framework.config.Constants;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;

@Transactional(rollbackFor = Exception.class)
@Service("rewarranterServiceMgr")
public class RewarranterServiceMgrImpl extends AbstractBusinessObjectServiceMgr implements RewarranterServiceMgr{
	@Autowired
	private TblRewarranterMapper rewarranterMapper;
	
	@Autowired
	private SequenceService sequenceService;
	
	@Autowired
	private TblConsignorMapper consignormapper;

/*	//查找所有反担保人信息
	@Override
	public List<Rewarranter> searchRewarranter(BaseConditionVO vo,
			String orderField, int startIndex, int count) {
		List<Rewarranter> tlist = new ArrayList<Rewarranter>();
		RowBounds rb = new RowBounds(startIndex, count);
		List<TblRewarranter> tp = rewarranterMapper.selectByCondition(vo.getKeywords(),rb);
		for(TblRewarranter to:tp){
			tlist.add(new Rewarranter(to));
		}
		return tlist;
	}*/
    
	//按ID删除反担保人信息
	@Override
	public void deleteByPrimaryKey(long oid) {
		rewarranterMapper.deleteByPrimaryKey(oid);
	}
    
	//计算返回总条数
	@Override
	public int countByExample(TblRewarranterExample example) {
		int total = rewarranterMapper.countByExample(example);
		return total;
	}
	
/*	//计算按条件查询返回的总条数
	public int count(BaseConditionVO vo){
		int total = rewarranterMapper.countByCondition(vo.getKeywords());
		return total;
	}*/

    //添加反担保人信息
	@Override
	public void add(Rewarranter rewarranter,Long dictid,String string,String flag,String sort) {
		
		try {
			TblRewarranter tr = rewarranter.getRewarranter();
			tr.setOid(sequenceService.getSequence("rewarranter_id"));
			User user = (User) request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
			tr.setPropertyid(dictid);
			tr.setPropertyname(string);
			tr.setCreateoperatorid(user.getId());
			tr.setModifyoperatorid(user.getId());
			tr.setCreatetime(new Date());
			tr.setModifytime(new Date());
			rewarranterMapper.insert(tr);
			if(flag.equals("1")){
				TblConsignor tc =new TblConsignor();
				tc.setOid(sequenceService.getSequence("consignor_id"));
				tc.setName(tr.getName());
				tc.setNames(tr.getNames());
				tc.setAddress(tr.getAddress());
				tc.setSort(sort);
				tc.setCountry(tr.getCountry());
				tc.setArea(tr.getArea());
				tc.setCreateoperatorid(user.getId());
				tc.setModifyoperatorid(user.getId());
				tc.setCreatetime(new Date());
				tc.setModifytime(new Date());
				consignormapper.insert(tc);
			}
			else{
				System.out.println("flase");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
    //修改反担保人信息
	@Override
	public void update(Rewarranter rewarranter,String string) {
		TblRewarranter tr = rewarranterMapper.selectByPrimaryKey(rewarranter.getOid());
		User u = (User) request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		tr.setName(rewarranter.getName());
		tr.setNames(rewarranter.getNames());
		tr.setPropertyname(string);
		tr.setAddress(rewarranter.getAddress());
		tr.setCountry(rewarranter.getCountry());
		tr.setArea(rewarranter.getArea());
		//修改人通过Session中取得用户ID来进行修改
		tr.setModifyoperatorid(u.getId());
		tr.setModifytime(new Date());
		rewarranterMapper.updateByPrimaryKey(tr);
	}

	//修改记录时先通过oid获取rewarranter对象 
	@Override
	public Rewarranter getRewarranter(long oid) {
		TblRewarranter t = rewarranterMapper.selectByPrimaryKey(oid);
		return new Rewarranter(t);
	}

	@Override
	public List<Rewarranter> searchRewarranter(BaseConditionVO vo,
			String orderField, int startIndex, int count) {
		return null;
	}

	@Override
	public int count(BaseConditionVO vo) {
		return 0;
	}

}
