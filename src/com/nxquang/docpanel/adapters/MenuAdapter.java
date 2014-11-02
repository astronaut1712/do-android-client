package com.nxquang.docpanel.adapters;

import com.nxquang.docpanel.R;
import com.nxquang.docpanel.model.MainMenuItem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuAdapter extends ArrayAdapter<MainMenuItem>{

	public MenuAdapter(Context context) {
		super(context, 0);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = LayoutInflater.from(getContext()).inflate(R.layout.main_menu_item, null);
		}
		ImageView icon = (ImageView) convertView.findViewById(R.id.row_icon);
		icon.setImageResource(getItem(position).iconRes);
		TextView title = (TextView) convertView.findViewById(R.id.row_title);
		title.setText(getItem(position).tagTitle);

		return convertView;
	}

}
