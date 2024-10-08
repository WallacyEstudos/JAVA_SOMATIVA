package br.gestaoManutencao.visao.gui;

import javax.swing.*;
import java.awt.*;

public class TelaManutencao extends JFrame {

    private JComboBox<String> cbEquipamentos;
    private JTextField txtDataManutencao;
    private JTextField txtStatus;
    private JButton btnSalvar;
    private JButton btnCancelar;

    public TelaManutencao() {
        setTitle("Cadastro de Manutenção");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel panel = new JPanel(new GridLayout(4, 2));

        // Campos de texto e botões
        panel.add(new JLabel("Equipamento:"));
        cbEquipamentos = new JComboBox<>();
        panel.add(cbEquipamentos);

        panel.add(new JLabel("Data Manutenção:"));
        txtDataManutencao = new JTextField();
        panel.add(txtDataManutencao);

        panel.add(new JLabel("Status:"));
        txtStatus = new JTextField();
        panel.add(txtStatus);

        btnSalvar = new JButton("Salvar");
        panel.add(btnSalvar);

        btnCancelar = new JButton("Cancelar");
        panel.add(btnCancelar);

        add(panel);
    }

    // Getters para os componentes
    public JComboBox<String> getCbEquipamentos() {
        return cbEquipamentos;
    }

    public JTextField getTxtDataManutencao() {
        return txtDataManutencao;
    }

    public JTextField getTxtStatus() {
        return txtStatus;
    }

    public JButton getBtnSalvar() {
        return btnSalvar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }
}
