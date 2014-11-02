package com.nxquang.docpanel.manager;

import java.util.List;

public class ActionManager implements BaseManagerInterface{
	
	private static ActionManager instance = new ActionManager();
	
	private ActionManager(){}
	
	public static ActionManager getInstance(){
		return instance;
	}
	
	@Override
	public List<Object> getAll() {
		return null;
	}

	@Override
	public Object getInfo() {
		return null;
	}

	@Override
	public Object create(Object obj) {
		return null;
	}

	@Override
	public boolean delete(Object obj) {
		return false;
	}
	
}
