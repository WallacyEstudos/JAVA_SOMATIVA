package br.gestaoManutencao.controle;

import br.gestaoManutencao.modelo.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioDAOTest {

    private UsuarioDAO usuarioDAO;

    @BeforeEach
    public void setUp() throws SQLException {
        usuarioDAO = new UsuarioDAO();
    }

    @Test
    public void testInserirUsuario() throws SQLException {
        Usuario usuario = new Usuario(0, "Teste", "teste@example.com", "senha123");
        usuarioDAO.inserir(usuario);
        
        List<Usuario> usuarios = usuarioDAO.buscarTodos();
        assertTrue(usuarios.stream().anyMatch(u -> u.getEmail().equals("teste@example.com")));
    }

    @Test
    public void testBuscarTodos() throws SQLException {
        List<Usuario> usuarios = usuarioDAO.buscarTodos();
        assertNotNull(usuarios);
        assertFalse(usuarios.isEmpty());
    }

    @Test
    public void testBuscarPorId() throws SQLException {
        Usuario usuario = usuarioDAO.buscarPorId(1); // Altere o ID conforme necessário
        assertNotNull(usuario);
        assertEquals("Nome Esperado", usuario.getNome()); // Altere para o nome que você espera
    }

    @Test
    public void testAtualizarUsuario() throws SQLException {
        Usuario usuario = new Usuario(1, "Nome Atualizado", "atualizado@example.com", "novaSenha");
        usuarioDAO.atualizar(usuario);
        
        Usuario usuarioAtualizado = usuarioDAO.buscarPorId(1); // Altere o ID conforme necessário
        assertEquals("Nome Atualizado", usuarioAtualizado.getNome());
        assertEquals("atualizado@example.com", usuarioAtualizado.getEmail());
    }

    @Test
    public void testRemoverUsuario() throws SQLException {
        Usuario usuario = new Usuario(0, "Remover", "remover@example.com", "senhaRemover");
        usuarioDAO.inserir(usuario);
        
        List<Usuario> usuariosAntes = usuarioDAO.buscarTodos();
        usuarioDAO.remover(usuario.getId());

        List<Usuario> usuariosDepois = usuarioDAO.buscarTodos();
        assertEquals(usuariosAntes.size() - 1, usuariosDepois.size());
        assertFalse(usuariosDepois.stream().anyMatch(u -> u.getEmail().equals("remover@example.com")));
    }
}
