package br.gestaoManutencao.visao.gui;

import br.gestaoManutencao.controle.EquipamentoDAO;
import br.gestaoManutencao.modelo.Equipamento;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaVisualizarEquipamentos extends JFrame {

    public TelaVisualizarEquipamentos() {
        setTitle("Visualizar Equipamentos");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        EquipamentoDAO equipamentoDAO = new EquipamentoDAO();
        List<Equipamento> equipamentos = equipamentoDAO.buscarTodos();

        String[] columnNames = {"ID", "Nome", "Modelo", "Ano"};
        Object[][] data = new Object[equipamentos.size()][4];

        for (int i = 0; i < equipamentos.size(); i++) {
            Equipamento e = equipamentos.get(i);
            data[i][0] = e.getId();
            data[i][1] = e.getNome();
            data[i][2] = e.getModelo();
            data[i][3] = e.getAno();
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }
}
