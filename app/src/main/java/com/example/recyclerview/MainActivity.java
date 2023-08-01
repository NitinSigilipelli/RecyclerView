package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ItemClickListener {
    // 1 - AdapterView
    RecyclerView recyclerView;
    //2-Data Source
    VacinesModel[] myListData;
    //3-Adapter
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        myListData = new VacinesModel[]{
                new VacinesModel("Hepatitis B Vaccine",R.drawable.vaccine1  ),
                new VacinesModel("Tetanus Vaccine",R.drawable.vaccine4),
                new VacinesModel("Pneumococcal Vaccine",R.drawable.vaccine5),
                new VacinesModel("Rotavirus Vaccine",R.drawable.vaccine6),
                new VacinesModel("Measles Virus",R.drawable.vaccine7),
                new VacinesModel("Cholera Virus",R.drawable.vaccine8),
                new VacinesModel("Covid-19 Virus",R.drawable.vaccine9)
        };
        // Adapter
        adapter = new MyAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(adapter);
        //Handling the Click Events
        adapter.setClickListener(this);

    }

    @Override
    public void onClick(View view, int pos) {
        Toast.makeText(this, "Vaccine name:"+myListData[pos].getTitle(), Toast.LENGTH_SHORT).show();
    }
}