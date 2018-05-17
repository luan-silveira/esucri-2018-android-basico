package br.com.esucri.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BemVindoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bem_vindo);

        Intent intent = getIntent();
        Bundle args = intent.getExtras();
        String usuario = args.getString("usuario");

        TextView textoBemVindo = findViewById(R.id.textoBemVindo);
        textoBemVindo.append(" " + usuario);
    }
}
