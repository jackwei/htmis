package dwz.common.util;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
public class CommonUtils {
	
	public static String parseHexStringFromBytes(final byte[] text) {
		StringBuffer buff = new StringBuffer(0);
		for (int i = 0; i < text.length; i++) {
			byte _byte = text[i];
			byte _bytel = (byte) (_byte & 0x000f);
			byte _byteh = (byte) (_byte & 0x00f0);
			getHexString(buff, (byte) ((_byteh >> 4) & 0x000f));
			getHexString(buff, _bytel);
		}
		return buff.toString();
	}
	
	private static void getHexString(final StringBuffer buffer, final byte value) {
		if (value - 9 > 0) {
			int index = value - 9;
			switch (index) {
			case 1:
				buffer.append("A");
				break;
			case 2:
				buffer.append("B");
				break;
			case 3:
				buffer.append("C");
				break;
			case 4:
				buffer.append("D");
				break;
			case 5:
				buffer.append("E");
				break;
			case 6:
				buffer.append("F");
				break;
			default:
				break;
			}
		} else {
			buffer.append(String.valueOf(value));
		}
	}
	  public static boolean isEmpty(Object ob) {
	        return ob == null || "".equals(ob.toString()) ? true : false;
	    }
	// 删除文件
	public static void deleteFile(String filePath) {
		try {
			File file = new File(filePath);
			if (file.exists()) { // 判断文件是否存在
				if (file.isFile()) { // 判断是否是文件
					file.delete(); // delete()方法 你应该知道 是删除的意思;
				} else if (file.isDirectory()) { // 否则如果它是一个目录
					File files[] = file.listFiles(); // 声明目录下所有的文件 files[];
					for (int i = 0; i < files.length; i++) { // 遍历目录下所有的文件
						deleteFile(files[i].getAbsolutePath()); // 把每个文件
						// 用这个方法进行迭代
					}
				}
				file.delete();
			} else {
				System.out.println("所删除的文件不存在！" + '\n');
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String nullToEmpty(Object msg){
		 return msg == null || "".equals(msg.toString()) ? "" : msg.toString();
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

	public static byte[] parseBytesByHexString(final String hexString) {
		if (hexString == null || hexString.length() == 0
				|| hexString.equals("")) {
			return new byte[0];
		}
		if (hexString.length() % 2 != 0) {
			throw new IllegalArgumentException(
					"hexString length must be an even number!");
		}
		StringBuffer sb = new StringBuffer(hexString);
		StringBuffer sb1 = new StringBuffer(2);
		int n = hexString.length() / 2;
		byte[] bytes = new byte[n];
		for (int i = 0; i < n; i++) {
			if (sb1.length() > 1) {
				sb1.deleteCharAt(0);
				sb1.deleteCharAt(0);
			}
			sb1.append(sb.charAt(0));
			sb1.append(sb.charAt(1));
			sb.deleteCharAt(0);
			sb.deleteCharAt(0);
			bytes[i] = (byte) Integer.parseInt(sb1.toString(), 16);
		}
		return bytes;
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
	public static Integer convert2int(Object o){
		if(o==null) return 0;
		else return (Integer)o;
	}

}
