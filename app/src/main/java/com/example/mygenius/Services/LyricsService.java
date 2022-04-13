package com.example.mygenius.Services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mygenius.Database.InterfaceAPIListener;
import com.example.mygenius.Lyrics;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class LyricsService extends Service {

    public static String API_KEY = "f4f2dd7e34msh23aed500d2c0c32p136655jsn243c1d3090e2";
    public static String protocol = "https://";
    public static String URL = "genius.p.rapidapi.com";
    public static String reqParam = "/search?q=";

    public static void searchLyrics(Context context, String searchValue, InterfaceAPIListener listener){

        RequestQueue queue = Volley.newRequestQueue(context); // Vollet bibliotheque qui permet de faire des requetes asynchrones
        StringRequest request= new StringRequest(protocol + URL + reqParam + searchValue,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    ArrayList<Lyrics> lyrics= new ArrayList<Lyrics>();
                    try {
                        JSONObject jsonObject= new JSONObject(response);
                        JSONArray jsonArray= jsonObject.getJSONArray("response.hits");
                        for(int i=0; i<jsonArray.length(); i++){
                            JSONObject object= jsonArray.getJSONObject(i);
                            lyrics.add(Lyrics.jsonToLyrics(object));
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    listener.onReceiveLyrics(lyrics);
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("error is ", "" + error);
                }
            }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("X-RapidAPI-Host", URL);
                params.put("X-RapidAPI-Key", API_KEY);
                return params;
            }
        };
        }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}