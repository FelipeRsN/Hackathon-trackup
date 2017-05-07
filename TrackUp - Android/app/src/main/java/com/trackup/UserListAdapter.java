package com.trackup;

import android.graphics.Paint;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by felipersn on 07/05/17.
 */

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.MyViewHolder> {

    private List<CNPJResult> CNPJ;
    private List<CPFResult> CPF;
    private int mode;
    private View v;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        //Elements
        View v;
        CircleImageView pic;
        TextView name;
        TextView doc;

        public MyViewHolder(View view) {
            super(view);
            pic = (CircleImageView) view.findViewById(R.id.resultImage);
            name = (TextView) view.findViewById(R.id.userName);
            doc = (TextView) view.findViewById(R.id.userDocument);
            v = view;
        }
    }


    public UserListAdapter(List<CPFResult> cpf, List<CNPJResult> cnpj, int mode) {
        this.mode = mode;
        if (mode == 1) {
            this.CNPJ = cnpj;
        } else {
            this.CPF = cpf;
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_result, parent, false);
        v = itemView;
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        //Get position data
        CNPJResult cnpjModel = null;
        CPFResult cpfModel = null;
        if(mode == 1){
            cnpjModel = CNPJ.get(position);
            holder.name.setText(cnpjModel.getCadastro().getRazaoSocial());
            holder.doc.setText(cnpjModel.getCadastro().getCnpj());
            holder.pic.setImageResource(R.drawable.briefcase);

        }else{
            cpfModel = CPF.get(position);
            holder.name.setText(cpfModel.getCadastro().getNome());
            holder.doc.setText(cpfModel.getCadastro().getCpf());
            holder.pic.setImageResource(R.drawable.account);
        }

        final CPFResult finalCPF = cpfModel;
        final CNPJResult finalCNPJ = cnpjModel;

        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mode == 1){
                    LayoutInflater inflater = LayoutInflater.from(MainActivity.a);
                    View i = inflater.inflate(R.layout.cardview_orginfo, null, false);

                    TextView cname = (TextView) i.findViewById(R.id.name);
                    TextView cdoc = (TextView) i.findViewById(R.id.document);
                    TextView tipo = (TextView) i.findViewById(R.id.tipo);
                    TextView abertura = (TextView) i.findViewById(R.id.abertura);

                    String getDoc = finalCNPJ.getCadastro().getCnpj();
                    try {
                        if (getDoc.equalsIgnoreCase("null")) getDoc = "Valor não encontrado";
                    }catch (Exception e){
                        e.printStackTrace();
                        getDoc = "Valor não encontrado";
                    }

                    String getTipo = finalCNPJ.getCadastro().getTipoEmpresa();
                    try {
                        if (getTipo.equalsIgnoreCase("null")) getTipo = "Valor não encontrado";
                    }catch (Exception e){
                        e.printStackTrace();
                        getTipo = "Valor não encontrado";
                    }

                    String getAbertura = finalCNPJ.getCadastro().getDataAbertura();
                    try {
                        if (getAbertura.equalsIgnoreCase("null")) getAbertura = "Valor não encontrado";
                    }catch (Exception e){
                        e.printStackTrace();
                        getAbertura = "Valor não encontrado";
                    }

                    cname.setText(""+finalCNPJ.getCadastro().getRazaoSocial());
                    cdoc.setText("CNPJ: "+getDoc);
                    tipo.setText("Tipo de empresa: "+getTipo);
                    abertura.setText("Data de abertuda: "+getAbertura);

                    MainActivity.cardLayoutStatic.removeAllViews();
                    MainActivity.cardLayoutStatic.addView(i);

                    View i2 = inflater.inflate(R.layout.cardview_orgcontact, null, false);
                    LinearLayout fixos = (LinearLayout) i2.findViewById(R.id.fixos);
                    LinearLayout enderecos = (LinearLayout) i2.findViewById(R.id.enderecos);

                    try{
                        for (int j = 0; j < finalCNPJ.getTelefones().getFixos().size(); j++) {
                            try {
                                TextView tv = new TextView(MainActivity.a);
                                tv.setText(finalCNPJ.getTelefones().getFixos().get(j).getTelefone());
                                tv.setTextSize(14);
                                tv.setPaintFlags(tv.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
                                tv.setTextColor(MainActivity.a.getResources().getColor(R.color.colorPrimaryDark));
                                fixos.addView(tv);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    try{
                        for (int j = 0; j < finalCNPJ.getEnderecos().size(); j++) {
                            try {
                                TextView tv = new TextView(MainActivity.a);
                                tv.setText(finalCNPJ.getEnderecos().get(j).getTipoLogradouro() + " " + finalCNPJ.getEnderecos().get(j).getLogradouro() + ", " + finalCNPJ.getEnderecos().get(j).getNumero() + "" +
                                        "\n" + finalCNPJ.getEnderecos().get(j).getBairro() + ", " + finalCNPJ.getEnderecos().get(j).getCidade() + " - " + finalCNPJ.getEnderecos().get(j).getUf() + "\nCEP: " + finalCNPJ.getEnderecos().get(j).getCep()+"\n");
                                tv.setTextSize(14);
                                enderecos.addView(tv);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    MainActivity.cardLayoutStatic.addView(i2);

                    View i3 = inflater.inflate(R.layout.cardview_orgsocios, null, false);
                    LinearLayout socios = (LinearLayout) i3.findViewById(R.id.socios);

                    for (int j = 0; j < finalCNPJ.getQuadroSocietario().size(); j++) {
                        View soc = inflater.inflate(R.layout.layout_socios, null, false);
                        TextView socName = (TextView) soc.findViewById(R.id.name);
                        TextView socDoc = (TextView) soc.findViewById(R.id.documento);
                        TextView socPartic = (TextView) soc.findViewById(R.id.participacao);

                        try{
                            socName.setText(finalCNPJ.getQuadroSocietario().get(j).getNome());
                        }catch (Exception e){
                            e.printStackTrace();
                            socName.setText("Valor não encontrado");
                        }

                        try{
                            socDoc.setText("CPF: "+finalCNPJ.getQuadroSocietario().get(j).getDocumento());
                        }catch (Exception e){
                            e.printStackTrace();
                            socDoc.setText("Valor não encontrado");
                        }

                        try{
                            socPartic.setText("Qualificação social: "+finalCNPJ.getQuadroSocietario().get(j).getQualificacaoSocio());
                        }catch (Exception e){
                            e.printStackTrace();
                            socPartic.setText("Valor não encontrado");
                        }

                        if(!socDoc.getText().toString().equalsIgnoreCase("Valor não encontrado")) {
                            final int finalJ = j;
                            soc.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    MainActivity.swipeRefreshLayoutStatic.setRefreshing(true);
                                    MainActivity.cardLayoutStatic.removeAllViews();
                                    new getCPFFromBD2().execute(finalCNPJ.getQuadroSocietario().get(finalJ).getDocumento());
                                }
                            });
                        }

                        socios.addView(soc);
                    }

                    MainActivity.cardLayoutStatic.addView(i3);

                }else{
                    LayoutInflater inflater = LayoutInflater.from(MainActivity.a);
                    View i = inflater.inflate(R.layout.cardview_userinfo, null, false);

                    TextView cname = (TextView) i.findViewById(R.id.name);
                    TextView cdoc = (TextView) i.findViewById(R.id.document);
                    TextView sexo = (TextView) i.findViewById(R.id.sexo);
                    TextView idade = (TextView) i.findViewById(R.id.idade);
                    TextView obito = (TextView) i.findViewById(R.id.obito);
                    TextView mae = (TextView) i.findViewById(R.id.mae);
                    TextView docmae = (TextView) i.findViewById(R.id.docmae);

                    String getSexo = finalCPF.getCadastro().getSexo();
                    try {
                        if (getSexo.equalsIgnoreCase("null")) getSexo = "Valor não encontrado";
                    }catch (Exception e){
                        e.printStackTrace();
                        getSexo = "Valor não encontrado";
                    }

                    String getIdade = finalCPF.getCadastro().getIdade();
                    try {
                        if (getIdade.equalsIgnoreCase("null")) getIdade = "Valor não encontrado";
                    }catch (Exception e){
                        e.printStackTrace();
                        getIdade = "Valor não encontrado";
                    }

                    String getObito = finalCPF.getCadastro().getObitoProvavel();
                    try {
                        if (getObito.equalsIgnoreCase("null")) getObito = "Valor não encontrado";
                    }catch (Exception e){
                        e.printStackTrace();
                        getObito = "Valor não encontrado";
                    }

                    String getMae = finalCPF.getCadastro().getMaeNome();
                    try {
                        if (getMae.equalsIgnoreCase("null")) getMae = "Valor não encontrado";
                    }catch (Exception e){
                        e.printStackTrace();
                        getMae = "Valor não encontrado";
                    }

                    String getDocMae = finalCPF.getCadastro().getMaeCpf();
                    try {
                        if (getDocMae != null)
                            if (getDocMae.equalsIgnoreCase("null"))
                                getDocMae = "Valor não encontrado";
                            else{
                                boolean contain = false;
                                for (int j = 0; j < MainActivity.listaUser.size(); j++) {
                                    if(MainActivity.listaUser.get(j).getCadastro().getCpf().equalsIgnoreCase(getDocMae)){
                                        contain = true;
                                        break;
                                    }
                                }
                                if(!contain){
                                    MainActivity.swipeRefreshLayoutStatic.setRefreshing(true);
                                    new getCPFFromBD().execute(getDocMae);
                                }
                            }
                        else getDocMae = "Valor não encontrado";
                    }catch (Exception e){
                        e.printStackTrace();
                        getDocMae = "Valor não encontrado";
                    }

                    cname.setText(""+finalCPF.getCadastro().getNome());
                    cdoc.setText("CPF: "+finalCPF.getCadastro().getCpf());
                    sexo.setText("Sexo: "+getSexo);
                    idade.setText("Idade: "+getIdade);
                    obito.setText("Óbito provável: "+getObito);
                    mae.setText("Nome da mãe: "+getMae);
                    docmae.setText("CPF da mãe: "+getDocMae);


                    MainActivity.cardLayoutStatic.removeAllViews();
                    MainActivity.cardLayoutStatic.addView(i);

                    View ii = inflater.inflate(R.layout.cardview_userinteresses, null, false);
                    MainActivity.cardLayoutStatic.addView(ii);

                    View i2 = inflater.inflate(R.layout.cardview_usercontact, null, false);
                    LinearLayout fixos = (LinearLayout) i2.findViewById(R.id.fixos);
                    LinearLayout moveis = (LinearLayout) i2.findViewById(R.id.moveis);
                    LinearLayout participacoes = (LinearLayout) i2.findViewById(R.id.participacoes);
                    LinearLayout enderecos = (LinearLayout) i2.findViewById(R.id.enderecos);
                    LinearLayout emails = (LinearLayout) i2.findViewById(R.id.emails);

                    try{
                        for (int j = 0; j < finalCPF.getTelefones().getFixos().size(); j++) {
                            try {
                                TextView tv = new TextView(MainActivity.a);
                                tv.setText(finalCPF.getTelefones().getFixos().get(j).getTelefone());
                                tv.setTextSize(14);
                                tv.setPaintFlags(tv.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
                                tv.setTextColor(MainActivity.a.getResources().getColor(R.color.colorPrimaryDark));
                                fixos.addView(tv);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    try{
                        for (int j = 0; j < finalCPF.getTelefones().getMoveis().size(); j++) {
                            try{
                            TextView tv = new TextView(MainActivity.a);
                            tv.setText(finalCPF.getTelefones().getMoveis().get(j).getTelefone());
                            tv.setTextSize(14);
                            tv.setPaintFlags(tv.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
                            tv.setTextColor(MainActivity.a.getResources().getColor(R.color.colorPrimaryDark));
                            moveis.addView(tv);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    try{
                        for (int j = 0; j < finalCPF.getParticipacoesEmpresas().size(); j++) {
                            try{
                            TextView tv = new TextView(MainActivity.a);
                            tv.setText(finalCPF.getParticipacoesEmpresas().get(j).getNome() + " - ("+finalCPF.getParticipacoesEmpresas().get(j).getDocumento()+")");
                            tv.setTextSize(14);
                            participacoes.addView(tv);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    try{
                        for (int j = 0; j < finalCPF.getEnderecos().size(); j++) {
                            try {
                                TextView tv = new TextView(MainActivity.a);
                                tv.setText(finalCPF.getEnderecos().get(j).getTipoLogradouro() + " " + finalCPF.getEnderecos().get(j).getLogradouro() + ", " + finalCPF.getEnderecos().get(j).getNumero() + "" +
                                        "\n" + finalCPF.getEnderecos().get(j).getBairro() + ", " + finalCPF.getEnderecos().get(j).getCidade() + " - " + finalCPF.getEnderecos().get(j).getUf() + "\nCEP: " + finalCPF.getEnderecos().get(j).getCep()+"\n");
                                tv.setTextSize(14);
                                enderecos.addView(tv);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    try {
                        for (int j = 0; j < finalCPF.getEmails().size(); j++) {
                            try {
                                TextView tv = new TextView(MainActivity.a);
                                tv.setText(finalCPF.getEmails().get(j).getEmail());
                                tv.setTextSize(14);
                                tv.setPaintFlags(tv.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
                                tv.setTextColor(MainActivity.a.getResources().getColor(R.color.colorPrimaryDark));
                                emails.addView(tv);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    MainActivity.cardLayoutStatic.addView(i2);

                    View i3 = inflater.inflate(R.layout.cardview_score, null, false);
                    TextView score = (TextView) i3.findViewById(R.id.score);
                    TextView negativos = (TextView) i3.findViewById(R.id.negativos);
                    TextView protestos = (TextView) i3.findViewById(R.id.protestos);
                    TextView acoes = (TextView) i3.findViewById(R.id.acoes);

                    int min = -10;
                    int max = 10;

                    Random r = new Random();
                    int i1 = r.nextInt(max - min + 1) + min;

                    score.setText(Integer.toString(i1));

                    min = 0;
                    max = 50;

                    int nega = r.nextInt(max - min + 1) + min;
                    int prot = r.nextInt(max - min + 1) + min;
                    int acoe = r.nextInt(max - min + 1) + min;

                    negativos.setText(Integer.toString(nega));
                    protestos.setText(Integer.toString(prot));
                    acoes.setText(Integer.toString(acoe));

                    MainActivity.cardLayoutStatic.addView(i3);

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        if(mode == 1) return CNPJ.size();
        else return CPF.size();
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

            MainActivity.swipeRefreshLayoutStatic.setRefreshing(false);
            MainActivity.listaUser.add(result);
            MainActivity.rvListStatic.getAdapter().notifyDataSetChanged();


        }
    }

    protected class getCPFFromBD2 extends AsyncTask<String, Void, Void> {

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

            LayoutInflater inflater = LayoutInflater.from(MainActivity.a);
            View i = inflater.inflate(R.layout.cardview_userinfo, null, false);

            TextView cname = (TextView) i.findViewById(R.id.name);
            TextView cdoc = (TextView) i.findViewById(R.id.document);
            TextView sexo = (TextView) i.findViewById(R.id.sexo);
            TextView idade = (TextView) i.findViewById(R.id.idade);
            TextView obito = (TextView) i.findViewById(R.id.obito);
            TextView mae = (TextView) i.findViewById(R.id.mae);
            TextView docmae = (TextView) i.findViewById(R.id.docmae);

            String getSexo = result.getCadastro().getSexo();
            try {
                if (getSexo.equalsIgnoreCase("null")) getSexo = "Valor não encontrado";
            }catch (Exception e){
                e.printStackTrace();
                getSexo = "Valor não encontrado";
            }

            String getIdade = result.getCadastro().getIdade();
            try {
                if (getIdade.equalsIgnoreCase("null")) getIdade = "Valor não encontrado";
            }catch (Exception e){
                e.printStackTrace();
                getIdade = "Valor não encontrado";
            }

            String getObito = result.getCadastro().getObitoProvavel();
            try {
                if (getObito.equalsIgnoreCase("null")) getObito = "Valor não encontrado";
            }catch (Exception e){
                e.printStackTrace();
                getObito = "Valor não encontrado";
            }

            String getMae = result.getCadastro().getMaeNome();
            try {
                if (getMae.equalsIgnoreCase("null")) getMae = "Valor não encontrado";
            }catch (Exception e){
                e.printStackTrace();
                getMae = "Valor não encontrado";
            }

            String getDocMae = result.getCadastro().getMaeCpf();
            try {
                if (getDocMae != null)
                    if (getDocMae.equalsIgnoreCase("null"))
                        getDocMae = "Valor não encontrado";
//                    else{
//                        boolean contain = false;
//                        for (int j = 0; j < MainActivity.listaUser.size(); j++) {
//                            if(MainActivity.listaUser.get(j).getCadastro().getCpf().equalsIgnoreCase(getDocMae)){
//                                contain = true;
//                                break;
//                            }
//                        }
//                        if(!contain){
//                            MainActivity.swipeRefreshLayoutStatic.setRefreshing(true);
//                            new getCPFFromBD().execute(getDocMae);
//                        }
//                    }
                else getDocMae = "Valor não encontrado";
            }catch (Exception e){
                e.printStackTrace();
                getDocMae = "Valor não encontrado";
            }

            cname.setText(""+result.getCadastro().getNome());
            cdoc.setText("CPF: "+result.getCadastro().getCpf());
            sexo.setText("Sexo: "+getSexo);
            idade.setText("Idade: "+getIdade);
            obito.setText("Óbito provável: "+getObito);
            mae.setText("Nome da mãe: "+getMae);
            docmae.setText("CPF da mãe: "+getDocMae);


            MainActivity.cardLayoutStatic.removeAllViews();
            MainActivity.cardLayoutStatic.addView(i);

            View ii = inflater.inflate(R.layout.cardview_userinteresses, null, false);
            MainActivity.cardLayoutStatic.addView(ii);

            View i2 = inflater.inflate(R.layout.cardview_usercontact, null, false);
            LinearLayout fixos = (LinearLayout) i2.findViewById(R.id.fixos);
            LinearLayout moveis = (LinearLayout) i2.findViewById(R.id.moveis);
            LinearLayout participacoes = (LinearLayout) i2.findViewById(R.id.participacoes);
            LinearLayout enderecos = (LinearLayout) i2.findViewById(R.id.enderecos);
            LinearLayout emails = (LinearLayout) i2.findViewById(R.id.emails);

            try{
                for (int j = 0; j < result.getTelefones().getFixos().size(); j++) {
                    try {
                        TextView tv = new TextView(MainActivity.a);
                        tv.setText(result.getTelefones().getFixos().get(j).getTelefone());
                        tv.setTextSize(14);
                        tv.setPaintFlags(tv.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
                        tv.setTextColor(MainActivity.a.getResources().getColor(R.color.colorPrimaryDark));
                        fixos.addView(tv);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }

            try{
                for (int j = 0; j < result.getTelefones().getMoveis().size(); j++) {
                    try{
                        TextView tv = new TextView(MainActivity.a);
                        tv.setText(result.getTelefones().getMoveis().get(j).getTelefone());
                        tv.setTextSize(14);
                        tv.setPaintFlags(tv.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
                        tv.setTextColor(MainActivity.a.getResources().getColor(R.color.colorPrimaryDark));
                        moveis.addView(tv);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }

            try{
                for (int j = 0; j < result.getParticipacoesEmpresas().size(); j++) {
                    try{
                        TextView tv = new TextView(MainActivity.a);
                        tv.setText(result.getParticipacoesEmpresas().get(j).getNome() + " - ("+result.getParticipacoesEmpresas().get(j).getDocumento()+")");
                        tv.setTextSize(14);
                        participacoes.addView(tv);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }

            try{
                for (int j = 0; j < result.getEnderecos().size(); j++) {
                    try {
                        TextView tv = new TextView(MainActivity.a);
                        tv.setText(result.getEnderecos().get(j).getTipoLogradouro() + " " + result.getEnderecos().get(j).getLogradouro() + ", " + result.getEnderecos().get(j).getNumero() + "" +
                                "\n" + result.getEnderecos().get(j).getBairro() + ", " + result.getEnderecos().get(j).getCidade() + " - " + result.getEnderecos().get(j).getUf() + "\nCEP: " + result.getEnderecos().get(j).getCep()+"\n");
                        tv.setTextSize(14);
                        enderecos.addView(tv);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }

            try {
                for (int j = 0; j < result.getEmails().size(); j++) {
                    try {
                        TextView tv = new TextView(MainActivity.a);
                        tv.setText(result.getEmails().get(j).getEmail());
                        tv.setTextSize(14);
                        tv.setPaintFlags(tv.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
                        tv.setTextColor(MainActivity.a.getResources().getColor(R.color.colorPrimaryDark));
                        emails.addView(tv);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }

            MainActivity.cardLayoutStatic.addView(i2);

            View i3 = inflater.inflate(R.layout.cardview_score, null, false);
            TextView score = (TextView) i3.findViewById(R.id.score);
            TextView negativos = (TextView) i3.findViewById(R.id.negativos);
            TextView protestos = (TextView) i3.findViewById(R.id.protestos);
            TextView acoes = (TextView) i3.findViewById(R.id.acoes);

            int min = -10;
            int max = 10;

            Random r = new Random();
            int i1 = r.nextInt(max - min + 1) + min;

            score.setText(Integer.toString(i1));

            min = 0;
            max = 50;

            int nega = r.nextInt(max - min + 1) + min;
            int prot = r.nextInt(max - min + 1) + min;
            int acoe = r.nextInt(max - min + 1) + min;

            negativos.setText(Integer.toString(nega));
            protestos.setText(Integer.toString(prot));
            acoes.setText(Integer.toString(acoe));

            MainActivity.cardLayoutStatic.addView(i3);
            MainActivity.swipeRefreshLayoutStatic.setRefreshing(false);

        }
    }
}
