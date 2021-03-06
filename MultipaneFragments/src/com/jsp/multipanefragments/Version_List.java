package com.jsp.multipanefragments;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Version_List extends ListFragment 
{
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		String[] versions = {"v1","v2","v3","v4"};
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,versions);
		setListAdapter(adapter);
	}
	
	@Override
	public void onListItemClick(ListView l, View v, 
			int position, long id) 
	{
	
		Communicator communicator = (Communicator) getActivity();
		communicator.respond(position);
	}
	
}
