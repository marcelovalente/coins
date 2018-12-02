package br.edu.puccampinas.coin;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.drawable.Drawable;


import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Tales on 13/10/2016.
 */
public class ArrayAdapterCoin extends ArrayAdapter<Coin>{

    private Context context;
    private ArrayList<Coin> lista;
    private TextView txtUrl;


    public ArrayAdapterCoin(Context context, ArrayList<Coin> lista){
        super(context,0,lista);
        this.context = context;
        this.lista = lista;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Coin InfoCoinPosicao = this.lista.get(position);

        convertView = LayoutInflater.from(this.context).inflate(R.layout.item_coin,null);

        TextView rank = (TextView) convertView.findViewById(R.id.tvRankInfo);
        rank.setText(InfoCoinPosicao.getRank().toString());

        TextView name = (TextView) convertView.findViewById(R.id.tvNameInfo);
        name.setText(InfoCoinPosicao.getName());

        String url = "https://coinmarketcap.com/static/img/coins/16x16/"+InfoCoinPosicao.getId()+".png";
        ImageView imgView =(ImageView)convertView.findViewById(R.id.ivImage);
        Picasso.with(context).load(url).into(imgView);

        TextView price = (TextView) convertView.findViewById(R.id.tvPriceInfo);
        price.setText("$"+InfoCoinPosicao.getPrice_usd().toString());

        convertView.setPaddingRelative(0,30,0,30);

        return convertView;
    }
}
