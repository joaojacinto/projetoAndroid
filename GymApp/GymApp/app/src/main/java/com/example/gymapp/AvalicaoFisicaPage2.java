package com.example.gymapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.gymapp.Classes.Avaliacao;
import com.example.gymapp.Classes.RequestHandler;
import com.example.gymapp.Classes.SharedPrefManager;
import com.example.gymapp.Classes.URLs;
import com.example.gymapp.Classes.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AvalicaoFisicaPage2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AvalicaoFisicaPage2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public AvalicaoFisicaPage2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AvalicaoFisicaPage2.
     */
    // TODO: Rename and change types and number of parameters
    public AvalicaoFisicaPage2 newInstance(String param1, String param2) {
        AvalicaoFisicaPage2 fragment = new AvalicaoFisicaPage2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        avaliacaofisica();
        return inflater.inflate(R.layout.fragment_avalicao_fisica_page2, container, false);
    }

    public void avaliacaofisica()

    {
        class avaliacao_fisica extends AsyncTask<Void, Void, String> {
            ProgressBar progressBar;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressBar = (ProgressBar) requireView().findViewById(R.id.progressBar);
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
                        Toast.makeText(getActivity().getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();

                        //getting the user from the response
                        JSONObject avaliacaoJSON = obj.getJSONObject("avaliacao");

                        //creating a new user object
                        Avaliacao avaliacao = new Avaliacao(
                                avaliacaoJSON.getString("gordura_corporal"),
                                avaliacaoJSON.getString("massa_muscular"),
                                avaliacaoJSON.getString("peso"),
                                avaliacaoJSON.getString("altura"),
                                avaliacaoJSON.getString("massa_gorda")
                        );

                        JSONObject userJson = obj.getJSONObject("avaliacao");
                        User user = new User(
                                userJson.getInt("id"),
                                userJson.getString("username"),
                                userJson.getString("email")
                        );

                        //storing the user in shared preferences
                        SharedPrefManager.getInstance(getActivity().getApplicationContext()).userLogin(user);
                        SharedPrefManager.getInstance(getActivity().getApplicationContext()).getId(avaliacao);

                        //starting the home_main activity
                        getActivity().finish();
                        startActivity(new Intent(getActivity().getApplicationContext(), AvalicaoFisicaPage2.class));
                    } else {
                        Toast.makeText(getActivity().getApplicationContext(), "Invalid username or password", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected String doInBackground(Void... voids) {
                //creating request handler object
                RequestHandler requestHandler = new RequestHandler();

                User user = SharedPrefManager.getInstance(getActivity().getApplicationContext()).getUser();
                String userId = String.valueOf(user.getId());
                String userPassword = user.getEmail();

                //creating request parameters
                HashMap<String, String> params = new HashMap<>();
                params.put("idutilizador", userId);
                params.put("password", userPassword);

                //returing the response
                return requestHandler.sendPostRequest(URLs.URL_AVALIACAOID, params);

//                return("a");
            }
        }
    }
}