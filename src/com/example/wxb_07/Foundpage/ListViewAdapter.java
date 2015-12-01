package com.example.wxb_07.Foundpage;

import java.util.ArrayList;
import java.util.List;

import net.tsz.afinal.FinalBitmap;
import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.example.wxb_07.R;
import com.example.wxb_07.Helper.BaseHelper;
import com.example.wxb_07.Helper.RoundImage;
import com.example.wxb_07.attrs.Foundmsg;

public class ListViewAdapter extends BaseAdapter {
	private LayoutInflater mInflater;
	private Activity act;
	private List<Foundmsg> list;
	private FinalBitmap finalBitmap;
	private GridViewAdapter gridViewAdapter;
	private int width;
	public ListViewAdapter(Activity ctg,List<Foundmsg>list){
		
		
		this.mInflater = LayoutInflater.from(ctg);
		this.act = ctg;
		this.width = (BaseHelper.getScreenWidth(ctg)-BaseHelper.Dp2Px(ctg, 99))/3;
		this.list = list;
		this.finalBitmap = FinalBitmap.create(ctg);
		this.finalBitmap.configLoadfailImage(R.drawable.kuroku);
	}

	public List<Foundmsg> getList() {
		return list;
	}

	public void setList(List<Foundmsg> list) {
		this.list = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list == null? 0 : list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list == null? null : list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return list == null? 0 : position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(list.size() == 0){
			return null;
		}
		final  ViewHolder viewHolder;
		if(convertView == null){
			convertView = mInflater.inflate(R.layout.activity_item, null);
			viewHolder = new ViewHolder();
			viewHolder.username = (TextView) convertView.findViewById(R.id.user_name);
			viewHolder.userImage = (RoundImage) convertView.findViewById(R.id.user_image);
			viewHolder.time =(TextView) convertView.findViewById(R.id.time);
			viewHolder.comefrom = (TextView)convertView.findViewById(R.id.comefrom);
			viewHolder.content = (TextView)convertView.findViewById(R.id.content);
			viewHolder.gridView = (MyGridView)convertView.findViewById(R.id.gridview1);
		//	viewHolder.images = (ImageView)convertView.findViewById(R.id.ima)
			convertView.setTag(viewHolder);
		}
		else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		final Foundmsg msg = list.get(position);
		String name=null,userimage=null,headimage=null,time=null,place=null,content=null,image=null;
		
		if(msg != null){
			name = msg.getUsername();
			//userimage = msg.getHeadimage();
			headimage = msg.getHeadimage();
			time = msg.getTime();
			place = msg.getPlace();
			content = msg.getContent();
			image = msg.getImages();
			
		}
		//
		if(name !=null && !name.equals("")){
			Log.d("name", name);
			viewHolder.username.setText(name);;
		}
		//
		if(headimage != null && !headimage.equals("")){
			finalBitmap.display(viewHolder.userImage, headimage);
		}else{
			viewHolder.userImage.setImageResource(R.drawable.kuroku);
		}
		if(image!=null && !image.equals("")){
			//viewHolder.gridView.setVisibility(View.VISIBLE);
			initInfoImages(viewHolder.gridView,image);
		}
		
		if (time!=null && !time.equals("")) {
			viewHolder.time.setText(time);
		}
		if(content!=null && !content.equals("")){
			viewHolder.content.setText(content);
		}
		if(place!= null && !place.equals("")){
			viewHolder.comefrom.setText(place);
		}
		viewHolder.userImage.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//头像点击事件
				Toast.makeText(act, "点击了头像", Toast.LENGTH_LONG).show();
				
			}
		});
		return convertView;
	}
	public void initInfoImages(MyGridView gv_images,final String imgspath){
		if(imgspath!=null&&!imgspath.equals("")){
			String[] imgs=imgspath.split("#");
			ArrayList<String> list=new ArrayList<String>();
			for(int i=0;i<imgs.length;i++){
				list.add(imgs[i]);
			}
			int w=0;
			switch (imgs.length) {
			case 1:
				w=width;
				gv_images.setNumColumns(1);
				break;
			case 2:
			case 4:
				w=2*width+BaseHelper.Dp2Px(act, 2);
				gv_images.setNumColumns(2);
				break;
			case 3:
			case 5:
			case 6:
				w=width*3+BaseHelper.Dp2Px(act, 2)*2;
				gv_images.setNumColumns(3);
				break;
			}
			RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(w, RelativeLayout.LayoutParams.WRAP_CONTENT);
			gv_images.setLayoutParams(lp);
			gridViewAdapter=new GridViewAdapter(act, list);
			gv_images.setAdapter(gridViewAdapter);
			gv_images.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,int arg2, long arg3) {
					Toast.makeText(act, "点击了第"+(arg2+1)+"张图片", Toast.LENGTH_SHORT).show();
				}
			});
		}

	}

	static class ViewHolder{
		RoundImage userImage;
		TextView username;
		TextView time;
		TextView comefrom;
		TextView content;
		//ImageView images;
		MyGridView gridView;
	}
}
