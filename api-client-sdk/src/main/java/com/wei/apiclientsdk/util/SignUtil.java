package com.wei.apiclientsdk.util;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

/**
 * 签名工具
 */
public class SignUtil {

	private static final String SALT = "Weiwei666";

	/**
	 * 生成签名
	 * @param body
	 * @param secretKey
	 * @return
	 */
	public static String genSign(String body, String secretKey){
		Digester digester = new Digester(DigestAlgorithm.SHA256);
		String context = body + SALT + secretKey;
		return digester.digestHex(context);
	}
}
