package com.app.cameraindex;

import android.app.Application;
import android.appwidget.AppWidgetProvider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.auth.FirebaseUser;

public class MainActivityViewModel extends AndroidViewModel {
    private UserDAO userDAO;

    public MainActivityViewModel(Application app)
    {
        super(app);
        userDAO = UserDAO.getInstance(app);
    }

    public LiveData<FirebaseUser> getFirebaseUser() {
        return userDAO.getFirebaseUser();
    }

    public MutableLiveData<String> getAuthenticationMessage() {
        return userDAO.getAuthenticationMessage();
    }

    public void logOut(){
        userDAO.logOut();
    }

}
