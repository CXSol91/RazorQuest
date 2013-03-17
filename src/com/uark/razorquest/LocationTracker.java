package com.uark.razorquest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

public class LocationTracker extends Activity{
	
	TextView txtLat;
	TextView txtLong;

	public class myLocationListener implements LocationListener{
		FileOutputStream fout;
		String FILENAME;
			@Override
			public void onLocationChanged(Location location) {
				if (location!=null){
					double Lat = location.getLatitude();
					double Long = location.getLongitude();
					
					txtLat.setText(Double.toString(Lat));
					txtLong.setText(Double.toString(Long));
					FILENAME = "lastcoord";
					
					String coordinates = txtLat.getText().toString() + " " + txtLong.getText().toString();
					try {
						fout = openFileOutput(FILENAME, Context.MODE_PRIVATE);
						fout.write(coordinates.getBytes());
						fout.close();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					/*
					File lastcoord = new File("lastcoord");
					try {
						fout = new FileOutputStream(lastcoord);
						
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					*/ catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}				
			}
	
			@Override
			public void onProviderDisabled(String provider) {
				// TODO Auto-generated method stub
				
			}
	
			@Override
			public void onProviderEnabled(String provider) {
				// TODO Auto-generated method stub
				
			}
	
			@Override
			public void onStatusChanged(String provider, int status, Bundle extras) {
				// TODO Auto-generated method stub
				
			}
	}
	@Override	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tracker_layout);
		
		txtLat = (TextView)findViewById(R.id.txtLat);
		txtLong = (TextView)findViewById(R.id.txtLong);
		
		LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
		LocationListener ll = new myLocationListener();
		lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, ll);
		lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, ll);
	}
}


