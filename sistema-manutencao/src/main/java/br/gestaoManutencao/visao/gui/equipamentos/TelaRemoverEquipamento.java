package br.gestaoManutencao.visao.gui;

import br.gestaoManutencao.controle.EquipamentoDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaRemoverEquipamento extends JFrame {
    private JTextField txtId;

    public TelaRemoverEquipamento() {
        setTitle("Remover Equipamento");
        setSize(300, 150);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        panel.add(new JLabel("ID do Equipamento:"));
        txtId = new JTextField(10);
        panel.add(txtId);

        JButton btnRemover = new JButton("Remover");
        btnRemover.addActionListener(this::removerEquipamento);
        panel.add(btnRemover);

        add(panel);
    }

    private void removerEquipamento(ActionEvent e) {
        int id = Integer.parseInt(txtId.getText());

        EquipamentoDAO equipamentoDAO = new EquipamentoDAO();
        try {
            equipamentoDAO.remover(id);
            JOptionPane.showMessageDialog(this, "Equipamento removido com sucesso!");
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao remover equipamento: " + ex.getMessage());
        }
    }
}
