//package com.example.yasmine.gps;
//
//import android.Manifest;
//import android.content.Context;
//import android.content.Intent;
//import android.content.pm.PackageManager;
//import android.location.Criteria;
//import android.location.Location;
//import android.location.LocationListener;
//import android.location.LocationManager;
//import android.support.v4.app.ActivityCompat;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ListView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.database.ChildEventListener;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.Query;
//import com.google.firebase.database.ValueEventListener;
//
//import static android.R.attr.name;
//
//
//public class MainActivity extends AppCompatActivity implements LocationListener {
//    Button retrive,delete;
//    ListView lv;
//    TextView textView, textView2, textView3, textView4;
//    private FirebaseAuth firebaseAuth;
//    private DatabaseReference databaseReference;
//
//
//    //final FirebaseDatabase database = FirebaseDatabase.getInstance();
//    //DatabaseReference ref = database.getReference();
//
//    Intent intent2 = getIntent();
//    LocationManager locationmanager;
//    String lat_loc;
//    String lon_loc;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//
//        delete =(Button) findViewById(R.id.delete);
//        retrive = (Button) findViewById(R.id.retrive);
//        Intent intent2 = getIntent();
//        String message = intent2.getStringExtra(Authentication.Test);
//        // Capture the layout's TextView and set the string as its text
//        textView = (TextView) findViewById(R.id.text1);
//        textView.setText(message);
//
//        String message2 = intent2.getStringExtra(Authentication.Test2);
//        textView2 = (TextView) findViewById(R.id.text2);
//        textView2.setText(message2);
//
//
//        // SaveUserInfo();
//
////        DatabaseReference re = FirebaseDatabase.getInstance().getReference("Data base").child("name");
////        re.setValue(message);
////
////        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Data base").child("color");
////       ref.setValue(message2);
//
//
//        //String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
//        // DatabaseReference userRef = FirebaseDatabase.getInstance().getReference().child("users").child(uid);
//
////
////        firebaseAuth=FirebaseAuth.getInstance();
////        if(firebaseAuth.getCurrentUser()==null){
////            finish();
////        }
////
////        databaseReference= FirebaseDatabase.getInstance().getReference();
////        FirebaseUser user=firebaseAuth.getCurrentUser();
//
//        delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // var user = firebase.auth().currentUser;
//                databaseReference = FirebaseDatabase.getInstance().getReference();
//                Query applesQuery = databaseReference.child("gpsproject-6e20d").orderByChild("color").equalTo("blue");
//                applesQuery.addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//
//                        dataSnapshot.getRef().setValue(null);
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
//
//
//
//                    }
//
//                });
//
//
//
//            }
//        });
//
//        retrive.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FirebaseDatabase database = FirebaseDatabase.getInstance();
//                databaseReference = database.getReference();
//                databaseReference.addChildEventListener(new ChildEventListener() {
//                    @Override
//                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                        UserInformation data = dataSnapshot.getValue(UserInformation.class);
//                        // Log.i(" sss", String.valueOf(data.getMail()));
//                        //.i("", String.valueOf(data.getColor()));
//
////                                                   String cle = dataSnapshot.getKey();
////                                                   String name = dataSnapshot.child("name").getValue(String.class);
////                                                   Toast.makeText(MainActivity.this,"la cle est : "+cle+" nom est : "+name ,Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//
//                    }
//
//                    @Override
//                    public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//                    }
//
//                    @Override
//                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
//
//                    }
//                });
//
//            }
//        });
//
//        locationmanager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//        Criteria cri = new Criteria();
//        String provider = locationmanager.getBestProvider(cri, false);
//        if (provider != null & !provider.equals(""))
//
//        {
//
//            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                // TODO: Consider calling
//                //    ActivityCompat#requestPermissions
//                // here to request the missing permissions, and then overriding
//                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                //                                          int[] grantResults)
//                // to handle the case where the user grants the permission. See the documentation
//                // for ActivityCompat#requestPermissions for more details.
//                return;
//            }
//            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                // TODO: Consider calling
//                //    ActivityCompat#requestPermissions
//                // here to request the missing permissions, and then overriding
//                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                //                                          int[] grantResults)
//                // to handle the case where the user grants the permission. See the documentation
//                // for ActivityCompat#requestPermissions for more details.
//                return;
//            }
//            Location location = locationmanager.getLastKnownLocation(provider);
//
//            locationmanager.requestLocationUpdates(provider, 2000, 1, this);
//
//            if (location != null)
//
//            {
//
//                onLocationChanged(location);
//
//            } else {
//
//                Toast.makeText(getApplicationContext(), "location not found", Toast.LENGTH_LONG).show();
//
//            }
//
//        } else
//
//        {
//
//            Toast.makeText(getApplicationContext(), "Provider is null", Toast.LENGTH_LONG).show();
//
//        }
//
//
//    }
//
//
////    private void SaveUserInfo(){
////        String name= textView.getText().toString().trim();
////        String col =textView2.getText().toString().trim();
////        String lat= textView4.getText().toString().trim();
////        String lon=textView3.getText().toString().trim();
////        UserInformation information= new UserInformation(name,col,lon,lat);
////
////        FirebaseUser user = firebaseAuth.getCurrentUser();
////        databaseReference.child(user.getUid()).setValue(information);
////        Toast.makeText(this," .....information saved ......",Toast.LENGTH_LONG).show();
////    }
//
//
//    @Override
//    public void onLocationChanged(Location location) {
//
//        textView4 = (TextView) findViewById(R.id.textview2);
//
//        textView3 = (TextView) findViewById(R.id.textview3);
//        //   using format _minutes in latitude
//        lat_loc = location.convert(location.getLatitude(), location.FORMAT_MINUTES);
//        lon_loc = location.convert(location.getLongitude(), location.FORMAT_MINUTES);
//
//
////        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Data base").child("GPS latitude");
////        reference.setValue(lat_loc);
////        DatabaseReference r = FirebaseDatabase.getInstance().getReference("Data base").child("GPS longitude");
////       r.setValue(lon_loc);
//
//
//        //using format _minutes in longitude
//
//        //* Math.PI / 180;
//        textView4.setText("Latitude" + "     " + lat_loc);
//        //location.FORMAT_DEGREES);
//
//        textView3.setText("Longitude" + "    " + lon_loc);
//    }
//
//    @Override
//    public void onStatusChanged(String provider, int status, Bundle extras) {
//
//    }
//
//    @Override
//    public void onProviderEnabled(String provider) {
//
//    }
//
//    @Override
//    public void onProviderDisabled(String provider) {
//
//    }
//}