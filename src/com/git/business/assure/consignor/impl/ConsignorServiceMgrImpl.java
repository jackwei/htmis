package com.git.business.assure.consignor.impl;

//import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

//import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.git.business.assure.consignor.Consignor;
import com.git.business.assure.consignor.ConsignorServiceMgr;
import com.git.business.sys.User;
import com.git.db.BaseConditionVO;
import com.git.db.beans.TblConsignor;
import com.git.db.beans.TblConsignorExample;
import com.git.db.beans.TblRewarranter;
import com.git.db.mapper.TblConsignorMapper;
import com.git.db.mapper.TblRewarranterMapper;
import com.git.util.service.SequenceService;

import dwz.framework.config.Constants;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;

@Transactional(rollbackFor = Exception.class)
@Service("consignorServiceMgr")
public class ConsignorServiceMgrImpl extends AbstractBusinessObjectServiceMgr implements ConsignorServiceMgr{
	
	@Autowired
	private TblConsignorMapper consignorMapper;
	
	@Autowired
	private SequenceService sequenceService;
	
	@Autowired
	private TblRewarranterMapper rewarrantermapper;

/*	//查找所有委托人信息
	@Override
	public List<Consignor> searchConsignor(BaseConditionVO vo,String orderField, int startIndex, int count) {
		List<Consignor> tlist = new ArrayList<Consignor>();

		RowBounds rb = new RowBounds(startIndex, count);
		List<TblConsignor> tp = consignorMapper.selectByCondition(vo.getKeywords(), rb);
		for(TblConsignor to:tp){
			tlist.add(new Consignor(to));
		}
		return tlist;
	}*/
    
	//按ID删除委托人信息
	@Override
	public void deleteByPrimaryKey(long oid) {
		consignorMapper.deleteByPrimaryKey(oid);
	}
    
	//计算返回总条数
	@Override
	public int countByExample(TblConsignorExample example) {
		int total = consignorMapper.countByExample(example);
		return total;
	}
	
//	//计算条件查询返回总条数
//	public int count(BaseConditionVO vo){
//		int total = consignorMapper.countByCondition(vo.getKeywords());
//		return total;
//	}

    //添加委托人信息
	@Override
	public void add(Consignor consignor,HttpServletRequest request) {
		String sort = request.getParameter("orgLookup.DictName");
		String property = request.getParameter("rewarranter.DictName");
		String country = request.getParameter("country");
		String area = request.getParameter("area");
		String flag = request.getParameter("flag");
		try{
			TblConsignor ty = consignor.getConsignor();
			ty.setOid(sequenceService.getSequence("consignor_id"));
			ty.setSort(sort);
			User user = (User) request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
			ty.setCreateoperatorid(user.getId());
			ty.setModifyoperatorid(user.getId());
			ty.setCreatetime(new Date());
			ty.setModifytime(new Date());
			ty.setCountry(country);
			ty.setArea(area);
			consignorMapper.insert(ty);
			if(flag.equals("1")){
				TblRewarranter tr = new TblRewarranter();
				tr.setOid(sequenceService.getSequence("rewarranter_id"));
				tr.setName(ty.getName());
				tr.setNames(ty.getNames());
				tr.setPropertyname(property);
				tr.setAddress(ty.getAddress());
				tr.setCountry(country);
				tr.setArea(area);
				rewarrantermapper.insert(tr);
			}else{
				System.out.println("false");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
    //修改委托人信息
	@Override
	public void update(String string,Consignor consignor) {
		TblConsignor ttp = consignorMapper.selectByPrimaryKey(consignor.getOid());
		ttp.setName(consignor.getName());
		ttp.setNames(consignor.getNames());
		ttp.setAddress(consignor.getAddress());
		ttp.setSort(string);
		ttp.setCountry(consignor.getCountry());
		ttp.setArea(consignor.getArea());
		//修改人通过Session中取得用户ID来进行修改
		User u = (User) request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		ttp.setModifyoperatorid(u.getId());
		ttp.setModifytime(new Date());
		ttp.setAccountcode(consignor.getAccountcode());
		ttp.setCurrentcourse(consignor.getCurrentcourse());
		consignorMapper.updateByPrimaryKey(ttp);
	}

	//修改记录时先通过oid获取consignor对象 
	@Override
	public Consignor getconsignor(long oid) {
		TblConsignor t = consignorMapper.selectByPrimaryKey(oid);
		return new Consignor(t);
	}

	@Override
	public int count(BaseConditionVO vo) {
		return 0;
	}

	@Override
	public List<Consignor> searchConsignor(BaseConditionVO vo,
			String orderField, int startIndex, int count) {
		return null;
	}


}
