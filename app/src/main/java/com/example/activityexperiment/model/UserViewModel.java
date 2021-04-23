package com.example.activityexperiment.model;

import com.example.activityexperiment.bean.User;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserViewModel extends ViewModel {

    private final MutableLiveData<User> user = new MutableLiveData<>();

    public void setUser(User item) {
        user.setValue(item);
    }

    public LiveData<User> getUser() {
        return user;
    }

}
