package com.nxquang.docpanel.fragments;

import android.support.v4.app.Fragment;

import com.nxquang.docpanel.Constants;

public class FragmentFactory {

	private static FragmentFactory instance = new FragmentFactory();
	private FragmentFactory() {}
	public static FragmentFactory getInstance(){
		return instance;
	}
	
	public Fragment getFragment(int fragmentType){
		switch (fragmentType) {
		case Constants.MENU_DROPLETS:
			return new DropletFragment();
		case Constants.MENU_IMAGES:
			return new ImageFragment();
		case Constants.MENU_DNS:
			return new DNSFragment();
		case Constants.MENU_KEYS:
			return new KeyFragment();
		case Constants.MENU_ACTIONS:
			return new HistoryFragment();
		case Constants.MENU_SETTINGS:
			return new SettingFragment();
		}
		return null;
	}
	
}
