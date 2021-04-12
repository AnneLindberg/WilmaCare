package com.example.wilmacare.ui.resident;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.wilmacare.user.User;

import java.util.List;

public class ResidentViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private List<User> user;

    public ResidentViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
