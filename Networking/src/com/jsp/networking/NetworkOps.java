package com.jsp.networking;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

public class NetworkOps extends AsyncTask<Void, Void,Void> 
{
	ImageView Asyncnetworkimage;
	InputStream ins;
	Bitmap bm;
	HttpURLConnection httpurl;
	
	NetworkOps (ImageView networkimage)
	{
		Asyncnetworkimage = networkimage;
	}

	@Override
	protected Void doInBackground(Void... arg0) 
	{
		try 
		{
			URL imgurl = new URL("http://i.dailymail.co.uk/i/pix/2013/08/28/article-2404712-1B815F79000005DC-228_306x423.jpg");
			httpurl =  (HttpURLConnection) imgurl.openConnection();
			ins = httpurl.getInputStream();
			
			bm = BitmapFactory.decodeStream(ins);	
		} 

		catch (Exception e) 
		{
			e.printStackTrace();
		}	
		
		return null;
	}

	@Override
	protected void onPostExecute(Void result) 
	{
		Asyncnetworkimage.setImageBitmap(bm);
		super.onPostExecute(result);
	
	}
}
