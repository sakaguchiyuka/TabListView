package com.example.tablistview;

import java.util.ArrayList;
import java.util.List;

public class MockUtil {
	public static List<ListAdapter.ItemData> getItemList(int position) {

		List<ListAdapter.ItemData> ret = new ArrayList<ListAdapter.ItemData>();
		int number = (position + 1);
		int size = 5 * number;
		for (int i = 0; i < size; ++i) {
			ListAdapter.ItemData data = new ListAdapter.ItemData();
			data.iconResId = R.drawable.ic_launcher;
			data.text = "tab "+ number + " item " + i;
			data.date = "0000:00:00";
			ret.add(data);
		}
		return ret;
	}
}
