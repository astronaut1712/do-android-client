package com.nxquang.docpanel.fragments;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockListFragment;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.nxquang.docpanel.Constants;
import com.nxquang.docpanel.MyApplication;
import com.nxquang.docpanel.R;
import com.nxquang.docpanel.adapters.MenuAdapter;
import com.nxquang.docpanel.model.Client;
import com.nxquang.docpanel.model.MainMenuItem;


public class MainMenu extends SherlockListFragment {
	
	MenuAdapter adapter;
	
	private static MainMenu instance = new MainMenu();
	private MainMenu(){}
	public static MainMenu getInstance(){
		return instance;
	}
	
	@SuppressLint("InflateParams")
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.main_menu, null);
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		adapter = new MenuAdapter(getActivity());
		
		adapter.add(new MainMenuItem("Droplets", Constants.MENU_DROPLETS, android.R.drawable.ic_menu_compass));
		adapter.add(new MainMenuItem("Images", Constants.MENU_IMAGES, android.R.drawable.ic_menu_camera));
		adapter.add(new MainMenuItem("DNS", Constants.MENU_DNS, android.R.drawable.ic_menu_directions));
		adapter.add(new MainMenuItem("History", Constants.MENU_ACTIONS, android.R.drawable.ic_menu_recent_history));
		adapter.add(new MainMenuItem("SSH Keys", Constants.MENU_KEYS, android.R.drawable.ic_menu_agenda));
		adapter.add(new MainMenuItem("Settings", Constants.MENU_SETTINGS, android.R.drawable.ic_menu_preferences));
		setListAdapter(adapter);
		
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, Constants.API_BASE_URL + Constants.API_DROPLETS, null, new Response.Listener<JSONObject>() {
			 
            @Override
            public void onResponse(JSONObject response) {
                Constants.logger("Response => "+response.toString());
                
            }            
        }, new Response.ErrorListener() {
 
            @Override
            public void onErrorResponse(VolleyError error) {
                
            }
        }){
        	@Override
        	public Map<String, String> getHeaders() throws AuthFailureError {
        		Map<String, String> headers = new HashMap<String, String>();
        		headers.put("Authorization", "Bearer " + Client.getInstance().getToken(getActivity().getApplicationContext()));
        		return headers;
        	}
        };
        ((MyApplication)getActivity().getApplication()).getQueue().add(jsObjRequest);
		MainMenuItem item = adapter.getItem(position);
		getFragmentManager().beginTransaction().replace(R.id.content_frame, FragmentFactory.getInstance().getFragment(item.tagId)).addToBackStack(null).commit();
	}
	
}
