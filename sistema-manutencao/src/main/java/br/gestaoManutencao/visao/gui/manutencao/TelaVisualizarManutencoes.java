package br.gestaoManutencao.visao.gui;

import br.gestaoManutencao.controle.ManutencaoDAO;
import br.gestaoManutencao.modelo.Manutencao;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class TelaVisualizarManutencoes extends JDialog {
    
    public TelaVisualizarManutencoes() {
        setTitle("Visualizar Manutenções");
        setSize(400, 300);
        setModal(true);
        setLocationRelativeTo(null);
        
        // Painel para exibição
        JPanel panel = new JPanel(new BorderLayout());
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        
        try {
            ManutencaoDAO manutencaoDAO = new ManutencaoDAO();
            List<Manutencao> manutencoes = manutencaoDAO.buscarTodos();
            StringBuilder sb = new StringBuilder();
            for (Manutencao manutencao : manutencoes) {
                sb.append("ID: ").append(manutencao.getId()).append(", ID Equipamento: ")
                  .append(manutencao.getEquipamentoId()).append(", Descrição: ")
                  .append(manutencao.getDescricao()).append(", Data: ")
                  .append(manutencao.getData()).append("\n");
            }
            textArea.setText(sb.toString());
        } catch (SQLException ex) {
            textArea.setText("Erro ao buscar manutenções: " + ex.getMessage());
        }
        
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(panel);
    }
}
