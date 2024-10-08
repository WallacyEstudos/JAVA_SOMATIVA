package br.gestaoManutencao.visao.gui;

import br.gestaoManutencao.controle.ManutencaoDAO;
import br.gestaoManutencao.modelo.Manutencao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class TelaCadastrarManutencao extends JDialog {
    
    private JTextField txtEquipamentoId, txtDescricao, txtData;

    public TelaCadastrarManutencao() {
        setTitle("Cadastrar Manutenção");
        setSize(300, 250);
        setModal(true);
        setLocationRelativeTo(null);
        
        // Painel para campos de entrada
        JPanel panel = new JPanel(new GridLayout(4, 2));
        
        panel.add(new JLabel("ID do Equipamento:"));
        txtEquipamentoId = new JTextField();
        panel.add(txtEquipamentoId);
        
        panel.add(new JLabel("Descrição:"));
        txtDescricao = new JTextField();
        panel.add(txtDescricao);
        
        panel.add(new JLabel("Data:"));
        txtData = new JTextField();
        panel.add(txtData);
        
        JButton btnCadastrar = new JButton("Cadastrar");
        panel.add(btnCadastrar);
        
        add(panel);
        
        // Ação do botão de cadastro
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ManutencaoDAO manutencaoDAO = new ManutencaoDAO();
                    Manutencao manutencao = new Manutencao(0, Integer.parseInt(txtEquipamentoId.getText()), 
                                                            txtDescricao.getText(), txtData.getText());
                    manutencaoDAO.inserir(manutencao);
                    JOptionPane.showMessageDialog(TelaCadastrarManutencao.this, "Manutenção cadastrada com sucesso!");
                    dispose();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(TelaCadastrarManutencao.this, "Erro ao cadastrar manutenção: " + ex.getMessage());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(TelaCadastrarManutencao.this, "Por favor, insira um ID de equipamento válido.");
                }
            }
        });
    }
}
