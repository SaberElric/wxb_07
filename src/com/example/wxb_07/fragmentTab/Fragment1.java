package com.example.wxb_07.fragmentTab;

import com.example.wxb_07.R;
import com.example.wxb_07.Helper.BaseHelper;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


/**
 * @author wxb
 * 2015.11.24*/
public class Fragment1 extends Fragment {
	
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//View view1=inflater.inflate(R.layout.fragment_item1,container, false);
	View view2 = inflater.inflate(R.layout.activity_item, container,false);
		/*if(BaseHelper.isNetworkAvailable(getActivity()) == true){
			return view1;
		}
		else{
			return view2;
		}*/
	
	
		//return view1;
	return view2;
	}
}
