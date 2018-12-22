package com.git.util;

import it.sauronsoftware.base64.Base64;

import java.io.UnsupportedEncodingException;

public class Encrypt {
	private static char[] hexByte = new char[] { '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
	private static String hexString = "0123456789ABCDEF";

	public static String encode(String original) {
		String result = null;
		try {
			// 应为Base64对于中文的支持问题，首先把字符串转换为16进制表现形式
			StringBuffer encoded = new StringBuffer();
			byte[] bytes = original.getBytes("UTF-8");
			for (int i = 0; i < bytes.length; i++) {
				encoded.append(hexByte[(bytes[i] & 0xf0) >> 4]);
				encoded.append(hexByte[bytes[i] & 0x0f]);
			}
			result = encoded.toString();
			// 利用Base64加密
			result = Base64.encode(result);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		}
		return result;
	}

	public static String decode(String encoded) {
		// 先进行解密，得到16进制表现形式
		encoded = Base64.decode(encoded);

		// 再将16进制形式恢复为字符串
		String result = null;
		int length = encoded.length() / 2;
		byte[] bytes = new byte[length];

		for (int i = 0; i < encoded.length(); i += 2) {
			byte one = 0;
			char highChar = encoded.charAt(i);
			char lowChar = encoded.charAt(i + 1);
			int high = hexString.indexOf(highChar);
			int low = hexString.indexOf(lowChar);
			one |= ((high & 0x0f) << 4);
			one |= (low & 0x0f);
			bytes[i / 2] = one;
		}
		try {
			result = new String(bytes, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(encode("MzEzMjMz"));
		System.out.println(decode("MzEzMjMz"));
	}

}
