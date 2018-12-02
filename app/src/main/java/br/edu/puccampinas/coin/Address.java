package br.edu.puccampinas.coin;

/**
 * Created by aluno on 10/10/16.
 */
public enum Address {
    coinMarket;

    @Override
    public String toString(){
        String URL;
        switch (this){
            case coinMarket: URL = "https://api.coinmarketcap.com/v1/ticker/?limit=30"; break;
            default: URL = null; break;
        }
        return URL;
    }
}
