package br.edu.puccampinas.coin;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.os.AsyncTask;

import java.util.ArrayList;

public class Main extends AppCompatActivity {

    private String text;
    private ListView listView;
    private SwipeRefreshLayout swipeLayout;
    private ArrayList<Coin> coins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.lvCoin);

        carregar();

        final SwipeRefreshLayout swipeRefreshLayout=(SwipeRefreshLayout)findViewById(R.id.activity_main_swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                carregar();
                swipeRefreshLayout.setRefreshing(false);
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Coin coin = (Coin) parent.getItemAtPosition(position);
                Intent intent = new Intent(getApplicationContext(),Details.class);
                intent.putExtra("coin",coin);
                startActivity(intent);
            }
        });
    }

    private void carregar(){
        new getCoins().execute();
    }

    private class getCoins extends AsyncTask<Void,Void,String>{

        @Override
        protected String doInBackground(Void... params) {
            String text = Connection.getJson(Address.coinMarket);
            return text;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            coins = Parse.convertToCoin(result);
            ArrayAdapterCoin adapterCoin = new ArrayAdapterCoin(Main.this,coins);
            listView.setAdapter(adapterCoin);
        }
    }
}