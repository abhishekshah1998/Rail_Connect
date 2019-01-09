package com.abhishekshah.railconnect;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class trial1 extends AppCompatActivity {
    DatabaseReference mDatabaseReference,demoRef;
    FirebaseUser user;
    String in1;
    Map map1;
    TextView time,delay;
    String s1,d1,t1,st1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trial1);
        Spinner s=(Spinner)findViewById(R.id.source);
        Spinner d=(Spinner)findViewById(R.id.destination);
        Spinner t=(Spinner)findViewById(R.id.type);
        Spinner st=(Spinner)findViewById(R.id.status);
        ArrayAdapter<CharSequence> category_adapter = ArrayAdapter.createFromResource(this,R.array.source,android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(category_adapter);
        ArrayAdapter<CharSequence> category_adapter1 = ArrayAdapter.createFromResource(this,R.array.destination,android.R.layout.simple_spinner_dropdown_item);
        d.setAdapter(category_adapter1);
        ArrayAdapter<CharSequence> category_adapter2 = ArrayAdapter.createFromResource(this,R.array.type,android.R.layout.simple_spinner_dropdown_item);
        t.setAdapter(category_adapter2);
        ArrayAdapter<CharSequence> category_adapter3 = ArrayAdapter.createFromResource(this,R.array.status,android.R.layout.simple_spinner_dropdown_item);
        st.setAdapter(category_adapter3);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        String id = user.getUid();

        mDatabaseReference = FirebaseDatabase.getInstance().getReference();
        demoRef = mDatabaseReference.child("trial1");

        time = (TextView)findViewById(R.id.time);
        delay = (TextView)findViewById(R.id.delay);


        Button save = (Button)findViewById(R.id.save);


       // obj=new trial11(id,in1);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time1 = time.getText().toString();
                String delay1 = delay.getText().toString();
                s1 =  s.getSelectedItem().toString();
                d1 =  d.getSelectedItem().toString();
                t1 =  t.getSelectedItem().toString();
                st1 =  st.getSelectedItem().toString();
               // in1 = in.getText().toString();
               map1 = new HashMap();
                map1.put("uid",id);
              map1.put("time",time1);
                map1.put("source",s1);
                map1.put("type",t1);
                map1.put("destination",d1);
                map1.put("status",st1);
                map1.put("delay",delay1);
                //String id=mDatabaseReference.push().getKey();
               // demoRef.push().setValue(obj);
                  demoRef.push().setValue(map1);

            }
        });

    }
}
