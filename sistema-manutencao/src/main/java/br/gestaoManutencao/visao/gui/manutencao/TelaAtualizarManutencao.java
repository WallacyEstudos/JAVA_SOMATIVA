package br.gestaoManutencao.visao.gui;

import br.gestaoManutencao.controle.ManutencaoDAO;
import br.gestaoManutencao.modelo.Manutencao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class TelaAtualizarManutencao extends JDialog {
    
    private JTextField txtId, txtEquipamentoId, txtDescricao, txtData;

    public TelaAtualizarManutencao() {
        setTitle("Atualizar Manutenção");
        setSize(300, 300);
        setModal(true);
        setLocationRelativeTo(null);
        
        // Painel para campos de entrada
        JPanel panel = new JPanel(new GridLayout(5, 2));
        
        panel.add(new JLabel("ID:"));
        txtId = new JTextField();
        panel.add(txtId);
        
        panel.add(new JLabel("ID do Equipamento:"));
        txtEquipamentoId = new JTextField();
        panel.add(txtEquipamentoId);
        
        panel.add(new JLabel("Descrição:"));
        txtDescricao = new JTextField();
        panel.add(txtDescricao);
        
        panel.add(new JLabel("Data:"));
        txtData = new JTextField();
        panel.add(txtData);
        
        JButton btnAtualizar = new JButton("Atualizar");
        panel.add(btnAtualizar);
        
        add(panel);
        
        // Ação do botão de atualização
        btnAtualizar.addActionListener(e -> {
            try {
                ManutencaoDAO manutencaoDAO = new ManutencaoDAO();
                Manutencao manutencao = new Manutencao(Integer.parseInt(txtId.getText()), 
                                                        Integer.parseInt(txtEquipamentoId.getText()), 
                                                        txtDescricao.getText(), txtData.getText());
                manutencaoDAO.atualizar(manutencao);
                JOptionPane.showMessageDialog(TelaAtualizarManutencao.this, "Manutenção atualizada com sucesso!");
                dispose();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(TelaAtualizarManutencao.this, "Erro ao atualizar manutenção: " + ex.getMessage());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(TelaAtualizarManutencao.this, "Por favor, insira IDs válidos.");
            }
        });
    }
}
