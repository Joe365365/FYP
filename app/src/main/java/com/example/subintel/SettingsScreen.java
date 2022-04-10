package com.example.subintel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;
import com.example.subintel.model.Sub;
import com.example.subintel.model.viewmodel.SubViewModel;




public class SettingsScreen extends AppCompatActivity {

    private SubViewModel subViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_screen);
        subViewModel = ViewModelProviders.of(this).get(SubViewModel.class);

    }
    public void selectedDelete (View view) {
        findViewById(R.id.clear_data).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                subViewModel.deleteAll();
            }

        });


    }

    public void loadHome(View view) {
        Intent mainActivity = new Intent(this, MainActivity.class);
        startActivityForResult(mainActivity, 0);
    }
    public void loadSearch(View view) {
        Intent searchScreen = new Intent(this, SearchScreen.class);
        startActivityForResult(searchScreen, 0);
    }





}