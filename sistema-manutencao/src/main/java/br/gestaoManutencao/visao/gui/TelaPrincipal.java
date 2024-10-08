package br.gestaoManutencao.visao.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {

    public TelaPrincipal() {
        setTitle("Sistema de Gestão de Manutenção");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        // Botão para gerar relatório
        btnGerarRelatorio = new JButton("Gerar Relatório de Equipamentos");
        btnGerarRelatorio.setBounds(50, 50, 250, 30);
        add(btnGerarRelatorio);

        // Ação do botão
        btnGerarRelatorio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gerarRelatorio();
            }
        });

        // Botões de Usuários
        JButton btnCadastrarUsuario = new JButton("Cadastrar Usuário");
        JButton btnAtualizarUsuario = new JButton("Atualizar Usuário");
        JButton btnVisualizarUsuarios = new JButton("Visualizar Usuários");
        JButton btnRemoverUsuario = new JButton("Remover Usuário");

        // Adicionando os botões ao painel
        panel.add(btnCadastrarUsuario);
        panel.add(btnAtualizarUsuario);
        panel.add(btnVisualizarUsuarios);
        panel.add(btnRemoverUsuario);

        // Ações dos botões de Usuários
        btnCadastrarUsuario.addActionListener(e -> new TelaCadastrarUsuario().setVisible(true));
        btnAtualizarUsuario.addActionListener(e -> new TelaAtualizarUsuario().setVisible(true));
        btnVisualizarUsuarios.addActionListener(e -> new TelaVisualizarUsuarios().setVisible(true));
        btnRemoverUsuario.addActionListener(e -> new TelaRemoverUsuario().setVisible(true));

        // Botões de Manutenções
        JButton btnCadastrarManutencao = new JButton("Cadastrar Manutenção");
        JButton btnAtualizarManutencao = new JButton("Atualizar Manutenção");
        JButton btnVisualizarManutencoes = new JButton("Visualizar Manutenções");
        JButton btnRemoverManutencao = new JButton("Remover Manutenção");

        // Adicionando os botões de Manutenção ao painel
        panel.add(btnCadastrarManutencao);
        panel.add(btnAtualizarManutencao);
        panel.add(btnVisualizarManutencoes);
        panel.add(btnRemoverManutencao);

        // Ações dos botões de Manutenções
        btnCadastrarManutencao.addActionListener(e -> new TelaCadastrarManutencao().setVisible(true));
        btnAtualizarManutencao.addActionListener(e -> new TelaAtualizarManutencao().setVisible(true));
        btnVisualizarManutencoes.addActionListener(e -> new TelaVisualizarManutencoes().setVisible(true));
        btnRemoverManutencao.addActionListener(e -> new TelaRemoverManutencao().setVisible(true));

        // Adicionando na TelaPrincipal.java

        // Botões de Equipamentos
        JButton btnCadastrarEquipamento = new JButton("Cadastrar Equipamento");
        JButton btnAtualizarEquipamento = new JButton("Atualizar Equipamento");
        JButton btnVisualizarEquipamentos = new JButton("Visualizar Equipamentos");
        JButton btnRemoverEquipamento = new JButton("Remover Equipamento");

        // Adicionando os botões de Equipamento ao painel
        panel.add(btnCadastrarEquipamento);
        panel.add(btnAtualizarEquipamento);
        panel.add(btnVisualizarEquipamentos);
        panel.add(btnRemoverEquipamento);

        // Ações dos botões de Equipamentos
        btnCadastrarEquipamento.addActionListener(e -> new TelaCadastrarEquipamento().setVisible(true));
        btnAtualizarEquipamento.addActionListener(e -> new TelaAtualizarEquipamento().setVisible(true));
        btnVisualizarEquipamentos.addActionListener(e -> new TelaVisualizarEquipamentos().setVisible(true));
        btnRemoverEquipamento.addActionListener(e -> new TelaRemoverEquipamento().setVisible(true));

        // Adicionando o painel à tela principal
        add(panel);
    }

    private void gerarRelatorio() {
        // Instância do DAO
        EquipamentoDAO equipamentoDAO = new EquipamentoDAO();

        // Instância do Relatório
        RelatorioEquipamentos relatorioEquipamentos = new RelatorioEquipamentos(equipamentoDAO);

        // Caminho para salvar o arquivo
        String caminhoArquivo = "relatorio_equipamentos.csv";

        try {
            relatorioEquipamentos.gerarRelatorio(caminhoArquivo);
            JOptionPane.showMessageDialog(this, "Relatório gerado com sucesso em: " + caminhoArquivo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao gerar relatório: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaPrincipal().setVisible(true);
        });
    }
}
