package br.gestaoManutencao.modelo;

public class Equipamento {

    private int id;
    private String nome;
    private String descricao;

    // Construtor
    public Equipamento(int id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Equipamento [id=" + id + ", nome=" + nome + ", descricao=" + descricao + "]";
    }
}
