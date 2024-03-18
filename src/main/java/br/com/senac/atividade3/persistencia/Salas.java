package br.com.senac.atividade3.persistencia;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

            @Entity      
public class Salas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    
    int id_filmes, capacidade;
    String horarios;

    public int getId_filmes() {
        return id_filmes;
    }

    public void setId_filmes(int id_filmes) {
        this.id_filmes = id_filmes;
    }
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }
}
