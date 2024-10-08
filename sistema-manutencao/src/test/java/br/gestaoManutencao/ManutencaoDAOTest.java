package br.gestaoManutencao.controle;

import br.gestaoManutencao.modelo.Manutencao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ManutencaoDAOTest {

    private ManutencaoDAO manutencaoDAO;

    @BeforeEach
    public void setUp() throws SQLException {
        manutencaoDAO = new ManutencaoDAO();
    }

    @Test
    public void testInserirManutencao() throws SQLException {
        Manutencao manutencao = new Manutencao(0, "2024-10-10", "Equipamento Teste", "Descrição da Manutenção");
        manutencaoDAO.inserir(manutencao);
        
        List<Manutencao> manutenções = manutencaoDAO.buscarTodos();
        assertTrue(manutenções.stream().anyMatch(m -> m.getEquipamento().equals("Equipamento Teste")));
    }

    @Test
    public void testBuscarTodos() throws SQLException {
        List<Manutencao> manutenções = manutencaoDAO.buscarTodos();
        assertNotNull(manutenções);
        assertFalse(manutenções.isEmpty());
    }

    @Test
    public void testBuscarPorId() throws SQLException {
        Manutencao manutencao = manutencaoDAO.buscarPorId(1); // Altere o ID conforme necessário
        assertNotNull(manutencao);
        assertEquals("Descrição Esperada", manutencao.getDescricao()); // Altere para a descrição que você espera
    }

    @Test
    public void testAtualizarManutencao() throws SQLException {
        Manutencao manutencao = new Manutencao(1, "2024-11-10", "Equipamento Atualizado", "Descrição Atualizada");
        manutencaoDAO.atualizar(manutencao);
        
        Manutencao manutencaoAtualizada = manutencaoDAO.buscarPorId(1); // Altere o ID conforme necessário
        assertEquals("Equipamento Atualizado", manutencaoAtualizada.getEquipamento());
    }

    @Test
    public void testRemoverManutencao() throws SQLException {
        Manutencao manutencao = new Manutencao(0, "2024-10-15", "Remover Equipamento", "Descrição Remover");
        manutencaoDAO.inserir(manutencao);
        
        List<Manutencao> manutençõesAntes = manutencaoDAO.buscarTodos();
        manutencaoDAO.remover(manutencao.getId());

        List<Manutencao> manutençõesDepois = manutencaoDAO.buscarTodos();
        assertEquals(manutençõesAntes.size() - 1, manutençõesDepois.size());
        assertFalse(manutençõesDepois.stream().anyMatch(m -> m.getEquipamento().equals("Remover Equipamento")));
    }
}
