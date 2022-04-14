package com.example.foodofest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginpage extends AppCompatActivity {
//    creating two buttons btn one for login and btn2 for new user
    Button btn1;
    Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
//
        btn2=(Button)findViewById(R.id.button2);
//        initialising firebase authentication variable
        FirebaseAuth auth = FirebaseAuth.getInstance();
//        function to  switch from login to signup while clicking on new user  button
        btn2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(loginpage.this,Signup.class);
                startActivity(intent);
            }
        });
//        taking  input ids  to variable
        btn1=(Button)findViewById(R.id.button);
        EditText login_email =(EditText)findViewById(R.id.login_email_Id) ;
        EditText login_pass =(EditText)findViewById(R.id.login_password) ;
        TextView textView=(TextView) findViewById(R.id.show);
//        function to show password or to hid password
        textView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textView.getText().toString().equals("show")){
                    login_pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    textView.setText("hide");
                }
                else{
                    login_pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    textView.setText("show");
                }
            }
        });
//        function to switch from login to restaurant list
        btn1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {

//checking emmail is empty  or not
                if(login_email.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"UserId can not be empty!!!",Toast.LENGTH_LONG).show();
                }
                //checking password is empty  or not
                else if(login_pass.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Password can not be empty!!!",Toast.LENGTH_LONG).show();
                }

                else {


                    String login_mail = login_email.getText().toString().trim();
                    String login_pas = login_pass.getText().toString().trim();
//                    funnction to login with validaion using firebase Athentication
                    auth.signInWithEmailAndPassword(login_mail, login_pas).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(), "Successfully Logged In", Toast.LENGTH_LONG).show();
                                Intent i = new Intent(loginpage.this, Restaurant.class);
                                startActivity(i);
                                finish();
                            } else {
                                Toast.makeText(getApplicationContext(), "Email Id or Password does not match", Toast.LENGTH_LONG).show();
                            }
                        }
                    });

                }
            }
        });
    }

}

