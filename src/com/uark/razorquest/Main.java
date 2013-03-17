package com.uark.razorquest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Main extends Activity {

	FileInputStream fin;
	TextView txtLastCoord;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		/*
		try {
			fin = openFileInput("lastcoord");
			String lc = "pasta";
			//lc = lc+fin.read();
			txtLastCoord.setText(lc);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		final Button btnTracker = (Button) findViewById(R.id.btnTracker);
        btnTracker.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Intent myIntent = new Intent(Main.this, LocationTracker.class);
                startActivity(myIntent);
                
            }
        });
	}
				
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	/*
	public class InternalData extends Activity implements OnClickListener{

		FileOutputStream fout;
		String FILENAME = "lastcoord";
		
		
		@Override
		protected void onCreate(Bundle savedInstanceState){
			super.onCreate(savedInstanceState);
			setContentView(R.layout.main_layout);
			
		}
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		}
	}
	*/
	
}
