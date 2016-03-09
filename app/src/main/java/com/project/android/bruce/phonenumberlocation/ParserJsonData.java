package com.project.android.bruce.phonenumberlocation;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by shuai on 2016/3/10.
 *
 * {
 "errNum": 0,
 "retMsg": "success",
 "retData": {
 "phone": "15210011578",
 "prefix": "1521001",
 "supplier": "移动 ",
 "province": "北京 ",
 "city": "北京 ",
 "suit": "152卡"
 }
 }
 */
public class ParserJsonData {

    public static final String TAG_JSON = "JSON解析类";

    public NumberData parserTool(String jsonData){

        NumberData numberData = new NumberData();

        try {
            JSONObject jsonObject1 = new JSONObject(jsonData);

            Log.d(TAG_JSON,jsonObject1.getString("errNum"));
            Log.d(TAG_JSON,jsonObject1.getString("retMsg"));

            JSONObject jsonObject2 = jsonObject1.getJSONObject("retData");
            numberData.setPhoneNumber(jsonObject2.getString("phone"));
            numberData.setPrefix(jsonObject2.getString("prefix"));
            numberData.setNumberSupplier(jsonObject2.getString("supplier"));
            numberData.setNumberProvince(jsonObject2.getString("province"));
            numberData.setNumberCity(jsonObject2.getString("city"));
            numberData.setNumberSuit(jsonObject2.getString("suit"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return numberData;
    }
}
