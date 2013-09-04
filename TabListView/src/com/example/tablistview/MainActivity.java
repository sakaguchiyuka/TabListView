package com.example.tablistview;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity implements TabListener {
	ListView mListView;
	
	List<ListAdapter.ItemData> mTab1List;
	List<ListAdapter.ItemData> mTab2List;
	List<ListAdapter.ItemData> mTab3List;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setTheme(R.style.Theme_AppCompat_Light);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.addTab(createTabObj(actionBar, R.string.tab_1_name));
		actionBar.addTab(createTabObj(actionBar, R.string.tab_2_name));
		actionBar.addTab(createTabObj(actionBar, R.string.tab_3_name));
		
		mListView = (ListView) findViewById(R.id.list_view);
		loadTabItems();
		setListView(actionBar.getSelectedNavigationIndex());
	}

	protected Tab createTabObj(ActionBar actionBar, int resId) {
		return actionBar
				.newTab()
				.setText(getString(resId))
				.setTabListener(this);
	}

	protected void loadTabItems() {
		mTab1List = MockUtil.getItemList(0);
		mTab2List = MockUtil.getItemList(1);
		mTab3List = MockUtil.getItemList(2);
	}

    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {
    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
    	setListView(tab.getPosition());
    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
    }

    protected void setListView(int position) {
    	if (null == mListView) {
    		return;
    	}
    	ListAdapter adapter = (ListAdapter) mListView.getAdapter();
    	if (null == adapter) {
    		adapter = new ListAdapter(this);
    		mListView.setAdapter(adapter);
    	} else {
    		adapter.clear();
    	}
    	List<ListAdapter.ItemData> list = getList(position);
    	if (null != list) {
        	adapter.addAll(list);
    	}
    }

    protected List<ListAdapter.ItemData> getList(int position) {
    	switch (position) {
    	case 0:
    		return mTab1List;
    	case 1:
    		return mTab2List;
    	case 2:
    		return mTab3List;
    	}
    	return null;
    }
}
