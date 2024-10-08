package br.gestaoManutencao.visao.gui;

import javax.swing.*;
import java.awt.*;

public class TelaEquipamento extends JFrame {

    private JTextField txtNome;
    private JTextField txtDescricao;
    private JButton btnSalvar;
    private JButton btnCancelar;

    public TelaEquipamento() {
        setTitle("Cadastro de Equipamento");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel panel = new JPanel(new GridLayout(3, 2));

        // Campos de texto e botões
        panel.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        panel.add(txtNome);

        panel.add(new JLabel("Descrição:"));
        txtDescricao = new JTextField();
        panel.add(txtDescricao);

        btnSalvar = new JButton("Salvar");
        panel.add(btnSalvar);

        btnCancelar = new JButton("Cancelar");
        panel.add(btnCancelar);

        add(panel);
    }

    // Getters para os componentes
    public JTextField getTxtNome() {
        return txtNome;
    }

    public JTextField getTxtDescricao() {
        return txtDescricao;
    }

    public JButton getBtnSalvar() {
        return btnSalvar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }
}
