package com.git.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import org.w3c.dom.*;

public class XmlOperate {
	
	public static String getNodeAsText(Node node, String defaultValue) {
		if (node != null){
			return StringUtil.strip(node.getText());
		}
		return defaultValue;
	}

	public static String formatXML(String XMLContent) throws Exception{
		XMLWriter xwoutput = null;
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setIndentSize(4);
		format.setEncoding("utf-8");
		StringWriter resultCollector = new StringWriter();
		xwoutput = new XMLWriter(resultCollector, format);
		xwoutput.write(DocumentHelper.parseText(XMLContent));
		xwoutput.close();
		return resultCollector.getBuffer().toString();
	}
	
	
    public static String getRootElementText(String root,String path){
    	SAXReader reader = new SAXReader();
    	try {
			Document doc = reader.read(new File(path));
			Element rootDocElement = doc.getRootElement();
			return rootDocElement.elementText(root);
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }


    public static String getRootSecendElementText(String root,String secend, String path){
    	SAXReader reader = new SAXReader();
    	try {
			Document doc = reader.read(new File(path));
			Element rootDocElement = doc.getRootElement();
			Element bankElement = rootDocElement.element(root);
			if(null == bankElement){
				return "";
			}else{
				return bankElement.elementText(secend);	
			 } 
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
    
    private   org.w3c.dom.Document   document;     
    private   String   filename;     
    
    public XmlOperate(String   name)   throws   ParserConfigurationException{     
    	filename=name;     
    	DocumentBuilderFactory   factory=DocumentBuilderFactory.newInstance();     
    	DocumentBuilder   builder=factory.newDocumentBuilder();   
    	document=builder.newDocument();     
  }     
    
    public   void   toWrite(String   mytitle,String   mycontent){     
    	org.w3c.dom.Element   root=document.createElement("Voucher");
    	root.setAttribute("id", "主键");
    	document.appendChild(root);     
    	org.w3c.dom.Element   title=document.createElement("Title");     
    	title.appendChild(document.createTextNode(mytitle));     
    	root.appendChild(title);     
    	org.w3c.dom.Element   content=document.createElement("Content"); 
    	org.w3c.dom.Element   entry=document.createElement("Entry"); 
    	entry.appendChild(document.createTextNode(mycontent));  
    	content.appendChild(entry);
    	root.appendChild(content);   
    
    }     
    public   void   toSave(){     
    	try{     
    		TransformerFactory   tf=TransformerFactory.newInstance();     
    		Transformer   transformer=tf.newTransformer();     
    		DOMSource   source=new   DOMSource(document);     
    		transformer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");     
    		transformer.setOutputProperty(OutputKeys.INDENT,"yes");     
    		PrintWriter   pw=new   PrintWriter(new   FileOutputStream(filename));     
    		StreamResult   result=new   StreamResult(pw);     
    		transformer.transform(source,result);     
	  }     
    	catch(TransformerException   mye){     
    		mye.printStackTrace();     
    	}     
    	catch(IOException   exp){
    		exp.printStackTrace();     
    	}     
    }     
    public   static   void   main(String   args[]){     
    	try{     
    		XmlOperate   myxml=new   XmlOperate("d:\\8.xml");     
    		myxml.toWrite("中文题目","中文内容");     
    		myxml.toSave();     
    		System.out.print("Your   writing   is   successful!");     
    	}     
    	catch(ParserConfigurationException   exp){     
    		exp.printStackTrace();     
    		System.out.print("Your   writing   is   failed!");     
    	}     
    } 

/*
   public static void main(String[] args){
	   String root = getRootElementText("url","F:\\Eps.xml");
	   System.out.println(root);
	   String second = getRootSecendElementText("A001","productId", "F:\\Eps.xml");
	   System.out.println(second);
   }*/
}
