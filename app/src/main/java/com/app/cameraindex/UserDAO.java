package com.app.cameraindex;

import android.app.Application;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserDAO {
    private static UserDAO instance;
    private final UserLiveData currentUser;
    private Application app;
    private MutableLiveData<String> authenticationMessage = new MutableLiveData<>(null);
    private FirebaseAuth mAuth;

    public UserDAO(Application app)
    {
        this.app = app;
        this.mAuth = FirebaseAuth.getInstance();
        currentUser = new UserLiveData();
    }
    public static UserDAO getInstance(Application app)
    {
        if(instance == null)
        {
            instance = new UserDAO(app);
        }
        return instance;
    }

    public LiveData<FirebaseUser> getFirebaseUser() {
        return currentUser;
    }

    public MutableLiveData<String> getAuthenticationMessage() {
        return authenticationMessage;
    }

    public void loginUser(String etLoginEmail, String etLoginPassword)
    {
        if (TextUtils.isEmpty(etLoginEmail)) {
            authenticationMessage.postValue("Email cannot be empty");
        } else if (TextUtils.isEmpty(etLoginPassword)) {
            authenticationMessage.postValue("Password cannot be empty");
        }else{
            mAuth.signInWithEmailAndPassword(etLoginEmail, etLoginPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        authenticationMessage.postValue("User is logged in!");
                    }
                }
            });
        }
    }

    public void registerUser(String etRegEmail, String etRegPassword)
    {
        if (TextUtils.isEmpty(etRegEmail)){
            authenticationMessage.postValue("Email cannot be empty");
        } else if (TextUtils.isEmpty(etRegPassword)){
            authenticationMessage.postValue("Password cannot be empty");
        } else {
            mAuth.createUserWithEmailAndPassword(etRegEmail, etRegPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        authenticationMessage.postValue("User registered successfully!");
                    } else {
                        authenticationMessage.postValue("Register error: " + task.getException());
                    }
                }
            });
        }
    }

    public void logOut()
    {
        mAuth.signOut();
    }
}
