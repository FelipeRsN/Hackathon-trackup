package com.trackup;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    public static Activity a;
    @BindView(R.id.search)
    EditText search;
    @BindView(R.id.rvList)
    RecyclerView rvList;
    @BindView(R.id.swipeRefreshList)
    SwipeRefreshLayout swipeRefreshList;
    @BindView(R.id.ivSearch)
    ImageView ivSearch;
    @BindView(R.id.cardLayout) LinearLayout cardLayout;
    public static LinearLayout cardLayoutStatic;
    public static RecyclerView rvListStatic;
    public static SwipeRefreshLayout swipeRefreshLayoutStatic;
    public static List<CPFResult> listaUser;
    public static List<CNPJResult> listaOrg;


    private String selectedInput;
    private CNPJResult CNPJResult;

    private int modeSelectedList = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        a = this;

        RecyclerView.LayoutManager layoutList = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvList.setLayoutManager(layoutList);

        search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                ivSearch.callOnClick();
                return true;
            }
        });

        listaUser = new ArrayList<CPFResult>();
        listaOrg = new ArrayList<CNPJResult>();

        ivSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard(MainActivity.this, search);
                if (search.getText().length() < 11) {
                    Snackbar.make(search, "Número de caracteres inválido para consulta", Snackbar.LENGTH_LONG).show();
                } else {
                    if (search.getText().length() < 14) {
                        selectedInput = search.getText().toString();
                        swipeRefreshList.setRefreshing(true);
                        listaUser.clear();
                        cardLayoutStatic.removeAllViews();
                        new getCPFFromBD().execute(selectedInput);
                        modeSelectedList = 0;
                    } else {
                        selectedInput = search.getText().toString();
                        swipeRefreshList.setRefreshing(true);
                        listaOrg.clear();
                        cardLayoutStatic.removeAllViews();
                        new getCNPJ().execute();
                        modeSelectedList = 1;
                    }
                }
            }
        });

        swipeRefreshList.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (modeSelectedList == 1) {
                    rvList.setAdapter(null);
                    listaOrg.clear();
                    new getCNPJ().execute();
                }
                if (modeSelectedList == 0) {
                    rvList.setAdapter(null);
                    listaUser.clear();
                    new getCPFFromBD().execute(selectedInput);
                }
            }
        });

        cardLayoutStatic = cardLayout;
        rvListStatic = rvList;
        swipeRefreshLayoutStatic = swipeRefreshList;
    }

    private void hideKeyboard(Context c, View v) {
        InputMethodManager imm = (InputMethodManager) c.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    protected class getCNPJ extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            String api_url = "https://services.assertivasolucoes.com.br/v1/localize/1001/consultar?cnpj=" + selectedInput;
            HttpURLConnection urlConnection;

            try {
                URL url = new URL(api_url);
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.setDefaultUseCaches(false);
                urlConnection.setDoOutput(true);
                urlConnection.setRequestProperty("Authorization", "E1F59C73-DBBF-41FB-8C3C-054E5190E74F");

                urlConnection.setConnectTimeout(15000);
                urlConnection.setReadTimeout(15000);
                OutputStream outputStream = new BufferedOutputStream(urlConnection.getOutputStream());

                outputStream.close();
                InputStream inputStream;
                // get stream
                if (urlConnection.getResponseCode() < HttpURLConnection.HTTP_BAD_REQUEST) {
                    inputStream = urlConnection.getInputStream();
                } else {
                    inputStream = urlConnection.getErrorStream();
                }
                // parse stream
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String temp, response = "";
                while ((temp = bufferedReader.readLine()) != null) {
                    response += temp;
                }
                Log.i("SUMMARY_PICS", response);
                JSONObject api_data = new JSONObject(response);

                Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();

                CNPJResult = gson.fromJson(api_data.toString(), CNPJResult.class);

                Log.i("LOG", "Razao social " + CNPJResult.getCadastro().getRazaoSocial());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            swipeRefreshList.setRefreshing(false);
            listaOrg.add(CNPJResult);

            UserListAdapter adapter = new UserListAdapter(null, listaOrg, 1);
            rvList.setAdapter(adapter);
            adapter.notifyDataSetChanged();

//            List<com.trackup.CNPJResult.QuadroSocietarioBean> list = CNPJResult.getQuadroSocietario();
//
//            if (list.size() > 0) {
//                for (int i = 0; i < list.size(); i++) {
//                    Log.i("LOG", "SOCIO " + i + ": " + list.get(i).getDocumento());
//                    new getCPFFromBD().execute(list.get(i).getDocumento());
//
//                }
//            }


        }
    }

    protected class getCPFFromBD extends AsyncTask<String, Void, Void> {

        CPFResult result;

        @Override
        protected Void doInBackground(String... p) {
            String cpf = p[0];
            String api_url = "https://services.assertivasolucoes.com.br/v1/localize/1000/consultar?cpf=" + cpf;
            HttpURLConnection urlConnection;

            try {
                URL url = new URL(api_url);
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.setDefaultUseCaches(false);
                urlConnection.setDoOutput(true);
                urlConnection.setRequestProperty("Authorization", "E1F59C73-DBBF-41FB-8C3C-054E5190E74F");

                urlConnection.setConnectTimeout(15000);
                urlConnection.setReadTimeout(15000);
                OutputStream outputStream = new BufferedOutputStream(urlConnection.getOutputStream());

                outputStream.close();
                InputStream inputStream;
                // get stream
                if (urlConnection.getResponseCode() < HttpURLConnection.HTTP_BAD_REQUEST) {
                    inputStream = urlConnection.getInputStream();
                } else {
                    inputStream = urlConnection.getErrorStream();
                }
                // parse stream
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String temp, response = "";
                while ((temp = bufferedReader.readLine()) != null) {
                    response += temp;
                }
                Log.i("SUMMARY_PICS", response);
                JSONObject api_data = new JSONObject(response);

                Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();

                result = gson.fromJson(api_data.toString(), CPFResult.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

//            List<CPFResult.EmailsBean> list = result.getEmails();
//
//            if (list.size() > 0) {
//                for (int i = 0; i < list.size(); i++) {
//                    Log.i("LOG", "EMAIL DO CARA: " + list.get(i).getEmail());
//                }
//            }

            swipeRefreshList.setRefreshing(false);
            listaUser.add(result);

            UserListAdapter adapter = new UserListAdapter(listaUser, null, 0);
            rvList.setAdapter(adapter);
            adapter.notifyDataSetChanged();


        }
    }

//    protected class GetFacebookInformation extends AsyncTask<String, Void, Void> {
//
//        @Override
//        protected Void doInBackground(String... p) {
//            String email = p[0];
//            String api_url = "http://api.dataholics.io/profile?email="+email.trim()+"&accessKey=2d8d596a0b97569f9226a8c33ed9c6dbc8d88120";
//            HttpURLConnection urlConnection;
//
//            try {
//                URL url = new URL(api_url);
//                urlConnection = (HttpURLConnection) url.openConnection();
//                urlConnection.setRequestMethod("GET");
//                urlConnection.setDefaultUseCaches(false);
//                urlConnection.setDoOutput(true);
//                urlConnection.setConnectTimeout(15000);
//                urlConnection.setReadTimeout(15000);
//                OutputStream outputStream = new BufferedOutputStream(urlConnection.getOutputStream());
//
//                outputStream.close();
//                InputStream inputStream;
//                // get stream
//                if (urlConnection.getResponseCode() < HttpURLConnection.HTTP_BAD_REQUEST) {
//                    inputStream = urlConnection.getInputStream();
//                } else {
//                    inputStream = urlConnection.getErrorStream();
//                }
//                // parse stream
//                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//                String temp, response = "";
//                while ((temp = bufferedReader.readLine()) != null){
//                    response += temp;
//                }
//                Log.i("SUMMARY_PICS", response);
////                JSONObject api_data = new JSONObject(response);
////
////                Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
////
////                CNPJResult = gson.fromJson(api_data.toString(), CNPJResult.class);
//
//                //Log.i("LOG","Razao social "+CNPJResult.getCadastro().getRazaoSocial());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Void aVoid) {
//            super.onPostExecute(aVoid);
//            cardContent.setVisibility(View.VISIBLE);
//
//
//        }
//    }
}
