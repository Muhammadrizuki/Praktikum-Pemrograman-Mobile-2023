package com.example.applicationfragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private static final MutableLiveData<Parcable>data = new MutableLiveData<>();

    public static void setData(Parcable parcable){
        data.setValue(parcable);
    }

    public LiveData<Parcable> getData(){
        return data;
    }
}
