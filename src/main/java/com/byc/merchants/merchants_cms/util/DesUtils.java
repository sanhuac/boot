package com.byc.merchants.merchants_cms.util;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.io.UnsupportedEncodingException;

public class DesUtils {
	private static byte[] iv1;

	static {
		try {
			iv1 = "byc18914".getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	private static String padding = "DES/CBC/PKCS5Padding";
	private static String mode = "DES";
	private static String def_key = "2587@#$%\\lisa";

	/**
	 * java字节码转字符串
	 * 
	 * @param b
	 * @return
	 */
	public static String byte2hex(byte[] b) { // 一个字节的数，

		// 转成16进制字符串

		String hs = "";
		String tmp = "";
		for (int n = 0; n < b.length; n++) {
			// 整数转成十六进制表示
			tmp = (Integer.toHexString(b[n] & 0XFF));
			if (tmp.length() == 1) {
				hs = hs + "0" + tmp;
			} else {
				hs = hs + tmp;
			}
		}
		tmp = null;
		return hs.toLowerCase();

	}
	
	//加密
	public static String encrypt(String content) {
		return encrypt(content,def_key);
	}
	
	public static String encrypt(String content,String desKey) {
		try {
			byte[] plainText = content.getBytes("UTF-8");
			IvParameterSpec iv = new IvParameterSpec(iv1);
			DESKeySpec dks = new DESKeySpec(desKey.getBytes("UTF-8"));
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(mode);
			SecretKey key = keyFactory.generateSecret(dks);
			Cipher cipher = Cipher.getInstance(padding);
			cipher.init(Cipher.ENCRYPT_MODE, key, iv);
			byte data[] = plainText;
			byte encryptedData[] = cipher.doFinal(data);
			return byte2hex(encryptedData);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

    /**
     * 字符串转java字节码
     * @param b
     * @return
     */
    public static byte[] hex2byte(byte[] b) {
        if ((b.length % 2) != 0) {
            throw new IllegalArgumentException("长度不是偶数");
        }
        byte[] b2 = new byte[b.length / 2];
        for (int n = 0; n < b.length-1; n += 2) {
            String item = new String(b, n, 2);
            // 两位一组，表示一个字节,把这样表示的16进制字符串，还原成一个进制字节 
            b2[n / 2] = (byte) Integer.parseInt(item, 16);
        }
        b = null;
        return b2;
    }
	
    public static String decrypt(String content)throws Exception{
    	return decrypt(content,def_key);
    }
	public static String decrypt(String content,String desKey)throws Exception{
			byte[] data = content.getBytes("UTF-8");
			data = hex2byte(data);
			IvParameterSpec iv = new IvParameterSpec(iv1);
			DESKeySpec dks = new DESKeySpec(desKey.getBytes("UTF-8"));
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(mode);
			SecretKey key = keyFactory.generateSecret(dks);
			Cipher cipher = Cipher.getInstance(padding);
			cipher.init(Cipher.DECRYPT_MODE, key, iv);
			byte encryptedData[] = cipher.doFinal(data);
			return new String(encryptedData);
		
	}

	public static void main(String[] args) throws Exception {
		System.out.println(encrypt("1231321321"));
		String DESKey ="1cxbPRGG"; // 字节数必须是8的倍数
		String result = "234567";
		System.out.println("明文："+result);
		String encrypt = encrypt(result,DESKey);
		System.out.println("密文："+encrypt);
		String decrypt = decrypt(encrypt,DESKey);
		System.out.println("解密："+decrypt);
		System.out.println("加密:"+encrypt("123456","1cxbPRGG"));
		}

}
