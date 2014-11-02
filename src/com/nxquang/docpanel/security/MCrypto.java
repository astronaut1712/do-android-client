package com.nxquang.docpanel.security;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import com.nxquang.docpanel.Constants;
import com.nxquang.docpanel.database.ClientHelper;



public class MCrypto {
	
	private String secretKey;
	private static MCrypto instance = new MCrypto();
	private MCrypto(){
		secretKey = new String(Hex.encodeHex(DigestUtils.sha256(ClientHelper.DATABASE_NAME)));
		Constants.logger("scretKey: " + secretKey);
	}
	public static MCrypto getInstance(){
		return instance;
	}	
	
	public String getSecretKey() {
		return secretKey;
	}
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
}
