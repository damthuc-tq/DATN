package com.example.iwash.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.iwash.R;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MotorcycleWashSeviceActivity extends AppCompatActivity {

    TextView tvLocal;
    AutoCompleteTextView vehicles;
    TextView textViewDate, textViewTime;
    Button btnSchedule;
    Calendar calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motorcycle_wash_sevice);
        tvLocal = findViewById(R.id.tvStoreAddress);
        vehicles = findViewById(R.id.choose_vhicles);
        textViewDate = findViewById(R.id.textViewDate);
        textViewTime = findViewById(R.id.textViewTime);
        btnSchedule = findViewById(R.id.btnSchedule);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        calendar = Calendar.getInstance();
        Time time = new Time(calendar.getTime().getHours(), calendar.getTime().getMinutes(), calendar.getTime().getSeconds());
        textViewTime.setText(new SimpleDateFormat("hh:mm:a").format(time));
        setUpSpin();
        Date date = new Date(Calendar.getInstance().getTime().getYear(), Calendar.getInstance().getTime().getMonth(), Calendar.getInstance().getTime().getDate());
        textViewDate.setText(new SimpleDateFormat("dd/MM/YYYY").format(date));
    }
    public void chooseAdress(View view) {
        startActivity(new Intent(this, MapsActivity.class));
    }

    String[] data = {"22B1-032 74", "22S2-02386"};

    public void setUpSpin() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        vehicles.setAdapter(adapter);
    }

    public void chooseDate(View view) {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Date date = new Date(year, monthOfYear, dayOfMonth);
                textViewDate.setText(new SimpleDateFormat("dd/MM/YYYY").format(date));
            }
        };
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                dateSetListener, 2021, 1, 1);
        datePickerDialog.show();
    }

    public void chooTime(View view) {
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Time time = new Time(hourOfDay, minute, 0);
                textViewTime.setText(new SimpleDateFormat("hh:mm:a").format(time));
            }
        };
        TimePickerDialog dialog = new TimePickerDialog(this, timeSetListener, 0, 0, true);
        dialog.show();
    }
}