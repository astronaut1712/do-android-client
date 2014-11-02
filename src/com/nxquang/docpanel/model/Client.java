package com.nxquang.docpanel.model;

import android.content.Context;

public class Client {

	private int id = 1;
	private String token;
	
	private static Client instance = new Client();
	private Client(){}
	public static Client getInstance(){
		return instance;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setToken(String _token){
		token = _token;
	}
	
	public String getToken(Context context){
		if(token == null || token.equals("")){
			ClientSource.getInstance(context).open();
			token = ClientSource.getInstance(context).getToken();
			ClientSource.getInstance(context).close();
		}
		return token;
	}
}
