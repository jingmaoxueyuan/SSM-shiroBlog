package com.ss.www.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

public class Md5Tools {
	public static String Md5(Object passWord, Object userName, int hashIterations) {
		Md5Hash md5 = new Md5Hash(passWord, userName, hashIterations);
		return md5.toString();

	}
}
