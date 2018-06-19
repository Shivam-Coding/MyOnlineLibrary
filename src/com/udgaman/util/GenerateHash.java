package com.udgaman.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

public class GenerateHash {
	
	public static String getHash(byte[] data){
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			 md.update(data);
			 byte[] b = md.digest();
			char[] ret = Hex.encodeHex(b);
			String t =new String(ret);
			 return t;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		
		}
		return null;
		}}


