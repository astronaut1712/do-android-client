package com.nxquang.docpanel;

import android.util.Log;

public class Constants {
	public final static int DEFAULT_TTL = 1800;
	final static String TAG = "MyDebug";
	static boolean isDebug = true;

	public static void logger(String msg) {
		if (isDebug)
			Log.d(TAG, msg);
	}

	public final static String API_BASE_URL = "https://api.digitalocean.com";
	public final static String API_DOMAINS = "/v2/domains";
	public final static String API_ACTIONS = "/v2/actions";
	public final static String API_DROPLETS = "/v2/droplets";
	public final static String API_IMAGES = "/v2/images";
	public final static String API_KEYS = "/v2/account/keys";
	public final static String API_REGIONS = "/v2/regions";
	public final static String API_SIZES = "/v2/sizes";

	// menu item constant
	public final static int MENU_ACTIONS = 0;
	public final static int MENU_DROPLETS = 1;
	public final static int MENU_IMAGES = 2;
	public final static int MENU_DNS = 3;
	public final static int MENU_KEYS = 4;
	public final static int MENU_SETTINGS = 5;

}
