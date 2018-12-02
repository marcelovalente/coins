package br.edu.puccampinas.coin;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by aluno on 10/10/16.
 */
public class Connection{

    private static String convertInputStreamToString(InputStream is){

        StringBuilder stringBuilder = new StringBuilder();
        try{

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
            String line;

            while((line = bufferedReader.readLine()) != null){
                stringBuilder.append(line + "\n");
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        //System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    public static String getJson(Address address) {
        String text = null;
        InputStream is = null;
        HttpsURLConnection connection = null;
        try{
            URL url = new URL(address.toString());
            connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(15000);
            connection.setConnectTimeout(15000);
            connection.setDoInput(true);

            is = connection.getInputStream();
            text = convertInputStreamToString(is);

            is.close();
            connection.disconnect();

        }catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }
}