package com.example.wxb_07.Helper;

import com.example.wxb_07.R;






import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class HDialog extends Activity {


	private Button b1;
	private TextView t1;
	private TextView t2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.phone_dialog);
		t1 = (TextView)findViewById(R.id.dialog_title);
		t2 = (TextView)findViewById(R.id.dialog_content);
		t1.setText(getIntent().getStringExtra("tittle"));
		if(getIntent().getStringExtra("content").length()>10){
			String contentString = getIntent().getStringExtra("content").substring(1, 15)+ "...";
					//	+ getIntent().getStringExtra("content").substring(11, getIntent().getStringExtra("content").length());
			t2.setText(contentString);
		}
		else{
			t2.setText(getIntent().getStringExtra("content"));
		}
		
		b1 = (Button)findViewById(R.id.PANButton);
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

}
