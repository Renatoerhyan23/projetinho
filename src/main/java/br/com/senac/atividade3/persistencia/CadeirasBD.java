package br.com.senac.atividade3.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class CadeirasBD {
    public List<Integer> cadeirasOc() {
    EntityManager em = JPAUtil.getEntityManager();
    List<Integer> cadeirasOcupadas = new ArrayList<>();
    
    try{em.getTransaction().begin();
        TypedQuery<Integer> query = em.createQuery("SELECT c.id FROM Cadeiras c WHERE c.ocupada = true", Integer.class);
        cadeirasOcupadas = query.getResultList();
        em.getTransaction().commit();        
    } catch (Exception e) 
    { em.getTransaction().rollback(); e.printStackTrace(); } 
    finally { em.close(); }

    return cadeirasOcupadas;
    }
    
public boolean consultarCadeiraOcupada(int id, int cadeiraNumero) {  
    EntityManager em = JPAUtil.getEntityManager();
    try {
        Query query = em.createQuery("SELECT c.ocupada FROM Cadeiras c WHERE c.id_sala = :idSala AND c.id = :idCadeira", Boolean.class);
        query.setParameter("idSala", id);
        query.setParameter("idCadeira", (cadeiraNumero + ((id - 1) * 60)));
        Boolean ocupada; try { ocupada = (Boolean) query.getSingleResult();} 
        catch (NoResultException e) {
            ocupada = false;
        } return ocupada;
    } finally { em.close(); }
 }    
}
