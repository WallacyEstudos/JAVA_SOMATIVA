package br.gestaoManutencao.visao.gui;

import br.gestaoManutencao.controle.ManutencaoDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class TelaRemoverManutencao extends JDialog {
    
    private JTextField txtId;

    public TelaRemoverManutencao() {
        setTitle("Remover Manutenção");
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
                ManutencaoDAO manutencaoDAO = new ManutencaoDAO();
                int id = Integer.parseInt(txtId.getText());
                manutencaoDAO.remover(id);
                JOptionPane.showMessageDialog(TelaRemoverManutencao.this, "Manutenção removida com sucesso!");
                dispose();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(TelaRemoverManutencao.this, "Erro ao remover manutenção: " + ex.getMessage());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(TelaRemoverManutencao.this, "Por favor, insira um ID válido.");
            }
        });
    }
}
