package com.camillacarvalho.projetos.aplicativo_institucional.helper;

import android.provider.BaseColumns;

public class VisaoContract {

    public VisaoContract(){}

    public static abstract class VisaoDb implements BaseColumns {
        public static final String TABLE_NAME = "visao";
        public static final String TITULO = "titulo";
        public static final String CONTEUDO = "conteudo";
    }
}
