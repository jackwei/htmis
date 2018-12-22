package com.git.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.git.util.FDate;
import com.git.util.StrTool;

public class PubDateUtil {
	private final SimpleDateFormat longHourSdf = new SimpleDateFormat(
			"yyyy-MM-dd HH");
	private final static SimpleDateFormat longSdf = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	private final static SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");

	public static int getMaxDayOfMonth(int year, int month) {
		Calendar time = Calendar.getInstance();
		time.clear();
		time.set(Calendar.YEAR, year);
		time.set(Calendar.MONTH, month - 1);
		int day = time.getActualMaximum(Calendar.DAY_OF_MONTH);
		return day;
	}

	public static Date calendarToDate(Calendar cal) {
		return cal.getTime();
	}

	public static Calendar dateToCalendar(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	public static String dateFormat(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(date);
		return time;
	}

	public static String dateFormat(Date date, String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		String time = df.format(date);
		return time;
	}

	public static String dateFormat(String str, String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		String time = df.format(str);
		return time;
	}

	public static Date stringToDate(String str, String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		Date time = null;
		try {
			time = df.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return time;
	}

	public int getIntervalDays(Calendar startday, Calendar endday) {
		if (startday.after(endday)) {
			Calendar cal = startday;
			startday = endday;
			endday = cal;
		}
		long sl = startday.getTimeInMillis();
		long el = endday.getTimeInMillis();

		long ei = el - sl;
		return (int) (ei / (1000 * 60 * 60 * 24));
	}

	public int getIntervalDays(Date startday, Date endday) {
		if (startday.after(endday)) {
			Date cal = startday;
			startday = endday;
			endday = cal;
		}
		long sl = startday.getTime();
		long el = endday.getTime();
		long ei = el - sl;
		return (int) (ei / (1000 * 60 * 60 * 24));
	}

	public int getDaysBetween(Calendar d1, Calendar d2) {
		if (d1.after(d2)) {
			java.util.Calendar swap = d1;
			d1 = d2;
			d2 = swap;
		}
		int days = d2.get(Calendar.DAY_OF_YEAR) - d1.get(Calendar.DAY_OF_YEAR);
		int y2 = d2.get(Calendar.YEAR);
		if (d1.get(Calendar.YEAR) != y2) {
			d1 = (Calendar) d1.clone();
			do {
				days += d1.getActualMaximum(Calendar.DAY_OF_YEAR);
				d1.add(Calendar.YEAR, 1);
			} while (d1.get(Calendar.YEAR) != y2);
		}
		return days;
	}

	// 按照格式返回当前日期元素
	/**
	 * format类型： yyyy：当前年 MM：当前月 dd：当前日 yyyy-MM：当前年月 yyyy-MM-dd：当前年月日
	 * 
	 * HH：当前小时（24小时） hh：当前小时（12小时） mm：当前分钟 ss：当前秒 HH:mm:ss：当前Time（24小时制）
	 * 
	 * @param format
	 * @return
	 */
	public static String getNowDateFormat(String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);

		String tNowDateFormat = formatter.format(new Date());

		return tNowDateFormat;
	}

	// 按小时来比较两个时间的大小,如果DATE1>DATE2，返回1，相等返回0，小于返回-1
	public static int compareDate(String DATE1, String DATE2) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH");

		try {
			Date dt1 = df.parse(DATE1.trim());
			Date dt2 = df.parse(DATE2.trim());
			if (dt1.getTime() > dt2.getTime()) {
				// System.out.println("dt1 在dt2前");
				return 1;
			} else if (dt1.getTime() < dt2.getTime()) {
				// System.out.println("dt1在dt2后");
				return -1;
			} else {
				return 0;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return 0;

	}

	/**
	 * 获取前/后半年的开始时间
	 * 
	 * @return
	 */
	public static Date getCurrentDateByMonth(int month) {
		Calendar c = Calendar.getInstance();
		Date now = null;
		try {
			c.add(Calendar.MONTH, month);
			now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");
			System.out.println(longSdf.format(now));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	public static void main(String[] args) {
		PubDateUtil pd = new PubDateUtil();
		
		SimpleDateFormat sd = new SimpleDateFormat("yyMM");
		Date date = new Date();
		String yearstr = sd.format(date);
		System.out.println(yearstr);
		// String runParam = "2013-1-27 10:00:00";//需要执行的日期（yyyy-MM-dd）
		// String nowDate = DateUtil.getNowDateFormat("yyyy-MM-dd HH");
		//
		// int t=compareDate(runParam,nowDate);
		//
		// int b=0;
		//
		//
		// String tWeek = getNowDateFormat("E HH");
		//
		// Calendar calendar = Calendar.getInstance();
		// Date date = new Date();
		//
		// calendar.setTime(date);
		// int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		//
		// String tLastMonth = DateUtil.getIntervalMonth(0)+"-21";
		//
		// System.out.println("tLastMonth=="+tLastMonth);
		// System.out.println("dayOfWeek=="+dayOfWeek);

		/*
		 * String nowMonth = DateUtil.getNowDateFormat("MM"); String result =
		 * getRealMonthForQuarter(3,"12");
		 * System.out.println("result=="+result);
		 */
		/*
		 * String runDateTime = "2013-03-06 12:00:00"; String nowDate =
		 * PubDateUtil.getNowDateFormat("yyyy-MM-dd HH:mm:ss");
		 * 
		 * int result = PubDateUtil.compareDate(runDateTime, nowDate);
		 * 
		 * System.out.println("result=="+result);
		 */
	}

	/*
	 * 获取当天前几个月或者后几个月的月份 interval等于负值，表示获取前几个月的；等于正值，表示获取后几个月的
	 */
	public static String getIntervalMonth(int interval) {
		Date date = new Date();
		int year = Integer.parseInt(new SimpleDateFormat("yyyy").format(date));// 取到年份值
		int month = Integer.parseInt(new SimpleDateFormat("MM").format(date))
				+ interval;// 取到月份值
		int day = Integer.parseInt(new SimpleDateFormat("dd").format(date));// 取到天值
		if (month == 0) {
			year -= 1;
			month = 12;
		} else if (day > 28) {
			if (month == 2) {
				if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
					day = 29;
				} else
					day = 28;
			} else if ((month == 4 || month == 6 || month == 9 || month == 11)
					&& day == 31) {
				day = 30;
			}
		}

		String y = year + "";
		String m = "";
		String d = "";
		if (month < 10)
			m = "0" + month;
		else
			m = month + "";
		if (day < 10)
			d = "0" + day;
		else
			d = day + "";
		// System.out.println(y+"-"+m+"-"+d);
		return y + "-" + m;
	}

	public static String getRealMonthForQuarter(int index, String nowMonth) {
		String quarterSet = "";
		switch (index) {
		case 1:
			quarterSet = "01,04,07,10";
			break;
		case 2:
			quarterSet = "02,05,08,11";
			break;
		case 3:
			quarterSet = "03,06,09,12";
			break;
		default:
			quarterSet = "00";
		}

		int result = quarterSet.indexOf(nowMonth);
		if (result > -1) {
			return nowMonth;
		} else {
			return "00";
		}
	}

	/*
	 * 获取当天前几天或者后几天的日期 interval等于负值，表示获取前几天的；等于正值，表示获取后几天
	 */
	public static String getSpecifiedDayAfter(String specifiedDay, int interval) {
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + interval);

		String dayAfter = new SimpleDateFormat("yyyy-MM-dd")
				.format(c.getTime());
		return dayAfter;
	}

	/**
	 * 传入指定日期的进行解析，获取年、月、或日；
	 * 
	 * @param tDate
	 * @param format
	 * @return
	 */
	public static int getDateFormat(String tDate, String format) {
		int returnValue = 0;
		String[] tDateStr = tDate.split("-");
		if ("Y".equals(format)) {
			returnValue = Integer.parseInt(tDateStr[0]);
		} else if ("M".equals(format)) {
			returnValue = Integer.parseInt(tDateStr[1]);
		} else if ("D".equals(format)) {
			returnValue = Integer.parseInt(tDateStr[2]);
		}

		return returnValue;
	}

	/**
	 * 通过起始日期和终止日期计算以时间间隔单位为计量标准的时间间隔，舍弃法 author: HST
	 * 起始日期，(String,格式："YYYY-MM-DD")
	 * 
	 * @param cstartDate
	 *            String 终止日期，(String,格式："YYYY-MM-DD")
	 * @param cendDate
	 *            String 时间间隔单位，可用值("Y"--年 "M"--月 "D"--日)
	 * @param unit
	 *            String 时间间隔,整形变量int
	 * @return int
	 */
	public static int calInterval(String cstartDate, String cendDate,
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

		GregorianCalendar eCalendar = new GregorianCalendar();
		eCalendar.setTime(endDate);
		int eYears = eCalendar.get(Calendar.YEAR);
		int eMonths = eCalendar.get(Calendar.MONTH);
		int eDays = eCalendar.get(Calendar.DAY_OF_MONTH);

		if (StrTool.cTrim(unit).equals("Y")) {
			interval = eYears - sYears;

			if (eMonths < sMonths) {
				interval--;
			} else {
				if (eMonths == sMonths && eDays < sDays) {
					interval--;
					if (eMonths == 1) { // 如果同是2月，校验润年问题
						if ((sYears % 4) == 0 && (eYears % 4) != 0) { // 如果起始年是润年，终止年不是润年
							if (eDays == 28) { // 如果终止年不是润年，且2月的最后一天28日，那么补一
								interval++;
							}
						}
					}
				}
			}
		}
		if (StrTool.cTrim(unit).equals("M")) {
			interval = eYears - sYears;
			interval *= 12;
			interval += eMonths - sMonths;

			if (eDays < sDays) {
				interval--;
				// eDays如果是月末，则认为是满一个月
				int maxDate = eCalendar.getActualMaximum(Calendar.DATE);
				if (eDays == maxDate) {
					interval++;
				}
			}
		}
		if (StrTool.cTrim(unit).equals("D")) {
			sCalendar.set(sYears, sMonths, sDays);
			eCalendar.set(eYears, eMonths, eDays);
			long lInterval = (eCalendar.getTime().getTime() - sCalendar
					.getTime().getTime()) / 86400000;
			interval = (int) lInterval;
		}
		return interval;
	}
}
