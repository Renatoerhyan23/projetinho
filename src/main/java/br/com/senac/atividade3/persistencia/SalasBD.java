package br.com.senac.atividade3.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

public class SalasBD {
public List<Salas> listar(int id){
    EntityManager em = JPAUtil.getEntityManager();
    List<Salas> salas = null;
        try{ 
          String textoQuery = "SELECT s FROM Salas s JOIN Filmes f ON s.id_filmes = f.id WHERE f.titulo = (SELECT titulo FROM Filmes WHERE id = :id)";
            
          Query consulta = em.createQuery(textoQuery);
          consulta.setParameter("id", id);  
            
          salas = consulta.getResultList();
        } finally{  JPAUtil.closeEtityManager();  }
   return salas;
 }    
}
