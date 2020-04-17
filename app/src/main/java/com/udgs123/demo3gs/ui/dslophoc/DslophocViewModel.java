package com.udgs123.demo3gs.ui.dslophoc;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DslophocViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DslophocViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}