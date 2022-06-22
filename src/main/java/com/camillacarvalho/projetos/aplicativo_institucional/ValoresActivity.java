package com.camillacarvalho.projetos.aplicativo_institucional;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.camillacarvalho.projetos.aplicativo_institucional.helper.ValoresDbHelper;
import com.camillacarvalho.projetos.aplicativo_institucional.model.Valores;

public class ValoresActivity extends AppCompatActivity {

    private ValoresDbHelper base;
    private TextView titulo, conteudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valores);

        // Carregar os dados da valores
        base = new ValoresDbHelper(getApplicationContext());
        titulo = (TextView) findViewById(R.id.titleValores);
        conteudo = (TextView) findViewById(R.id.textValores);

        try{
            base.inserirValores();

            Valores valores = base.consultarValores();
            System.out.println( "SQLite Base consultarValores(): " + base);

            titulo.setText( valores.getTítulo() );
            conteudo.setText( valores.getConteudo() );
        }catch(Exception e){

        }

        iniciarButtonHome();
        iniciarButtonMissao();
        iniciarButtonVisao();

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

    public void iniciarButtonVisao(){
        Button button = (Button) findViewById(R.id.buttonVisao);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VisaoActivity.class);
                startActivity(intent);
            }
        });
    }

}