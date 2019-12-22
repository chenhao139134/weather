package com.weather.support;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * FileName: PureNetUtil.java
 * Author:   chenhao
 * Date:     2019/11/30 18:34
 * Description: 网络工具类
 */
public class PureNetUtil {

    /**
     * get调用post方法
     * @param url
     * @return
     */
    public static String get(String url){
        return post(url, null);
    }

    /**
     * post获取网络资源
     * @param url
     * @param param
     * @return
     */
    private static String post(String url, Map<String, String> param) {
        HttpURLConnection conn = null;
        try {
            URL u = new URL(url);
            conn = (HttpURLConnection) u.openConnection();
            StringBuffer sb = null;
            if(param != null){
                sb = new StringBuffer();
                conn.setDoOutput(true);
                conn.setRequestMethod("POST");
                OutputStream out = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
                for(Map.Entry<String, String> s : param.entrySet()){
                    sb.append(s.getKey()).append(s.getValue()).append("&");
                }
                writer.write(sb.deleteCharAt(sb.toString().length() - 1).toString());
                writer.close();
                sb = null;
            }
            conn.connect();
            sb = new StringBuffer();

            int recode = conn.getResponseCode();
            BufferedReader reader = null;
            if(recode == 200){
                InputStream in = conn.getInputStream();
                reader = new BufferedReader(new InputStreamReader(in));
                String str = null;
                while ((str = reader.readLine()) != null){
                    sb.append(str).append(System.getProperty("line.separator"));
                }
                reader.close();
                if(sb.toString().length() == 0){
                    return null;
                }
                return sb.toString().substring(0, sb.toString().length() - System.getProperty("line.separator").length());
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            if(conn != null){
                conn.disconnect();
            }
        }
        return null;
    }
}