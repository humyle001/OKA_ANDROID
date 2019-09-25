package oka.codedieux.com.restaurant.operations;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import oka.codedieux.com.restaurant.enums.NetworkType;

public class NetworkOperations {

    private Context context;
    public static String ERROR_STRING = "Unable to communicate with the server at the moment. Please try again later.";
//    public static String SERVER_ADDRESS = "http://192.168.100.6/"; //LORDAW
//    public static String SERVER_ADDRESS = "http://192.168.8.200:8080/"; //LORDAWS
    public static String SERVER_ADDRESS = "http://3.13.188.196/"; //LORDAW
    private final String USER_AGENT = "Mozilla/5.0";
    boolean isRequested = false;
    String versionNo;
    long userID;

    public NetworkOperations(Context context) {
        this.context = context;

    }

    public NetworkType getNetworkType() {
        NetworkType networkType = null;

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected()) {

                    networkType = NetworkType.WIFI;
                    break;
                }
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected()) {

                    networkType = NetworkType.GPRS;
                    break;
                }
        }
        return networkType;
    }

    public String pushToServer(String parameterValues, String pageAddress) {
        StringBuffer response = null;
        String inputLine = null;
        String url = SERVER_ADDRESS + pageAddress;
        Log.i("Url" , url);
        HttpURLConnection con = null;

        try {
            URL obj = new URL(url);
            con = (HttpURLConnection) obj.openConnection();
            con.setReadTimeout(10000);
            con.setConnectTimeout(250000);

        } catch (MalformedURLException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }


        //add reuqest header
        try {
            con.setRequestMethod("POST");
        } catch (ProtocolException e) {

            e.printStackTrace();
        }
//        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("User-Agent", "Mozilla/5.0 ( compatible ) ");
        con.setRequestProperty("Accept", "*/*");
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = parameterValues;
        //Send POST req
        try {
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();

            int responseCode = con.getResponseCode();
            Log.d("ResponseCode", (String.valueOf(responseCode).toString()));
           
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
			 System.out.println("EXCEPTIONN !!! " + e.toString());

        }



        return String.valueOf(response);
    }





}

