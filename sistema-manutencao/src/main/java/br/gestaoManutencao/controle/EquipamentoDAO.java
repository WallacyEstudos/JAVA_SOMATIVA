package br.gestaoManutencao.controle;

import br.gestaoManutencao.modelo.Equipamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipamentoDAO {
    private Connection connection;

    public EquipamentoDAO() throws SQLException {
        this.connection = ConexaoBD.getConnection();
    }

    // Método para inserir um novo equipamento no banco de dados
    public void inserir(Equipamento equipamento) throws SQLException {
        String sql = "INSERT INTO equipamentos (nome, descricao, fabricante, ano) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, equipamento.getNome());
            stmt.setString(2, equipamento.getDescricao());
            stmt.setString(3, equipamento.getFabricante());
            stmt.setInt(4, equipamento.getAno());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro ao inserir o equipamento: " + e.getMessage());
        }
    }

    // Método para buscar todos os equipamentos
    public List<Equipamento> buscarTodos() throws SQLException {
        List<Equipamento> equipamentos = new ArrayList<>();
        String sql = "SELECT * FROM equipamentos";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                String fabricante = rs.getString("fabricante");
                int ano = rs.getInt("ano");

                Equipamento equipamento = new Equipamento(id, nome, descricao, fabricante, ano);
                equipamentos.add(equipamento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro ao buscar equipamentos: " + e.getMessage());
        }
        return equipamentos;
    }

    // Método para buscar equipamento por ID
    public Equipamento buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM equipamentos WHERE id = ?";
        Equipamento equipamento = null;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String nome = rs.getString("nome");
                    String descricao = rs.getString("descricao");
                    String fabricante = rs.getString("fabricante");
                    int ano = rs.getInt("ano");

                    equipamento = new Equipamento(id, nome, descricao, fabricante, ano);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro ao buscar equipamento por ID: " + e.getMessage());
        }
        return equipamento;
    }

    // Método para atualizar um equipamento
    public void atualizar(Equipamento equipamento) throws SQLException {
        String sql = "UPDATE equipamentos SET nome = ?, descricao = ?, fabricante = ?, ano = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, equipamento.getNome());
            stmt.setString(2, equipamento.getDescricao());
            stmt.setString(3, equipamento.getFabricante());
            stmt.setInt(4, equipamento.getAno());
            stmt.setInt(5, equipamento.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro ao atualizar o equipamento: " + e.getMessage());
        }
    }

    // Método para remover um equipamento
    public void remover(int id) throws SQLException {
        String sql = "DELETE FROM equipamentos WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro ao remover o equipamento: " + e.getMessage());
        }
    }
}
