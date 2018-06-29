package com.coolweather.android.util;

import android.text.TextUtils;
import com.coolweather.android.db.City;
import com.coolweather.android.db.County;
import com.coolweather.android.db.Province;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utility {
//处理省级数据
    public static boolean handleProvinceReSponse(String response){

        try {
            if(!TextUtils.isEmpty(response)) {
                JSONArray jsonArray = new JSONArray(response);
                for (int i=0;i<jsonArray.length();i++) {
                    JSONObject object=jsonArray.getJSONObject(i);
                    Province province=new Province();
                    province.setProvinceCode(object.getInt("id"));
                    province.setProvinceName(object.getString("name"));
                     province.save();
                }
                return  true;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    return  false;
    }//处理市级数据
    public static boolean handleCityReSponse(String response,int provinceId){

        try {
            if(!TextUtils.isEmpty(response)) {
                JSONArray jsonArray = new JSONArray(response);
                for (int i=0;i<jsonArray.length();i++) {
                    JSONObject object=jsonArray.getJSONObject(i);
                    City city=new City();
                  city.setCityCode(object.getInt("id"));
                    city.setCityName(object.getString("name"));
                    city.setProvinceId(provinceId);
                     city.save();
                }
                return  true;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    return  false;
    }
    //处理县级数据
    public static boolean handleCountyReSponse(String response,int cityId){

        try {
            if(!TextUtils.isEmpty(response)) {
                JSONArray jsonArray = new JSONArray(response);
                for (int i=0;i<jsonArray.length();i++) {
                    JSONObject object=jsonArray.getJSONObject(i);
                    County county=new County();
                    county.setWeatherId(object.getString("weather_id"));
                    county.setCountyName(object.getString("name"));
                    county.setCityId(cityId);
                    county.save();
                }
                return  true;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    return  false;
    }
}
