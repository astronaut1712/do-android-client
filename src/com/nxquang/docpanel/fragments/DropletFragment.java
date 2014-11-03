package com.nxquang.docpanel.fragments;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import android.os.Bundle;
import android.view.View;

import com.actionbarsherlock.app.SherlockFragment;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.nxquang.docpanel.Constants;
import com.nxquang.docpanel.MyApplication;
import com.nxquang.docpanel.model.Client;

public class DropletFragment extends SherlockFragment implements AbsFragment {

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		
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
	}
}
