package com.git.util;


import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.servlet.http.HttpSession;

import com.wabacus.config.component.application.report.ReportBean;
import com.wabacus.system.ReportRequest;

/**
 * <p>Title: Web业务系统</p>
 * <p>Description:业务系统的公共业务处理函数
 * 该类包含所有业务处理中的公共函数，和以前系统中的funpub.4gl
 * 文件相对应。在这个类中，所有的函数都采用Static的类型，所有需要的数据都是
 * 通过参数传入的，在本类中不采用通过属性传递数据的方法。 </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Sinosoft</p>
 * @author YT
 * @version 1.0
 */
public class PubFun
{

    public PubFun() {}
    
    /**
     * 将字符串补数,将sourString的<br>后面</br>用cChar补足cLen长度的字符串,如果字符串超长，则不做处理
     * <p><b>Example: </b><p>
     * <p>RCh("Minim", "0", 10) returns "Minim00000"<p>
     * @param sourString 源字符串
     * @param cChar 补数用的字符
     * @param cLen 字符串的目标长度
     * @return 字符串
     */
    public static String RCh(String sourString, String cChar, int cLen)
    {
        int tLen = sourString.length();
        int i, iMax;
        String tReturn = "";
        if (tLen >= cLen)
        {
            return sourString;
        }
        iMax = cLen - tLen;
        for (i = 0; i < iMax; i++)
        {
            tReturn += cChar;
        }
        tReturn = sourString.trim() + tReturn.trim();
        return tReturn;
    }

    /**
     * 将字符串补数,将sourString的<br>前面</br>用cChar补足cLen长度的字符串,如果字符串超长，则不做处理
     * <p><b>Example: </b><p>
     * <p>LCh("Minim", "0", 10) returns "00000Minim"<p>
     * @param sourString 源字符串
     * @param cChar 补数用的字符
     * @param cLen 字符串的目标长度
     * @return 字符串
     */
    public static String LCh(String sourString, String cChar, int cLen)
    {
        int tLen = sourString.length();
        int i, iMax;
        String tReturn = "";
        if (tLen >= cLen)
        {
            return sourString;
        }
        iMax = cLen - tLen;
        for (i = 0; i < iMax; i++)
        {
            tReturn += cChar;
        }
        tReturn = tReturn.trim() + sourString.trim();
        return tReturn;
    }
    
    /**
     * 将字符串类型的日期转换为Date型
     * @param date
     * @return
     */
    public static Date parseToDate(String date)
    {       
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try
        {
        	Date s_date =(Date)sdf.parse(date);
        	return   s_date ;
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        
        return   null ;
    }

    /**
     * 得到当前系统日期 author: YT
     * @return 当前日期的格式字符串,日期格式为"yyyy-MM-dd"
     */
    public static String getCurrentDate()
    {
    	GregorianCalendar tGCalendar = new GregorianCalendar();
        int sYears = tGCalendar.get(Calendar.YEAR);
        int sMonths = tGCalendar.get(Calendar.MONTH) + 1;
        int sDays = tGCalendar.get(Calendar.DAY_OF_MONTH);
        StringBuffer tStringBuffer = new StringBuffer(10) ;
        tStringBuffer.append(sYears) ;
        tStringBuffer.append('-') ;
        if(sMonths<10)
        {
        	tStringBuffer.append('0') ;
        }
        tStringBuffer.append(sMonths) ;
        tStringBuffer.append('-') ;
        if(sDays<10)
        {
        	tStringBuffer.append('0') ;
        }
        tStringBuffer.append(sDays) ;
        
        return   tStringBuffer.toString() ;
    }
    

    /**
     * 得到当前系统日期 author: YT
     * @return 当前日期的格式字符串,日期格式为"yyyy-MM-dd"
     */
    public static Date getCurrentDateByFormat(String format)
    {       
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try
        {
        	Date s_date =(Date)sdf.parse(PubFun.getCurrentDate());
        	return   s_date ;
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        
        return   null ;
    }

    /**
     * 得到当前系统时间 author: YT
     * @return 当前时间的格式字符串，时间格式为"HH:mm:ss"
     */
    public static String getCurrentTime()
    {
    	GregorianCalendar tGCalendar = new GregorianCalendar();
        int sHOUR = tGCalendar.get(Calendar.HOUR_OF_DAY);
        int sMINUTE = tGCalendar.get(Calendar.MINUTE);
        int sSECOND = tGCalendar.get(Calendar.SECOND);
        StringBuffer tStringBuffer = new StringBuffer(8) ;
        if(sHOUR<10) 
        {
        	tStringBuffer.append('0') ;
        }
        tStringBuffer.append(sHOUR) ;
        tStringBuffer.append(':') ;
        if(sMINUTE<10)
        {
        	tStringBuffer.append('0') ;
        }
        tStringBuffer.append(sMINUTE) ;
        tStringBuffer.append(':') ;
        if(sSECOND<10) 
        {
        	tStringBuffer.append('0') ;
        }
        tStringBuffer.append(sSECOND) ;
        return tStringBuffer.toString();
    }
    
    public static String getCurrentDateTime(String formatType)
    {
    	String tCurrentDateTime = "";
    	SimpleDateFormat sdf = new SimpleDateFormat("", Locale.SIMPLIFIED_CHINESE);
    	sdf.applyPattern(formatType);
    	Timestamp now = new Timestamp(System.currentTimeMillis());
    	tCurrentDateTime = (String)sdf.format(now);
    	
    	return tCurrentDateTime;
    }

    /**
     * 得到流水号前导 author: YT
     * @param comCode 机构代码
     * @return 流水号的前导字符串
     */
    public static String getNoLimit(String comCode)
    {
        comCode = comCode.trim();
        int tLen = comCode.length();
        if (tLen > 6)
        {
            comCode = comCode.substring(0, 6);
        }
        if (tLen < 6)
        {
            comCode = RCh(comCode, "0", 6);
        }
        String tString = "";
        tString = comCode + getCurrentDate().substring(0, 4);
        return tString;
    }

    /**
     * 该函数得到c_Str中的第c_i个以c_Split分割的字符串
     * @param c_Str 目标字符串
     * @param c_i 位置
     * @param c_Split   分割符
     * @return 如果发生异常，则返回空
     */
    public static String getStr(String c_Str, int c_i, String c_Split)
    {
        String t_Str1 = "", t_Str2 = "", t_strOld = "";
        int i = 0, i_Start = 0;
        t_Str1 = c_Str;
        t_Str2 = c_Split;
        i = 0;
        try
        {
            while (i < c_i)
            {
                i_Start = t_Str1.indexOf(t_Str2, 0);
                if (i_Start >= 0)
                {
                    i += 1;
                    t_strOld = t_Str1;
                    t_Str1 = t_Str1.substring(i_Start + t_Str2.length(),
                                              t_Str1.length());
                }
                else
                {
                    if (i != c_i - 1)
                    {
                        t_Str1 = "";
                    }
                    break;
                }
            }

            if (i_Start >= 0)
            {
                t_Str1 = t_strOld.substring(0, i_Start);
            }
        }
        catch (Exception ex)
        {
            t_Str1 = "";
        }
        return t_Str1;
    }

    /**
     * 把数字金额转换为中文大写金额 author: HST
     * @param money 数字金额(double)
     * @return 中文大写金额(String)
     */
    public static String getChnMoney(double money)
    {
        String ChnMoney = "";
        String s0 = "";

        // 在原来版本的程序中，getChnMoney(585.30)得到的数据是585.29。

        if (money == 0.0)
        {
            ChnMoney = "零元整";
            return ChnMoney;
        }

        if (money < 0)
        {
            s0 = "负";
            money *= ( -1);
        }

        String sMoney = new DecimalFormat("0").format(money * 100);

        int nLen = sMoney.length();
        String sInteger;
        String sDot;
        if (nLen < 2)
        {
            //add by JL at 2004-9-14
            sInteger = "";
            if (nLen == 1)
            {
                sDot = "0" + sMoney.substring(nLen - 1, nLen);
            }
            else
            {
                sDot = "0";
            }
        }
        else
        {
            sInteger = sMoney.substring(0, nLen - 2);
            sDot = sMoney.substring(nLen - 2, nLen);
        }

        String sFormatStr = PubFun.formatStr(sInteger);

        String s1 = PubFun.getChnM(sFormatStr.substring(0, 4), "亿");

        String s2 = PubFun.getChnM(sFormatStr.substring(4, 8), "万");

        String s3 = PubFun.getChnM(sFormatStr.substring(8, 12), "");

        String s4 = PubFun.getDotM(sDot);

        if (s1.length() > 0 && s1.substring(0, 1).equals("0"))
        {
            s1 = s1.substring(1,
                              s1.length());
        }
        if (s1.length() > 0 &&
            s1.substring(s1.length() - 1, s1.length()).equals("0")
            && s2.length() > 0 && s2.substring(0, 1).equals("0"))
        {
            s1 = s1.substring(0, s1.length() - 1);
        }
        if (s2.length() > 0 &&
            s2.substring(s2.length() - 1, s2.length()).equals("0")
            && s3.length() > 0 && s3.substring(0, 1).equals("0"))
        {
            s2 = s2.substring(0, s2.length() - 1);
        }
        if (s4.equals("00"))
        {
            s4 = "";
            if (s3.length() > 0 &&
                s3.substring(s3.length() - 1, s3.length()).equals("0"))
            {
                s3 = s3.substring(0, s3.length() - 1);
            }
        }
        if (s3.length() > 0 &&
            s3.substring(s3.length() - 1, s3.length()).equals("0")
            && s4.length() > 0 && s4.substring(0, 1).equals("0"))
        {
            s3 = s3.substring(0, s3.length() - 1);
        }
        if (s4.length() > 0 &&
            s4.substring(s4.length() - 1, s4.length()).equals("0"))
        {
            s4 = s4.substring(0, s4.length() - 1);
        }
        if (s3.equals("0"))
        {
            s3 = "";
            s4 = "0" + s4;
        }

        ChnMoney = s0 + s1 + s2 + s3 + "元" + s4;
        if (ChnMoney.substring(0, 1).equals("0"))
        {
            ChnMoney = ChnMoney.substring(1,
                                          ChnMoney.length());
        }
        for (int i = 0; i < ChnMoney.length(); i++)
        {
            if (ChnMoney.substring(i, i + 1).equals("0"))
            {
                ChnMoney = ChnMoney.substring(0, i) + "零" +
                           ChnMoney.substring(i + 1, ChnMoney.length());
            }
        }

        if (sDot.substring(1, 2).equals("0"))
        {
            ChnMoney += "整";
        }

        return ChnMoney;
    }

    /**
     * 得到money的角分信息
     * @param sIn String
     * @return String
     */
    private static String getDotM(String sIn)
    {
        String sMoney = "";
        if (!sIn.substring(0, 1).equals("0"))
        {
            sMoney += getNum(sIn.substring(0, 1)) + "角";
        }
        else
        {
            sMoney += "0";
        }
        if (!sIn.substring(1, 2).equals("0"))
        {
            sMoney += getNum(sIn.substring(1, 2)) + "分";
        }
        else
        {
            sMoney += "0";
        }

        return sMoney;
    }

    /**
     * 添加仟、佰、拾等单位信息
     * @param strUnit String
     * @param digit String
     * @return String
     */
    private static String getChnM(String strUnit, String digit)
    {
        String sMoney = "";
        boolean flag = false;

        if (strUnit.equals("0000"))
        {
            sMoney += "0";
            return sMoney;
        }
        if (!strUnit.substring(0, 1).equals("0"))
        {
            sMoney += getNum(strUnit.substring(0, 1)) + "仟";
        }
        else
        {
            sMoney += "0";
            flag = true;
        }
        if (!strUnit.substring(1, 2).equals("0"))
        {
            sMoney += getNum(strUnit.substring(1, 2)) + "佰";
            flag = false;
        }
        else
        {
            if (!flag)
            {
                sMoney += "0";
                flag = true;
            }
        }
        if (!strUnit.substring(2, 3).equals("0"))
        {
            sMoney += getNum(strUnit.substring(2, 3)) + "拾";
            flag = false;
        }
        else
        {
            if (!flag)
            {
                sMoney += "0";
                flag = true;
            }
        }
        if (!strUnit.substring(3, 4).equals("0"))
        {
            sMoney += getNum(strUnit.substring(3, 4));
        }
        else
        {
            if (!flag)
            {
                sMoney += "0";
                flag = true;
            }
        }

        if (sMoney.substring(sMoney.length() - 1, sMoney.length()).equals("0"))
        {
            sMoney = sMoney.substring(0, sMoney.length() - 1) + digit.trim() +
                     "0";
        }
        else
        {
            sMoney += digit.trim();
        }
        return sMoney;
    }

    /**
     * 格式化字符
     * @param sIn String
     * @return String
     */
    private static String formatStr(String sIn)
    {
        int n = sIn.length();
        String sOut = sIn;
        for (int k = 1; k <= 12 - n; k++)
        {
            sOut = "0" + sOut;
        }
        return sOut;
    }

    /**
     * 获取阿拉伯数字和中文数字的对应关系
     * @param value String
     * @return String
     */
    private static String getNum(String value)
    {
        String sNum = "";
        Integer I = new Integer(value);
        int iValue = I.intValue();
        switch (iValue)
        {
            case 0:
                sNum = "零";
                break;
            case 1:
                sNum = "壹";
                break;
            case 2:
                sNum = "贰";
                break;
            case 3:
                sNum = "叁";
                break;
            case 4:
                sNum = "肆";
                break;
            case 5:
                sNum = "伍";
                break;
            case 6:
                sNum = "陆";
                break;
            case 7:
                sNum = "柒";
                break;
            case 8:
                sNum = "捌";
                break;
            case 9:
                sNum = "玖";
                break;
        }
        return sNum;
    }

    /**
     * 如果一个字符串数字中小数点后全为零，则去掉小数点及零
     * @param Value String
     * @return String
     */
    public static String getInt(String Value)
    {
        if (Value == null)
        {
            return null;
        }
        String result = "";
        boolean mflag = true;
        int m = 0;
        m = Value.lastIndexOf(".");
        if (m == -1)
        {
            result = Value;
        }
        else
        {
            for (int i = m + 1; i <= Value.length() - 1; i++)
            {
                if (Value.charAt(i) != '0')
                {
                    result = Value;
                    mflag = false;
                    break;
                }
            }
            if (mflag)
            {
                result = Value.substring(0, m);
            }
        }
        return result;
    }

    /**
     * 得到近似值
     * @param aValue double
     * @return double
     */
    public static double getApproximation(double aValue)
    {
        if (java.lang.Math.abs(aValue) <= 0.01)
        {
            aValue = 0;
        }
        return aValue;
    }

    /**
     * 根据输入标记为间隔符号，拆分字符串
     * @param strMain String
     * @param strDelimiters String
     * 失败返回NULL
     * @return String[]
     */
    public static String[] split(String strMain, String strDelimiters)
    {
        int i;
        int intIndex = 0; //记录分隔符位置，以取出子串
        Vector vResult = new Vector(); //存储子串的数组
        String strSub = ""; //存放子串的中间变量

        strMain = strMain.trim();

        //若主字符串比分隔符串还要短的话,则返回空字符串
        if (strMain.length() <= strDelimiters.length())
        {
            System.out.println("分隔符串长度大于等于主字符串长度，不能进行拆分！");
            return null;
        }

        //取出第一个分隔符在主串中的位置
        intIndex = strMain.indexOf(strDelimiters);

        //在主串中找不到分隔符
        if (intIndex == -1)
        {
            String[] arrResult =
                    {
                    strMain};
            return arrResult;
        }

        //分割主串到数组中
        while (intIndex != -1)
        {
            strSub = strMain.substring(0, intIndex);
            if (intIndex != 0)
            {
                vResult.add(strSub);
            }
            else
            {
                //break;
                vResult.add("");
            }

            strMain = strMain.substring(intIndex + strDelimiters.length()).trim();
            intIndex = strMain.indexOf(strDelimiters);
        }

        //如果最末不是分隔符，取最后的字符串
//        if (!strMain.equals("") && strMain != null)
        if (!strMain.equals(""))
        {
            vResult.add(strMain);
        }

        String[] arrResult = new String[vResult.size()];
        for (i = 0; i < vResult.size(); i++)
        {
            arrResult[i] = (String) vResult.get(i);
        }

        return arrResult;
    }

    /**
     * 设置数字精度
     * 需要格式化的数据
     * @param value float
     * 精度描述（0.00表示精确到小数点后两位）
     * @param precision String
     * @return double
     */
    public static double setPrecision(float value, String precision)
    {
        return Float.parseFloat(new DecimalFormat(precision).format(value));
    }

    /**
     * 设置数字精度
     * 需要格式化的数据
     * @param value double
     * 精度描述（0.00表示精确到小数点后两位）
     * @param precision String
     * @return double
     */
    public static double setPrecision(double value, String precision)
    {
    	int Length = precision.length() - precision.indexOf(".") - 1;//小数点后的位数
    	if (Length < 0) {
            throw new IllegalArgumentException(
                    "The precision must be a positive integer or zero");
        }

        BigDecimal b = new BigDecimal(Double.toString(value));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one,Length,BigDecimal.ROUND_HALF_UP).doubleValue();

        /*原函数中使用下面方法
         * return Double.parseDouble(new DecimalFormat(precision).format(value));
         * 此方法不是传统意义上的四舍五入的数据格式化函数，而是采用to even的格式化方案(属于国际IEEE754标准规定的五种四舍五入方法之一)
         * IEEE754标准规定的五种四舍五入方法：
         * away from zero                 例：3.215 －> 3.22，-3.215 －> -3.22
         * towards zero                   例：3.215 －> 3.21，-3.215 －> -3.21
         * to even                        例：3.215 －> 3.22，3.245 －> 3.24
         * towards positive infinity      例：3.215 －> 3.22，-3.215 －> -3.21
         * towards negative infinity      例：3.215 －> 3.21，-3.215 －> -3.22
         * 
         * modified by zhanggl 2008-01-30
         */
        
    }

    /**
     * 生成更新的sql列表
     * @param tables String[]
     * @param condition String
     * @param wherepart String
     * @return Vector
     */
    public static Vector formUpdateSql(String[] tables, String condition,
                                       String wherepart)
    {
        Vector sqlVec = new Vector();
        for (int i = 0; i < tables.length; i++)
        {
            sqlVec.add("update " + tables[i] + " set " + condition + " where " +
                       wherepart);
        }
        return sqlVec;
    }
    
    /**
     * 获取单表的更新语句
     * @param table 要更新的表名
     * @param tFiledAndValue 要更新的内容，key即要更新的字段，value即要更新的内容
     * @param wherepart 更新的条件
     * @return 更新的Sql语句字符串
     */
    public static String formatOneUpdateSql(String table,HashMap tFiledAndValue,String wherepart)
    {
    	StringBuffer updateSql = new StringBuffer(256);
    	
    	if(table == null || "".equals(table) || tFiledAndValue == null || tFiledAndValue.size() <=0
    			|| wherepart == null || "".equals(wherepart))
    	{
    		return "";
    	}
    	
    	updateSql.append("update ");
    	updateSql.append(table);
    	updateSql.append(" set ");
    	
    	int tFiledSize = tFiledAndValue.size();
    	int num = 0;
    	Iterator it = tFiledAndValue.entrySet().iterator(); 
    	while(it.hasNext())
    	{ 
    		num++;
    		Entry entry = (Entry)it.next(); 
    		updateSql.append(entry.getKey());// 返回与此项对应的键，即列名
    		updateSql.append("= '");
    		updateSql.append(entry.getValue());// 返回与此项对应的值，即需要更新的内容
    		if(num == tFiledSize)//如果是最后一个字段，则后面不能再加逗号分隔
    		{
    			updateSql.append("' "); 
    		}
    		else
    		{
    			updateSql.append("', "); 
    		}    	
    	}
    	
    	updateSql.append(" where ");
    	updateSql.append(wherepart);
    	
    	return updateSql.toString();
    }
    
    /**
     * 获取单表的插入语句
     * @param table 要插入的表名
     * @param tFiledAndValue 要插入的内容，key即要插入的字段，value即要插入的内容
     * @return 插入的Sql语句字符串
     */
    public static String formatOneInsertSql(String table,HashMap tFiledAndValue)
    {
    	StringBuffer insertSql = new StringBuffer(256);
    	
    	if(table == null || "".equals(table) || tFiledAndValue == null || tFiledAndValue.size() <=0)
    	{
    		return "";
    	}
    	    	
    	insertSql.append("insert into ");
    	insertSql.append(table);
    	insertSql.append(" (");
    	
    	StringBuffer tFiledBuffer = new StringBuffer(256);
    	StringBuffer tValueBuffer = new StringBuffer(256);
    	int tFiledSize = tFiledAndValue.size();
    	int num = 0;
    	Iterator it = tFiledAndValue.entrySet().iterator(); 
    	while(it.hasNext())
    	{ 
    		num++;
    		Entry entry = (Entry)it.next(); 
    		tFiledBuffer.append(entry.getKey());// 返回与此项对应的键，即列名    		
    		tValueBuffer.append(entry.getValue());// 返回与此项对应的值，即需要更新的内容
    		if(num == tFiledSize)//如果是最后一个字段，则后面不能再加逗号分隔
    		{
    			tFiledBuffer.append(" ");
    			tValueBuffer.append("') "); 
    		}
    		else
    		{
    			tFiledBuffer.append(", ");
    			tValueBuffer.append("','"); 
    		}    	
    	}
    	
    	insertSql.append(tFiledBuffer.toString());
    	insertSql.append(") values ('");
    	insertSql.append(tValueBuffer.toString());
    	
    	return insertSql.toString();
    }
   
    /**
     * 将账号前的0去掉
     * @param sIn String
     * @return String
     */
    public static String DeleteZero(String sIn)
    {
        int n = sIn.length();
        String sOut = sIn;

        while (sOut.substring(0, 1).equals("0") && n > 1)
        {
            sOut = sOut.substring(1, n);
            n = sOut.length();
            System.out.println(sOut);
        }

        if (sOut.equals("0"))
        {
            return "";
        }
        else
        {
            return sOut;
        }
    }

    /**
     * 转换JavaScript解析不了的特殊字符
     * @param s String
     * @return String
     */
    public static String changForJavaScript(String s)
    {
        char[] arr = s.toCharArray();
        s = "";
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] == '"' || arr[i] == '\'' || arr[i] == '\n')
            {
                s += "\\";
            }

            s += arr[i];
        }

        return s;
    }

    /**
     * 转换JavaScript解析不了的特殊字符
     * @param s String
     * @return String
     */
    public static String changForHTML(String s)
    {
        char[] arr = s.toCharArray();
        s = "";

        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] == '"' || arr[i] == '\'')
            {
                s += "\\";
            }

            if (arr[i] == '\n')
            {
                s += "<br>";
                continue;
            }

            s += arr[i];
        }

        return s;
    }

    public static String getClassFileName(Object o)
    {
        String fileName = o.getClass().getName();
        fileName = fileName.substring(fileName.lastIndexOf(".") + 1);
        return fileName;
    }

    public static void out(Object o, String s)
    {
        System.out.println(PubFun.getClassFileName(o) + " : " + s);
    }
    
    /**
     * 通过身份证号号获取生日日期
     * @param IdNo String
     * @return String
     */
    public static String getBirthdayFromId(String IdNo)
    {
        String tIdNo = StrTool.cTrim(IdNo);
        String birthday = "";
        if (tIdNo.length() != 15 && tIdNo.length() != 18)
        {
            return "";
        }
        if (tIdNo.length() == 18)
        {
            birthday = tIdNo.substring(6, 14);
            birthday = birthday.substring(0, 4) + "-" + birthday.substring(4, 6) +
                       "-" + birthday.substring(6);
        }
        if (tIdNo.length() == 15)
        {
            birthday = tIdNo.substring(6, 12);
            birthday = birthday.substring(0, 2) + "-" + birthday.substring(2, 4) +
                       "-" + birthday.substring(4);
            birthday = "19" + birthday;
        }
        return birthday;

    }

    /**
     * 通过身份证号获取性别
     * @param IdNo String
     * @return String
     */
    public static String getSexFromId(String IdNo)
    {
        String tIdNo = StrTool.cTrim(IdNo);
        if (tIdNo.length() != 15 && tIdNo.length() != 18)
        {
            return "";
        }
        String sex = "";
        if (tIdNo.length() == 15)
        {
            sex = tIdNo.substring(14, 15);
        }
        else
        {
            sex = tIdNo.substring(16, 17);
        }
        try
        {
            int iSex = Integer.parseInt(sex);
//            iSex = iSex % 2;
            iSex %= 2;
            if (iSex == 0)
            {
                return "1";
            }
            if (iSex == 1)
            {
                return "0";
            }
        }
        catch (Exception ex)
        {
            return "";
        }
        return "";
    }    

    /**
     * 修改RCH函数，可以在字符串后面补空格
     * 将字符串补数,将sourString的<br>后面</br>用cChar补足cLen长度的字符串,如果字符串超长，则不做处理
     * <p><b>Example: </b><p>
     * <p>RCh("Minim", "0", 10) returns "Minim00000"<p>
     * @param sourString 源字符串
     * @param cChar 补数用的字符
     * @param cLen 字符串的目标长度
     * @return 字符串
     */
    public static String RChSpace(String sourString, String cChar, int cLen)
    {
        int tLen = sourString.length();
        int i, iMax;
        String tReturn = "";
        if (tLen >= cLen)
        {
            return sourString;
        }
        iMax = cLen - tLen;
        for (i = 0; i < iMax; i++)
        {
            tReturn += cChar;
        }
        tReturn = sourString.trim() + tReturn;
        return tReturn;
    }
    
    /**
     * 日期格式的转换，输入2008-01-01，转换成20080101
     * @param currentDate
     * @return
     */
    public static String getFileDateFormate(String currentDate)
    {
        StringTokenizer st=new StringTokenizer(currentDate.trim(),"-");
        String outputDate="";
        while(st.hasMoreElements())
        {
            String str=(String)st.nextToken();
            outputDate=outputDate+str;
        }
        return outputDate;
    }
    
    /**
     * 获取当前类文件所在的路径
     * @return
     */
    public static String getRealPath()
    {
        try 
        {
        	return getFullPathRelateClass("../../../../../..", PubFun.class);
        }
        catch (IOException ex) 
        {
        	return "Error!getFilePath Fail!";
        }
    }
    
    /**
     * 这个方法可以通过与某个类的class文件的相对路径来获取文件或目录的绝对路径。 通常在程序中很难定位某个相对路径，特别是在B/S应用中。
     * 通过这个方法，我们可以根据我们程序自身的类文件的位置来定位某个相对路径。
     * 比如：某个txt文件相对于程序的Test类文件的路径是../../resource/test.txt，
     * 那么使用本方法Path.getFullPathRelateClass("../../resource/test.txt",Test.class)
     * 得到的结果是txt文件的在系统中的绝对路径。
     *
     * @param relatedPath
     *            相对路径
     * @param cls
     *            用来定位的类
     * @return 相对路径所对应的绝对路径
     * @throws IOException
     *             因为本方法将查询文件系统，所以可能抛出IO异常
     */
    public static String getFullPathRelateClass(String relatedPath, Class cls) throws IOException 
    {
    	String path = null;
    	if (relatedPath == null) 
    	{
    		throw new NullPointerException();
    	}
    	String clsPath = getPathFromClass(cls);
	    File clsFile = new File(clsPath);
	    String tempPath = clsFile.getParent() + File.separator + relatedPath;
	    File file = new File(tempPath);
	    path = file.getCanonicalPath();
	    
	    return path;
    }
    
    /**
     * 获取一个类的class文件所在的绝对路径。 这个类可以是JDK自身的类，也可以是用户自定义的类，或者是第三方开发包里的类。
     * 只要是在本程序中可以被加载的类，都可以定位到它的class文件的绝对路径。
     *
     * @param cls  一个对象的Class属性
     * @return 这个类的class文件位置的绝对路径。 如果没有这个类的定义，则返回null。
     */
    public static String getPathFromClass(Class cls) throws IOException 
    {
    	String path = null;
    	if (cls == null) 
    	{
    		throw new NullPointerException();
    	}
    	
    	URL url = getClassLocationURL(cls);
    	if (url != null) 
    	{
    		path = url.getPath();
    		if ("jar".equalsIgnoreCase(url.getProtocol())) 
    		{
    			try 
    			{
    				path = new URL(path).getPath();
    			} catch (MalformedURLException e) {}
    			
    			int location = path.indexOf("!/");
    			if (location != -1) 
    			{
    				path = path.substring(0, location);
    			}
    		}
    		File file = new File(path);
    		path = file.getCanonicalPath();
    	}
    	
    	return path;
    }
    
    /**
     * 获取类的class文件位置的URL。这个方法是本类最基础的方法，供其它方法调用。
     */
    private static URL getClassLocationURL(final Class cls) 
    {
    	if (cls == null)
    		throw new IllegalArgumentException("null input: cls");
    	URL result = null;
    	final String clsAsResource = cls.getName().replace('.', '/').concat(".class");
    	final ProtectionDomain pd = cls.getProtectionDomain();
     
    	if (pd != null) 
    	{
    		final CodeSource cs = pd.getCodeSource();      
    		if (cs != null)
    			result = cs.getLocation();

    		if (result != null) 
    		{       
    			if ("file".equals(result.getProtocol())) 
    			{
    				try 
    				{
    					if (result.toExternalForm().endsWith(".jar")
    							|| result.toExternalForm().endsWith(".zip"))
    					{
    						result = new URL("jar:".concat(result.toExternalForm()).concat("!/").concat(clsAsResource));
    					}
    					else if (new File(result.getFile()).isDirectory())
    					{
    						result = new URL(result, clsAsResource);
    					}
    				} 
    				catch (MalformedURLException ignore) 
    				{
    				}
    			}
    		}
    	}

    	if (result == null) 
    	{      
    		final ClassLoader clsLoader = cls.getClassLoader();
    		result = clsLoader != null ? clsLoader.getResource(clsAsResource)
    				: ClassLoader.getSystemResource(clsAsResource);
    	}
    	
    	return result;
    }   
    
    

    /**
     * 主函数，测试用
     * @param args String[]
     */
    public static void main(String[] args)
    {   
    }
}