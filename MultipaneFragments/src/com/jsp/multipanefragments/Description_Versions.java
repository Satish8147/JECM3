package com.jsp.multipanefragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Description_Versions extends Fragment {
	
	TextView displayversion;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		return inflater.inflate(R.layout.description_fragment,container,false);
	}
	
	public void recievedata(int position)
	{
	 
		String[] versiondesc = {"This is version1","This is version2","This is version3","This is version4"};
		displayversion= (TextView) getActivity().findViewById(R.id.textView1);
		displayversion.setText(versiondesc[position]);
	}

}
