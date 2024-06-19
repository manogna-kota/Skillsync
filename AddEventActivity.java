package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;

public class AddEventActivity extends AppCompatActivity {

    private EditText titleEditText, descriptionEditText, dateEditText, timeEditText, locationEditText;
    private Button addEventButton, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        titleEditText = findViewById(R.id.titleEditText);
        descriptionEditText = findViewById(R.id.descriptionEditText);
        dateEditText = findViewById(R.id.dateEditText);
        timeEditText = findViewById(R.id.timeEditText);
        locationEditText = findViewById(R.id.locationEditText);
        addEventButton = findViewById(R.id.addEventButton);
        backButton = findViewById(R.id.back);

        // Logging to debug which view is not being found
        if (addEventButton == null) {
            Log.e("AddEventActivity", "addEventButton is null. Check the ID in the XML layout.");
        } else {
            addEventButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String title = titleEditText.getText().toString().trim();
                    String description = descriptionEditText.getText().toString().trim();
                    String dateStr = dateEditText.getText().toString().trim();
                    String time = timeEditText.getText().toString().trim();
                    String location = locationEditText.getText().toString().trim();

                    if (title.isEmpty() || description.isEmpty() || dateStr.isEmpty() || time.isEmpty() || location.isEmpty()) {
                        Toast.makeText(AddEventActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("title", title);
                    resultIntent.putExtra("description", description);
                    resultIntent.putExtra("date", dateStr);
                    resultIntent.putExtra("time", time);
                    resultIntent.putExtra("location", location);
                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
            });
        }

        if (backButton == null) {
            Log.e("AddEventActivity", "backButton is null. Check the ID in the XML layout.");
        } else {
            backButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish(); // Finish the current activity and go back to the previous one
                }
            });
        }
    }
}
