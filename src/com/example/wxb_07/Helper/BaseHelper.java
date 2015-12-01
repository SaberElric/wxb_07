package com.example.wxb_07.Helper;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.Display;
import android.view.WindowManager;

public class BaseHelper {

	/**ÅÐ¶ÏÍøÂçÁ¬½Ó*/
	public static boolean isNetworkAvailable(Context context){
		
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		int i;
		if(cm == null){
		
	}else{
		NetworkInfo[] info = cm.getAllNetworkInfo();
		if(info!=null){
			for(i=0;i<info.length;i++){
			if(info[i].getState() == NetworkInfo.State.CONNECTED){
				return true;
			}
			}
		}
		
	}
		return false;
	}
	/***/
	public static int getScreenWidth(Activity act){
		int width = 0;
		WindowManager windowManager = act.getWindowManager();
		Display diaDisplay = windowManager.getDefaultDisplay();
		width = diaDisplay.getWidth();
		return width;
		
	}
	public static int Dp2Px(Context context,float dp){
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int)(dp*scale + 0.5f);
	}
	
}
