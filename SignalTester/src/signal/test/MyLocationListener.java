package signal.test;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

public class MyLocationListener implements LocationListener{
	
	public static double latitude;
	public static double longitude;
	
	
//	bOne = (Button) findViewById(R.id.checkButton);		
//	bOne.setOnClickListener(new View.OnClickListener() {
//		
//		@Override
//		public void onClick(View v) {
//			sValue= 99;
//			// TODO Auto-generated method stub
//			sigDisplay.setText("Signal Strength " + sValue);
//		}
//	});
//	
	
	

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		location.getLatitude();
		location.getLongitude();
		latitude=location.getLatitude();
		longitude=location.getLongitude();
	}
	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
	
	}
	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	
	
	

	

}
