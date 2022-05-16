package com.app.cameraindex;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

public class SecondViewModel extends AndroidViewModel {
    private UserDAO userDAO;
    public SecondViewModel(Application app)
    {
        super(app);
        userDAO = UserDAO.getInstance(app);
    }

    public void logOut(){
        userDAO.logOut();
    }
}
