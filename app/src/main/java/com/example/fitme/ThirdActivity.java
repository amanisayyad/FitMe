package com.example.fitme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<Workout> workouts;
    EditText weight,height;
    Spinner goal;
    Button gen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        listView = findViewById(R.id.listViewWorkouts);
        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        goal = findViewById(R.id.spinner_goal);
        gen = findViewById(R.id.gen);

        //workouts = generateWorkoutOptions();

        gen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Generate the workout options when the button is clicked
                workouts = generateWorkoutOptions();

                // Populate the ListView with workout names
                ArrayList<String> workoutNames = new ArrayList<>();
                for (Workout workout : workouts) {
                    workoutNames.add(workout.getName());
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<>(ThirdActivity.this, android.R.layout.simple_list_item_1, workoutNames);
                listView.setAdapter(adapter);
                listView.setVisibility(View.VISIBLE);
            }
        });

        // Set an event handler for ListView item clicks
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Open the detail activity and pass the workout details
                Intent intent = new Intent(ThirdActivity.this, DetailActivity.class);
                intent.putExtra("name", workouts.get(position).getName());
                intent.putExtra("difficulty", workouts.get(position).getDifficulty());
                intent.putExtra("description", workouts.get(position).getDescription());
                intent.putExtra("duration",workouts.get(position).getDuration());
                startActivity(intent);
            }
        });
    }


    private ArrayList<Workout> generateWorkoutOptions() {
        ArrayList<Workout> options = new ArrayList<>();

        String weightText = weight.getText().toString();
        if (weightText.isEmpty()) {
            // Show a message or handle the case where weight input is empty
            Toast.makeText(this, "Please enter your weight", Toast.LENGTH_SHORT).show();
            return options; // Return an empty list if the weight is not provided
        }

        int weightInput = Integer.parseInt(weightText);
        String goalInput = goal.getSelectedItem().toString();

        if (weightInput >= 1 && weightInput <= 60 && goalInput.equalsIgnoreCase("Build Muscle")) {
            options.add(new Workout("Strength Training", "Intermediate", "A medium intensity strength workout.","1 Hour"));
            options.add(new Workout("Lifting Weights", "Hard", "An intense lifting session to build muscle mass.","30 mins"));
        } else if (weightInput >= 1 && weightInput <= 60 && goalInput.equalsIgnoreCase("Gain Weight")) {
            options.add(new Workout("Build Muscle Workout", "Intermediate", "A structured workout plan to increase muscle mass.","45 mins"));
            options.add(new Workout("Bulking Exercise", "Hard", "High-calorie strength exercises for bulking.","2 hours"));
        } else if (weightInput > 60 && weightInput <= 100 && goalInput.equalsIgnoreCase("Lose Weight")) {
            options.add(new Workout("Beginner Cardio", "Easy", "A gentle cardio routine for weight loss beginners.","20 mins"));
            options.add(new Workout("Ab Workout", "Intermediate", "Core exercises focused on abdominal muscle definition.","45 mins"));
        } else {
            options.add(new Workout("General Fitness", "Easy", "A balanced workout plan for maintaining health.","15 mins"));
        }

        return options;
    }

}
