package com.ss.www.control;

import org.apache.shiro.crypto.hash.Md5Hash;

public class main {

	public main(String[] args) {
		// TODO Auto-generated method stub
Md5Hash hash=new Md5Hash("admin","admin",3);
System.out.println(hash);
	}

}
