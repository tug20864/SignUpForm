package edu.temple.signupform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.text.TextUtils.isEmpty;

public class FormActivity extends AppCompatActivity {


    //create button for the save button
    public Button saveButton0;
    public EditText input1;
    public EditText input2;
    public EditText input3;
    public EditText input4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        //assign view to button
        saveButton0 = findViewById(R.id.savebutton);
        //assign edit test
        input1 = findViewById(R.id.editText1);
        input2 = findViewById(R.id.editText2);
        input3 = findViewById(R.id.editText3);
        input4 = findViewById(R.id.editText4);


        //set listener for when button is pushed
        saveButton0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check to make sure that all editTextViews are filled in Else toast
                if(
                        input1.getText().toString().equals("")  ||
                        input2.getText().toString().equals("") ||
                        input3.getText().toString().equals("") ||
                        input4.getText().toString().equals("")
                        )
                {
                    Toast.makeText(getApplicationContext(),"Please enter all information!",Toast.LENGTH_LONG).show();
                    return;
                }//end if statement
                //make sure that the password matches the confirm password Else toast
                boolean checkPasswords = input3.getText().toString().equals( input4.getText().toString() );
                if(  !checkPasswords  ){
                    //toast message that passwords dont match
                    Toast.makeText(getApplicationContext(),"Passwords must match!",Toast.LENGTH_LONG).show();
                    return;
                }
                //load new activity and pass the name
                openWelcomeActivity();
            }
        });

    }//end onCreate method

    public void openWelcomeActivity(){
        Intent intent = new Intent(this, WelcomeActivity.class);
        intent.putExtra("nameUserEntered", input1.getText().toString());
        startActivity(intent);
    }
}
