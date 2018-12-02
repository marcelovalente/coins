package br.edu.puccampinas.coin;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by aluno on 10/10/16.
 */

public class Coin implements Serializable {

    private String id;
    private String name;
    private String symbol;
    private Integer rank;
    private Double price_usd;
    private Double price_btc;

    @Override
    public String toString() {
        return "Coin{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", rank=" + rank +
                ", price_usd=" + price_usd +
                ", price_btc=" + price_btc +
                ", volume_usd_24h=" + volume_usd_24h +
                ", market_cap_usd=" + market_cap_usd +
                ", available_supply=" + available_supply +
                ", total_supply=" + total_supply +
                ", percent_change_1h=" + percent_change_1h +
                ", percent_change_24h=" + percent_change_24h +
                ", percent_change_7d=" + percent_change_7d +
                ", last_updated=" + last_updated +
                '}';
    }

    @SerializedName("24h_volume_usd")
    private Double volume_usd_24h;
    private Double market_cap_usd;
    private Double available_supply;
    private Double total_supply;
    private Double percent_change_1h;
    private Double percent_change_24h;
    private Double percent_change_7d;
    private Double last_updated;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Double getPrice_usd() {
        return price_usd;
    }

    public void setPrice_usd(Double price_usd) {
        this.price_usd = price_usd;
    }

    public Double getPrice_btc() {
        return price_btc;
    }

    public void setPrice_btc(Double price_btc) {
        this.price_btc = price_btc;
    }

    public Double getVolume_usd_24h() {
        return volume_usd_24h;
    }

    public void setVolume_usd_24h(Double volume_usd_24h) {
        this.volume_usd_24h = volume_usd_24h;
    }

    public Double getMarket_cap_usd() {
        return market_cap_usd;
    }

    public void setMarket_cap_usd(Double market_cap_usd) {
        this.market_cap_usd = market_cap_usd;
    }

    public Double getAvailable_supply() {
        return available_supply;
    }

    public void setAvailable_supply(Double available_supply) {
        this.available_supply = available_supply;
    }

    public Double getTotal_supply() {
        return total_supply;
    }

    public void setTotal_supply(Double total_supply) {
        this.total_supply = total_supply;
    }

    public Double getPercent_change_1h() {
        return percent_change_1h;
    }

    public void setPercent_change_1h(Double percent_change_1h) {
        this.percent_change_1h = percent_change_1h;
    }

    public Double getPercent_change_24h() {
        return percent_change_24h;
    }

    public void setPercent_change_24h(Double percent_change_24h) {
        this.percent_change_24h = percent_change_24h;
    }

    public Double getPercent_change_7d() {
        return percent_change_7d;
    }

    public void setPercent_change_7d(Double percent_change_7d) {
        this.percent_change_7d = percent_change_7d;
    }

    public Double getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(Double last_updated) {
        this.last_updated = last_updated;
    }
}
