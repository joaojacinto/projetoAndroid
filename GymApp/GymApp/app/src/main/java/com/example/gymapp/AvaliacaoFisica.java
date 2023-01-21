package com.example.gymapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gymapp.Classes.Avaliacao;
import com.example.gymapp.Classes.RequestHandler;
import com.example.gymapp.Classes.SharedPrefManager;
import com.example.gymapp.Classes.URLs;
import com.example.gymapp.Classes.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class AvaliacaoFisica extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_login);


        //if user presses on avaliacao fisica
        //calling the method avaliacao fisica
       /* findViewById(R.id.buttonLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                avaliacao_fisica();
            }
        }); */
    }

    private void avaliacaofisica()

    {
        class avaliacao_fisica extends AsyncTask<Void, Void, String> {
            ProgressBar progressBar;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressBar = (ProgressBar) findViewById(R.id.progressBar);
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                progressBar.setVisibility(View.GONE);


                try {
                    //converting response to json object
                    JSONObject obj = new JSONObject(s);

                    //if no error in response
                    if (!obj.getBoolean("error")) {
                        Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();

                        //getting the user from the response
                        JSONObject userJson = obj.getJSONObject("avaliacao");

                        //creating a new user object
                        Avaliacao avaliacao = new Avaliacao(
                                userJson.getString("gordura_corporal"),
                                userJson.getString("massa_muscular"),
                                userJson.getString("peso"),
                                userJson.getString("altura"),
                                userJson.getString("massa_gorda")
                        );

                        //storing the user in shared preferences
                        //SharedPrefManager.getInstance(getApplicationContext()).userLogin(avaliacao);

                        //starting the home_main activity
                        /*finish();
                        startActivity(new Intent(getApplicationContext(), Home_Main.class));*/
                    } else {
                        Toast.makeText(getApplicationContext(), "Invalid username or password", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected String doInBackground(Void... voids) {
                //creating request handler object
               /* RequestHandler requestHandler = new RequestHandler();

                //creating request parameters
                HashMap<String, String> params = new HashMap<>();
                params.put("username", username);
                params.put("password", password);

                //returing the response
                return requestHandler.sendPostRequest(URLs.URL_LOGIN, params);
                */
                return("a");
            }
        }
    }
}
