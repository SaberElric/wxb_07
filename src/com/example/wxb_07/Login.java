package com.example.wxb_07;



import com.example.wxb_07.Helper.HDialog;
import com.example.wxb_07.Helper.Task;
import com.example.wxb_07.fragmentTab.AppMain;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Login extends Activity {

	private static EditText ed1;
	private static EditText ed2;
	private static Button btg01;
	private static Button btg02;
	
	
	
	public void btgclickable(EditText e1,EditText e2){
		if(e2.getText().toString().trim().length() >=6 && e1.getText().toString().trim().length() >=6 ){//设置为格式检验
			btg01.setClickable(true);
		}
		else{
			btg01.setClickable(false);
		}
	}
	TextWatcher tw = new TextWatcher() {
		
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			// TODO Auto-generated method stub
			btgclickable(ed1,ed2);
		}
		
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			btgclickable(ed1,ed2);
		}
		
		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			btgclickable(ed1,ed2);
		}
	};//ed1 done

	OnClickListener listener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			//可以设置格式检测
			//登录
			switch (v.getId()) {
			case R.id.btg_login:
				check();
				Intent intent1 = new Intent(Login.this,AppMain.class);
				startActivity(intent1);
//				Intent intent1 = new Intent(MainActivity.this,vpager.class);
//				startActivity(intent1);
				break;
			case R.id.button_register:
				Intent intent2 = new Intent(Login.this,HDialog.class).putExtra(Task.reg, "register");
				startActivity(intent2);
		
				break;
			default:
				break;
			}
			
		}
	};
	public boolean check() {
		//添加格式检验
		return true;
	}
	public void initUI() {
		// TODO Auto-generated method stub
		ed1 = (EditText)findViewById(R.id.userID);
		ed2 = (EditText)findViewById(R.id.userPasswd);
		btg01 = (Button)findViewById(R.id.btg_login);
		btg02 = (Button)findViewById(R.id.button_register);
		ed1.addTextChangedListener(tw);
		ed2.addTextChangedListener(tw);
		btg01.setOnClickListener(listener);
		btg01.setClickable(false);
		btg02.setOnClickListener(listener);
		
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login);
		initUI();
	
	}
	
	
	
	
}
