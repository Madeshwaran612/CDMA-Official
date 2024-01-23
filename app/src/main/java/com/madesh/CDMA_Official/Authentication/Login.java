package com.madesh.CDMA_Official.Authentication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.madesh.CDMA_Official.MainActivity2;
import com.madesh.CDMA_Official.MainActivity3;
import com.madesh.CDMA_Official.R;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.annotations.NonNull;

public class Login extends AppCompatActivity {
EditText mEmail, mPassword;
Button mLoginButton;
TextView mCreatebutton, forgotButton;
ProgressBar progressBar;
FirebaseAuth fAuth;
FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password20);
        mLoginButton = findViewById(R.id.reg_but);
        mCreatebutton = findViewById(R.id.regText1);
        progressBar = findViewById(R.id.progressBarlogin);
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        forgotButton = findViewById(R.id.forgetText);

        forgotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText resetMail = new EditText((v.getContext()));
                AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(v.getContext());
                passwordResetDialog.setTitle("Reset Password ?");
                passwordResetDialog.setMessage("Enter Your Email to receive Reset Link.");
                passwordResetDialog.setView(resetMail);

                passwordResetDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String mail = resetMail.getText().toString();
                        fAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(Login.this,"Reset Link sent successfully to your Mail",Toast.LENGTH_LONG).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Login.this,e.toString(),Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                passwordResetDialog.show();
            }
        });

        mCreatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Register.class));
                finish();
            }
        });



        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString().trim();
                String password1 = mPassword.getText().toString();


                if (TextUtils.isEmpty(email)){
                    mEmail.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(password1) || password1.length()< 6){
                    mPassword.setError("Password is required and must be 6 or more characters long");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);

                fAuth.signInWithEmailAndPassword(email,password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                      if(task.isSuccessful()){

                         CollectionReference collectionReference = fStore.collection("Users");
                          Map<String, String> user = new HashMap<>();
                          user.put("password", mPassword.getText().toString());
                          user.put("email",mEmail.getText().toString());
                          


                          collectionReference.add(user);

                          Toast.makeText(Login.this,"Logged in Successfully",Toast.LENGTH_LONG).show();
                          startActivity(new Intent(getApplicationContext(), MainActivity2.class));
                          finish();
                      } else {
                          Toast.makeText(Login.this,"Something went wrong, please check the details given"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                      progressBar.setVisibility(View.GONE);
                      }
                    }
                });

            }
        });

    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();

    }
}