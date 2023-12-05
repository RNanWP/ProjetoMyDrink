package com.mydrink.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:mysql://localhost:3306/banco_varejo";
    private static final String USUARIO = "root";
    private static final String SENHA = "root";

    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException | SQLException e) {
            // Trate ou relance as exceções de uma maneira apropriada para seu aplicativo
            throw new SQLException("Erro ao obter conexão com o banco de dados", e);
        }
    }
}
