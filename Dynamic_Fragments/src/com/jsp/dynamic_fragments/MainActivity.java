package com.jsp.dynamic_fragments;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	Button startbutton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
		startbutton = (Button) findViewById(R.id.buttonaddfragment);
		
		startbutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) 
			{
				DynamicFragments_Demo fragment1 = new DynamicFragments_Demo(); 
				
				/*getFragmentManager().beginTransaction().
				add(R.id.activity_main, fragment1).
				addToBackStack("f1").commit();*/
				
				
				FragmentManager manager = getFragmentManager();
				 
				FragmentTransaction transaction = manager.beginTransaction();
			
				transaction.add(R.id.activity_main, fragment1);
				
				transaction.addToBackStack("f1");
				
				transaction.commit();			
			}
		});
	}

}
