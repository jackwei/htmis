package com.git.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.git.business.process.ApplyInfoServiceMgr;
import com.git.business.process.DocInfos;
import com.mysql.jdbc.DocsConnectionPropsHelper;


/**
 * 文件下载
 * @author shona
 *
 */
@Controller
@RequestMapping(value="/FileDown")
public class FileDownloadAction extends BaseController {
	
	@Autowired
	ApplyInfoServiceMgr applyInfoServiceMgr;
	
	/**
	 * 只打开文件下载页面
	 * */
	@RequestMapping("/openFile")
	public String openFile(HttpServletRequest request,Model model){
		List<DocInfos> docList=applyInfoServiceMgr.selectByApplyId(Long.valueOf(request.getParameter("oId")),request.getParameter("docType"));
		model.addAttribute("docList", docList);
		return "/common/downloadFile";
	}
	
	/**
	 * 文件下载
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/download")  
	public ModelAndView download(HttpServletRequest request, HttpServletResponse response)
	throws Exception {  
	request.setCharacterEncoding("UTF-8");
	Long oid=Long.valueOf(request.getParameter("oid"));
//	String fileName= URLDecoder.decode(request.getParameter("filename"),"UTF-8");
	response.setContentType("text/html;charset=utf-8"); 
	request.setCharacterEncoding("UTF-8"); 
	DocInfos docInfos=applyInfoServiceMgr.selectByOid(oid);
	String fileName=docInfos.getFilename();
	java.io.BufferedInputStream bis = null;
	java.io.BufferedOutputStream bos = null;  
//	String downLoadPath =request.getParameter("cxtPath"); 
	String downLoadPath=docInfos.getFilelocation();
	System.out.println(downLoadPath);  
	try { 
	long fileLength = new File(downLoadPath).length(); 
	response.setContentType("application/x-msdownload;"); 
	if (request.getHeader("User-Agent").toLowerCase().indexOf(
	"firefox") > 0) {
    fileName = new String(fileName.getBytes("UTF-8"),
		"ISO8859-1");// firefox浏览器
   } else if (request.getHeader("User-Agent").toUpperCase()
	 .indexOf("MSIE") > 0) {
    fileName = URLEncoder.encode(fileName, "UTF-8");// IE浏览器
   }
	response.setHeader("Content-disposition", "attachment; filename=" 
	+ fileName); 
	response.setHeader("Content-Length", String.valueOf(fileLength)); 
	bis = new BufferedInputStream(new FileInputStream(downLoadPath));
	bos = new BufferedOutputStream(response.getOutputStream());
	byte[] buff = new byte[2048];  
	int bytesRead;  
	while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) { 
	bos.write(buff, 0, bytesRead);  
	}  
	} catch (Exception e) { 
	e.printStackTrace(); 
	} finally { 
	if (bis != null) 
	  bis.close(); 
	if (bos != null) 
	bos.close();  
	}  
	return null;  

}  
	
}
