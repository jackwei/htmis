/*
 * Created on 2006-3-28
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package dwz.common.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;


/**
 * @author Administrator
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class HtmlOperator {
	private java.util.Properties dBlocks = new java.util.Properties();
	private java.util.Properties parsedBlocks = new java.util.Properties();
	private String fileContent = null;
	private String encoding="UTF-8";

	public void setBlock(String tplName, String blockName) {
		dBlocks.put(blockName,
				getBlock(dBlocks.getProperty(tplName), blockName));
		dBlocks.put(tplName, replaceBlock(dBlocks.getProperty(tplName),
				blockName));
		String nName = nextDBlockName(blockName);
		while (!"".equals(nName)) {
			setBlock(blockName, nName);
			nName = nextDBlockName(blockName);
		}
	}

	public void loadTemplate(String path,HttpServletRequest request) {
		try {
			try {
				fileContent = getFileContent(path,request);
			} catch (java.io.FileNotFoundException e) {
				System.err.println("\nCodecharge "
						+ new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
								.format(new java.util.Date()) + " ==> \""
						+ path + "\" not found.\n\n");
			} catch (java.io.IOException e) {
			}
			if (fileContent != null) {
				loadTemplate(fileContent);
			}
		} catch (Exception e) {
			System.out.println(e);
			System.err.println("\nCodecharge "
					+ new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
							.format(new java.util.Date())
					+ " ==> TextTemplate.loadTemplate(\"" + path + "\")\n\n");
		}
	}

	public void loadTemplate(String htmlContent) {

		fileContent = htmlContent;
		String name = "main";
		if (fileContent != null) {
			dBlocks.put(name, fileContent);
			String nName = nextDBlockName(name);
			while (!(nName == null || "".equals(nName))) {
				setBlock(name, nName);
				nName = nextDBlockName(name);
			}
		}
	}

	public String getCharacterEncoding() {
		return encoding;
	}

	public void setCharacterEncoding(String encoding) {
		this.encoding = encoding;
	}

	public String getVar(String name) {
		String result = dBlocks.getProperty(name);
		if (result == null) {
			return "";
		} else {
			return result;
		}
	}

	public void setVar(String name, String value) {
		if (value == null)
			value = "";
		parsedBlocks.put(name, value);
	}

	public void parse(String tplName, boolean repeat) {
		try {
			if (parsedBlocks.getProperty(tplName) != null) {
				if (repeat) {
					parsedBlocks.put(tplName, parsedBlocks.getProperty(tplName)
							+ proceedTpl(dBlocks.getProperty(tplName)));
				} else {
					parsedBlocks.put(tplName, proceedTpl(dBlocks
							.getProperty(tplName)));
				}
			} else {
				parsedBlocks.put(tplName, proceedTpl(dBlocks
						.getProperty(tplName)));
			}
		} catch (Exception e) {
			System.err.println("\nCodecharge "
					+ new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
							.format(new java.util.Date())
					+ " ==> TextTemplate.parse(" + tplName + "," + repeat
					+ ")\n\n");
			e.printStackTrace(System.err);
			System.err.println("\nparsedBlocks.getProperty(" + tplName
					+ ") => " + parsedBlocks.getProperty(tplName));
			System.err.println("dBlocks.getProperty(" + tplName + ") => "
					+ dBlocks.getProperty(tplName));
		}
		return;
	}

	public String printVar(String name) {
		return parsedBlocks.getProperty(name);
	}

	private String proceedTpl(String tpl) {
		String tTpl = tpl;
		try {
			String regEx = null, match = null, name = null;
			java.util.Enumeration matches = null;
			matches = extractMatches(tpl, '{', '}');
			while (matches.hasMoreElements()) {
				match = (String) matches.nextElement();
				name = match.substring(1, match.length() - 1);
				if (parsedBlocks.containsKey(name)) {
					tTpl = replace(tTpl, match, proceedTpl(parsedBlocks.getProperty(name)));
					parsedBlocks.remove(name);
				} else if (dBlocks.containsKey(name)) {
					parse(name, false);
					tTpl = replace(tTpl, match, parsedBlocks.getProperty(name));
					parsedBlocks.remove(name);
				} else {
					tTpl = replace(tTpl, match, dBlocks.getProperty(name));
				}
			}
		} catch (Exception e) {
			System.err.println("\nCodecharge "
					+ new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
							.format(new java.util.Date())
					+ " ==> TextTemplate.proceedTpl(" + tpl + ")\n\n");
			e.printStackTrace(System.err);
		}
		return tTpl;
	}

	private String getBlock(String template, String name) {
		int bBlock, eBlock, alpha;
		alpha = name.length() + 12;
		bBlock = template.indexOf("<!--Begin" + name + "-->");
		eBlock = template.indexOf("<!--End" + name + "-->");
		if (!(bBlock == 0 || eBlock == 0)) {
			return template.substring(bBlock + alpha, eBlock);
		} else {
			return "";
		}
	}

	private String replaceBlock(String template, String name) {
		int bBlock, eBlock;
		bBlock = template.indexOf("<!--Begin" + name + "-->");
		eBlock = template.indexOf("<!--End" + name + "-->");
		if (!(bBlock == 0 || eBlock == 0)) {
			return template.substring(0, bBlock)
					+ "{"
					+ name
					+ "}"
					+ template.substring(eBlock
							+ ("<!--End" + name + "-->").length(), template
							.length());
		} else {
			return template;
		}
	}

	private String nextDBlockName(String templateName) {
		int bTag = 0, eTag = 0;
		String name = "", template = "";
		template = dBlocks.getProperty(templateName);

		bTag = template.indexOf("<!--Begin");
		if (bTag != -1) {
			eTag = template.indexOf("-->", bTag);
			name = template.substring(bTag + 9, eTag);
			if (template.indexOf("<!--End" + name + "-->") != -1) {
				return name;
			}
		}
		return "";
	}

	public String printAll() {
		return "<h1><font color=\"red\">printAll() is not implemented yet</font></h1>";
	}

	private java.util.Enumeration extractMatches(String str, char start,
			char end) {
		java.util.Vector vec = new java.util.Vector(10, 10);
		if (str != null) {
			int s = 0, e = 0, sc = 0, se = 0;
			while ((s = str.indexOf(start, e)) >= 0) {
				if ((e = str.indexOf(end, s)) >= 0) {
					sc = str.indexOf(" ", s);
					se = str.indexOf("\n", s);
					if (sc == -1) {
						sc = se;
					}
					if (se < sc && se != -1) {
						sc = se;
					}
					se = str.indexOf("=", s);
					if (sc == -1) {
						sc = se;
					}
					if (se < sc && se != -1) {
						sc = se;
					}
					if (sc == -1 || sc > e) {
						vec.addElement(str.substring(s, e) + end);
					}
				}
			}
		}
		return vec.elements();
	}

	private String replace(String str, String pattern, String replace) {
		if (replace == null) {
			replace = "";
		}
		int s = 0, e = 0;
		StringBuffer result = new StringBuffer();
		while ((e = str.indexOf(pattern, s)) >= 0) {
			result.append(str.substring(s, e));
			result.append(replace);
			s = e + pattern.length();
		}
		result.append(str.substring(s));
		return result.toString();
	}

	private String getFileContent(String fName,HttpServletRequest request)
			throws Exception {
		String path =this.getAppPath(request);
		fName=path+"/"+fName;
		java.io.File f = new java.io.File(fName);
		if(!f.exists()){
			throw new MessageException("模板不存在！");
		}
		int lenFile = (int) f.length(); // No checking so template-file is not
										// big
		java.io.BufferedReader bf = null;
		try {
			bf = new java.io.BufferedReader(new java.io.InputStreamReader(
					new java.io.FileInputStream(fName), this.encoding));
		} catch (java.io.UnsupportedEncodingException uee) {
			bf = new java.io.BufferedReader(new java.io.FileReader(fName));
		}
		StringBuffer line = new StringBuffer(lenFile + 1024);
		while (bf.ready()) {
			line.append(bf.readLine() + "\n");
		}
		bf.close();
		return line.toString();
	}

	private String getAppPath(HttpServletRequest req) {
		ServletContext app = req.getSession().getServletContext();
		/*String appPath = app.getRealPath(req.getRequestURI()).replace('\\', '/');*/
		
		String appPath = app.getRealPath("").replace('\\', '/');
		String cPath = req.getContextPath();
		if (cPath.length() > 1) {
			int f1 = appPath.lastIndexOf(cPath);
			appPath = appPath.substring(0, f1)
					+ appPath.substring(f1 + cPath.length());
		}
		return appPath;
		//return appPath.substring(0, appPath.indexOf(cPath)+cPath.length()+1);
	}
	public void reload(){
		this.dBlocks.clear();
		this.parsedBlocks.clear();
		this.loadTemplate(this.fileContent);
	}
	
}
