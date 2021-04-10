package com.example.wilmacare.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.wilmacare.user.User;

import java.util.List;

public class ProfileViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private List<User> user;

    public ProfileViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}