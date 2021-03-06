package com.jsp.weatherupdates;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

public class Netwrok_Job extends AsyncTask<Void,Void,Void> 
{
	URL updateurl;
	HttpURLConnection connection;
	 Bundle responsebundle;
	
	
	
	@Override
	protected Void doInBackground(Void... params) 
	{
		try 
		{
			updateurl = new URL("http://api.openweathermap.org/data/2.5/weather?q=London,uk&appid=2de143494c0b295cca9337e1e96b00e0");
		    connection = (HttpURLConnection) updateurl.openConnection();
		    InputStream ins =  connection.getInputStream();
		    
		    InputStreamReader insr = new InputStreamReader(ins);
		    
		  
		    
		    BufferedReader reader = new BufferedReader(insr);
		    
		    StringBuffer buffer = new StringBuffer();
		    
		    String line = "";
		    
		    while((line = reader.readLine())!=null )
			{
				buffer.append(line+"/r"+"/n");
			}
		    
		    String response =  buffer.toString(); 
		    
		    Log.d("[DEBUG]", response);
		    responsebundle= JsonParser.processjson(response);
		    
		    
		} 
		
		
		catch (MalformedURLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	protected void onPostExecute(Void result) 
	{
	
		super.onPostExecute(result);
	}

}
