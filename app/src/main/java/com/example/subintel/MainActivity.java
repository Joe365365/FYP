package com.example.subintel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


import com.example.subintel.model.Sub;
import com.example.subintel.model.viewmodel.SubViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SubViewModel subViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        subViewModel = ViewModelProviders.of(this).get(SubViewModel.class);
        subViewModel.getAllSubs().observe(this, new Observer<List<Sub>>(){

            @Override
            public void onChanged(List<Sub> subs) {
                String listAsString = "";
                for (Sub contact : subs) {
                    listAsString += contact.getSubName()+"\n"+"Price: "+contact.getSubPrice()+"\n"+ "Date Due is:" +contact.getSubDate()+"\n";
                }
                TextView tv = findViewById(R.id.sub_details);
                tv.setText(listAsString);
            }
        });
    }

    @Override
    public void onActivityResult (int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String subName = data.getStringExtra("subNameFromAddNew");
        String subPrice = data.getStringExtra("subPriceFromAddNew");
        String subDate = data.getStringExtra("subDateFromAddNew");
        Sub newSub = new Sub (subName, subPrice, subDate);
        subViewModel.insert(newSub);

    }



    public void loadAddNewSub(View view) {
        Intent addNewSub = new Intent(this, AddNewSubScreen.class);
        startActivityForResult(addNewSub, 0);
    }


}