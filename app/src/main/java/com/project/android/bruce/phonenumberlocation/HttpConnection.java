package com.project.android.bruce.phonenumberlocation;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by shuai on 2016/3/9.
 */
public class HttpConnection {

    /*
     http://apis.baidu.com/apistore/mobilenumber/mobilenumber?phone=输入的电话号码
     */

    public String requestData(String number) {

        String responseData = null;
        String address = "http://apis.baidu.com/apistore/mobilenumber/mobilenumber?phone="+number;
        try {
            URL url = new URL(address);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("apikey", "0ca2ecf99594a5168d5887f9d4498b4a");//设置自己的apikey
            connection.setConnectTimeout(1000 * 5);
            connection.setReadTimeout(1000 * 5);
            connection.connect();

            InputStream in = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            StringBuffer sb = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                responseData = sb.append(line).toString();
            }

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        return responseData;
    }
}
