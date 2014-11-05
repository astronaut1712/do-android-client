package com.nxquang.docpanel.adapters;

import java.util.ArrayList;

import com.nxquang.docpanel.R;
import com.nxquang.docpanel.model.Droplet;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class DropletAdapter extends BaseAdapter {
	
	Activity activity;
	LayoutInflater inflater;
	ArrayList<Droplet> data = new ArrayList<Droplet>(); 
	
	public DropletAdapter(Activity activity){
		this.activity = activity;
		inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		return data.get(position).getId() | 0;
	}
	
	public void add(Droplet obj){
		data.add(obj);
		notifyDataSetChanged();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v;
		
		Droplet obj = data.get(position);
		
		v = inflater.inflate(R.layout.list_item, null);
		TextView tv = (TextView)v.findViewById(R.id.list_item_title);
		tv.setText(obj.getName());
		
		return v;
	}

}
