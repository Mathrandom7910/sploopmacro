package me.just.sploopmacro.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetPageData {
    public static String page(String url){
        StringBuilder text = new StringBuilder();
        try{
            URL url1 = new URL(url);
            HttpURLConnection con = (HttpURLConnection) url1.openConnection();
            con.setRequestMethod("GET");
            if(con.getResponseCode() == 204) return null;
            BufferedReader reader = new BufferedReader(new InputStreamReader(url1.openStream()));
            for(String line; (line = reader.readLine()) != null;){
                text.append(line);
            }
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return text.toString();
    }
}
