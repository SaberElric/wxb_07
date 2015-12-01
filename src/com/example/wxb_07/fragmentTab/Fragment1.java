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
			Toast.makeText(getActivity(), "����˵�"+(arg2+1)+"��", Toast.LENGTH_LONG).show();
		}
	});
	//���swiperefresh��listview�ĳ�ͻ
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
		 * ���ģ�����ݣ���������£���Щ�����Ǵӷ���˻�ȡ��
		 * �˴�������������ݣ���ӦGridview��ͼƬ����
		 */
		//ģ���û�������ͼƬ��·����"#"����
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
				bean.setUsername("������");
				bean.setHeadimage("http://avatar.csdn.net/3/B/9/1_baiyuliang2013.jpg");
				bean.setContent("��ӭ��ע���˲��ͣ�http://blog.csdn.net/baiyuliang2013");
				bean.setTime("1����ǰ");
				bean.setPlace("xxx");
				//bean.set
				
				break;
			case 1:
				bean.setUsername("���»�");
				bean.setHeadimage("http://t10.baidu.com/it/u=2565424359,3856609610&fm=58");
				bean.setContent("��Һã��������»�");
				bean.setTime("3����ǰ");
				bean.setImages(imgs1);
				bean.setPlace("xxx");
				break;
			case 2:
				bean.setUsername("��ѧ��");
				bean.setHeadimage("http://t10.baidu.com/it/u=374721516,1427740298&fm=58");
				bean.setContent("��Һã�������ѧ��");
				bean.setTime("5����ǰ");
				bean.setImages(imgs2);
				bean.setPlace("xxx");
				break;
			case 3:
				bean.setUsername("������");
				bean.setHeadimage("http://t11.baidu.com/it/u=3158457091,3429860559&fm=58");
				bean.setContent("��Һã����ǹ�����");
				bean.setTime("1Сʱǰ");
				bean.setImages(imgs3);
				bean.setPlace("xxx");
				break;
			case 4:
				bean.setUsername("����");
				bean.setHeadimage("http://t12.baidu.com/it/u=732128477,3149312025&fm=58");
				bean.setContent("��Һã���������");
				bean.setTime("2Сʱǰ");
				bean.setImages(imgs4);
				bean.setPlace("xxx");
				break;
			case 5:
				bean.setUsername("�����");
				bean.setHeadimage("http://t11.baidu.com/it/u=2722915642,3232472693&fm=58");
				bean.setContent("��Һã����ǽ����");
				bean.setTime("����");
				bean.setImages(imgs5);bean.setPlace("xxx");
				break;
			case 6:
				bean.setUsername("������");
				bean.setHeadimage("http://t12.baidu.com/it/u=1313963321,225077119&fm=58");
				bean.setContent("��Һã����ǹ�����");
				bean.setTime("ǰ��");
				bean.setImages(imgs6);bean.setPlace("xxx");
				break;
			}
			list.add(bean);//��ӽ�list
		}
		
		
	}
}
