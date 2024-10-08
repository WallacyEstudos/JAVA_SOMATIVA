package br.gestaoManutencao.visao.gui;

import br.gestaoManutencao.controle.EquipamentoDAO;
import br.gestaoManutencao.modelo.Equipamento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaAtualizarEquipamento extends JFrame {
    private JTextField txtId;
    private JTextField txtNome;
    private JTextField txtModelo;
    private JTextField txtAno;

    public TelaAtualizarEquipamento() {
        setTitle("Atualizar Equipamento");
        setSize(300, 250);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        panel.add(new JLabel("ID:"));
        txtId = new JTextField();
        panel.add(txtId);

        panel.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        panel.add(txtNome);

        panel.add(new JLabel("Modelo:"));
        txtModelo = new JTextField();
        panel.add(txtModelo);

        panel.add(new JLabel("Ano:"));
        txtAno = new JTextField();
        panel.add(txtAno);

        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.addActionListener(this::atualizarEquipamento);
        panel.add(btnAtualizar);

        add(panel);
    }

    private void atualizarEquipamento(ActionEvent e) {
        int id = Integer.parseInt(txtId.getText());
        String nome = txtNome.getText();
        String modelo = txtModelo.getText();
        int ano = Integer.parseInt(txtAno.getText());

        Equipamento equipamento = new Equipamento(id, nome, modelo, ano);
        EquipamentoDAO equipamentoDAO = new EquipamentoDAO();
        try {
            equipamentoDAO.atualizar(equipamento);
            JOptionPane.showMessageDialog(this, "Equipamento atualizado com sucesso!");
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar equipamento: " + ex.getMessage());
        }
    }
}
