package br.edu.puccampinas.coin;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;


/**
 * Created by aluno on 10/10/16.
 */
public class Parse {
    public static ArrayList<Coin> convertToCoin(String jsonString){
        if(jsonString != null){
            try {
                ArrayList<Coin> coins = new ArrayList<Coin>();
                Gson gson = new Gson();
                Coin coin;
                JsonArray jsonArray = gson.fromJson(jsonString, JsonArray.class);
                for (int i = 0; i < jsonArray.size(); i++) {
                    JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
                    coin = gson.fromJson(jsonObject, Coin.class);
                    coins.add(coin);
                   // System.out.println(coins.get(i).getName());
                }
                return coins;
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }
    public static Coin convertUniqueCoin(String jsonString){
        if(jsonString != null){
            Gson gson = new Gson();
            Coin coin = gson.fromJson(jsonString, Coin.class);
            return coin;
        }
        return null;
    }

}
