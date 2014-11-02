package com.nxquang.docpanel.manager;

import java.util.List;

public class DropletManager implements BaseManagerInterface{
	
	private static DropletManager instance = new DropletManager();
	
	private DropletManager(){}
	
	public static DropletManager getInstance(){
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
