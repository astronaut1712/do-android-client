package com.nxquang.docpanel.model;

import java.util.Date;

public class DropletAction {

	int id;
	String status;
	String type;
	Date started_at;
	Date completed_at = null;
	int resource_id;
	String resource_type;
	String region;
}
