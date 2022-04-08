package com.example.subintel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class AddNewSubScreen extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private TextView dateText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_sub_screen);
        dateText = findViewById(R.id.dateText);

        findViewById(R.id.calendarSelect).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                showDatePickerDialog();
            }

        });
    }

    public void showDatePickerDialog(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)

                );
        datePickerDialog.show();
    }
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = dayOfMonth + "/" + month + "/" + year;
        dateText.setText(date);
    }

    public void insertNewSub(View view) {
        EditText subField = findViewById(R.id.editTextSubName);
        String subName = subField.getText().toString();
        EditText priceField = findViewById(R.id.editTextPrice);
        String subPrice = priceField.getText().toString();
        TextView dateField = findViewById(R.id.dateText);
        String subDate = dateField.getText().toString();


        Intent replyIntent = new Intent();
        replyIntent.putExtra("subNameFromAddNew", subName);
        replyIntent.putExtra("subPriceFromAddNew", subPrice);
        replyIntent.putExtra("subDateFromAddNew", subDate);
        setResult(RESULT_OK, replyIntent);

        finish();
    }


}