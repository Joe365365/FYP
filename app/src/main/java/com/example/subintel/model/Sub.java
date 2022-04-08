package com.example.subintel.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Sub {
    @PrimaryKey
    @NonNull
    private String subName;

    @NonNull
    private String subPrice;

    @NonNull
    private String subDate;


    public Sub (@NonNull String subName, @NonNull String subPrice, @NonNull String subDate) {
        this.subName = subName;
        this.subPrice = subPrice;
        this.subDate = subDate;

    }

    public String getSubName() {
        return subName;
    }

    public String getSubPrice() {
        return subPrice;
    }

    public String getSubDate() {return subDate; }


}