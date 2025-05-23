package com.example.mymegaawesomechat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignInActivity extends AppCompatActivity {

    private static final  String TAG = "SingInActivity";
    private FirebaseAuth auth;

    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText repeatPasswordEditText;
    private EditText nameEditText;
    private Button loginSignUpButton;
    private TextView toggleLoginSignUpTextView;

    private boolean loginModeActive;

    FirebaseDatabase database;
    DatabaseReference usersDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance(
                "https://firstfirebaseandroidproj-6bc5e-default-rtdb.asia-southeast1.firebasedatabase.app/");
        usersDatabaseReference = database.getReference().
                child("users");

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        repeatPasswordEditText = findViewById(R.id.repeatPasswordEditText);
        nameEditText = findViewById(R.id.nameEditText);
        loginSignUpButton = findViewById(R.id.loginSignUpButton);
        toggleLoginSignUpTextView = findViewById(R.id.toggleLoginSignUpTextView);

        loginSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginSignUpUser(emailEditText.getText().toString().trim(),
                        passwordEditText.getText().toString().trim());
            }
        });

        if(auth.getCurrentUser() != null){
            startActivity(new Intent(SignInActivity.this, UserListActivity.class));
        }
    }

    private void loginSignUpUser(String email, String password) {

        if(loginModeActive){
            if (passwordEditText.getText().toString().trim().length() < 7){
            Toast.makeText(this, "Password too short, it must be at least 7 " +
                    "characters", Toast.LENGTH_SHORT).show();
            } else  if (emailEditText.getText().toString().trim().equals("")){
                Toast.makeText(this, "Please input your email" +
                        "characters", Toast.LENGTH_SHORT).show();
            } else {
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "signInWithEmail:success");
                                    FirebaseUser user = auth.getCurrentUser();
                                    Intent intent = new Intent(SignInActivity.this,
                                            UserListActivity.class);
                                    intent.putExtra("userName",
                                            nameEditText.getText().toString().trim());
                                    startActivity(intent);
    //                                updateUI(user);
                                } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "signInWithEmail:failure", task.getException());
                                Toast.makeText(SignInActivity.this,
                                        "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
//                                updateUI(null);
                            }
                        }
                    });
            }
        } else {
            if (!passwordEditText.getText().toString().trim().equals(
                    repeatPasswordEditText.getText().toString().trim()
            )){
                Toast.makeText(this, "Passwords don't match", Toast.LENGTH_SHORT).show();
            } else  if (passwordEditText.getText().toString().trim().length() < 7){
                Toast.makeText(this, "Password too short, it must be at least 7 " +
                        "characters", Toast.LENGTH_SHORT).show();
            } else  if (emailEditText.getText().toString().trim().equals("")){
            Toast.makeText(this, "Please input your email" , Toast.LENGTH_SHORT).show();
            } else {
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's
                                    // information
                                    Log.d(TAG, "createUserWithEmail:success");
                                    FirebaseUser user = auth.getCurrentUser();
                                    createUser(user);
                                    // updateUI(user);
                                    Intent intent = new Intent(SignInActivity.this,
                                            UserListActivity.class);
                                    intent.putExtra("userName",
                                            nameEditText.getText().toString().trim());
                                    startActivity(intent);


                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "createUserWithEmail:failure",
                                            task.getException());
                                    Toast.makeText(SignInActivity.this,
                                            "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                                }
                            }
                        });
            }
        }

    }

    private void createUser(FirebaseUser firebaseUser) {
        User user = new User();
        user.setId(firebaseUser.getUid());
        user.setEmail(firebaseUser.getEmail());
        user.setName(nameEditText.getText().toString().trim());

        usersDatabaseReference.push().setValue(user);
    }

    public void toggleLoginMode(View view) {

        if(loginModeActive){
            loginModeActive = false;
            loginSignUpButton.setText("Sing Up");
            toggleLoginSignUpTextView.setText("or, Log In");
            passwordEditText.setHint("Create Your Password");
            repeatPasswordEditText.setVisibility(View.VISIBLE);
        } else {
            loginModeActive = true;
            loginSignUpButton.setText("Log In");
            toggleLoginSignUpTextView.setText("or, Sign Up");
            passwordEditText.setHint("Enter Your Password");
            repeatPasswordEditText.setVisibility(View.GONE);
        }

    }
}