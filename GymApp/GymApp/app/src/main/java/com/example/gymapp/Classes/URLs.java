package com.example.gymapp.Classes;

public class URLs {

    private static final String ROOT_URL = "http://192.168.1.213/android_db_test/Api.php?apicall=";

    public static final String URL_REGISTER = ROOT_URL + "signup";

    public static final String URL_LOGIN = ROOT_URL + "login";

    public static final String URL_AVALIACAO = "http://192.168.1.213/android_db_test/AvaliacaoFisica.php?idutilizador=";

    public static final String URL_AVALIACAOID = URL_AVALIACAO + "idutilizador";
}
