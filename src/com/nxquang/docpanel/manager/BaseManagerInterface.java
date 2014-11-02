package com.nxquang.docpanel.manager;

import java.util.List;

public interface BaseManagerInterface {
	public List<Object> getAll();
	public Object getInfo();
	public Object create(Object obj);
	public boolean delete(Object obj);	
}
