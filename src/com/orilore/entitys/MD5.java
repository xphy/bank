package com.orilore.entitys;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class MD5 {
	private MessageDigest md5 = null;
	private StringBuffer digestBuffer = null;
	public MD5() {
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		digestBuffer = new StringBuffer();
	}
	public String md5crypt(String s) {
		digestBuffer.setLength(0);
		byte abyte0[] = md5.digest(s.getBytes());
		for (int i = 0; i < abyte0.length; i++){
			digestBuffer.append(toHex(abyte0[i]));
		}
		return digestBuffer.toString();
	}
	public String toHex(byte one) {
		String HEX = "0123456789ABCDEF";
		char[] result = new char[2];
		result[0] = HEX.charAt((one & 0xf0) >> 4);
		result[1] = HEX.charAt(one & 0x0f);
		String mm = new String(result);
		return mm;
	}
	
}
