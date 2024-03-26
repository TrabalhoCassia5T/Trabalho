package com.example.UnoLibrary.Pedido;

public class DBSingleton {
    private static Conexao con;
    public static boolean conectar()
    {
        con=new Conexao();
        return con.conectar("jdbc:postgresql://localhost:5432/",
                "biblioteca","postgres","postgres123");
    }

    public static Conexao getCon() {
        return con;
    }
}