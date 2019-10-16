package com.yaoyanshe.commonlibrary.util.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.yaoyanshe.commonlibrary.bean.HttpResult;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tck
 * Date: 2018/03/12 18：11
 */

public class GsonUtils {

    public static final Gson GSON;

    static {
        GSON = new GsonBuilder()
                .registerTypeAdapter(String.class, new StringTypeAdapter())
                .registerTypeAdapter(Long.class, new LongTypeAdapter())
                .registerTypeAdapter(Integer.class, new IntegerTypeAdapter())
                .registerTypeAdapter(Double.class, new DoubleTypeAdapter())
                .create();
    }


    public static <T> List<T> jsonToArray(String json, Class<T> cls) {
        List<T> list = new ArrayList<>();
        JsonParser parser = new JsonParser();
        JsonArray jsonArray = parser.parse(json).getAsJsonArray();
        for (JsonElement jsonElement : jsonArray) {
            list.add(GSON.fromJson(jsonElement, cls));
        }
        return list;
    }

    public static <T> T fromJson(String json, Class<T> classOfT) {
        return GSON.fromJson(json, classOfT);
    }

    public static <T> HttpResult<T> fromJson1(String json, Class<T> clazz) {
        Type type = new ParameterizedTypeImpl(HttpResult.class, new Class[]{clazz});
        return GSON.fromJson(json, type);
    }

    public static <T> T fromJson2(String json, Type type) {
        return GSON.fromJson(json, type);
    }


    //对象转换为json
    public static String toJson(Object object) {
        return GSON.toJson(object);
    }

}
