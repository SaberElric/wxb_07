/**有左右滑动的 fragmentTabhost 
 * @author wxb*/
package com.example.wxb_07.fragmentTab;

import java.util.ArrayList;
import java.util.List;

import com.example.wxb_07.R;
import com.example.wxb_07.Helper.TitleBar;

import android.R.string;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toast;

public class AppMain extends FragmentActivity implements OnClickListener,OnRefreshListener {



	private TextView textViewArray[] ;
	private List<Fragment> list = new ArrayList<Fragment>();
	private ViewPager viewpager;
	private static int index= 0 ;
	private Button[] btnArray;
	private int backgroundID_u[];
	private int backgtoundID_s[];
	private static short[] count;
	private static boolean isFirstsp;
	SwipeRefreshLayout sp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main_tab);

		initView();
		initPage();
		setSelectStyle();
		TitleBar.initTitleBar(this, index);
		sp.setOnRefreshListener(this);
		SetFirstSp();
	//	refresh(this, sp, index);
	}
	public void SetFirstSp(){
			switch (index) {
			case 0:
				count[0]++;
				if(count[0] < 2){
					sp.post(new Thread(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							sp.setRefreshing(true);
						}
					}));
				onRefresh();
				}
				else {
					
				}
				
				break;
			case 1:
				count[1]++;
				if(count[1] < 2){
					sp.post(new Thread(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							sp.setRefreshing(true);
						}
					}));
				onRefresh();
				}
				
				break;
			case 2:
				count[2]++;
				if(count[2] < 2){
					sp.post(new Thread(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							sp.setRefreshing(true);
						}
					}));
				onRefresh();
				}
				
				break;
			case 3:
				count[3]++;
				if(count[3] < 2){
					sp.post(new Thread(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							sp.setRefreshing(true);
						}
					}));
				onRefresh();
				}
				
				break;

			default:
				break;
			}
			
	

		
		
		}
		
			
	
/**设置选中样式*/
	private void setSelectStyle() {
		for (int i = 0; i < btnArray.length; i++) {
			if (i == index) {
				//tabWidget.setCurrentTab(i);
				btnArray[i].setBackgroundResource(backgtoundID_s[i]);
				textViewArray[i].setTextColor(Color.rgb(126, 144, 255));
				
			} else {
				btnArray[i].setBackgroundResource(backgroundID_u[i]);
				textViewArray[i].setTextColor(Color.rgb(0, 0, 0));
			}
			
		}
	}


	/**
	 * 控件初始化
	 */
	@SuppressWarnings("deprecation")
	private void initView() {
		viewpager = (ViewPager) findViewById(R.id.pager);
		sp = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);
		
		sp.setColorSchemeColors(Color.RED,Color.BLUE,Color.GREEN,Color.CYAN);
		
		final LinearLayout layout = (LinearLayout) findViewById(R.id.main_app);
		/**设置点击空白区域键盘隐藏*/
		viewpager.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				InputMethodManager IM = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
				if(event.getAction() == MotionEvent.ACTION_MOVE){
					sp.setEnabled(false);
				}
				else {
					sp.setEnabled(true);
				}
				return IM.hideSoftInputFromWindow(layout.getWindowToken(), 0);
			}
		});
		/**设置viewpager切换*/
		viewpager.setOnPageChangeListener(new SimpleOnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				
				index = arg0;			
				viewpager.setCurrentItem(index);
				setSelectStyle();
				TitleBar.initTitleBar(AppMain.this, index);
				SetFirstSp();
			//	refresh(AppMain.this, sp, index);
			
			}
			
			@Override
			public void   onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});

		btnArray=new Button[]{
				(Button)findViewById(R.id.btgpersonal),
				(Button)findViewById(R.id.btgwork),
				(Button)findViewById(R.id.btgmypatient),				
				(Button)findViewById(R.id.btgSetList)};
		for (Button btn : btnArray) {
			btn.setOnClickListener(this);
		}
		textViewArray=new TextView[]{
				(TextView)findViewById(R.id.person_text),
				(TextView)findViewById(R.id.work_text),
				(TextView)findViewById(R.id.patient_text),
				(TextView)findViewById(R.id.setting_text),
		};
		for (TextView txt : textViewArray) {
			txt.setOnClickListener(this);
		}
		backgroundID_u = new int[]{R.drawable.infusion,R.drawable.mywork,R.drawable.mypatient,R.drawable.personal};
		backgtoundID_s = new int[]{R.drawable.infusion_s,R.drawable.mywork_s,R.drawable.mypatient_s,R.drawable.personal_s};
		
		

	}
	@Override
	public void onClick(View v) {
		try {
			switch (v.getId()) {
				case R.id.btgpersonal :
					index = 0;
					break;
				case R.id.btgwork:
					index = 1;
					break;
				case R.id.btgmypatient:
					index = 2;
					break;
				case R.id.btgSetList:
					index = 3;
					break;
				case R.id.person_text:
					index = 0;
					break;
				case R.id.work_text:
					index = 1;
					break;
				case R.id.patient_text:
					index = 2;
					break;
				case R.id.setting_text:
					index = 3;
					break;
				
					
			}
			viewpager.setCurrentItem(index);
			
			SetFirstSp();
			//refresh(this, sp, index);
		}catch(Exception e){
			
		}
	}

	/**
	 * init Fragment
	 */
	private void initPage() {
		Fragment1 fragment1 = new Fragment1();
		Fragment2 fragment2 = new Fragment2();
		Fragment3 fragment3 = new Fragment3();
		Fragment4 fragment4 = new Fragment4();
		list.add(fragment1);
		list.add(fragment2);
		list.add(fragment3);
		list.add(fragment4);
		viewpager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(), list));
		count = new short[]{0,0,0,0,};

	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		sp.setRefreshing(false);
	}
		@Override
		public void onRefresh() {
			// TODO Auto-generated method stub
			switch (index) {
			case 0:
				sp.postDelayed(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
					
						Toast.makeText(AppMain.this, String.valueOf(index),Toast.LENGTH_SHORT ).show();
	
				sp.setRefreshing(false);
					}
				},2000);
				
				break;
			case 1:
				sp.postDelayed(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						Toast.makeText(AppMain.this, String.valueOf(index),Toast.LENGTH_SHORT ).show();
						
				sp.setRefreshing(false);
					}
				},2000);
				break;
			case 2:
				Toast.makeText(AppMain.this, String.valueOf(index),Toast.LENGTH_SHORT ).show();
				sp.setRefreshing(false);
				break;
			case 3:
				Toast.makeText(AppMain.this, String.valueOf(index),Toast.LENGTH_SHORT ).show();
				sp.setRefreshing(false);
				break;

			default:
				break;
			}
		}

}


	



