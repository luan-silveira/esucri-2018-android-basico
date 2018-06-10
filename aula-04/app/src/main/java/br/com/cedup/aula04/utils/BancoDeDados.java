package br.com.cedup.aula04.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoDeDados extends SQLiteOpenHelper {

    private static final String DB_NOME = "aula04";
    private static final int DB_VERSAO = 1;

    public BancoDeDados(Context context) {
        super(context, DB_NOME, null, DB_VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_table_produtos =
                "CREATE TABLE produtos (" +
                "   _id integer primary key autoincrement," +
                "   descricao text not null," +
                "   marca text not null," +
                "   preco_base numeric not null " +
                ")";

        db.execSQL(create_table_produtos);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        for (int i = oldVersion; i <= newVersion; i++) {
            if (i==2) {
                upgradeVersao2(db);
            } else if (i==3) {
                upgradeVersao3(db);
            }
        }

        String drop_table_produto = "DROP TABLE IF EXISTS produto";
        db.execSQL(drop_table_produto);

        onCreate(db);
    }

    public void upgradeVersao2(SQLiteDatabase db) {

    }

    public void upgradeVersao3(SQLiteDatabase db) {

    }
}
