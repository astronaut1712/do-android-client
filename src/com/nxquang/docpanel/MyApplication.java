package com.nxquang.docpanel;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import android.app.Application;

public class MyApplication extends Application {

	RequestQueue queue;
	@Override
	public void onCreate() {	
		super.onCreate();
		if(queue == null)
			queue = Volley.newRequestQueue(getApplicationContext());		
	}
	public RequestQueue getQueue(){
		return queue;
	}
	
}
