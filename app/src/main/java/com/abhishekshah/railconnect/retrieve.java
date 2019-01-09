package com.abhishekshah.railconnect;


        import android.app.ProgressDialog;
        import android.content.Intent;
        import android.support.design.widget.FloatingActionButton;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.view.View;
        import android.widget.Button;
        import android.widget.Toast;

        import com.abhishekshah.railconnect.main.main.MainActivity;
        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.ValueEventListener;

        import java.util.ArrayList;
        import java.util.List;

public class retrieve extends AppCompatActivity {


    DatabaseReference databaseReference;

    ProgressDialog progressDialog;

    List<StudentDetails> list = new ArrayList<>();

    RecyclerView recyclerView;

    RecyclerView.Adapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrieve);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(retrieve.this));

        progressDialog = new ProgressDialog(retrieve.this);

        progressDialog.setMessage("Loading Data from Firebase Database");

        progressDialog.show();

        databaseReference = FirebaseDatabase.getInstance().getReference().child("trial1");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    StudentDetails stud = new StudentDetails(dataSnapshot.child("status").getValue().toString(),dataSnapshot.child("uid").getValue().toString(),dataSnapshot.child("time").getValue().toString(),dataSnapshot.child("source").getValue().toString(),dataSnapshot.child("destination").getValue().toString(),dataSnapshot.child("type").getValue().toString(),dataSnapshot.child("delay").getValue().toString());

                  //  StudentDetails studentDetails = dataSnapshot.getValue(StudentDetails.class);

                    list.add(stud);
                }

                adapter = new RecyclerViewAdapter(retrieve.this, list);

                recyclerView.setAdapter(adapter);

                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                progressDialog.dismiss();

            }
        });
        FloatingActionButton fb = (FloatingActionButton) findViewById(R.id.fb12);

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(retrieve.this, trial1.class);
                startActivity(i);
            }
        });


    }
}