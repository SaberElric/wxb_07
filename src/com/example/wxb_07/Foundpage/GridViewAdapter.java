package com.example.wxb_07.Foundpage;

import java.util.ArrayList;

import net.tsz.afinal.FinalBitmap;

import com.example.wxb_07.R;
import com.example.wxb_07.Helper.BaseHelper;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class GridViewAdapter extends BaseAdapter{
	
	Activity context;
	ArrayList<String> list;
	int width;
	private Bitmap bitmaps[];
	private FinalBitmap finalimageLoader;
	public GridViewAdapter(Activity act,ArrayList<String> data){
		this.context = act;
		this.width = (BaseHelper.getScreenWidth(act)-BaseHelper.Dp2Px(act, 99))/3;
		this.list = data;
		this.finalimageLoader = FinalBitmap.create(act);
		this.finalimageLoader.configLoadfailImage(R.drawable.kuroku);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder viewHolder ;
		if(convertView == null){
			convertView = LayoutInflater.from(context).inflate(R.layout.gridviewitem, null);
			viewHolder = new ViewHolder();
			viewHolder.imageView = (ImageView) convertView.findViewById(R.id.imageViewn);
			convertView.setTag(viewHolder);
		}else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		finalimageLoader.display(viewHolder.imageView, list.get(position));
		AbsListView.LayoutParams params = new AbsListView.LayoutParams(width,width);
		convertView.setLayoutParams(params);
		
		
		return convertView;
	}
	static class ViewHolder{
		ImageView imageView;
	}

}
