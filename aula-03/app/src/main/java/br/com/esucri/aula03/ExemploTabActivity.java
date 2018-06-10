package br.com.esucri.aula03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;

public class ExemploTabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exemplo_tab);

        TabHost tabHost = findViewById(R.id.tab_host);
        tabHost.setup();

        TabHost.TabSpec tab01 = tabHost.newTabSpec("tab01");
        tab01.setIndicator("Tab 01");
        tab01.setContent(R.id.tab01);

        TabHost.TabSpec tab02 = tabHost.newTabSpec("tab02");
        tab02.setIndicator("Tab 02");
        tab02.setContent(R.id.tab02);

        tabHost.addTab(tab01);
        tabHost.addTab(tab02);

        ListView lista = findViewById(R.id.lista_tab01);
        String[] listaDados = new String[]{"Compra 01","Compra 02", "Compra 03"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, listaDados);
        lista.setAdapter(adapter);

    }
}
