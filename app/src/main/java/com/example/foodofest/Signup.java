package com.example.foodofest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.io.File;
import java.io.IOException;


public class Signup extends AppCompatActivity {
//    variable for signup and already a  user
    Button btn1;
    Button btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        btn1=(Button)findViewById(R.id.buttonb);
        FirebaseAuth auth = FirebaseAuth.getInstance();
//        function to  go login pagge from signup
        btn1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Signup.this,loginpage.class);
                startActivity(intent);
            }
        });
        btn2=(Button)findViewById(R.id.buttona);
//funtion to login
        btn2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText signup_email =(EditText)findViewById(R.id.signup_email_id) ;
                EditText signup_pass =(EditText)findViewById(R.id.signup_password) ;
                EditText confirm_pass=(EditText) findViewById(R.id.confirm_password);
                String signup_mail=signup_email.getText().toString().trim();
                String signup_pas=signup_pass.getText().toString().trim();
                String confirm_pas=confirm_pass.getText().toString().trim();
// to checkemail is empty or  not
                if(signup_mail.isEmpty()){
                    Toast.makeText(getApplicationContext(),"UserId can not be empty!!!",Toast.LENGTH_LONG).show();
                }
                // to check password is empty or  not
                else if(signup_pas.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Password can not be empty!!!",Toast.LENGTH_LONG).show();
                }
                // to check password lennth is greater than 6 ab less than 8
                else if((signup_pas.length()<6) || (8<signup_pas.length()))
                {
                    Toast.makeText(getApplicationContext(),"Password length should be more than 6 and less than 8",Toast.LENGTH_LONG).show();

                }
//                to check confirm password is equal to password or not
                else if(!confirm_pas.equals(signup_pas)) {
                    Toast.makeText(getApplicationContext(),"Password and Confirm Password does not match!!!",Toast.LENGTH_LONG).show();

                }
                else {
//                    function for signup
                    auth.createUserWithEmailAndPassword(signup_mail,signup_pas).addOnCompleteListener(new OnCompleteListener<AuthResult>(){


                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(), "Successfully Registered", Toast.LENGTH_LONG).show();
                                Intent i = new Intent(Signup.this, Restaurant.class);
                                startActivity(i);
                                finish();
                            } else {
                                Toast.makeText(getApplicationContext(), "Provide Valid Gooogle Email Id", Toast.LENGTH_LONG).show();
                            }
                        }
                    });

                }
            }
        });

    }
}