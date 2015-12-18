package com.jsp.weatherupdates;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.util.Log;

public class JsonParser 
{
	static Bundle b1;

    public static Bundle processjson(String jsondata)
    {
    	
    	try 
    	{
			JSONObject rootobject = new JSONObject(jsondata);
			
			Log.d("[DEBUG]",rootobject.getString("name"));
			
			
			JSONObject mainobject = rootobject.getJSONObject("main");
		
			/*	JSONArray listarray = rootobject.getJSONArray("list");
			
			for(int i=0;i<=listarray.length();i++)
			{
				
			}
			*/
			Log.d("[DEBUG]",""+mainobject.getDouble("temp"));
			
			b1 = new Bundle();
			b1.putDouble("temp", mainobject.getDouble("temp"));
	
		} 
    	
    	catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return b1;
    }

}
