package com.example.fitme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;




public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.loginButton);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userInput = username.getText().toString().trim();
                String passInput = password.getText().toString().trim();


                if (userInput.isEmpty() && passInput.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Username and password cannot be empty.", Toast.LENGTH_SHORT).show();
                }

                else if (userInput.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Username cannot be empty.", Toast.LENGTH_SHORT).show();
                } else if (!userInput.matches("[a-zA-Z]+")) {
                    Toast.makeText(MainActivity.this, "Invalid username: Must contain only letters.", Toast.LENGTH_SHORT).show();
                }

                else if (passInput.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Password cannot be empty.", Toast.LENGTH_SHORT).show();
                } else if (passInput.length() < 8) {
                    Toast.makeText(MainActivity.this, "Invalid password: Must be at least 8 characters long.", Toast.LENGTH_SHORT).show();
                }

                else {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("username", userInput); // Pass the username to the next Activity
                    startActivity(intent); // Start the next Activity
                    Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

