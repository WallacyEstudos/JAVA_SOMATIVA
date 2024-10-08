package br.gestaoManutencao.controle;

import br.gestaoManutencao.modelo.Equipamento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EquipamentoDAOTest {

    private EquipamentoDAO equipamentoDAO;

    @BeforeEach
    public void setUp() throws SQLException {
        equipamentoDAO = new EquipamentoDAO();
    }

    @Test
    public void testInserirEquipamento() throws SQLException {
        Equipamento equipamento = new Equipamento(0, "Equipamento Teste", "Descrição", "Tipo", 2023);
        equipamentoDAO.inserir(equipamento);
        
        List<Equipamento> equipamentos = equipamentoDAO.buscarTodos();
        assertTrue(equipamentos.stream().anyMatch(e -> e.getNome().equals("Equipamento Teste")));
    }

    @Test
    public void testBuscarTodos() throws SQLException {
        List<Equipamento> equipamentos = equipamentoDAO.buscarTodos();
        assertNotNull(equipamentos);
        assertFalse(equipamentos.isEmpty());
    }

    @Test
    public void testBuscarPorId() throws SQLException {
        Equipamento equipamento = equipamentoDAO.buscarPorId(1); // Altere o ID conforme necessário
        assertNotNull(equipamento);
        assertEquals("Nome Esperado", equipamento.getNome()); // Altere para o nome que você espera
    }

    @Test
    public void testAtualizarEquipamento() throws SQLException {
        Equipamento equipamento = new Equipamento(1, "Nome Atualizado", "Descrição Atualizada", "Tipo Atualizado", 2024);
        equipamentoDAO.atualizar(equipamento);
        
        Equipamento equipamentoAtualizado = equipamentoDAO.buscarPorId(1); // Altere o ID conforme necessário
        assertEquals("Nome Atualizado", equipamentoAtualizado.getNome());
    }

    @Test
    public void testRemoverEquipamento() throws SQLException {
        Equipamento equipamento = new Equipamento(0, "Remover Equipamento", "Descrição Remover", "Tipo", 2023);
        equipamentoDAO.inserir(equipamento);
        
        List<Equipamento> equipamentosAntes = equipamentoDAO.buscarTodos();
        equipamentoDAO.remover(equipamento.getId());

        List<Equipamento> equipamentosDepois = equipamentoDAO.buscarTodos();
        assertEquals(equipamentosAntes.size() - 1, equipamentosDepois.size());
        assertFalse(equipamentosDepois.stream().anyMatch(e -> e.getNome().equals("Remover Equipamento")));
    }
}
