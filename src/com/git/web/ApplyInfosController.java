package com.git.web;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.git.business.PassureInfos.PassureInfos;
import com.git.business.PassureInfos.PassureInfosServiceMgr;
import com.git.business.Passurepayments.PassurePayMents;
import com.git.business.Passurepayments.PassurePayMentsServiceMgr;
import com.git.business.caseService.CaseBillDetailServiceMgr;
import com.git.business.caseService.CaseServiceMgr;
import com.git.business.claim.CaseClaimServiceMgr;
import com.git.business.claim.ClaimInComeServiceMgr;
import com.git.business.process.ApplyInfoServiceMgr;
import com.git.business.process.ApplyInfos;
import com.git.business.process.DocInfos;
import com.git.business.sys.User;
import com.git.db.BaseConditionVO;
import com.git.db.beans.CaseBillDetailImpl;
import com.git.db.beans.CaseClaimImpl;
import com.git.db.beans.CaseInfoImpl;
import com.git.db.beans.ClaimIncomeImpl;
import com.git.db.beans.TblPassureInfos;
import com.git.db.beans.TblPassurePayMents;
import com.git.enums.AssureStatus;
import com.git.enums.ClaimStatus;
import com.git.enums.DocInfoType;
import com.git.enums.InComeStatus;
import com.git.enums.PClientStatus;
import com.git.log.Log;
import com.git.log.LogMessageObject;
import com.git.log.impl.LogUitl;
import com.git.util.Jutil;

import dwz.common.util.BidConfig;
import dwz.common.util.CommonUtils;
import dwz.framework.config.Constants;
import dwz.framework.sys.exception.ServiceException;

/**
 * 呈批件信息的Controller
 * @author shona
 *
 */
@Controller
@RequestMapping(value="/applyInfos")
public class ApplyInfosController extends BaseController {

	@Autowired
	private ApplyInfoServiceMgr applyInfoServiceMgr;
	
	@Autowired
	private CaseServiceMgr caseServiceMgr;
	
	@Autowired
	private CaseClaimServiceMgr caseClaimServiceMgr;
	
	@Autowired
	private ClaimInComeServiceMgr claimInComeServiceMgr;
	
	@Autowired
	private PassurePayMentsServiceMgr passurePayMentsServiceMgr;
	
	@Autowired
	private PassureInfosServiceMgr passureInfosServiceMgr;
	
	private String uploadDir;//上传文件路径

	
	@Autowired
	private CaseBillDetailServiceMgr caseBillDetailServiceMgr;
	
	public String getUploadDir() {
		return uploadDir;
	}

	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	}

	/**
	 * 进入呈批件添加页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/toApplyInfos")
	public ModelAndView toApplyInfos(HttpServletRequest request){
		ModelAndView model=new ModelAndView();
		Long detail_id=Long.valueOf(request.getParameter("detail_id"));
		String applyId=request.getParameter("applyId");
		String shipname=request.getParameter("shipname");
		String backNav=request.getParameter("backNav");
		model.addObject("backNav", backNav);
		try {
			shipname = new String(shipname.getBytes("ISO-8859-1"), "gbk");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try{
		CaseBillDetailImpl caseBillDetail=applyInfoServiceMgr.selectByDetailId(detail_id);
		List<DocInfos> listDocs=applyInfoServiceMgr.selectByApplyId(caseBillDetail.getDetailId(),DocInfoType.thirdparty.getCode());
		model.addObject("caseBillDetail", caseBillDetail);
		model.addObject("listDocs", listDocs);
		model.addObject("shipname", shipname);
		
		if(applyId!=null && !"".equals(applyId)){
			ApplyInfos applyInfos=applyInfoServiceMgr.searchApplyInfosByOid(Long.valueOf(applyId));
		    model.addObject("applyInfos", applyInfos);
		}
		model.setViewName("/Apply/addApplyInfos");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	/**
	 * 添加第三方状态呈批件信息
	 * @param applyInfos
	 * @param request
	 * @return
	 */
	@Log(message="{0}{1}第三方状态呈批件{2}")
	@RequestMapping(value = "/insertApplyInfos")
	public ModelAndView insertApplyInfos(ApplyInfos applyInfos,HttpServletRequest request){
     try
	   {
	 	   User user = (User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
			List<Map> ls=applyInfoServiceMgr.getProcessDefByNo("0001");
			String result="";
		if(ls!=null && ls.size()!=0){
			Map mp=ls.get(0);
			
//			String processname=request.getParameter("orgLookup.name");
//			String processId=request.getParameter("orgLookup.id");
//			if(processId==null || "".equals(processId)){
//				processId=request.getParameter("processId");
//			}
			
			applyInfos.setProcessdefid(Long.valueOf(mp.get("Process_Def_Id").toString()));
			applyInfos.setProcessname(mp.get("Process_Name").toString());
//			String applyid = request.getParameter("applyid");
			
			String detailId=request.getParameter("detail_id");
			String caseId=request.getParameter("caseId");
			CaseInfoImpl caseInfoImpl = caseServiceMgr.getCaseInfo(caseId);
			String shipname=caseInfoImpl.getShipname();
			CaseBillDetailImpl caseBillDetailImpl = caseBillDetailServiceMgr.searchCaseBillDetail(detailId);
			applyInfos.setParentid(caseBillDetailImpl.getDetailId());
			applyInfos.setParentname(caseBillDetailImpl.getConsignorname());
			applyInfos.setName("("+caseBillDetailImpl.getFeenumber()+")"+shipname);
			applyInfos.setApplydes(caseBillDetailImpl.getConsignorname()+"("+caseBillDetailImpl.getAccamount()+")");
			
			String sqnumber = request.getParameter("sqnumber");
			applyInfos.setSqnumber(sqnumber);
//			if(CommonUtils.isEmpty(applyid))
//			{
//				applyid="0";
//			}
			
//			applyInfos.setId(Long.valueOf(applyid));
			
			applyInfos.setStatus("new");
			applyInfos.setApplytype("thirdparty");
			
			result=applyInfoServiceMgr.addOrUpdApplyInfos(applyInfos, request);
			if("true".equals(result.split(",")[3]))
			{
				CaseBillDetailImpl record = new CaseBillDetailImpl();
				record.setDetailId(applyInfos.getParentid());
				record.setStatus(PClientStatus.ClientFee2.getCode());
				
				applyInfoServiceMgr.updateCaseBillDetailByOid(record);
			}
			LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),"新增",applyInfos.getName()}));
//			if(Long.valueOf(applyid)==0){
//			}else{
//				LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),"修改",applyInfos.getName()}));
//			}
		}else{
			return ajaxDoneError(getMessage("billDetail.error"));
		}
//			String forwardUrl = request.getParameter("forwardUrl");
//			
//			if (forwardUrl != null) {
//				//forwardUrl = forwardUrl.replace("{billId}", String.valueOf(caseBillImpl.getBillId()));
//				String message = getMessage("msg.operation.success");
//				
//				return ajaxDone(200, message,"","", forwardUrl);
//			}
//			else
//				return ajaxDoneBack(200, (result.split(",")[0]), result.split(",")[1], Long.valueOf(result.split(",")[2]));
		  return ajaxDoneSuccess(getMessage("msg.operation.success"));
		}catch (Exception e) 
		{
			e.printStackTrace();
			return ajaxDoneError(getMessage("msg.operation.failure"));
		}
	}

	
	/**
	 * 进入呈批件附件页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/toUploadFile/{applyId},{doctype}")
	public ModelAndView toUploadFile(@PathVariable("applyId") Long applyId,@PathVariable("doctype")String doctype,HttpServletRequest request){
		ModelAndView model=new ModelAndView();
		model.addObject("doctype",doctype);
		model.addObject("applyId", applyId);
		if(null !=request.getParameter("mark")){
			model.addObject("mark", request.getParameter("mark"));
		}
		model.addObject("filetype",Jutil.getDictEntry("filetype"));
		model.setViewName("/common/uploadFile");
		return model;
	}
	
	/**
	 * 进入呈批件附件页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/toFileUpload")
	public ModelAndView toFileUpload(HttpServletRequest request){
		ModelAndView model=new ModelAndView();
		String applyId=request.getParameter("applyId");
		String mark=request.getParameter("mark");
		String doctype=request.getParameter("doctype");
		model.addObject("mark", mark);
		model.addObject("applyId", applyId);
		model.addObject("doctype",doctype);
		model.addObject("filetype",Jutil.getDictEntry("filetype"));
		model.setViewName("/common/uploadFile");
		return model;
	}
	
	/**
	 * 上传文件信息
	 * @param request
	 * @return
	 * @throws IOException 
	 * @throws Exception 
	 */
	@RequestMapping(value = "/UploadDocinfos", method = RequestMethod.POST)
	public ModelAndView UploadDocinfos(DocInfos docInfos,HttpServletRequest request) throws IOException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.AUTHENTICATION_KEY);
		try {
		if("".equals(docInfos.getApplyid()) || docInfos.getApplyid()==null){
			return ajaxDoneSuccess(getMessage("file.apply.required"));
		}
		MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
		MultipartFile multFile = multiRequest.getFile("file1");
		//取得上传的文件名
		String fileName = multFile.getOriginalFilename();
		if("".equals(docInfos.getDocname()) || null==docInfos.getDocname()){
			docInfos.setDocname(fileName);
		}
		docInfos.setFilename(fileName);
		//取得上传文件的类型
		String contenttype= multFile.getContentType();
		docInfos.setContenttype(contenttype);
		String uploadDirct="";
		String filelocation="";
		String uploadFileName="";
		String extName="";
		if(fileName != null && !"".equals(fileName.trim())){
			extName=fileName.substring(fileName.lastIndexOf(".")+1);
			//定义允许上传的文件类型
			String fileType="jpegjpgpnggifpdftifftifdocrarppt7zzipdocxxlsxlsxpptxeml";
			if(!fileType.contains(extName.toLowerCase())){
				return ajaxDoneSuccess(getMessage("file.validation.failure"));
			}
			Date date = new Date();
			String dt = CommonUtils.formatDate(date, "yyyyMM");
			uploadDirct = BidConfig.getOtaiDir()+dt+"/";
	    	File uploadedFileDirct = new File(uploadDirct);
		    if(!uploadedFileDirct.exists()){
		    	uploadedFileDirct.mkdirs();
		    }
			uploadFileName = UUID.randomUUID().toString()+fileName.substring(fileName.lastIndexOf("."));
			filelocation = uploadDirct+uploadFileName;
			docInfos.setFilelocation(filelocation);
			File newFile = new File(filelocation);
			multFile.transferTo(newFile);
	       if("1".equals(docInfos.getSecretflag())){
	    	  docInfos.setSecretflag("1");
	       }else{
	    	  docInfos.setSecretflag("0");
	       }
	        docInfos.setCreatedate(new Date());
		    docInfos.setUserid(user.getUserCode());
		    docInfos.setUsername(user.getName());
		    applyInfoServiceMgr.addDocInfos(docInfos);
		    return ajaxDoneSuccess(getMessage("msg.operation.success"));
		}else{
			return ajaxDoneError(getMessage("msg.operation.failure"));
		}
		} catch (Exception e) {
		 e.printStackTrace();
	     return ajaxDoneError(getMessage("msg.operation.failure"));
		}
	}

	/**
	 * 读取附件信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/searchDocInfos", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object>  searchDocInfos(HttpServletRequest request){
	   Map<String,Object> map = new HashMap<String,Object>();  
	 try{
		String applyid=request.getParameter("applyid");
		List<DocInfos> list=applyInfoServiceMgr.selectByApplyId(Long.valueOf(applyid),request.getParameter("docType"));
		String oid="";
		String name="";
		String desc="";
		String filename="";
		String path="";
		String type="";
		if(list!=null && list.size()!=0){
			for(int i=0;i<list.size();i++){
				oid+=list.get(i).getId()+",";
				name+=list.get(i).getDocname()+",";
				desc+=list.get(i).getDocdes()+",";
				filename+=list.get(i).getFilename()+",";
				path+=list.get(i).getFilelocation()+",";
				if(list.get(i).getParent2id()!=null && !"".equals(list.get(i).getParent2id())){
					type+=Jutil.getDictName("filetype", list.get(i).getParent2id())+",";
				}
			}
		}
	    map.put("oid", oid); 
	    map.put("name", name); 
	    map.put("desc", desc);
	    map.put("filename", filename);
	    map.put("path", path);
	    map.put("type", type);
		}catch (Exception e) {
          e.printStackTrace();
        }
		return map;  
	}
	
	/**
	 * 删除附件信息
	 * @param oid
	 * @return
	 */
	@RequestMapping("/deleteDoc")
	@ResponseBody
	public Map<String,Object> deleteDoc(HttpServletRequest request){
		 Map<String,Object> map = new HashMap<String,Object>();
		try{
		  Long oid=Long.valueOf(request.getParameter("oid"));
		  String cxtPath=request.getParameter("cxtPath");
		  applyInfoServiceMgr.deleteByOid(oid);
		  CommonUtils.deleteFile(cxtPath);
		  map.put("result", 1);
		}catch (Exception e) {
             e.printStackTrace();
             map.put("result", 2);
		}
		return map;
	}
	
	/**
	 * 删除附件信息
	 * @param oid
	 * @return
	 */
	@RequestMapping("/deleteDocs")
	public ModelAndView deleteDocs(HttpServletRequest request){
		try{
		  Long oid=Long.valueOf(request.getParameter("oid"));
		  String cxtPath=request.getParameter("cxtPath");
		  applyInfoServiceMgr.deleteByOid(oid);
		  CommonUtils.deleteFile(cxtPath);
		  return ajaxDoneSuccess(getMessage("msg.operation.success"));
		}catch (Exception e) {
             e.printStackTrace();
		}
		return ajaxDoneError(getMessage("msg.operation.failure"));
	}
	@RequestMapping("/toUpload")
	@ResponseBody
	public Map<String,Object> toUpload(HttpServletRequest request){
		 Map<String,Object> map = new HashMap<String,Object>();
		 map.put("result", request.getParameter("oid"));
		 return map;
	}
	
	/**
	 * 启动流程/提交呈批件
	 * @param request
	 * @return
	 */
	@Log(message="{0}启动{1}流程")
	@RequestMapping("/submitApplyInfos")
	public ModelAndView submitApplyInfos(HttpServletRequest request){
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.AUTHENTICATION_KEY);
		Map<String,Object> map = new HashMap<String,Object>();
		
		String applyId=request.getParameter("applyId");
		ApplyInfos applyInfos=null;
		
		try{			
			applyInfos=applyInfoServiceMgr.searchApplyInfosByOid(Long.valueOf(applyId));
			
			try 
			{
				boolean result = applyInfoServiceMgr.startProcess(applyInfos, user);
				
				if(result)
				{
					//applyInfoServiceMgr.updateApplyInfosById(applyInfos);
					
					
					if(applyInfos.getApplytype()!= null && "thirdparty".equals(applyInfos.getApplytype()))//第三方支付的呈批件处理
					{
						CaseBillDetailImpl record = new CaseBillDetailImpl();
						record.setDetailId(applyInfos.getParentid());
						record.setStatus(PClientStatus.ClientFee3.getCode());
						
						applyInfoServiceMgr.updateCaseBillDetailByOid(record);
					}
					else if(applyInfos.getApplytype()!=null && "caseClaim".equals(applyInfos.getApplytype()))//如果claimId不为空，则表明是赔款呈批件的处理
					{
						CaseClaimImpl caseClaimImpl=caseClaimServiceMgr.getCaseClaim(applyInfos.getParentid().toString());
						if(caseClaimImpl.getRecordtype().equals("D")){
							ClaimIncomeImpl claimIncomeImpl=new ClaimIncomeImpl();
							claimIncomeImpl.setIncomeId(Long.valueOf(caseClaimImpl.getRemark1()));
							claimIncomeImpl.setStatus(InComeStatus.ClaimFee1.getCode());
							claimInComeServiceMgr.updateClaimIncome(claimIncomeImpl);
							
							CaseClaimImpl caseClaim=new CaseClaimImpl();
							caseClaim.setStatus(ClaimStatus.ClaimFee1.getCode());
							caseClaim.setClaimId(Long.valueOf(applyInfos.getParentid()));
							applyInfoServiceMgr.updateByClaimId(caseClaim);
							
						}else{
							CaseClaimImpl caseClaim=new CaseClaimImpl();
							caseClaim.setStatus(ClaimStatus.ClaimFee1.getCode());
							caseClaim.setClaimId(Long.valueOf(applyInfos.getParentid()));
							applyInfoServiceMgr.updateByClaimId(caseClaim);
						}
					}else if(applyInfos.getApplytype()!=null && "assure".equals(applyInfos.getApplytype())){
						    PassureInfos tp = null;
						    TblPassurePayMents tppm = passurePayMentsServiceMgr.selectpassurepayments(applyInfos.getParentid());
//						    PassurePayMents ppm = passurePayMentsServiceMgr.getPassurePayMents(applyInfos.getParentid());
						    //修改PassurePayMents状态为已提交submit
						    tppm.setReportflag("submit");
						    passurePayMentsServiceMgr.updpayment(tppm);
						    Map<Object, Object> criterias = new HashMap<Object, Object>();
						    criterias.put("paymentid", tppm.getPassurepayid());
						    BaseConditionVO vo = new BaseConditionVO();
							List<PassureInfos> plist = passureInfosServiceMgr.searchAllPassureInfos(vo, criterias);
							for(int i=0;i<plist.size();i++){
								Long billid = plist.get(i).getPassureid();
								tp = passureInfosServiceMgr.getPassureInfos(billid);
								//修改对应申请呈批担保状态为4
								tp.setFeestatuse(AssureStatus.AssureStatus4.getCode());
								passureInfosServiceMgr.update(tp);
							}
					}
				}
			} 
			catch (ServiceException e) {
				
				return ajaxDoneError(e.getMessage());
			}	
			LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),applyInfos.getProcessname()}));
		}catch (Exception e) {
			e.printStackTrace();			
			return ajaxDoneError("处理时发生异常错误，请联系管理员！");
		}
		
		return ajaxDone(200, "提交成功!");
	}
	
}
