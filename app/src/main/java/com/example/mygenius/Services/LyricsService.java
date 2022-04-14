package com.example.mygenius.Services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.Request.Method;
import com.example.mygenius.Database.InterfaceAPIListener;
import com.example.mygenius.Lyrics;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class LyricsService extends Service {

    public static String API_KEY = "f4f2dd7e34msh23aed500d2c0c32p136655jsn243c1d3090e2";
    public static String URL = "https://lyrics-search.p.rapidapi.com/search/lyrics";
    public static String headerURL = "lyrics-search.p.rapidapi.com";
    private static final String TAG = "My debug";

    public static void searchLyrics(Context context, String searchValue, InterfaceAPIListener listener){
        RequestQueue queue= Volley.newRequestQueue(context);

        Map<String, String> jsonParams = new HashMap<String, String>();
        jsonParams.put("searchTerm", searchValue);

        JsonObjectRequest postRequest = new JsonObjectRequest(Request.Method.POST, URL,
            new JSONObject(jsonParams), new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    ArrayList<Lyrics> lyrics= new ArrayList<Lyrics>();
                    Log.d(TAG,"Json"+ response);
                    lyrics.add(Lyrics.jsonToLyrics(response));
                    listener.onReceiveLyrics(lyrics);
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d(TAG, "Error: " + error
                            + "\nStatus Code " + error.networkResponse.statusCode
                            + "\nResponse Data " + error.networkResponse.data
                            + "\nCause " + error.getCause()
                            + "\nmessage " + error.getMessage());
                }
            }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String,String>();
                headers.put("Content-Type", "application/json");
                headers.put("X-RapidAPI-Host", headerURL);
                headers.put("X-RapidAPI-Key", API_KEY);

                return headers;
            }

            /*@Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                String responseString = "";
                if (response != null) {
                    responseString = String.valueOf(response.statusCode);
                    // can get more details such as response.headers
                }
                return Response.success(responseString, HttpHeaderParser.parseCacheHeaders(response));
            }*/
        };
        queue.add(postRequest);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}