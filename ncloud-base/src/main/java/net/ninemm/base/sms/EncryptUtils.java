package net.ninemm.base.sms;

import io.jboot.utils.StrUtil;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

public class EncryptUtils {
	private static final char[] HEX_DIGITS = "0123456789abcdef".toCharArray();
	private static final char[] CHAR_ARRAY = "_-0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

	public static String salt() {
		int random = (int) (10 + (Math.random() * 10));
		return UUID.randomUUID().toString().replace("-", "").substring(random);// 随机长度
	}

	public static String encryptPassword(String password, String salt) {
		return hash("SHA-256", password + salt);
	}

	public static boolean verlifyUser(String userPassword,String userSalt, String password) {
		if(userPassword == null)
			return false;

		if (userSalt == null) {
			return false;
		}
		return userPassword.equals(encryptPassword(password, userSalt));
	}

	public static String generateUcode(String id, String salt) {
		return hash("MD5", id + salt);
	}

	public static String signForRequest(Map<String, String> params,String secret) {
		String[] keys = params.keySet().toArray(new String[0]);
		Arrays.sort(keys);

		StringBuilder query = new StringBuilder();
		query.append(secret);
		for (String key : keys) {
			String value = params.get(key);
			if (StrUtil.areNotEmpty(key, value)) {
				query.append(key).append(value);
			}
		}
		query.append(secret);
		return hash("MD5",query.toString()).toUpperCase();
	}

	public static void main(String[] args) {
		System.out.println(encryptPassword("123456", "abc"));
	}
	
	
	public static String hash(String algorithm, String srcStr) {
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			byte[] bytes = md.digest(srcStr.getBytes("utf-8"));
			return toHex(bytes);
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public static String toHex(byte[] bytes) {
		StringBuilder ret = new StringBuilder(bytes.length * 2);
		for (int i=0; i<bytes.length; i++) {
			ret.append(HEX_DIGITS[(bytes[i] >> 4) & 0x0f]);
			ret.append(HEX_DIGITS[bytes[i] & 0x0f]);
		}
		return ret.toString();
	}

}
