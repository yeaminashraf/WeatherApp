package com.example.mirja.weatherapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.mirja.weatherapp.api_interfaces.WeatherApis;
import com.example.mirja.weatherapp.models.Channel;
import com.example.mirja.weatherapp.utils.RetrofitClients;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    WeatherApis weatherApis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar((android.support.v7.widget.Toolbar) findViewById(R.id.action_bar));
      getServerData();

    }

    private void getServerData() {
        weatherApis= RetrofitClients.getRetrofitClinets().create(WeatherApis.class);
        Call<Channel> channelCall=weatherApis.getWeatherById();
        channelCall.enqueue(new Callback<Channel>() {
            @Override
            public void onResponse(Call<Channel> call, Response<Channel> response) {
                Channel channel=response.body();

            }

            @Override
            public void onFailure(Call<Channel> call, Throwable t) {

            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.forscate:
                Intent intent=new Intent(MainActivity.this,ForecastActivity.class);
                startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }

}
