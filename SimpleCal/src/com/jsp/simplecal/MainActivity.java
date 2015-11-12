package com.jsp.simplecal;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText inputedittext;
    Button addbutton;
    TextView resulttextview;
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        inputedittext = (EditText) findViewById(R.id.editTextinput);
        addbutton = (Button) findViewById(R.id.buttonadd);
        resulttextview = (TextView) findViewById(R.id.textViewresult);
        
        
        addbutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) 
			{
				if(inputedittext.getText().toString().length()==0)
				{
					Toast.makeText(MainActivity.this,"Enter the values",Toast.LENGTH_SHORT).show();
				}
				
				else
				{
				
				String num1 = inputedittext.getText().toString();
				int inputnum1 =  Integer.parseInt(num1);
				
				inputedittext.setText("");
				
			
			
				String num2 = inputedittext.getText().toString();
				int inputnum2 =  Integer.parseInt(num2);
				
				int  result = inputnum1+inputnum2;
				
				resulttextview.setText(String.valueOf(result));
				
				}
				
			}
		});
        
        
    }

    
}
