package com.example.wxb_07.Helper;

import com.example.wxb_07.R;
import com.example.wxb_07.R.layout;

import android.app.Dialog;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ProDialog {
	public ProDialog() {
		// TODO Auto-generated constructor stub
	}
	public static Dialog createProgressDialog(Context context){
		
		LayoutInflater layoutInflater = LayoutInflater.from(context);
		View view = layoutInflater.inflate(R.layout.loadingdialog, null);
		
		LinearLayout layout = (LinearLayout) view.findViewById(R.id.dialog_loading);
		ImageView img = (ImageView) view.findViewById(R.id.image_loading);
		TextView txt = (TextView) view.findViewById(R.id.text_loading);
		
		Animation animation = AnimationUtils.loadAnimation(context, R.drawable.animation_loading);		
		img.startAnimation(animation);
		
		Dialog loaddialog = new Dialog(context,R.style.dialog_loading);
		loaddialog.setCancelable(true);;
		loaddialog.setContentView(layout, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT));
	
		return loaddialog;
		
	}
}
