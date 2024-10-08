package br.gestaoManutencao.visao.gui;

import br.gestaoManutencao.controle.UsuarioDAO;
import br.gestaoManutencao.modelo.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class TelaAtualizarUsuario extends JDialog {
    
    private JTextField txtId, txtNome, txtEmail, txtSenha;

    public TelaAtualizarUsuario() {
        setTitle("Atualizar Usuário");
        setSize(300, 200);
        setModal(true);
        setLocationRelativeTo(null);
        
        // Painel para campos de entrada
        JPanel panel = new JPanel(new GridLayout(5, 2));
        
        panel.add(new JLabel("ID:"));
        txtId = new JTextField();
        panel.add(txtId);
        
        panel.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        panel.add(txtNome);
        
        panel.add(new JLabel("Email:"));
        txtEmail = new JTextField();
        panel.add(txtEmail);
        
        panel.add(new JLabel("Senha:"));
        txtSenha = new JPasswordField();
        panel.add(txtSenha);
        
        JButton btnAtualizar = new JButton("Atualizar");
        panel.add(btnAtualizar);
        
        add(panel);
        
        // Ação do botão de atualização
        btnAtualizar.addActionListener(e -> {
            try {
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                Usuario usuario = new Usuario(Integer.parseInt(txtId.getText()), txtNome.getText(), txtEmail.getText(), txtSenha.getText());
                usuarioDAO.atualizar(usuario);
                JOptionPane.showMessageDialog(TelaAtualizarUsuario.this, "Usuário atualizado com sucesso!");
                dispose();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(TelaAtualizarUsuario.this, "Erro ao atualizar usuário: " + ex.getMessage());
            }
        });
    }
}
