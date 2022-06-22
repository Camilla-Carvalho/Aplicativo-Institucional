package com.camillacarvalho.projetos.aplicativo_institucional.helper;

import android.provider.BaseColumns;

public class HomeContract {

    public HomeContract(){}

    public static abstract class HomeDb implements BaseColumns {
        public static final String TABLE_NAME = "home";
        public static final String TITULO = "titulo";
        public static final String CONTEUDO = "conteudo";
    }
}
