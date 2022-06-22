package com.camillacarvalho.projetos.aplicativo_institucional;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.camillacarvalho.projetos.aplicativo_institucional.helper.VisaoDbHelper;
import com.camillacarvalho.projetos.aplicativo_institucional.model.Visao;

public class VisaoActivity extends AppCompatActivity {

    private VisaoDbHelper base;
    private TextView titulo, conteudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visao);

        // Carregar os dados de visão
        base = new VisaoDbHelper(getApplicationContext());
        titulo = (TextView) findViewById(R.id.titleVisao);
        conteudo = (TextView) findViewById(R.id.textVisao);

        try{
            base.inserirVisao();
            Visao visao = base.consultarVisao();
            System.out.println( "SQLite Base consultarVisao(): " + base);

            System.out.println( "SQLite Base consultarVisao(): " + visao.getTítulo());
            System.out.println( "SQLite Base consultarVisao(): " + visao.getConteudo());
            
            titulo.setText( ""+visao.getTítulo() );
            conteudo.setText( ""+visao.getConteudo() );
        }catch(Exception e){

        }

        iniciarButtonHome();
        iniciarButtonMissao();
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

    public void iniciarButtonMissao(){
        Button button = (Button) findViewById(R.id.buttonMissao);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MissaoActivity.class);
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