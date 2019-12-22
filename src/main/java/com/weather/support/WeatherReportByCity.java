package com.weather.support;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;

/**
 * FileName: WeatherReportByCity.java
 * Author:   chenhao
 * Date:     2019/11/30 18:54
 * Description: 根据城市名/id查询天气
 */
public class WeatherReportByCity {

    @Value("${project.key}")
    private static String KEY;

    /**
     * 根据城市名获取
     *
     * @param cid
     * @return
     */
    public static String excute(Integer cid) {
        String url =//此处以返回json格式数据示例,所以format=2,以根据城市名称为例,cityName传入中文
                "http://v.juhe.cn/weather/index?format=2&cityname=" + cid + "&key=" + KEY;
        return PureNetUtil.get(url);//通过工具类获取返回数据
    }

    /**
     * 获取返回数据中的一个属性示例,此处以获取今日温度为例
     * "temperature": "8℃~20℃"     今日温度
     *
     * @param city
     * @return
     */
    public static String GetTodayTemperatureByCity(Integer city) {
        String result = excute(city);
        if (result != null) {
            JSONObject obj = JSONObject.fromObject(result);
            /*获取返回状态码*/
            result = obj.getString("resultcode");
            /*如果状态码是200说明返回数据成功*/
            if (result != null && result.equals("200")) {
                result = obj.getString("result");
            }else{
                return "";
            }
        }
        return result;
    }
}