package com.example.subintel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.subintel.model.Sub;
import com.example.subintel.model.viewmodel.SubViewModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class SearchScreen extends AppCompatActivity {

    private SubViewModel subViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_screen);
        subViewModel = ViewModelProviders.of(this).get(SubViewModel.class);
        subViewModel.searchByNameSub.observe(this, new Observer<List<Sub>>() {
            @Override
            public void onChanged(List<Sub> subs) {
                String listAsString = "";
                for (Sub sub : subs) {
                    listAsString += sub.getSubName() + " - Price: " + sub.getSubPrice()+ " - Date Due: " + sub.getSubDate() + "\n";
                }
                TextView tv = findViewById(R.id.search_results_output);
                tv.setText(listAsString);
            }
        });
    }

    public void processSearch(View view) {
        EditText searchField = findViewById(R.id.search_field);
        String searchText = searchField.getText().toString();
        subViewModel.filterLiveData.setValue(searchText);
    }

    public void loadSettings(View view) {
        Intent settingsScreen = new Intent(this, SettingsScreen.class);
        startActivityForResult(settingsScreen, 0);
    }
    public void loadHome(View view) {
        Intent mainActivity = new Intent(this, MainActivity.class);
        startActivityForResult(mainActivity, 0);
    }
}