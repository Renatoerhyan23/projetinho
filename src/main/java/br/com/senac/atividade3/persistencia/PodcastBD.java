package br.com.senac.atividade3.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Renato Rodrigues
 */ 
/* Classe para manipular a tabela "Podcast" do banco de dados - TDS */
public class PodcastBD {
public void cadastrar(Podcast p){
          EntityManager em = JPAUtil.getEntityManager();
          try {
              em.getTransaction().begin();
              em.persist(p);
              em.getTransaction().commit();
              JOptionPane.showMessageDialog(null, "Dados cadastrados com sucesso!");
              
          }catch(Exception e){
              em.getTransaction().rollback();
              throw e;
          }
          finally{
              JPAUtil.closeEtityManager();
          }
      }

    public List<Podcast> listar(String filtroProdutor){
      EntityManager em = JPAUtil.getEntityManager();
      List podcasts = null;
      try{
          String textoQuery = "SELECT p FROM Podcast p"+
                  " WHERE (:produtor is null OR p.produtor LIKE :produtor ) ";
          
          Query consulta = em.createQuery(textoQuery);
          
          consulta.setParameter("produtor", filtroProdutor.isEmpty() ? null : "%" + filtroProdutor + "%" );        
          
          podcasts = consulta.getResultList();
      }finally{
          JPAUtil.closeEtityManager();
      }
      return podcasts;
    }
    
        public void excluir(int id){
      EntityManager em = JPAUtil.getEntityManager();
      
      try{
          Podcast p = em.find(Podcast.class, id);
          if(p != null){
              em.getTransaction().begin();
              em.remove(p);
              em.getTransaction().commit();
          }
      }catch(Exception e){
          em.getTransaction().rollback();
          throw e;
      }
      finally{
          JPAUtil.closeEtityManager();
      }
    }
}
