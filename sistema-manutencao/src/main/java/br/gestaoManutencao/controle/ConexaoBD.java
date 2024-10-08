package br.gestaoManutencao.controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

    private static final String URL = "jdbc:postgresql://localhost:5432/gestaomanutencao";  // URL do banco de dados
    private static final String USER = "postgres";  // Usuário do banco de dados
    private static final String PASSWORD = "1234";  // Senha do banco de dados

    // Método para obter a conexão com o banco de dados
    public static Connection getConnection() throws SQLException {
        try {
            // Carrega o driver JDBC para PostgreSQL
            Class.forName("org.postgresql.Driver");
            // Retorna a conexão
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Erro ao carregar o driver do banco de dados", e);
        }
    }

    // Método para fechar a conexão
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
