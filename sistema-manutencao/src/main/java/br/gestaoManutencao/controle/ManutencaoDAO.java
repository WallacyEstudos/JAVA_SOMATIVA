package br.gestaoManutencao.controle;

import br.gestaoManutencao.modelo.Manutencao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManutencaoDAO {
    private Connection connection;

    public ManutencaoDAO() throws SQLException {
        this.connection = ConexaoBD.getConnection();
    }

    // Método para inserir uma nova manutenção no banco de dados
    public void inserir(Manutencao manutencao) throws SQLException {
        String sql = "INSERT INTO manutencoes (equipamento_id, data, tipo, descricao) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, manutencao.getEquipamentoId());
            stmt.setDate(2, new java.sql.Date(manutencao.getData().getTime()));
            stmt.setString(3, manutencao.getTipo());
            stmt.setString(4, manutencao.getDescricao());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro ao inserir a manutenção: " + e.getMessage());
        }
    }

    // Método para buscar todas as manutenções
    public List<Manutencao> buscarTodos() throws SQLException {
        List<Manutencao> manutencoes = new ArrayList<>();
        String sql = "SELECT * FROM manutencoes";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                int equipamentoId = rs.getInt("equipamento_id");
                java.sql.Date data = rs.getDate("data");
                String tipo = rs.getString("tipo");
                String descricao = rs.getString("descricao");

                Manutencao manutencao = new Manutencao(id, equipamentoId, new java.util.Date(data.getTime()), tipo, descricao);
                manutencoes.add(manutencao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro ao buscar manutenções: " + e.getMessage());
        }
        return manutencoes;
    }

    // Método para buscar manutenção por ID
    public Manutencao buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM manutencoes WHERE id = ?";
        Manutencao manutencao = null;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int equipamentoId = rs.getInt("equipamento_id");
                    java.sql.Date data = rs.getDate("data");
                    String tipo = rs.getString("tipo");
                    String descricao = rs.getString("descricao");

                    manutencao = new Manutencao(id, equipamentoId, new java.util.Date(data.getTime()), tipo, descricao);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro ao buscar manutenção por ID: " + e.getMessage());
        }
        return manutencao;
    }

    // Método para atualizar uma manutenção
    public void atualizar(Manutencao manutencao) throws SQLException {
        String sql = "UPDATE manutencoes SET equipamento_id = ?, data = ?, tipo = ?, descricao = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, manutencao.getEquipamentoId());
            stmt.setDate(2, new java.sql.Date(manutencao.getData().getTime()));
            stmt.setString(3, manutencao.getTipo());
            stmt.setString(4, manutencao.getDescricao());
            stmt.setInt(5, manutencao.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro ao atualizar a manutenção: " + e.getMessage());
        }
    }

    // Método para remover uma manutenção
    public void remover(int id) throws SQLException {
        String sql = "DELETE FROM manutencoes WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro ao remover a manutenção: " + e.getMessage());
        }
    }
}
