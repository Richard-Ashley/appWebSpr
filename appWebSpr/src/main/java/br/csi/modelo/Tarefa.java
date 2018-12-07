package br.csi.modelo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



public class Tarefa {
        
    private Integer id;
    
    @NotNull    
    private String nome;
    
    @NotNull
    @Size(min=5)
    private String descricao;

    public Tarefa() {        
    }
    
    public Tarefa(Integer id, String nome, String descricao) {        
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Tarefa(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {        
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
    
    
    
}
