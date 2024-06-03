package com.example.applicationfitness.entidades;

import android.provider.BaseColumns;


public class UsuarioContract {

    public static final String DATABASE_NAME = "usuario.db";
    public static final int DATABASE_VERSION = 1;

    public static final class UsuarioEntry implements BaseColumns {
        public static final String TABLE_NAME = "usuario";
        public static final String COLUMN_NAME_NOME = "nome";
        public static final String COLUMN_NAME_GENERO = "genero";
        public static final String COLUMN_NAME_META = "meta";
        public static final String COLUMN_NAME_DIA_TREINO_DOMINGO = "dia_treino_domingo";
        public static final String COLUMN_NAME_DIA_TREINO_SEGUNDA = "dia_treino_segunda";
        public static final String COLUMN_NAME_DIA_TREINO_TERCA = "dia_treino_terca";
        public static final String COLUMN_NAME_DIA_TREINO_QUARTA = "dia_treino_quarta";
        public static final String COLUMN_NAME_DIA_TREINO_QUINTA = "dia_treino_quinta";
        public static final String COLUMN_NAME_DIA_TREINO_SEXTA = "dia_treino_sexta";
        public static final String COLUMN_NAME_DIA_TREINO_SABADO = "dia_treino_sabado";
        public static final String COLUMN_NAME_PESO = "peso";
    }

}