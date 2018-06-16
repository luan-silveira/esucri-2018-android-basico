package br.com.cedup.aula04;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class ChamadaRemotaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chamada_remota);

        final TextView textoSaudacao = findViewById(R.id.textoSaudacao);

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                try {
                    URL githubEndpoint = new URL("https://api.github.com/users/lucasscarduelli");
                    HttpsURLConnection conexao = (HttpsURLConnection) githubEndpoint.openConnection();

                    conexao.setRequestProperty("User-Agent", getResources().getString(R.string.app_name));
                    conexao.setRequestProperty("Accept", "application/vnd.github.v3+json");

                    if (conexao.getResponseCode() == 200) {
                        InputStream responseBody = conexao.getInputStream();
                        InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");

                        StringBuffer buffer = new StringBuffer();
                        BufferedReader reader = new BufferedReader(responseBodyReader);

                        String line;
                        while ((line = reader.readLine()) != null) {
                            buffer.append(line + "\n");
                        }

                        JSONObject json = new JSONObject(buffer.toString());

                        final String nome = json.getString("name");

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                textoSaudacao.setText("Olá\n" + nome);
                            }
                        });

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
