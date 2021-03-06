package com.jsp.asynctask_demo;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;


public class Network_Demo extends AsyncTask<Void,String,Void> 
{

	TextView Asymesaagetextview;
	Button Asydownloadbutton;
	Context Asycontext;
	NotificationCompat.Builder builder;
	NotificationManager mgr;
	
	Network_Demo (TextView mesaagetextview,Button downloadbutton,Context context)
	{
		Asymesaagetextview = mesaagetextview;
		Asydownloadbutton = downloadbutton;
		Asycontext = context;
	}
	
	
	
	
	@Override
	protected void onPreExecute() 
	{
		super.onPreExecute();
		Asydownloadbutton.setEnabled(false);
		Asymesaagetextview.setText("Download in progress");
		
		builder = new NotificationCompat.Builder(Asycontext);
        builder.setContentTitle("Download started...");	
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setProgress(100,0,false);
        mgr =  (NotificationManager) Asycontext.getSystemService(Asycontext.NOTIFICATION_SERVICE);
		mgr.notify(1,builder.build());
	}
	
	@Override
	protected Void doInBackground(Void... params) 
	{
		Log.d("[DEBUG]", "Started Background job");
		for (int i = 0; i <= 100; i++) 
		{
			try 
			{
				Thread.sleep(200);
				publishProgress(String.valueOf(i));
				
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		
		Log.d("[DEBUG]", "Background job completed");

		return null;
	}
	
	@Override
	protected void onProgressUpdate(String... values) 
	{
		super.onProgressUpdate(values);
		Asymesaagetextview.setText(values[0]+"%");
		builder.setProgress(100,Integer.parseInt(values[0]),false);
		builder.setContentText(values[0]+"%");
		mgr.notify(1,builder.build());
		
	}

	
	@Override
	protected void onPostExecute(Void result) 
	{
		super.onPostExecute(result);
		Asymesaagetextview.setText("Download completed...");
		Asydownloadbutton.setEnabled(true);
		builder.setContentTitle("Download completed...");
		mgr.notify(1,builder.build());

	}

	
	
}