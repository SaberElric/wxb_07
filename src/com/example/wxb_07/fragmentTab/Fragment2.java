
package com.example.wxb_07.fragmentTab;

import com.example.wxb_07.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * @author wxb
 * 2015.11.24*/
public class Fragment2 extends Fragment {
	SwipeRefreshLayout sp;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_item2, null);
		return view;
	}
}
