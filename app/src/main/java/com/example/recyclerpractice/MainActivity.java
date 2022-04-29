package com.example.recyclerpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Consult> consults = new ArrayList<Consult>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setInitialData();
        RecyclerView recyclerView = findViewById(R.id.list);
        ConsultAdapter consultAdapter = new ConsultAdapter(this, consults);
        recyclerView.setAdapter(consultAdapter);
    }

    private void setInitialData(){
        consults.add(new Consult("Kid", "Norman", "112", R.drawable.doctor1));
        consults.add(new Consult("Roberts", "William", "113", R.drawable.doctor2));
        consults.add(new Consult("Charles", "David", "114", R.drawable.doctor3));
        consults.add(new Consult("Wallas", "Jennifer", "115", R.drawable.doctor4));
        consults.add(new Consult("Born", "Elizabeth", "116", R.drawable.doctor5));
        consults.add(new Consult("Matthew", "Sarah", "117", R.drawable.doctor6));
        consults.add(new Consult("Kim", "Steven", "118", R.drawable.doctor7));
    }
}