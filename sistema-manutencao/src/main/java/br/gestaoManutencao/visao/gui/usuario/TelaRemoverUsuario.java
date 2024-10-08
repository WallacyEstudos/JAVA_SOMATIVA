package br.gestaoManutencao.visao.gui;

import br.gestaoManutencao.controle.UsuarioDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class TelaRemoverUsuario extends JDialog {
    
    private JTextField txtId;

    public TelaRemoverUsuario() {
        setTitle("Remover Usuário");
        setSize(300, 150);
        setModal(true);
        setLocationRelativeTo(null);
        
        // Painel para campos de entrada
        JPanel panel = new JPanel(new GridLayout(2, 2));
        
        panel.add(new JLabel("ID:"));
        txtId = new JTextField();
        panel.add(txtId);
        
        JButton btnRemover = new JButton("Remover");
        panel.add(btnRemover);
        
        add(panel);
        
        // Ação do botão de remoção
        btnRemover.addActionListener(e -> {
            try {
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                int id = Integer.parseInt(txtId.getText());
                usuarioDAO.remover(id);
                JOptionPane.showMessageDialog(TelaRemoverUsuario.this, "Usuário removido com sucesso!");
                dispose();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(TelaRemoverUsuario.this, "Erro ao remover usuário: " + ex.getMessage());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(TelaRemoverUsuario.this, "Por favor, insira um ID válido.");
            }
        });
    }
}
