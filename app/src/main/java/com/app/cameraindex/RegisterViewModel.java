package com.app.cameraindex;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.auth.FirebaseUser;

public class RegisterViewModel extends AndroidViewModel {

    private UserDAO userDAO;

    public RegisterViewModel(Application app)
    {
        super(app);
        userDAO = UserDAO.getInstance(app);
    }

    public MutableLiveData<String> getAuthenticationMessage()
    {
        return userDAO.getAuthenticationMessage();
    }

    public void registerUser(String etRegEmail, String etRegPassword){
        userDAO.registerUser(etRegEmail,etRegPassword);
    }

    public LiveData<FirebaseUser> getFirebaseUser()
    {
        return userDAO.getFirebaseUser();
    }
}
