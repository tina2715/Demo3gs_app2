package com.udgs123.demo3gs.ui.lopchonhan;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LopchonhanViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public LopchonhanViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is lớp chờ nhận fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}