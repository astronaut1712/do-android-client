package com.nxquang.docpanel.model;

public class MainMenuItem {
	public String tagTitle;
	public int tagId;
	public int iconRes;
	public MainMenuItem(String title,int Id, int iconRes) {
		this.tagId = Id;
		this.tagTitle = title; 
		this.iconRes = iconRes;
	}
}
