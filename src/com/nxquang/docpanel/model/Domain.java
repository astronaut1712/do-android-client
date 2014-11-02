package com.nxquang.docpanel.model;

import com.nxquang.docpanel.Constants;

public class Domain {
	private String name;
	private int ttl;
	private String zonefile;
	
	public Domain(){
		this(null, Constants.DEFAULT_TTL, null);
	}
	public Domain(String name, int ttl, String zonefile) {
		this.name = name;
		this.ttl = ttl;
		this.zonefile = zonefile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTtl() {
		return ttl;
	}
	public void setTtl(int ttl) {
		this.ttl = ttl;
	}
	public String getZonefile() {
		return zonefile;
	}
	public void setZonefile(String zonefile) {
		this.zonefile = zonefile;
	}
}
