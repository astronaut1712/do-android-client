package com.nxquang.docpanel.manager;

import java.util.List;

public class KeyManager implements BaseManagerInterface {

	private static KeyManager instance = new KeyManager();
	
	private KeyManager(){}
	
	public static KeyManager getInstance(){
		return instance;
	}
	
	@Override
	public List<Object> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object create(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
