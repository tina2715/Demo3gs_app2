package com.udgs123.demo3gs.ui.lichsulophoc;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LichsulophocViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public LichsulophocViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("a");
    }

    public LiveData<String> getText() {
        return mText;
    }
}