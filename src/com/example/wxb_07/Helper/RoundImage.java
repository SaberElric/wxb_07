package com.example.wxb_07.Helper;

import java.text.AttributedCharacterIterator.Attribute;

import com.example.wxb_07.R;
import com.example.wxb_07.R.drawable;

import android.R.integer;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
/**制作圆形图片
 * @author wxb
 * */
public class RoundImage extends ImageView{

	private Context context;
	private int defaultcolor = Color.rgb(255, 255, 255);
	
	private int thickness = 0;
	private int outsidecolor = 0;
	private int insiddcolor = 0;
	private int defaultwidth = 0;
	private int defaultheight = 0;
	
	
	
	
	
	
	public RoundImage(Context context) {
		super(context);
		this.context = context;
		// TODO Auto-generated constructor stub
	}
	public RoundImage(Context context,AttributeSet attr){
		super(context, attr);
		
	}
	public RoundImage(Context context,AttributeSet attr,int defaultstyle){
		super(context, attr,defaultstyle);
		
	}
	private void setattrs(AttributeSet attrs) {
		// TODO Auto-generated method stub
		TypedArray Ta = context.obtainStyledAttributes(attrs, R.styleable.RoundImage);
		thickness = Ta.getDimensionPixelSize(R.styleable.RoundImage_border_thickness, 0);
		outsidecolor =Ta.getColor(R.styleable.RoundImage_border_outside_color, defaultcolor);
		insiddcolor = Ta.getColor(R.styleable.RoundImage_border_inside_color, defaultcolor);
	}
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		 Bitmap bitmap;
		Drawable drawable = getDrawable();
		if(drawable ==null){
			return;
		}
		if(getWidth()==0 || getHeight()==0){
			return;
		}
		this.measure(0, 0);
		if(drawable.getClass()==NinePatchDrawable.class)
			return;
		Bitmap b = ((BitmapDrawable)drawable).getBitmap();
		bitmap = b.copy(Bitmap.Config.ARGB_8888, true);
		  if (defaultwidth == 0) {  
			  defaultwidth = getWidth();
		  }
		  if(defaultheight == 0){
			  defaultheight = getHeight();
		  }
		  int radius = 0;
		  /**定义画两个边框，外圆框和内圆框*/
		  if(insiddcolor != defaultcolor && outsidecolor != defaultcolor){
			  radius = (defaultwidth < defaultheight ? defaultwidth:defaultheight)/2-2*thickness;
			  drawCircleBorder(canvas, radius+thickness/2, insiddcolor);
			  drawCircleBorder(canvas, radius+thickness+thickness/2, outsidecolor);
		  }else if(insiddcolor != defaultcolor && outsidecolor == defaultcolor){
			  radius=(defaultwidth<defaultheight?defaultwidth:defaultheight)/2-thickness;
			  drawCircleBorder(canvas, radius+thickness/2, insiddcolor);
		  }else if (insiddcolor == defaultcolor && outsidecolor != defaultcolor) {
			  radius=(defaultwidth<defaultheight?defaultwidth:defaultheight)/2-thickness;
			  drawCircleBorder(canvas, radius+thickness/2, outsidecolor);
		  }else{//没框
			  radius=(defaultwidth<defaultheight?defaultwidth:defaultheight)/2;
		  }
		  Bitmap roundbitmap = getCroppedRoundBitmap(bitmap,radius);
		  canvas.drawBitmap(roundbitmap, defaultwidth/2-radius, defaultheight/2-radius, null);
			

	}
	/**裁剪*/
	private Bitmap getCroppedRoundBitmap(Bitmap bitmap,int radius){
		
		Bitmap scaledSrcBmp;
		
		int diameter = radius*2;
		int bmpwidth = bitmap.getWidth();
		int bmpheight = bitmap.getWidth();
		int x = 0,y = 0;
		int squarewidth = 0,squarheight =0;
		Bitmap squarebitmap;
		
		if (bmpheight > bmpwidth) {// 高大于宽
			squarewidth = squarheight = bmpwidth;
			x=0;
			y= (bmpheight-bmpwidth)/2;
			squarebitmap = Bitmap.createBitmap(bitmap,x,y,squarewidth,squarheight);
		}
		else if(bmpheight < bmpwidth){
			squarewidth = squarheight = bmpheight;
			x=(bmpwidth-bmpheight)/2;
			y=0;
			squarebitmap = Bitmap.createBitmap(bitmap,x,y,squarewidth,squarheight);

		}
		else{
			squarebitmap = bitmap;
		}
		if(squarebitmap.getWidth() != diameter || squarebitmap.getHeight()!= diameter){
			scaledSrcBmp = Bitmap.createScaledBitmap(squarebitmap, diameter, diameter, true);
		}else{
			scaledSrcBmp = squarebitmap;
		}
		Bitmap output = Bitmap.createBitmap(scaledSrcBmp.getWidth(),scaledSrcBmp.getWidth(),Config.ARGB_8888);
		Canvas canvas = new Canvas(output);
		
		Paint paint = new Paint();
		Rect rect = new Rect(0,0,scaledSrcBmp.getWidth(),scaledSrcBmp.getHeight());
		
		paint.setAntiAlias(true);
		paint.setFilterBitmap(true);
		paint.setDither(true);
		canvas.drawARGB(0, 0, 0, 0);
		canvas.drawCircle(scaledSrcBmp.getWidth()/2, scaledSrcBmp.getHeight()/2, scaledSrcBmp.getWidth()/2, paint);
		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		canvas.drawBitmap(scaledSrcBmp, rect, rect,paint);
		bitmap =null;
		squarebitmap = null;
		scaledSrcBmp =null;
		
		return output;
		
	}
	private void drawCircleBorder(Canvas canvas,int radius,int color){
		Paint paint = new Paint();
		/* 去锯齿 */
		paint.setAntiAlias(true);
		paint.setFilterBitmap(true);
		paint.setDither(true);
		paint.setColor(color);
		/* 设置paint的　style　为STROKE：空心 */
		paint.setStyle(Paint.Style.STROKE);
		/* 设置paint的外框宽度 */
		paint.setStrokeWidth(thickness);
		canvas.drawCircle(defaultwidth / 2, defaultheight / 2, radius, paint);
	}
	

}
