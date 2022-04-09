package com.example.subintel.model.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.example.subintel.model.Sub;
import com.example.subintel.model.SubRepo;

import java.util.List;

public class SubViewModel extends AndroidViewModel {

    private SubRepo repo;
    private LiveData<List<Sub>> allSubs;

    public LiveData<List<Sub>> searchByNameSub;
    public MutableLiveData<String> filterLiveData = new MutableLiveData<>();

    public SubViewModel(@NonNull Application application) {
        super(application);
        repo = new SubRepo(application);
        allSubs = repo.getAllSubs();
        searchByNameSub = Transformations.switchMap(filterLiveData,
                name -> repo.getSubsByName(name));
    }
    public LiveData<List<Sub>> getAllSubs() {
        return  allSubs;
    }

    public void insert (Sub sub) {
        repo.insert(sub);
    }

    public void deleteAll() {repo.deleteAll();}
}
