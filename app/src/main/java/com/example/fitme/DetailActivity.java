package com.example.fitme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailActivity extends AppCompatActivity {
    TextView name,difficulty,description,duration;
    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
       name = findViewById(R.id.name);
       difficulty = findViewById(R.id.difficulty);
       description= findViewById(R.id.description);
       duration=findViewById(R.id.duration);
       start=findViewById(R.id.start);

        String nameIn = getIntent().getStringExtra("name");
        String difficultyIn = getIntent().getStringExtra("difficulty");
        String descriptionIn = getIntent().getStringExtra("description");
        String durationIn= getIntent().getStringExtra("duration");

        name.setText(nameIn);
        difficulty.setText("Difficulty: " + difficultyIn);
        description.setText(descriptionIn);
        duration.setText(durationIn);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DetailActivity.this,FinalActivity.class);
                startActivity(intent);
            }
        });
    }
}