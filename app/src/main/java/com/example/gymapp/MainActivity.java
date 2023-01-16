package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pesquisarUser(View view) throws JSONException{
        String email = ((EditText)findViewById(R.id.edEmail)).getText().toString();
        Button btnLogin = (Button)findViewById(R.id.btnLogin);

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = "http://192.168.55.47/medion/loginandroid.php";

        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("users", email);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest postRequest = new JsonObjectRequest (Request.Method.POST, url,jsonObj,
                response ->
                {
                    try
                    {
                        JSONObject resposta = new JSONObject(response.toString());
                        Log.d("MDLog", resposta.toString());
                        JSONObject nomeUser = resposta.getJSONObject("edNome");
                        LinearLayout llContainer = findViewById(R.id.container);
                        llContainer.removeAllViews();

                            TextView nTextView = new TextView(getApplicationContext());
                            nTextView.setText(nomeUser.toString());
                            llContainer.addView(nTextView);

                    } catch (JSONException e)
                    {
                        e.printStackTrace();
                    }
                },
                error -> {
                    // error
                    //Log.d("MDLog", error.getMessage());
                }
        );
        queue.add(postRequest);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}