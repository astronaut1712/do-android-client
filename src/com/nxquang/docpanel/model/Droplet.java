package com.nxquang.docpanel.model;

import java.util.Date;
import java.util.List;

public class Droplet {

	int id;
	String name;
	int memory;
	int vcpus;
	int disk;
	Region region;
	Image image;
	Object kernel;
	String size_slug;
	boolean locked;
	Date created_at;
	String status;
	Object networks;
	List<Object> backup_ids;
	List<Object> snapshot_ids;
	String[] features;  
}
