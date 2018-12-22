package com.git.util;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @author Joylisten 2011-9-12
 */
public class JCryptology
{
	private static final Log log=LogFactory.getLog(Log.class);
	private static Key keyDES=JCryptology.getDESKey("cooban@joylisten.com");;

	public static Key getDESKey(String strKey)
	{
		try
		{
			KeyGenerator _generator=KeyGenerator.getInstance("DES");
			_generator.init(new SecureRandom(strKey.getBytes()));
			return _generator.generateKey();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 加密String明文输入,String密文输出
	 * 
	 * @param strMing
	 * @return
	 */
	public String getDESEncString(String strMing)
	{
		byte[] byteMi=null;
		byte[] byteMing=null;
		String strMi="";
		BASE64Encoder base64en=new BASE64Encoder();
		try
		{
			byteMing=strMing.getBytes("UTF8");
			byteMi=this.getDESEncCode(byteMing);
			strMi=base64en.encode(byteMi);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			base64en=null;
			byteMing=null;
			byteMi=null;
		}
		return strMi;
	}

	/**
	 * 解密 以String密文输入,String明文输出
	 * 
	 * @param strMi
	 * @return
	 */
	public String getDesString(String strMi)
	{
		BASE64Decoder base64De=new BASE64Decoder();
		byte[] byteMing=null;
		byte[] byteMi=null;
		String strMing="";
		try
		{
			byteMi=base64De.decodeBuffer(strMi);
			byteMing=this.getDesCode(byteMi);
			strMing=new String(byteMing,"UTF8");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			base64De=null;
			byteMing=null;
			byteMi=null;
		}
		return strMing;
	}

	/**
	 * 加密以byte[]明文输入,byte[]密文输出
	 * 
	 * @param byteS
	 * @return
	 */
	private byte[] getDESEncCode(byte[] byteS)
	{
		byte[] byteFina=null;
		Cipher cipher;
		try
		{
			cipher=Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE,keyDES);
			byteFina=cipher.doFinal(byteS);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cipher=null;
		}
		return byteFina;
	}

	/**
	 * 解密以byte[]密文输入,以byte[]明文输出
	 * 
	 * @param byteD
	 * @return
	 */
	private byte[] getDesCode(byte[] byteD)
	{
		Cipher cipher;
		byte[] byteFina=null;
		try
		{
			cipher=Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE,keyDES);
			byteFina=cipher.doFinal(byteD);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cipher=null;
		}
		return byteFina;
	}

	public static void main(String[] args)
	{
		JCryptology des=new JCryptology();// 实例化一个对像
		des.getDESKey("web@ceemoo.com");// 生成密匙
		String strEnc=des.getDESEncString("fengye666666666|sdfskdfkjhfe|你sdk谁将fks都江府");// 加密字符串,返回String的密文
		System.out.println(strEnc);
		String strDes=des.getDesString(strEnc);// 把String 类型的密文解密
		System.out.println(strDes);
	}

}
