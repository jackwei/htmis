package com.git.business.params.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.git.business.params.Params;
import com.git.business.params.ParamsServiceMgr;
import com.git.business.sys.User;
import com.git.db.BaseConditionVO;
import com.git.db.beans.TblParams;
import com.git.db.beans.TblParamsExample;
import com.git.db.mapper.TblParamsMapper;
import com.git.util.service.SequenceService;


import dwz.framework.config.Constants;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;

@Transactional(rollbackFor = Exception.class)
@Service("paramsServiceMgr")
public class ParamsServiceMgrImpl extends AbstractBusinessObjectServiceMgr implements ParamsServiceMgr{
	@Autowired
	private TblParamsMapper paramsMapper;

	@Autowired
	private SequenceService sequenceService;
	
	//查找所有事发口岸信息
	@Override
	public List<Params> searchParams(BaseConditionVO vo,
			String orderField, int startIndex, int count) {
		List<Params> tlist = new ArrayList<Params>();
		RowBounds rb = new RowBounds(startIndex, count);
		List<TblParams> tp = paramsMapper.selectByCondition(vo.getKeywords(), rb);
		for(TblParams to:tp){
			tlist.add(new Params(to));
		}
		return tlist;
	}
    
	//按ID删除事发口岸信息
	@Override
	public void deleteByPrimaryKey(long oid) {
		paramsMapper.deleteByPrimaryKey(oid);
	}
    
	//计算返回总条数
	@Override
	public int countByExample(TblParamsExample example) {
		// TODO Auto-generated method stub
		int total = paramsMapper.countByExample(example);
		return total;
	}

    //添加事发口岸信息
	@Override
	public void add(Params params) {
		// TODO Auto-generated method stub
		TblParams tr = params.getParams();
		User user = (User) request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		tr.setOid(sequenceService.getSequence("params"));	
		tr.setBiztype("otai");
		tr.setBiztypename("海事");
		tr.setParamtype("accidentport");
		tr.setCreateoperatorid(user.getId());
		tr.setModifyoperatorid(user.getId());
		tr.setCreatetime(new Date());
		tr.setModifytime(new Date());
		paramsMapper.insert(tr);
	}
	
    //修改事发口岸信息
	@Override
	public void update(Params params) {
		// TODO Auto-generated method stub
		TblParams tr = paramsMapper.selectByPrimaryKey(params.getOid());
		User u = (User) request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
        tr.setParamtexta(params.getParamtexta());
        tr.setParamtextb(params.getParamtextb());
		//修改人通过Session中取得用户ID来进行修改
		tr.setModifyoperatorid(u.getId());
		tr.setModifytime(new Date());
		paramsMapper.updateByPrimaryKey(tr);
	}

	//修改记录时先通过oid获取params对象 
	@Override
	public Params getParams(long oid) {
		// TODO Auto-generated method stub
		TblParams t = paramsMapper.selectByPrimaryKey(oid);
		return new Params(t);
	}

	//有查询条件时返回记录总条数
	@Override
	public int count(BaseConditionVO vo) {
		// TODO Auto-generated method stub
		int total = paramsMapper.countByCondition(vo.getKeywords());
		return total;
	}


}
