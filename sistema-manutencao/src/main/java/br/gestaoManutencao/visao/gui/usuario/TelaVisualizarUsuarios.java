package br.gestaoManutencao.visao.gui;

import br.gestaoManutencao.controle.UsuarioDAO;
import br.gestaoManutencao.modelo.Usuario;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class TelaVisualizarUsuarios extends JDialog {
    
    public TelaVisualizarUsuarios() {
        setTitle("Visualizar Usuários");
        setSize(400, 300);
        setModal(true);
        setLocationRelativeTo(null);
        
        // Painel para exibição
        JPanel panel = new JPanel(new BorderLayout());
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            List<Usuario> usuarios = usuarioDAO.buscarTodos();
            StringBuilder sb = new StringBuilder();
            for (Usuario usuario : usuarios) {
                sb.append("ID: ").append(usuario.getId()).append(", Nome: ").append(usuario.getNome())
                  .append(", Email: ").append(usuario.getEmail()).append("\n");
            }
            textArea.setText(sb.toString());
        } catch (SQLException ex) {
            textArea.setText("Erro ao buscar usuários: " + ex.getMessage());
        }
        
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(panel);
    }
}
