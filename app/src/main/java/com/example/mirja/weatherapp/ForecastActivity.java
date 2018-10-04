package com.example.mirja.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.mirja.weatherapp.models.Forecast;

import java.util.ArrayList;

public class ForecastActivity extends AppCompatActivity {
    ListView mlistView;
    ArrayList<Forecast> forecastArrayList;
    ForcastAdpater forcastAdpater =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);
        setSupportActionBar((android.support.v7.widget.Toolbar) findViewById(R.id.action_bar));


        mlistView=findViewById(R.id.listView);
        forecastArrayList=new ArrayList<>();
        forcastAdpater =new ForcastAdpater(this,R.layout.row,forecastArrayList);
        mlistView.setAdapter(forcastAdpater);
        //get data now from stream




    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }
}
