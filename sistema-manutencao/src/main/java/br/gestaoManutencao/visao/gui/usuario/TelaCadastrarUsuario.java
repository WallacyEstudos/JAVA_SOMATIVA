package br.gestaoManutencao.visao.gui;

import br.gestaoManutencao.controle.UsuarioDAO;
import br.gestaoManutencao.modelo.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class TelaCadastrarUsuario extends JDialog {
    
    private JTextField txtNome, txtEmail, txtSenha;

    public TelaCadastrarUsuario() {
        setTitle("Cadastrar Usuário");
        setSize(300, 200);
        setModal(true);
        setLocationRelativeTo(null);
        
        // Painel para campos de entrada
        JPanel panel = new JPanel(new GridLayout(4, 2));
        
        panel.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        panel.add(txtNome);
        
        panel.add(new JLabel("Email:"));
        txtEmail = new JTextField();
        panel.add(txtEmail);
        
        panel.add(new JLabel("Senha:"));
        txtSenha = new JPasswordField();
        panel.add(txtSenha);
        
        JButton btnCadastrar = new JButton("Cadastrar");
        panel.add(btnCadastrar);
        
        add(panel);
        
        // Ação do botão de cadastro
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UsuarioDAO usuarioDAO = new UsuarioDAO();
                    Usuario usuario = new Usuario(0, txtNome.getText(), txtEmail.getText(), txtSenha.getText());
                    usuarioDAO.inserir(usuario);
                    JOptionPane.showMessageDialog(TelaCadastrarUsuario.this, "Usuário cadastrado com sucesso!");
                    dispose();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(TelaCadastrarUsuario.this, "Erro ao cadastrar usuário: " + ex.getMessage());
                }
            }
        });
    }
}
