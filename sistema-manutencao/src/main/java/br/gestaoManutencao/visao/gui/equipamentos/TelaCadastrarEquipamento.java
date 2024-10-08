package br.gestaoManutencao.visao.gui;

import br.gestaoManutencao.controle.EquipamentoDAO;
import br.gestaoManutencao.modelo.Equipamento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaCadastrarEquipamento extends JFrame {
    private JTextField txtNome;
    private JTextField txtModelo;
    private JTextField txtAno;
    
    public TelaCadastrarEquipamento() {
        setTitle("Cadastrar Equipamento");
        setSize(300, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        panel.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        panel.add(txtNome);

        panel.add(new JLabel("Modelo:"));
        txtModelo = new JTextField();
        panel.add(txtModelo);

        panel.add(new JLabel("Ano:"));
        txtAno = new JTextField();
        panel.add(txtAno);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(this::cadastrarEquipamento);
        panel.add(btnCadastrar);

        add(panel);
    }

    private void cadastrarEquipamento(ActionEvent e) {
        String nome = txtNome.getText();
        String modelo = txtModelo.getText();
        int ano = Integer.parseInt(txtAno.getText());

        Equipamento equipamento = new Equipamento(nome, modelo, ano);
        EquipamentoDAO equipamentoDAO = new EquipamentoDAO();
        try {
            equipamentoDAO.inserir(equipamento);
            JOptionPane.showMessageDialog(this, "Equipamento cadastrado com sucesso!");
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar equipamento: " + ex.getMessage());
        }
    }
}
