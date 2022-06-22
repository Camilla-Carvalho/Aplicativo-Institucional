package com.camillacarvalho.projetos.aplicativo_institucional.helper;

import android.provider.BaseColumns;

public class MissaoContract {

    public MissaoContract(){}

    public static abstract class MissaoDb implements BaseColumns {
        public static final String TABLE_NAME = "missao";
        public static final String TITULO = "titulo";
        public static final String CONTEUDO = "conteudo";
    }
}
