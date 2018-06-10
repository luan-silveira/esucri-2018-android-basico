package br.com.cedup.aula04.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import br.com.cedup.aula04.model.Produto;
import br.com.cedup.aula04.utils.BancoDeDados;

public class ProdutoController {

    private SQLiteDatabase instanciaDb;
    private BancoDeDados db;

    public ProdutoController(Context context) {
        db = new BancoDeDados(context);
    }

    public long create(final Produto produto) {
        ContentValues dados = new ContentValues();
        long resutado;

        instanciaDb = db.getWritableDatabase();
        dados.put("descricao", produto.getDescricao());
        dados.put("marca", produto.getMarca());
        dados.put("preco_base", produto.getPrecoBase().floatValue());

        resutado = instanciaDb.insert("produtos", null, dados);
        return resutado;
    }

    public long update(final Produto produto) {
        return 0;
    }

    public Cursor retrieve() {
        return null;
    }

    public long delete(final Produto produto) {
        return 0;
    }

}
