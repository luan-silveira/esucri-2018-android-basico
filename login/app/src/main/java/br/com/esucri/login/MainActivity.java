package br.com.esucri.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button botaoLogin;
    EditText campoUsuario, campoSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoLogin = findViewById(R.id.botaoLogin);
        campoUsuario = findViewById(R.id.campoLogin);
        campoSenha = findViewById(R.id.campoSenha);
    }

    public void onClickLogin(View view) {

        String usuario = campoUsuario.getText().toString();
        String senha = campoSenha.getText().toString();

        if ("lucas".equals(usuario) &&
                "abc123".equals(senha)) {
            Toast.makeText(this,
                    "Login realizado com sucesso!",
                    Toast.LENGTH_LONG).show();

            Intent intent = new Intent(this,
                    BemVindoActivity.class);

            Bundle param = new Bundle();
            param.putString("usuario",usuario);
            intent.putExtras(param);

            startActivity(intent);
            finish();

        } else {
            Toast.makeText(this,
                    "Usuário ou senha inválido!",
                    Toast.LENGTH_LONG).show();
        }
    }

}
