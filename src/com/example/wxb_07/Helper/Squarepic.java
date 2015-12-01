package com.example.wxb_07.Helper;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


public class Squarepic{


	/**
     * ������ͼƬά�ֿ�߱����ź󣬽�ȡ���м�������β��֡�
     * @param bitmap      ԭͼ
     * @param edgeLength  ϣ���õ��������β��ֵı߳�
     * @return  ���Ž�ȡ���в��ֺ��λͼ��
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
      //ѹ����һ����С������edgeLength��bitmap
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
            
         //��ͼ�н�ȡ���м�������β��֡�
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
