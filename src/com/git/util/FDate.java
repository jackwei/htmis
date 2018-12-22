package com.git.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/*
 * <p>Title: 日期处理类 </p>
 * <p>Description: 处理日期信息 </p>
 * <p>Copyright: Copyright (c) 2002</p>
 */
public class FDate implements Cloneable
{   
    private final String pattern = "yyyy-MM-dd";
    private final String pattern1 = "yyyyMMdd";
    private SimpleDateFormat df;
    private SimpleDateFormat df1;
    // @Constructor
    public FDate()
    {
        df = new SimpleDateFormat(pattern);
        df1 = new SimpleDateFormat(pattern1);
    }

    /**
     * 克隆FDate对象
     * 2005－04－15 朱向峰添加
     * @return Object
     * @throws CloneNotSupportedException
     */
    public Object clone()
            throws CloneNotSupportedException
    {
        FDate cloned = (FDate)super.clone();
        // clone the mutable fields of this class       
        return cloned;
    }

    // @Method
    /**
     * 输入符合格式要求的日期字符串，返回日期类型变量
     * <p><b>Example: </b><p>
     * <p>getDate("2002-10-8") returns "Tue Oct 08 00:00:00 CST 2002"<p>
     * @param dateString 日期字符串
     * @return 日期类型变量
     */
    public Date getDate(String dateString)
    {
        Date tDate = null;
        try
        {
            if (dateString.indexOf("-") != -1)
            {
                tDate = df.parse(dateString);
            }
            else
            {
                tDate = df1.parse(dateString);
            }
        }
        catch (Exception e)
        {
        }

        return tDate;
    }

    /**
     * 输入日期类型变量，返回日期字符串
     * <p><b>Example: </b><p>
     * <p>getString("Tue Oct 08 00:00:00 CST 2002") returns "2002-10-8"<p>
     * @param mDate 日期类型变量
     * @return 日期字符串
     */
    public String getString(Date mDate)
    {
        String tString = null;
        if (mDate != null)
        {
            tString = df.format(mDate);
        }
        return tString;
    }
    
    /**
     * 判断是否为闰年
     * XinYQ added on 2006-09-25
     */
    public static boolean isLeapYear(int nYear)
    {
        boolean ResultLeap = false;
        ResultLeap = (nYear % 400 == 0) | (nYear % 100 != 0) & (nYear % 4 == 0);
        return ResultLeap;
    }

    /**
     * 计算日期的函数 author: HST
     * 参照日期指当按照年月进行日期的计算的时候，参考的日期，如下例，结果返回2002-03-31
     * <p><b>Example: </b><p>
     * <p>FDate tD=new FDate();<p>
     * <p>Date baseDate =new Date();<p>
     * <p>baseDate=tD.getDate("2000-02-29");<p>
     * <p>Date comDate =new Date();<p>
     * <p>comDate=tD.getDate("1999-12-31");<p>
     * <p>int inteval=1;<p>
     * <p>String tUnit="M";<p>
     * <p>Date tDate =new Date();<p>
     * <p>tDate=PubFun.calDate(baseDate,inteval,tUnit,comDate);<p>
     * <p>System.out.println(tDate.toString());<p>
     * @param baseDate 起始日期
     * @param interval 时间间隔
     * @param unit 时间间隔单位
     * @param compareDate 参照日期
     * @return Date类型变量
     */
    public static Date calDate(Date baseDate, int interval, String unit, Date compareDate)
    {
        Date returnDate = null;

        GregorianCalendar tBaseCalendar = new GregorianCalendar();
        tBaseCalendar.setTime(baseDate);

        if (unit.equals("Y"))
        {
            tBaseCalendar.add(Calendar.YEAR, interval);
        }
        if (unit.equals("M"))
        {
            tBaseCalendar.add(Calendar.MONTH, interval);
        }
        if (unit.equals("D"))
        {
            tBaseCalendar.add(Calendar.DATE, interval);
        }

        if (compareDate != null)
        {
            GregorianCalendar tCompCalendar = new GregorianCalendar();
            tCompCalendar.setTime(compareDate);
            int nBaseYears = tBaseCalendar.get(Calendar.YEAR);
            int nBaseMonths = tBaseCalendar.get(Calendar.MONTH);
            int nCompMonths = tCompCalendar.get(Calendar.MONTH);
            int nCompDays = tCompCalendar.get(Calendar.DATE);

            if (unit.equals("Y"))
            {
                tCompCalendar.set(nBaseYears, nCompMonths, nCompDays);
                if (tCompCalendar.before(tBaseCalendar))
                {
                    tBaseCalendar.set(nBaseYears + 1, nCompMonths, nCompDays);
                    returnDate = tBaseCalendar.getTime();
                }
                else
                {
                    returnDate = tCompCalendar.getTime();
                }
            }
            if (unit.equals("M"))
            {
                tCompCalendar.set(nBaseYears, nBaseMonths, nCompDays);
                if (tCompCalendar.before(tBaseCalendar))
                {
                    tBaseCalendar.set(nBaseYears, nBaseMonths + 1, nCompDays);
                    returnDate = tBaseCalendar.getTime();
                }
                else
                {
                    returnDate = tCompCalendar.getTime();
                }
            }
            if (unit.equals("D"))
            {
                returnDate = tBaseCalendar.getTime();
            }
            tCompCalendar = null;
        }
        else
        {
            returnDate = tBaseCalendar.getTime();

            //XinYQ added on 2006-09-25 : 修正闰年闰月和月底天数,和Oracle保持一致
            GregorianCalendar tLeapCalendar = new GregorianCalendar();
            tLeapCalendar.setTime(returnDate);
            int arrComnYearEndDate[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            int arrLeapYearEndDate[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            int nOldYear = 1900 + baseDate.getYear();
            int nOldMonth = baseDate.getMonth();
            int nOldDate = baseDate.getDate();
            int nNewYear = tLeapCalendar.get(Calendar.YEAR);
            int nNewMonth = tLeapCalendar.get(Calendar.MONTH);

            if ((isLeapYear(nOldYear) && nOldDate == arrLeapYearEndDate[nOldMonth]) ||
                (!isLeapYear(nOldYear) && nOldDate == arrComnYearEndDate[nOldMonth]))
            {
                if (unit != null && (unit.equalsIgnoreCase("Y") || unit.equalsIgnoreCase("M")))
                {
                    if (isLeapYear(nNewYear))
                    {
                        returnDate.setDate(arrLeapYearEndDate[nNewMonth]);
                    }
                    else
                    {
                        returnDate.setDate(arrComnYearEndDate[nNewMonth]);
                    }
                }
            }
            tLeapCalendar = null;
        }
        tBaseCalendar = null;

        return returnDate;
    }

    /**
     * 重载计算日期，参数见楼上，add by Minim
     * @param baseDate String
     * @param interval int
     * @param unit String
     * @param compareDate String
     * @return String
     */
    public static String calDate(String baseDate, int interval, String unit,
                                 String compareDate)
    {
        try
        {
            FDate tFDate = new FDate();
            Date bDate = tFDate.getDate(baseDate);
            Date cDate = tFDate.getDate(compareDate);
            return tFDate.getString(calDate(bDate, interval, unit, cDate));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }

    public static String calOFDate(String baseDate, int interval, String unit, String compareDate)
    {
        try
        {
            FDate tFDate = new FDate();
            Date bDate = tFDate.getDate(baseDate);
            Date cDate = tFDate.getDate(compareDate);
            return tFDate.getString(calOFDate(bDate, interval, unit, cDate));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }


    public static Date calOFDate(Date baseDate, int interval, String unit, Date compareDate)
    {
        Date returnDate = null;

        GregorianCalendar mCalendar = new GregorianCalendar();
        //设置起始日期格式
        mCalendar.setTime(baseDate);
        if (unit.equals("Y"))
        {
            mCalendar.add(Calendar.YEAR, interval);
        }
        if (unit.equals("M"))
        {
            //执行月份增减
            mCalendar.add(Calendar.MONTH, interval);
        }
        if (unit.equals("D"))
        {
            mCalendar.add(Calendar.DATE, interval);
        }

        if (compareDate != null)
        {
            GregorianCalendar cCalendar = new GregorianCalendar();
            //设置坐标日期
            cCalendar.setTime(compareDate);

            int mYears = mCalendar.get(Calendar.YEAR);
            int mMonths = mCalendar.get(Calendar.MONTH);
            int cMonths = cCalendar.get(Calendar.MONTH);
            int cDays = cCalendar.get(Calendar.DATE);

            if (unit.equals("Y"))
            {
                cCalendar.set(mYears, cMonths, cDays);
                if (mMonths < cCalendar.get(Calendar.MONTH))
                {
                    cCalendar.set(mYears, mMonths + 1, 0);
                }
                if (cCalendar.before(mCalendar))
                {
                    mCalendar.set(mYears + 1, cMonths, cDays);
                    returnDate = mCalendar.getTime();
                }
                else
                {
                    returnDate = cCalendar.getTime();
                }
            }
            if (unit.equals("M"))
            {
                cCalendar.set(mYears, mMonths, cDays);

                if (mMonths < cCalendar.get(Calendar.MONTH))
                {
                    //取当前月的最后一天日期
                    cCalendar.set(mYears, mMonths + 1, 0);
                }
                if (cCalendar.before(mCalendar))
                {
                    mCalendar.set(mYears, mMonths + 1, cDays);
                    returnDate = mCalendar.getTime();
                }
                else
                {
                    returnDate = cCalendar.getTime();
                }
            }
            if (unit.equals("D"))
            {
                returnDate = mCalendar.getTime();
            }
        }
        else
        {
            returnDate = mCalendar.getTime();
        }

        return returnDate;
    }
    
    /**
     * 通过起始日期和终止日期计算以时间间隔单位为计量标准的时间间隔 author: HST
     * <p><b>Example: </b><p>
     * <p>参照calInterval(String  cstartDate, String  cendDate, String unit)，前两个变量改为日期型即可<p>
     * @param startDate 起始日期，Date变量
     * @param endDate 终止日期，Date变量
     * @param unit 时间间隔单位，可用值("Y"--年 "M"--月 "D"--日)
     * @return 时间间隔,整形变量int
     */
    public static int calInterval(Date startDate, Date endDate, String unit)
    {
        int interval = 0;

        GregorianCalendar sCalendar = new GregorianCalendar();
        sCalendar.setTime(startDate);
        int sYears = sCalendar.get(Calendar.YEAR);
        int sMonths = sCalendar.get(Calendar.MONTH);
        int sDays = sCalendar.get(Calendar.DAY_OF_MONTH);

        GregorianCalendar eCalendar = new GregorianCalendar();
        eCalendar.setTime(endDate);
        int eYears = eCalendar.get(Calendar.YEAR);
        int eMonths = eCalendar.get(Calendar.MONTH);
        int eDays = eCalendar.get(Calendar.DAY_OF_MONTH);

        if (unit.equals("Y"))
        {
            interval = eYears - sYears;
            if (eMonths < sMonths)
            {
                interval--;
            }
            else
            {
                if (eMonths == sMonths && eDays < sDays)
                {
                    interval--;
                    if (eMonths == 1)
                    { //如果同是2月，校验润年问题
                        if ((sYears % 4) == 0 && (eYears % 4) != 0)
                        { //如果起始年是润年，终止年不是润年
                            if (eDays == 28)
                            { //如果终止年不是润年，且2月的最后一天28日，那么补一
                                interval++;
                            }
                        }
                    }
                }
            }
        }
        if (unit.equals("M"))
        {
            interval = eYears - sYears;
            interval *= 12;
            interval += eMonths - sMonths;
            if (eDays < sDays)
            {
                interval--;
                int maxDate = eCalendar.getActualMaximum(Calendar.DATE);
                if (eDays == maxDate)
                {
                    interval++;
                }
            }
        }
        if (unit.equals("D"))
        {
            sCalendar.set(sYears, sMonths, sDays);
            eCalendar.set(eYears, eMonths, eDays);
            long lInterval = (eCalendar.getTime().getTime() -
                              sCalendar.getTime().getTime()) / 86400000;
            interval = (int) lInterval;
        }
        return interval;
    }

    /**
     * 通过起始日期和终止日期计算以时间间隔单位为计量标准的时间间隔，舍弃法 author: HST
     * 起始日期，(String,格式："YYYY-MM-DD")
     * @param cstartDate String
     * 终止日期，(String,格式："YYYY-MM-DD")
     * @param cendDate String
     * 时间间隔单位，可用值("Y"--年 "M"--月 "D"--日)
     * @param unit String
     * 时间间隔,整形变量int
     * @return int
     */
    public static int calInterval(String cstartDate, String cendDate,
                                  String unit)
    {
        FDate fDate = new FDate();
        Date startDate = fDate.getDate(cstartDate);
        Date endDate = fDate.getDate(cendDate);
       
        int interval = 0;

        GregorianCalendar sCalendar = new GregorianCalendar();
        sCalendar.setTime(startDate);
        int sYears = sCalendar.get(Calendar.YEAR);
        int sMonths = sCalendar.get(Calendar.MONTH);
        int sDays = sCalendar.get(Calendar.DAY_OF_MONTH);

        GregorianCalendar eCalendar = new GregorianCalendar();
        eCalendar.setTime(endDate);
        int eYears = eCalendar.get(Calendar.YEAR);
        int eMonths = eCalendar.get(Calendar.MONTH);
        int eDays = eCalendar.get(Calendar.DAY_OF_MONTH);

        if (StrTool.cTrim(unit).equals("Y"))
        {
            interval = eYears - sYears;

            if (eMonths < sMonths)
            {
                interval--;
            }
            else
            {
                if (eMonths == sMonths && eDays < sDays)
                {
                    interval--;
                    if (eMonths == 1)
                    { //如果同是2月，校验润年问题
                        if ((sYears % 4) == 0 && (eYears % 4) != 0)
                        { //如果起始年是润年，终止年不是润年
                            if (eDays == 28)
                            { //如果终止年不是润年，且2月的最后一天28日，那么补一
                                interval++;
                            }
                        }
                    }
                }
            }
        }
        if (StrTool.cTrim(unit).equals("M"))
        {
            interval = eYears - sYears;
//            interval = interval * 12;
            interval *= 12;
//            interval = eMonths - sMonths + interval;
            interval += eMonths - sMonths;

            if (eDays < sDays)
            {
                interval--;
                //eDays如果是月末，则认为是满一个月
                int maxDate = eCalendar.getActualMaximum(Calendar.DATE);
                if (eDays == maxDate)
                {
                    interval++;
                }
            }
        }
        if (StrTool.cTrim(unit).equals("D"))
        {
            sCalendar.set(sYears, sMonths, sDays);
            eCalendar.set(eYears, eMonths, eDays);
            long lInterval = (eCalendar.getTime().getTime() -
                              sCalendar.getTime().getTime()) / 86400000;
            interval = (int) lInterval;
        }
        return interval;
    }

    /**
     * 通过起始日期和终止日期计算以时间间隔单位为计量标准的时间间隔，约进法 author: YangZhao，Minim
     * 起始日期，(String,格式："YYYY-MM-DD")
     * @param cstartDate String
     * 终止日期，(String,格式："YYYY-MM-DD")
     * @param cendDate String
     * 时间间隔单位，可用值("Y"--年 "M"--月 "D"--日)
     * @param unit String
     * 时间间隔,整形变量int
     * @return int
     */
    public static int calInterval2(String cstartDate, String cendDate,
                                   String unit)
    {
        FDate fDate = new FDate();
        Date startDate = fDate.getDate(cstartDate);
        Date endDate = fDate.getDate(cendDate);
        

        int interval = 0;

        GregorianCalendar sCalendar = new GregorianCalendar();
        sCalendar.setTime(startDate);
        int sYears = sCalendar.get(Calendar.YEAR);
        int sMonths = sCalendar.get(Calendar.MONTH);
        int sDays = sCalendar.get(Calendar.DAY_OF_MONTH);

        GregorianCalendar eCalendar = new GregorianCalendar();
        eCalendar.setTime(endDate);
        int eYears = eCalendar.get(Calendar.YEAR);
        int eMonths = eCalendar.get(Calendar.MONTH);
        int eDays = eCalendar.get(Calendar.DAY_OF_MONTH);

        if (StrTool.cTrim(unit).equals("Y"))
        {
            interval = eYears - sYears;

            if (eMonths > sMonths)
            {
                interval++;
            }
            else
            {
                if (eMonths == sMonths && eDays > sDays)
                {
                    interval++;
                    if (eMonths == 1)
                    { //如果同是2月，校验润年问题
                        if ((sYears % 4) == 0 && (eYears % 4) != 0)
                        { //如果起始年是润年，终止年不是润年
                            if (eDays == 28)
                            { //如果终止年不是润年，且2月的最后一天28日，那么减一
                                interval--;
                            }
                        }
                    }
                }
            }
        }
        if (StrTool.cTrim(unit).equals("M"))
        {
            interval = eYears - sYears;
//            interval = interval * 12;
            interval *= 12;
//            interval = eMonths - sMonths + interval;
            interval += eMonths - sMonths;

            if (eDays > sDays)
            {
                interval++;
                //sDays  和 eDays如果均是月末，则认为是满一个月 //modified by zhangrong
                int maxsDate = sCalendar.getActualMaximum(Calendar.DATE);
                int maxeDate = eCalendar.getActualMaximum(Calendar.DATE);
                if (sDays == maxsDate && eDays == maxeDate)
                {
                    interval--;
                }
            }
        }
        if (StrTool.cTrim(unit).equals("D"))
        {
            sCalendar.set(sYears, sMonths, sDays);
            eCalendar.set(eYears, eMonths, eDays);
            long lInterval = (eCalendar.getTime().getTime() -
                              sCalendar.getTime().getTime()) / 86400000; //24*60*60*1000 一天对应的毫秒数
            interval = (int) lInterval;
        }
        return interval;
    }

    /**
     * 通过传入的日期可以得到所在月的第一天和最后一天的日期 author: LH
     * 日期，(String,格式："YYYY-MM-DD")
     * @param tDate String
     * 本月开始和结束日期，返回String[2]
     * @return String[]
     */
    public static String[] calFLDate(String tDate)
    {
        String MonDate[] = new String[2];
        FDate fDate = new FDate();
        Date CurDate = fDate.getDate(tDate);
        GregorianCalendar mCalendar = new GregorianCalendar();
        mCalendar.setTime(CurDate);
        int Years = mCalendar.get(Calendar.YEAR);
        int Months = mCalendar.get(Calendar.MONTH);
        int FirstDay = mCalendar.getActualMinimum(Calendar.DAY_OF_MONTH);
        int LastDay = mCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        mCalendar.set(Years, Months, FirstDay);
        MonDate[0] = fDate.getString(mCalendar.getTime());
        mCalendar.set(Years, Months, LastDay);
        MonDate[1] = fDate.getString(mCalendar.getTime());
        return MonDate;
    }


    /**
     * 比较获取两天中较后的一天
     * @param date1 String
     * @param date2 String
     * @return String
     */
    public static String getLaterDate(String date1, String date2)
    {
        try
        {
            date1 = StrTool.cTrim(date1);
            date2 = StrTool.cTrim(date2);
            if (date1.equals(""))
            {
                return date2;
            }
            if (date2.equals(""))
            {
                return date1;
            }
            FDate fd = new FDate();
            Date d1 = fd.getDate(date1);
            Date d2 = fd.getDate(date2);
            if (d1.after(d2))
            {
                return date1;
            }
            return date2;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "";
        }

    }

    /**
     * 比较获取两天中较早的一天
     * @param date1 String
     * @param date2 String
     * @return String
     */
    public static String getBeforeDate(String date1, String date2)
    {
        try
        {
            date1 = StrTool.cTrim(date1);
            date2 = StrTool.cTrim(date2);
            if (date1.equals(""))
            {
                return date2;
            }
            if (date2.equals(""))
            {
                return date1;
            }
            FDate fd = new FDate();
            Date d1 = fd.getDate(date1);
            Date d2 = fd.getDate(date2);
            if (d1.before(d2))
            {
                return date1;
            }
            return date2;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "";
        }

    }


    /**
     * 获取传入日期所在自然月的天数 add by zhangtao 2007-04-28
     * @param sDate 传入日期
     * @return
     */
    public static int monthLength(String sDate)
    {
        FDate fDate = new FDate();
        Date startDate = fDate.getDate(sDate);
        
        GregorianCalendar sCalendar = new GregorianCalendar();
        sCalendar.setTime(startDate);
        int sYears = sCalendar.get(Calendar.YEAR);
        int sMonths = sCalendar.get(Calendar.MONTH);

        return monthLength(sYears, sMonths+1);
    }

    /**
     * 获取传入年份、月份的自然月天数 add by zhangtao 2007-04-28
     * @param year 年份
     * @param month 月份 1-12
     * @return
     */
    public static int monthLength(int year, int month)
    {
        int LEAP_MONTH_LENGTH[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int MONTH_LENGTH[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        return isLeapYear(year) ? MONTH_LENGTH[month-1] : LEAP_MONTH_LENGTH[month-1];
    }
  

    /**
       * 通过起始日期和终止日期计算以时间间隔单位为计量标准的时间间隔，约进法 author: YangZhao，Minim
       * <p><b>Example: </b><p>
       * <p>calInterval("2002-10-8", "2012-10-1", "Y") returns 10<p>
       * @param startDate 起始日期，(String,格式："YYYY-MM-DD")
       * @param endDate 终止日期，(String,格式："YYYY-MM-DD")
       * @param unit 时间间隔单位，可用值("Y"--年 "M"--月 "D"--日)
       * @return 时间间隔,整形变量int
       */
      public static int calInterval3(String cstartDate, String cendDate,
                                     String unit) {
        FDate fDate = new FDate();
        Date startDate = fDate.getDate(cstartDate);
        Date endDate = fDate.getDate(cendDate);
        
        int interval = 0;

        GregorianCalendar sCalendar = new GregorianCalendar();
        sCalendar.setTime(startDate);
        int sYears = sCalendar.get(Calendar.YEAR);
        int sMonths = sCalendar.get(Calendar.MONTH);
        int sDays = sCalendar.get(Calendar.DAY_OF_MONTH);
        int sDaysOfYear = sCalendar.get(Calendar.DAY_OF_YEAR);

        GregorianCalendar eCalendar = new GregorianCalendar();
        eCalendar.setTime(endDate);
        int eYears = eCalendar.get(Calendar.YEAR);
        int eMonths = eCalendar.get(Calendar.MONTH);
        int eDays = eCalendar.get(Calendar.DAY_OF_MONTH);
        int eDaysOfYear = eCalendar.get(Calendar.DAY_OF_YEAR);

        if (StrTool.cTrim(unit).equals("Y")) {
          interval = eYears - sYears;

          if (eMonths > sMonths) {
            interval++;
          }
          else {
            if (eMonths == sMonths && eDays > sDays) {
              interval++;
              if (eMonths == 1) { //如果同是2月，校验润年问题
                if ( (sYears % 4) == 0 && (eYears % 4) != 0) { //如果起始年是润年，终止年不是润年
                  if (eDays == 28) { //如果终止年不是润年，且2月的最后一天28日，那么减一
                    interval--;
                  }
                }
              }
            }
          }
        }
        if (StrTool.cTrim(unit).equals("M")) {
          interval = eYears - sYears;
          interval = interval * 12;
          interval = eMonths - sMonths + interval;

          if (eDays > sDays) {
            interval++;
            //eDays如果是月末，则认为是满一个月
            int maxDate = eCalendar.getActualMaximum(Calendar.DATE);
            if (eDays == maxDate) {
              interval--;
            }
          }
        }
        if (StrTool.cTrim(unit).equals("D")) {
          interval = eYears - sYears;
          interval = interval * 365;

          interval = eDaysOfYear - sDaysOfYear + interval;
          interval = interval + 1;

          // 处理润年
          int n = 0;
          eYears--;
          if (eYears > sYears) {
            int i = sYears % 4;
            if (i == 0) {
              sYears++;
              n++;
            }
            int j = (eYears) % 4;
            if (j == 0) {
              eYears--;
              n++;
            }
            n += (eYears - sYears) / 4;
          }
          if (eYears == sYears) {
            int i = sYears % 4;
            if (i == 0)
              n++;
          }
          interval += n;
        }
        return interval;
    }
      
    /**
     *计算传入日期所在的月，有几天
     **/
    public static int nextMonth(String tDate){
  	  int days=0;	  
  	  String MonDate[] = new String[2];
  	  MonDate=calFLDate(tDate);
  	  days=calInterval3(MonDate[0], MonDate[1], "D");
  	  return days;	  
    }
    

    /**
     * MAIN方法，测试用
     * @param args String[]
     */
    public static void main(String[] args)
    {
//        FDate tFDate = new FDate();
//        System.out.println(tFDate.getDate("2002-10-8"));
    }
}