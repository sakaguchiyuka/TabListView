package com.example.tablistview;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAdapter extends ArrayAdapter<ListAdapter.ItemData> {
	LayoutInflater mInflater;

	public static class ItemData {
		int iconResId;
		String text;
		String date;
	}

	public ListAdapter(Context context) {
		super(context, 0, new ArrayList<ItemData>());
		mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		View view = convertView;

		if (convertView == null) {
			view = mInflater.inflate(R.layout.list_item, null);
		}
		ListAdapter.ItemData data = getItem(position);

		// アイコン設定
		((ImageView) view.findViewById(R.id.item_icon))
				.setImageResource(data.iconResId);

		// 詳細設定
		String infoStr = data.text + "\n" + data.date;
		((TextView) view.findViewById(R.id.item_info)).setText(infoStr);

		return view;
	}
}
