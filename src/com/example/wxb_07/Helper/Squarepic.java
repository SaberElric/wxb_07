package com.example.wxb_07.Helper;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


public class Squarepic{


	/**
     * 将给定图片维持宽高比缩放后，截取正中间的正方形部分。
     * @param bitmap      原图
     * @param edgeLength  希望得到的正方形部分的边长
     * @return  缩放截取正中部分后的位图。
     */
    public static Bitmap centerSquareScaleBitmap(Resources res, int edgeLength,int id)
    {
    	Bitmap bitmap = BitmapFactory.decodeResource(res, id);
     if(null == bitmap || edgeLength <= 0)
     {
      return  null;
     }
     
     Bitmap result = bitmap;
     int widthOrg = bitmap.getWidth();
     int heightOrg = bitmap.getHeight();
     
     if(widthOrg > edgeLength && heightOrg > edgeLength)
     {
      //压缩到一个最小长度是edgeLength的bitmap
      int longerEdge = (int)(edgeLength * Math.max(widthOrg, heightOrg) / Math.min(widthOrg, heightOrg));
      int scaledWidth = widthOrg > heightOrg ? longerEdge : edgeLength;
      int scaledHeight = widthOrg > heightOrg ? edgeLength : longerEdge;
      Bitmap scaledBitmap;
      
            try{
             scaledBitmap = Bitmap.createScaledBitmap(bitmap, scaledWidth, scaledHeight, true);
            } 
            catch(Exception e){
             return null;
            }
            
         //从图中截取正中间的正方形部分。
         int xTopLeft = (scaledWidth - edgeLength) / 2;
         int yTopLeft = (scaledHeight - edgeLength) / 2;
         
         try{
          result = Bitmap.createBitmap(scaledBitmap, xTopLeft, yTopLeft, edgeLength, edgeLength);
          scaledBitmap.recycle();
         }
         catch(Exception e){
          return null;
         }         
     }
          
     return result;
    } 
}
