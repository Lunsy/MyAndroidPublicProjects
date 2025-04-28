package com.example.counterapp;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel{

    private int count = 1;
    private MutableLiveData<Integer> countLiveData = new MutableLiveData<>();

    public void getDecreaseValue(){
        --count;
        countLiveData.setValue(count);
    }
    public void getIncreaseValue(){
         ++count;
        countLiveData.setValue(count);
    }

    public MutableLiveData<Integer> getCurrentValue(){
        countLiveData.setValue(count);
        return countLiveData;
    }
}
