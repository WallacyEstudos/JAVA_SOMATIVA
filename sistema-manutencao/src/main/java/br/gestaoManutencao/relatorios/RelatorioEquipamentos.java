package br.gestaoManutencao.relatorios;

import br.gestaoManutencao.modelo.Equipamento;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class RelatorioEquipamentos {

    public void gerarRelatorio(List<Equipamento> equipamentos, String caminhoArquivo) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(caminhoArquivo))) {
            // Cabeçalho do CSV
            String[] cabecalho = { "ID", "Nome", "Marca", "Modelo", "Ano" };
            writer.writeNext(cabecalho);

            // Adiciona os dados dos equipamentos
            for (Equipamento equipamento : equipamentos) {
                String[] dados = {
                    String.valueOf(equipamento.getId()),
                    equipamento.getNome(),
                    equipamento.getMarca(),
                    equipamento.getModelo(),
                    String.valueOf(equipamento.getAno()) // Supondo que você tenha esse método
                };
                writer.writeNext(dados);
            }
            System.out.println("Relatório gerado com sucesso em " + caminhoArquivo);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao gerar o relatório: " + e.getMessage());
        }
    }
}
