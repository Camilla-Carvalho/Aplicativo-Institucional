package com.camillacarvalho.projetos.aplicativo_institucional;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.camillacarvalho.projetos.aplicativo_institucional.helper.HomeDbHelper;
import com.camillacarvalho.projetos.aplicativo_institucional.model.Home;
import com.camillacarvalho.projetos.aplicativo_institucional.model.Valores;

public class HomeActivity extends AppCompatActivity {

    private HomeDbHelper base;
    private TextView titulo, conteudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Carregar os dados da home
        base = new HomeDbHelper(getApplicationContext());
        titulo = (TextView) findViewById(R.id.titleHome);
        conteudo = (TextView) findViewById(R.id.textHome);

        base.inserirHome();
        Home home = base.consultarHome();
        System.out.println( "SQLite Base consultarHome(): " + base);

        titulo.setText( home.getTítulo() );
        conteudo.setText( home.getConteudo() );

        iniciarButtonMissao();
        iniciarButtonVisao();
        iniciarButtonValores();

    }

    public void iniciarButtonMissao(){
        Button button = (Button) findViewById(R.id.buttonMissao);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MissaoActivity.class);
                startActivity(intent);
            }
        });
    }

    public void iniciarButtonVisao(){
        Button button = (Button) findViewById(R.id.buttonVisao);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VisaoActivity.class);
                startActivity(intent);
            }
        });
    }

    public void iniciarButtonValores(){
        Button button = (Button) findViewById(R.id.buttonValores);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ValoresActivity.class);
                startActivity(intent);
            }
        });
    }

}