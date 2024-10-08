package br.gestaoManutencao.modelo;

import java.util.Date;

public class Manutencao {

    private int id;
    private Equipamento equipamento;
    private Date dataManutencao;
    private String status;

    // Construtor
    public Manutencao(int id, Equipamento equipamento, Date dataManutencao, String status) {
        this.id = id;
        this.equipamento = equipamento;
        this.dataManutencao = dataManutencao;
        this.status = status;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public Date getDataManutencao() {
        return dataManutencao;
    }

    public void setDataManutencao(Date dataManutencao) {
        this.dataManutencao = dataManutencao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Manutencao [id=" + id + ", equipamento=" + equipamento.getNome() + ", dataManutencao=" + dataManutencao + ", status=" + status + "]";
    }
}
