
package com.example.wxb_07.fragmentTab;

import com.example.wxb_07.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * @author lili.guo
 * 
 *         2014-10-22
 */
public class Fragment2 extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_item2, null);
		EditText editText = (EditText) view.findViewById(R.id.editView2);
		
		return view;
	}
}
