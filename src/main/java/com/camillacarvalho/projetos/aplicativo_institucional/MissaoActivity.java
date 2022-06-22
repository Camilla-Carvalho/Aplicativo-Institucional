package com.camillacarvalho.projetos.aplicativo_institucional;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.camillacarvalho.projetos.aplicativo_institucional.helper.MissaoDbHelper;
import com.camillacarvalho.projetos.aplicativo_institucional.model.Missao;

public class MissaoActivity extends AppCompatActivity {

    private MissaoDbHelper base;
    private TextView titulo, conteudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_missao);

        // Carregar os dados da home
        base = new MissaoDbHelper(getApplicationContext());
        titulo = (TextView) findViewById(R.id.titleMissao);
        conteudo = (TextView) findViewById(R.id.textMissao);

        base.inserirMissao();

        Missao missao = base.consultarMissao();
        System.out.println( "SQLite Base consultarMissao(): " + base);

        titulo.setText( missao.getTítulo() );
        conteudo.setText( missao.getConteudo() );

        iniciarButtonHome();
        iniciarButtonVisao();
        iniciarButtonValores();

    }

    public void iniciarButtonHome(){
        Button button = (Button) findViewById(R.id.buttonHome);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
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