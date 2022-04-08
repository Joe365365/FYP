package com.example.subintel.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SubDao {
    @Insert
    void insert(Sub sub);

    @Query("SELECT * FROM Sub ORDER BY subName ASC")
    LiveData<List<Sub>> getAllSubs();

    @Query("SELECT * FROM Sub WHERE subName LIKE '%' || :subName || '%' ORDER by subName ASC")
    LiveData<List<Sub>> getSubByName(String subName);
}
