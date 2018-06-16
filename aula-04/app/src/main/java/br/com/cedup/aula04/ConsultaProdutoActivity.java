package br.com.cedup.aula04;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import br.com.cedup.aula04.controller.ProdutoController;

public class ConsultaProdutoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_produto);

        ProdutoController crud = new ProdutoController(getBaseContext());
        final Cursor cursor = crud.retrieve();

        String[] campos = {"descricao", "marca", "preco_base"};
        int[] componentes = { R.id.textoDescricao, R.id.textoMarca, R.id.textoPrecoBase };

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getBaseContext(),
                R.layout.lista_produtos, cursor, campos, componentes, 0);
        ListView lista = findViewById(R.id.lista);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cursor.moveToPosition(position);
                String idProduto = cursor.getString(cursor.getColumnIndexOrThrow("_id"));

                Intent intent = new Intent(ConsultaProdutoActivity.this, MainActivity.class);
                intent.putExtra("id", idProduto);

                startActivity(intent);
                finish();
            }
        });
    }
}
