package com.example.wxb_07.fragmentTab;


import java.util.ArrayList;
import java.util.List;

import com.example.wxb_07.R;
import com.example.wxb_07.Foundpage.ListViewAdapter;
import com.example.wxb_07.Helper.BaseHelper;
import com.example.wxb_07.Helper.PercentLinearLayout;
import com.example.wxb_07.Helper.Squarepic;
import com.example.wxb_07.Helper.PercentLinearLayout.LayoutParams;
import com.example.wxb_07.attrs.Foundmsg;

import android.R.raw;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;


/**
 * @author wxb
 * 2015.11.24*/
public class Fragment1 extends Fragment {
	
	String imgs1,imgs2,imgs3,imgs4,imgs5,imgs6;
	List<Foundmsg> list ;
	ListViewAdapter listAdapter;
	ListView listView;
	SwipeRefreshLayout sp;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//View view1=inflater.inflate(R.layout.fragment_item1,container, false);
	View view2 = inflater.inflate(R.layout.fragment_item1, container,false);
	listView = (ListView) view2.findViewById(R.id.listview1);
	sp = (SwipeRefreshLayout) getActivity().findViewById(R.id.swiperefresh);
	list = new ArrayList<Foundmsg>();
	
	initData();
	
	listAdapter=new ListViewAdapter(getActivity(), list);
	listView.setAdapter(listAdapter);
	listView.setOnItemClickListener(new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
			Toast.makeText(getActivity(), "点击了第"+(arg2+1)+"项", Toast.LENGTH_LONG).show();
		}
	});
	//解决swiperefresh和listview的冲突
	listView.setOnScrollListener(new OnScrollListener() {
		
		@Override
		public void onScrollStateChanged(AbsListView view, int scrollState) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onScroll(AbsListView view, int firstVisibleItem,
				int visibleItemCount, int totalItemCount) {
			// TODO Auto-generated method stub
			boolean enable =false;
			if(listView != null && listView.getChildCount()>0){
				boolean firstItemVisible = listView.getFirstVisiblePosition()==0;
			
				boolean topOfFirstItemVisible = listView.getChildAt(0).getTop()==0;
				
				enable = firstItemVisible &&topOfFirstItemVisible;
				
				sp.setEnabled(enable);
			}
		}
	});
	return view2;
	}

	private void initData() {
		/*
		 * 添加模拟数据，正常情况下，这些数据是从服务端获取的
		 * 此次添加了七条数据，对应Gridview中图片数量
		 */
		//模拟用户发布的图片，路径用"#"隔开
		imgs1="http://t10.baidu.com/it/u=2565424359,3856609610&fm=58";
		imgs2="http://t10.baidu.com/it/u=2565424359,3856609610&fm=58#http://t10.baidu.com/it/u=374721516,1427740298&fm=58";
		imgs3="http://t10.baidu.com/it/u=2565424359,3856609610&fm=58#http://t10.baidu.com/it/u=374721516,1427740298&fm=58#http://t11.baidu.com/it/u=3158457091,3429860559&fm=58";
		imgs4="http://t10.baidu.com/it/u=2565424359,3856609610&fm=58#http://t10.baidu.com/it/u=374721516,1427740298&fm=58#http://t11.baidu.com/it/u=3158457091,3429860559&fm=58#http://t12.baidu.com/it/u=732128477,3149312025&fm=58";
		imgs5="http://t10.baidu.com/it/u=2565424359,3856609610&fm=58#http://t10.baidu.com/it/u=374721516,1427740298&fm=58#http://t11.baidu.com/it/u=3158457091,3429860559&fm=58#http://t12.baidu.com/it/u=732128477,3149312025&fm=58#http://t11.baidu.com/it/u=2722915642,3232472693&fm=58";
		imgs6="http://t10.baidu.com/it/u=2565424359,3856609610&fm=58#http://t10.baidu.com/it/u=374721516,1427740298&fm=58#http://t11.baidu.com/it/u=3158457091,3429860559&fm=58#http://t12.baidu.com/it/u=732128477,3149312025&fm=58#http://t11.baidu.com/it/u=2722915642,3232472693&fm=58#http://t12.baidu.com/it/u=1313963321,225077119&fm=58";
		
		
		Foundmsg bean=null;
		for(int i=0;i<7;i++){
			bean=new Foundmsg();
			switch (i) {
			case 0:
				bean.setUsername("白玉梁");
				bean.setHeadimage("http://avatar.csdn.net/3/B/9/1_baiyuliang2013.jpg");
				bean.setContent("欢迎关注本人博客：http://blog.csdn.net/baiyuliang2013");
				bean.setTime("1分钟前");
				bean.setPlace("xxx");
				//bean.set
				
				break;
			case 1:
				bean.setUsername("刘德华");
				bean.setHeadimage("http://t10.baidu.com/it/u=2565424359,3856609610&fm=58");
				bean.setContent("大家好，我是刘德华");
				bean.setTime("3分钟前");
				bean.setImages(imgs1);
				bean.setPlace("xxx");
				break;
			case 2:
				bean.setUsername("张学友");
				bean.setHeadimage("http://t10.baidu.com/it/u=374721516,1427740298&fm=58");
				bean.setContent("大家好，我是张学友");
				bean.setTime("5分钟前");
				bean.setImages(imgs2);
				bean.setPlace("xxx");
				break;
			case 3:
				bean.setUsername("郭富城");
				bean.setHeadimage("http://t11.baidu.com/it/u=3158457091,3429860559&fm=58");
				bean.setContent("大家好，我是郭富城");
				bean.setTime("1小时前");
				bean.setImages(imgs3);
				bean.setPlace("xxx");
				break;
			case 4:
				bean.setUsername("黎明");
				bean.setHeadimage("http://t12.baidu.com/it/u=732128477,3149312025&fm=58");
				bean.setContent("大家好，我是黎明");
				bean.setTime("2小时前");
				bean.setImages(imgs4);
				bean.setPlace("xxx");
				break;
			case 5:
				bean.setUsername("金城武");
				bean.setHeadimage("http://t11.baidu.com/it/u=2722915642,3232472693&fm=58");
				bean.setContent("大家好，我是金城武");
				bean.setTime("昨天");
				bean.setImages(imgs5);bean.setPlace("xxx");
				break;
			case 6:
				bean.setUsername("古天乐");
				bean.setHeadimage("http://t12.baidu.com/it/u=1313963321,225077119&fm=58");
				bean.setContent("大家好，我是古天乐");
				bean.setTime("前天");
				bean.setImages(imgs6);bean.setPlace("xxx");
				break;
			}
			list.add(bean);//添加进list
		}
		
		
	}
}
