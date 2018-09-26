package edu.temple.signupform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //get the string that was passed into this activity
        Intent intent = getIntent();
        String userNameEnterd = intent.getStringExtra("nameUserEntered");

        //set the text to welcome the user
        TextView textView = findViewById(R.id.textView21);
        textView.setText("Welcome, " + userNameEnterd + ", to the SignUpForm App");
    }
}
