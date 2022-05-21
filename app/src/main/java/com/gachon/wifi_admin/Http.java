package com.gachon.wifi_admin;

import android.os.Message;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Http extends Thread{
    String mURL = null;
    String body = null;
    MainActivity.MyHandler mhandler = null;

    public Http(String input, MainActivity.MyHandler handler){

        body = input;

        mURL = "http://ec2-3-142-225-181.us-east-2.compute.amazonaws.com:8080/quest";

        mhandler = handler;
    }

    public static String httpPostBodyConnection(String UrlData, String ParamData) {

        String result = "";
        String line = null;
        InputStream in = null;
        BufferedReader reader = null;
        try{

            URL url = new URL(UrlData);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setDoInput(true);
            con.setUseCaches(false);
            con.setReadTimeout(1000);
            con.setConnectTimeout(1000);
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true); //OutputStream을 사용해서 post body 데이터 전송

            try(OutputStream os = con.getOutputStream()) {
                byte[] input = ParamData.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            con.connect();

            int responseCode = con.getResponseCode();
            Log.d("http","responsecode : "+responseCode);
            Log.d("http","response : "+con.getResponseMessage());

            con.setInstanceFollowRedirects(true);

            if(responseCode == HttpsURLConnection.HTTP_OK){

                in = con.getInputStream();

            }else{
                in = con.getErrorStream();
            }

            reader = new BufferedReader(new InputStreamReader(in));
            while((line = reader.readLine())!=null){
                result += line;
            }

            reader.close();

            if(con !=null){
                con.disconnect();
            }

        }catch(Exception e){

            Log.d("error",e.toString());
            result = null;
        }finally{
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        Log.d("http","data : "+result);

        return result;
    }

    @Override
    public void run() {

        String result = httpPostBodyConnection(mURL,body);

        if(result !=null){
            Message message = mhandler.obtainMessage(101,result);
            mhandler.sendMessage(message);
        }else{
            Message message = mhandler.obtainMessage(404,"error");
            mhandler.sendMessage(message);
        }

    }

}
