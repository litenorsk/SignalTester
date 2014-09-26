package signal.test;

import android.app.Activity;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;




public class MainActivity extends Activity {
	
	int sValue;
	Button bOne;
	TextView sigDisplay;
	TextView locDisplaylat;
	TextView locDisplaylon;
	
	

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	sigDisplay = (TextView) findViewById(R.id.tvSignal);
		bOne = (Button) findViewById(R.id.checkButton);
	locDisplaylat=(TextView)findViewById(R.id.latitude);
	locDisplaylon=(TextView)findViewById(R.id.longitude);
	
		
		
		
		bOne.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				sValue= 99;
				// TODO Auto-generated method stub
				sigDisplay.setText("Signal Strength " + sValue);
				LocationManager lMan =null;
				LocationListener lListen;
				
				lMan = (LocationManager)getSystemService(LOCATION_SERVICE);//may need Context.LOCA..
				lListen = new MyLocationListener();
				
				lMan.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,lListen);
				
				if(lMan.isProviderEnabled(LocationManager.GPS_PROVIDER)){
					if(MyLocationListener.latitude!=0&&MyLocationListener.longitude!=0){
						
					locDisplaylat.setText("Latitude: " +MyLocationListener.latitude);
					locDisplaylon.setText("Longitude: " +MyLocationListener.longitude);
					
						//locDisplaylat.setText(MyLocationListener.latitude);
					}else{
						locDisplaylat.setText("GPS is still Searching");
						locDisplaylon.setText("");
					}
					
				}else
				{
					locDisplaylat.setText("GPS is not turned on");
					locDisplaylon.setText("");
				}
			}
		});
	}

	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
