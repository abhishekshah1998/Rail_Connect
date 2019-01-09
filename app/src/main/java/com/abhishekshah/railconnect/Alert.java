package com.abhishekshah.railconnect;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Alert extends AppCompatActivity {
FirebaseUser user;
    String id;
    LocationManager locationManager;
    String latitude,longitude;
    private static final int REQUEST_LOCATION=1;
    DatabaseReference mDatabaseReference;
    DatabaseReference demoRef;
    Map map1;
    String location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);


        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        id = user.getUid();

        mDatabaseReference = FirebaseDatabase.getInstance().getReference();
        demoRef = mDatabaseReference.child("alert");
        Button alertButton =findViewById(R.id.alert);


        alertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

                if(!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
                    buildAlertMessageNoGps();
                }
                else if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                    getLocation();
                }
            }
        });

    }
    private void getLocation(){
        if(ActivityCompat.checkSelfPermission(Alert.this,Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(Alert.this,Manifest.permission.ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_LOCATION);
        }

        else{
            Location location=locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            Location location1=locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            Location location2=locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);

            if(location!=null){
                double latti=location.getLatitude();
                double longi=location.getLongitude();
                latitude =String.valueOf(latti);
                longitude=String.valueOf(longi);


                map1 = new HashMap();
                 map1.put("uid",id);
                map1.put("name",getLocationName(latti,longi));
                demoRef.push().setValue(map1);




            }
            else  if (location1 != null) {
                double latti = location1.getLatitude();
                double longi = location1.getLongitude();
                latitude = String.valueOf(latti);
                longitude = String.valueOf(longi);


                map1 = new HashMap();
               map1.put("uid",id);
                map1.put("name",getLocationName(latti,longi));
                demoRef.push().setValue(map1);


            } else  if (location2 != null) {
                double latti = location2.getLatitude();
                double longi = location2.getLongitude();
                latitude = String.valueOf(latti);
                longitude = String.valueOf(longi);


                map1 = new HashMap();
                map1.put("uid",id);
                map1.put("name",getLocationName(latti,longi));
                demoRef.push().setValue(map1);
            }else{

                Toast.makeText(this,"Unble to Trace your location",Toast.LENGTH_SHORT).show();

            }
        }
    }





    public String getLocationName(double lattitude,double longitude){
        Geocoder gcd = new Geocoder(getBaseContext(), Locale.getDefault());
        String result=null;
        try{
            List<Address> addressList=gcd.getFromLocation(lattitude,longitude,1);

            if(addressList !=null && addressList.size()>0){
                Address address = (Address) addressList.get(0);
                StringBuilder sb = new StringBuilder();

                sb.append(address.getAddressLine(0)).append("\n");

                result = sb.toString();

            }


        }catch (IOException e){
            e.printStackTrace();
        }
        return result;
    }



    protected void buildAlertMessageNoGps() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Please Turn ON your GPS Connection")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        dialog.cancel();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }








}
