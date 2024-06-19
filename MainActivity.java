package com.example.recyclerview;

import android.content.Intent;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int ADD_EVENT_REQUEST = 1;
    private ArrayList<event_model> event_models = new ArrayList<>();
    private event_RecyclerViewAdapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.eventRecyclerView);
        FloatingActionButton addEvent = findViewById(R.id.addEvent);

        setUpEventModels();

        adapter = new event_RecyclerViewAdapter(this, event_models);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddEventActivity.class);
                startActivityForResult(intent, ADD_EVENT_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_EVENT_REQUEST && resultCode == RESULT_OK && data != null) {
            String title = data.getStringExtra("title");
            String description = data.getStringExtra("description");
            String date = data.getStringExtra("date");
            String time = data.getStringExtra("time");
            String location = data.getStringExtra("location");

            event_model newEvent = new event_model(title, description, date, time, location);
            event_models.add(newEvent);
            adapter.notifyItemInserted(event_models.size() - 1);
        }
    }

    private void setUpEventModels() {
        String[] eventNames = getResources().getStringArray(R.array.event_name);
        String[] eventDescriptions = getResources().getStringArray(R.array.event_description);
        String[] eventDates = getResources().getStringArray(R.array.event_date);
        String[] eventTimes = getResources().getStringArray(R.array.event_time);
        String[] eventLocations = getResources().getStringArray(R.array.event_location);

        for (int i = 0; i < eventNames.length; i++) {
            event_models.add(new event_model(eventNames[i], eventDescriptions[i], eventDates[i], eventTimes[i], eventLocations[i]));
        }
    }
}
