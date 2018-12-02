package br.edu.puccampinas.coin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        Coin coin = (Coin) intent.getSerializableExtra("coin");
        TextView name = (TextView) findViewById(R.id.tvName);
        name.setText(coin.getName());
        TextView priced = (TextView) findViewById(R.id.tvPrice);
        priced.setText(coin.getPrice_usd().toString());
        TextView priceb = (TextView) findViewById(R.id.tvPriceb);
        priceb.setText(coin.getPrice_btc().toString());
        TextView volume = (TextView) findViewById(R.id.tv24hVol);
        volume.setText(coin.getVolume_usd_24h().toString());
        TextView marketCap = (TextView) findViewById(R.id.tvMarketCap);
        marketCap.setText(coin.getMarket_cap_usd().toString());
        TextView avaiable = (TextView) findViewById(R.id.tvAvaiable);
        avaiable.setText(coin.getAvailable_supply().toString());
        TextView total = (TextView) findViewById(R.id.tvTotal);
        total.setText(coin.getTotal_supply().toString());
        TextView pct1h = (TextView) findViewById(R.id.tvPct1h);
        pct1h.setText(coin.getPercent_change_1h().toString());
        TextView pct24h = (TextView) findViewById(R.id.tvPct24h);
        pct24h.setText(coin.getPercent_change_24h().toString());
        TextView pct7d = (TextView) findViewById(R.id.tvPct7d);
        pct7d.setText(coin.getPercent_change_7d().toString());
        TextView update = (TextView) findViewById(R.id.tvLastUpdate);
        update.setText(convDate(coin.getLast_updated()));
    }
    private String convDate(Double unixTime){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); // the format of your date
        sdf.setTimeZone(TimeZone.getTimeZone("GMT-3")); // give a timezone reference for formating (see comment at the bottom
        return sdf.format(unixTime*1000);
    }
}
