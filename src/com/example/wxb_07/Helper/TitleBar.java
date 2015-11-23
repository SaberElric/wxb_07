package com.example.wxb_07.Helper;

import com.example.wxb_07.R;


import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TitleBar {
	private static Activity activity;
	static Button btg_left;
	static Button btg_right;
	static TextView textview ;
	/**随着viewpager的滑动，title也要变化*/
	public static void initTitleBar(Activity act,int index){
		activity = act;
		View view = activity.getWindow().getDecorView();
		btg_left = (Button) view.findViewById(R.id.btg_left);
		btg_right = (Button) view.findViewById(R.id.btg_right);
		textview = (TextView) view.findViewById(R.id.tittle_text);
		btg_left.setVisibility(View.INVISIBLE);
		btg_right.setVisibility(View.INVISIBLE);
		switch (index) {
		case 0:
			textview.setText("fragment1");
			break;
		case 1:
			textview.setText("fragment2");	
			break;
		case 2:
			textview.setText("fragment3");
			break;
		case 3:
			textview.setText("fragment4");
			break;


		default:
			break;
		}
	}
	
}
