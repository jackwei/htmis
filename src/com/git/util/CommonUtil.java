/*
 * Created on 2006-3-9
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.git.util;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Administrator
 * 
 *         TODO To change the template for this generated type comment go to
 *         Window - Preferences - Java - Code Style - Code Templates
 */
public class CommonUtil {
	public static String jasperEncode(String src) {
		src = src.replaceAll("&", "&amp;");
		return src;
	}

	public static String frontYearStr(String date) {
		String result = "";
		int year = Integer.parseInt(date.substring(0, 4));
		String mon = date.substring(5, 7);
		String day = date.substring(8);
		year--;
		result = String.valueOf(year) + "-" + mon + "-" + day;
		return result;
	}

	public static int getIntervalDays(Date enddate, Date begindate) {
		long millisecond = enddate.getTime() - begindate.getTime();
		int day = (int) (millisecond / 24L / 60L / 60L / 1000L);
		return day;
	}

	public static String getRate(Object ob1, Object ob2) {
		if (CommonUtil.isEmpty(ob1) || CommonUtil.isEmpty(ob2)) {
			return " ";
		}
		if (Double.valueOf(ob1.toString()) == 0
				|| Double.valueOf(ob2.toString()) == 0) {
			return " ";
		}
		String result = "";
		Double dd = Double.valueOf(ob1.toString())
				/ Double.valueOf(ob2.toString());
		int n = Double.valueOf(dd * 100).intValue();
		result = String.valueOf(n) + "%";
		return result;
	}

	public static String getUNIQUEID() {
		String fileName1 = new Long(new java.util.Date().getTime()).toString();
		String fileName2;
		int random = (int) (100 * Math.random());
		fileName2 = new Integer(random).toString();

		if (random < 10) {
			fileName2 = "0" + new Integer(random).toString();
		}

		return fileName1 + fileName2;
	}

	public static String nullToEmpty(Object msg) {
		return msg == null || "".equals(msg.toString()) ? "" : msg.toString();
	}

	public static String splitOrgcode(String orgCode) {
		String spCode = "";
		for (int i = 0; i < orgCode.length(); i += 4) {
			if (i == 0) {
				spCode += "'" + orgCode.substring(0, i + 4) + "'";
			} else {
				spCode += ",'" + orgCode.substring(0, i + 4) + "'";
			}
		}
		return spCode;
	}

	public static String arrayToSql(String[] array) {
		String spCode = "'0'";
		if (array != null)
			for (int i = 0; i < array.length; i++) {
				if (array[i].equals("0")) {
					continue;
				}
				spCode += ",'" + array[i] + "'";
			}
		return spCode;
	}

	public static boolean isEmpty(Object ob) {
		return ob == null || "".equals(ob.toString()) ? true : false;
	}

	public static BigDecimal parseBigdecimal(Object ob) {
		BigDecimal bd = null;
		try {
			if (ob == null) {
				bd = new BigDecimal("0.00");
			} else {
				bd = (BigDecimal) ob;
			}
		} catch (Exception e) {
			bd = new BigDecimal("0.00");
		}
		return bd;
	}

	public static BigDecimal strToBigdecimal(String str) {
		BigDecimal bd = null;
		try {
			bd = new BigDecimal(str);
		} catch (Exception e) {
			bd = new BigDecimal("0.00");
		}
		return bd;
	}

	public static String FormatDoubleDoc(Object number) {
		java.text.DecimalFormat df = new java.text.DecimalFormat();
		df.applyPattern("#,##0.00");
		if (number == null) {
			return "0.00";
		}

		return df.format(number);
	}

	public static Integer parseInteger(Object ob) {
		Integer bd = null;
		try {
			if (ob == null) {
				bd = new Integer("0");
			} else {
				bd = (Integer) ob;
			}
		} catch (Exception e) {
			bd = new Integer("0");
		}

		return bd;
	}

	public static Integer strToInteger(String str) {
		Integer bd = null;
		try {
			bd = new Integer(str);
		} catch (Exception e) {
			bd = new Integer("0");
		}
		return bd;
	}

	public static int parseInt(String obj) {
		int result = 0;
		if (!isEmpty(obj)) {
			try {
				result = Integer.parseInt(obj);
			} catch (Exception e) {
				result = 0;
			}
		}
		return result;
	}

	public static String formatDate(Date tDATE, String format) {

		String fldDATE = "";
		try {
			SimpleDateFormat df = new SimpleDateFormat(format);
			if (tDATE != null) {
				fldDATE = df.format(tDATE);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return fldDATE;
	}

	public static Date parseDate(String sDate, String sFmt) {
		Date aDate = null;

		try {
			SimpleDateFormat sdf = new SimpleDateFormat(sFmt);
			aDate = sdf.parse(sDate);
		} catch (Exception e) {
		}

		return aDate;
	}

	public static String toHTML(String value) {
		if (value == null)
			return "";
		value = replace(value, "&", "&amp;");
		value = replace(value, "<", "&lt;");
		value = replace(value, ">", "&gt;");
		value = replace(value, "\"", "&" + "quot;");
		return value;
	}

	private static String replace(String str, String pattern, String replace) {
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

	private static String replaceLower(String str, String pattern,
			String replace) {
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
		return result.toString().trim().toLowerCase();
	}

	public static String pageValueToGBKSTR(String str) {
		try {
			return new String(str.trim().getBytes("Iso-8859-1"), "GBK");
		} catch (Exception e) {
			return "";
		}
	}

	public static String getAppPath(javax.servlet.ServletContext app,
			javax.servlet.http.HttpServletRequest req) {
		String appPath = app.getRealPath(req.getRequestURI())
				.replace('\\', '/');
		String cPath = req.getContextPath();
		if (cPath.length() > 1) {
			int f1 = appPath.lastIndexOf(cPath);
			appPath = appPath.substring(0, f1)
					+ appPath.substring(f1 + cPath.length());
		}
		return appPath.substring(0, appPath.lastIndexOf('/') + 1);
	}

	public static String getParam(javax.servlet.http.HttpServletRequest req,
			String paramName) {
		String param = req.getParameter(paramName);
		if (param == null || param.equals("")) {
			param = (String) req.getAttribute(paramName);
		}
		if (param == null)
			param = "";

		return param;
	}

	/**
	 * public static byte[] conver(String inEncoding, String toEncoding, byte[]
	 * in)
	 * 
	 * @param inEncoding
	 * @param toEncoding
	 * @param in
	 * @return
	 */
	public static byte[] convCharset(String inEncoding, String toEncoding,
			byte[] in) {
		Charset inCharset = Charset.forName(inEncoding);
		CharsetDecoder inDecoder = inCharset.newDecoder();
		ByteBuffer inBytes = ByteBuffer.wrap(in);
		CharBuffer inChars = null;

		try {
			inChars = inDecoder.decode(inBytes);
		} catch (CharacterCodingException e) {
			e.printStackTrace();
		}

		Charset toCharset = Charset.forName(toEncoding);
		CharsetEncoder toEncoder = toCharset.newEncoder();
		ByteBuffer toBytes = null;

		try {
			toBytes = toEncoder.encode(inChars);
		} catch (CharacterCodingException e) {
			e.printStackTrace();
		}

		return toBytes.array();
	}

	/**
	 * public static byte[] GBKtoUTF(byte[] in)
	 * 
	 * @param help
	 * @return
	 */
	public static byte[] GBKtoUTF(byte[] in) {
		return convCharset("GBK", "UTF-8", in);
	}

	public static String PageValueToGBK(String in) {
		if (isEmpty(in)) {
			return "";
		}
		try {
			return new String(in.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {

			return "";
		}
	}

	/**
	 * public static byte[] UTFtoGBK(byte[] in)
	 * 
	 * @param in
	 * @return
	 */
	public static byte[] UTFtoGBK(byte[] in) {
		return convCharset("UTF-8", "GBK", in);
	}

	/**
	 * public static byte[] GBKtoUTF(String in)
	 * 
	 * @param in
	 * @return
	 */
	public static byte[] GBKtoUTF(String in) {
		byte[] innerBytes = null;
		try {
			innerBytes = in.getBytes("GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return convCharset("GBK", "UTF-8", innerBytes);
	}

	/**
	 * public static byte[] UTFtoGBK(String in)
	 * 
	 * @param in
	 * @return
	 */
	public static byte[] UTFtoGBK(String in) {
		byte[] innerBytes = null;
		try {
			innerBytes = in.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return convCharset("UTF-8", "GBK", innerBytes);
	}

	public static String base64Encoder(String s) throws Exception {
		byte[] b = s.getBytes();
		sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
		String result = encoder.encodeBuffer(b);

		// org.
		return result;
	}

	public static String base64Decoder(String s) throws Exception {
		sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
		byte[] b = decoder.decodeBuffer(s);
		String result = new String(b);

		return result;
	}

	public static String urlEncode(String str)
			throws UnsupportedEncodingException {
		return java.net.URLEncoder.encode(str, "utf8");
	}

	public static String urlDecode(String str) {
		while (str.indexOf("+") != -1) {
			str = str.replace("+", " ");
		}
		while (str.indexOf("@") != -1) {
			str = str.replace("@", "+");
		}
		return str;
	}
}