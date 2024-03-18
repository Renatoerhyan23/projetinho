package br.com.senac.atividade3.persistencia;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author Renato Rodrigues
 */ 
/* Entidade-Classe-Tabela Podcast - TDS */
            @Entity
public class Podcast {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String produtor, nome_episodio, numero_episodio, duracao, url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProdutor() {
        return produtor;
    }

    public void setProdutor(String produtor) {
        this.produtor = produtor;
    }

    public String getNome_episodio() {
        return nome_episodio;
    }

    public void setNome_episodio(String nome_episodio) {
        this.nome_episodio = nome_episodio;
    }

    public String getNumero_episodio() {
        return numero_episodio;
    }

    public void setNumero_episodio(String numero_episodio) {
        this.numero_episodio = numero_episodio;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
}
