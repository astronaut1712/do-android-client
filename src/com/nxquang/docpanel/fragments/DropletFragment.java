package com.nxquang.docpanel.fragments;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockListFragment;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.nxquang.docpanel.Constants;
import com.nxquang.docpanel.MyApplication;
import com.nxquang.docpanel.R;
import com.nxquang.docpanel.adapters.DropletAdapter;
import com.nxquang.docpanel.model.Client;
import com.nxquang.docpanel.model.Droplet;

public class DropletFragment extends SherlockListFragment implements AbsFragment {

	DropletAdapter adapter;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.list, container, false);
		adapter = new DropletAdapter(getActivity());
		setListAdapter(adapter);
		JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, Constants.API_BASE_URL + Constants.API_DROPLETS, null, new Response.Listener<JSONObject>() {
			 
            @Override
            public void onResponse(JSONObject response) {
                Constants.logger("Response => "+response.toString());
                try {
					JSONArray arr = response.getJSONArray("droplets");
					for (int i = 0; i < arr.length(); i++) {
						Droplet obj = new Gson().fromJson(arr.getJSONObject(i).toString(), Droplet.class);
						adapter.add(obj);
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
                
                
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
		return v;
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);		
	}
}
