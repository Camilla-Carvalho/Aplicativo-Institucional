package com.camillacarvalho.projetos.aplicativo_institucional.helper;

import android.provider.BaseColumns;

public class ValoresContract {

    public ValoresContract(){}

    public static abstract class ValoresDb implements BaseColumns {
        public static final String TABLE_NAME = "valores";
        public static final String TITULO = "titulo";
        public static final String CONTEUDO = "conteudo";
    }
}
