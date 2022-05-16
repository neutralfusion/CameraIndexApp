package com.app.cameraindex;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.auth.FirebaseUser;

public class LoginViewModel extends AndroidViewModel {

    private UserDAO userDAO;

    public LoginViewModel(Application app)
    {
        super(app);
        userDAO = UserDAO.getInstance(app);
    }

    public void loginUser(String etLoginEmail, String etLoginPassword)
    {
        userDAO.loginUser(etLoginEmail,etLoginPassword);
    }

    public LiveData<FirebaseUser> getFirebaseUser() {
        return userDAO.getFirebaseUser();
    }

    public MutableLiveData<String> getAuthenticationMessage() {
        return userDAO.getAuthenticationMessage();
    }

}
