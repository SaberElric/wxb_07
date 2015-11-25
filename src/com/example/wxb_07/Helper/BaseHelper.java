package com.example.wxb_07.Helper;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

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
	
}
