package br.com.esucri.aula03;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirCaixaDialogo(View view) {

        final Resources resources = getResources();

        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);

        builder.setTitle(R.string.caixa_de_dialogo);
        builder.setItems(R.array.tipos_estabelecimento, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String tipo = resources.getStringArray(R.array.tipos_estabelecimento)[which];
                Toast.makeText(getBaseContext(), tipo, Toast.LENGTH_LONG).show();
            }
        });

        /*builder.setMessage(R.string.mensagem_caixa_de_dialogo);

        builder
                .setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getBaseContext(), "Confirmado", Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getBaseContext(), "Cancelado", Toast.LENGTH_LONG).show();
                    }
                });
                */

        AlertDialog alert = builder.create();
        alert.show();
    }

    public void abrirExemploTab(View view) {
        Intent intent = new Intent(this, ExemploTabActivity.class);
        startActivity(intent);


    }
}
