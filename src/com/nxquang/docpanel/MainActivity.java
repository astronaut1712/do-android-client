package com.nxquang.docpanel;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.nxquang.docpanel.R;
import com.nxquang.docpanel.fragments.MainMenu;
import com.nxquang.docpanel.model.Client;

import android.content.Context;
import android.os.Bundle;

public class MainActivity extends SlidingFragmentActivity {

	Context context;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = this;
		setBehindContentView(R.layout.menu_frame);
		getSupportFragmentManager().beginTransaction().replace(R.id.menu_frame, MainMenu.getInstance()).commit();
		getSlidingMenu().setBehindOffset(50);
		getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		getSlidingMenu().setFadeDegree(0.35f);
		getSlidingMenu().setShadowWidth(15);
		getSlidingMenu().setShadowDrawable(R.drawable.shadow);
		setSlidingActionBarEnabled(false);
		
		JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, Constants.API_BASE_URL + Constants.API_DOMAINS, null, new Response.Listener<JSONObject>() {
 
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
        		headers.put("Authorization", "Bearer " + Client.getInstance().getToken(context));
        		return headers;
        	}
        };
        ((MyApplication)getApplication()).getQueue().add(jsObjRequest);
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
		getSupportMenuInflater().inflate(R.menu.menu_main, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
}
