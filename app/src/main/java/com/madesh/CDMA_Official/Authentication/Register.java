package com.madesh.CDMA_Official.Authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.madesh.CDMA_Official.MainActivity2;
import com.madesh.CDMA_Official.MainActivity3;
import com.madesh.CDMA_Official.R;
import com.madesh.CDMA_Official.Utility.Users;

import io.reactivex.annotations.NonNull;

public class Register extends AppCompatActivity {

EditText fullName, mEmail, mPassword,phone;
Button regBut;
TextView loginText;
FirebaseAuth firebaseAuth;
ProgressBar progressBar;
FirebaseFirestore fStore;
String userId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        fullName = findViewById(R.id.FullName);
        mEmail = findViewById(R.id.emailtext);
        mPassword = findViewById(R.id.password);
        phone = findViewById(R.id.phonenumber);
        regBut = findViewById(R.id.reg_but);
        loginText = findViewById(R.id.regText1);
        progressBar = findViewById(R.id.progressBarReg);
        firebaseAuth =FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        if (firebaseAuth.getCurrentUser()!= null){
            startActivity(new Intent(getApplicationContext(), MainActivity2.class));
            finish();
        }

        loginText = findViewById(R.id.regText1);
        loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Login.class));
                finish();
            }
        });
        regBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = mEmail.getText().toString().trim();
                String password1 = mPassword.getText().toString();
                String ullName = fullName.getText().toString().trim();
                String hone = phone.getText().toString();

                if (TextUtils.isEmpty(hone)){
                    phone.setError("Phone Number is required");
                    return;
                }

                if (TextUtils.isEmpty(ullName)){
                    fullName.setError("Full Name is required");
                    return;
                }

                if (TextUtils.isEmpty(email)){
                    mEmail.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(password1) || password1.length()< 6){
                    mPassword.setError("Password is required and must be 6 or more characters long");
                    return;
                }


                progressBar.setVisibility(View.VISIBLE);

                firebaseAuth.createUserWithEmailAndPassword(email,password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){

                            FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                            firebaseUser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(Register.this,"Verification Email has been sent",Toast.LENGTH_SHORT).show();

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(Register.this,e.toString(),Toast.LENGTH_LONG).show();
                                }
                            });




                            Toast.makeText(Register.this,"Successfully registered",Toast.LENGTH_LONG).show();
                            userId = firebaseAuth.getCurrentUser().getUid();
                            CollectionReference dbProducts = fStore.collection("Users");
                            Users users = new Users(
                                    ullName,email,password1,hone
                            );

                            dbProducts.add(users)
                                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                        @Override
                                        public void onSuccess(DocumentReference documentReference) {
                                            Log.d("SUCCESS","onSuccess: user id is created for"+ userId);
                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d("FAIL"," OnFailure"+ e.toString());
                                }
                            });




                            startActivity(new Intent(getApplicationContext(), MainActivity3.class));
                            finish();
                        }else {
                            Toast.makeText(Register.this,"Something went wrong, please check the given details "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
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