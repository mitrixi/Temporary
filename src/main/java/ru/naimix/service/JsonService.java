package ru.naimix.service;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class JsonService {
    public static JSONObject readJsonFromFile(String path) {
        try (InputStream is = new FileInputStream(path);
             BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            return new JSONObject(readAll(rd));
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static String getUrl(JSONObject jsonObject) throws JSONException {
        return jsonObject.getJSONObject("appium").getString("url");
    }

    public static int getImplicitlyWait(JSONObject jsonObject) throws JSONException {
        return jsonObject.getJSONObject("appium").getInt("implicitlyWait");
    }

    public static JSONObject getCapabilities(JSONObject jsonObject) {
        try {
            return jsonObject.getJSONObject("appium").getJSONObject("capabilities");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
