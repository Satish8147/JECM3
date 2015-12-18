package com.jsp.networking;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {

	ImageView networkimage;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		networkimage = (ImageView) findViewById(R.id.imageViewdefault);
		
		NetworkOps obj = new NetworkOps(networkimage);
		obj.execute();
		
		
	}



}
