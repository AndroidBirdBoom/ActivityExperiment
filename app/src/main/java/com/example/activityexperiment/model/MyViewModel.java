package com.example.activityexperiment.model;

import com.example.activityexperiment.bean.User;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<List<User>> users;

    public LiveData<List<User>> getUsers() {
        if (users == null) {
            users = new MutableLiveData<>();
            loadUsers();
        }
        return users;
    }

    public void setUsers() {
        loadUsers();
    }

    private void loadUsers() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setAge(18 + i);
            user.setName("王二狗：" + i);
            users.add(user);
        }
        this.users.setValue(users);
    }
}
