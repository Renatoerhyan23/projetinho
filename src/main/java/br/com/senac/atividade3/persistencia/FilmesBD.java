package br.com.senac.atividade3.persistencia;

import br.com.senac.atividade3.gui.TelaInicial;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;
import javax.swing.JOptionPane;

public class FilmesBD {
    public void cadastrar(Filmes f, int conf) {
     EntityManager em = JPAUtil.getEntityManager();
     String textoQuery = "SELECT titulo FROM Filmes WHERE titulo = :titulo";
     switch(conf) {
            case 1 -> {
                f.setTitulo(f.getTitulo() + " - Dublado, 3D e D-BOX");
                f.setTipo("Dublado, 3D E D-BOX");   }            
            case 12 -> { 
                f.setTitulo(f.getTitulo() + " - Dublado 3D");
                f.setTipo("Dublado 3D"); }            
            case 13 -> { 
                f.setTitulo(f.getTitulo() + " - Dublado D-BOX");
                f.setTipo("Dublado D-BOX");   }            
            case 14 -> {   
                f.setTitulo(f.getTitulo() + " - Dublado");
                f.setTipo("Dublado");  }            
            case 2 -> { 
                f.setTitulo(f.getTitulo() + " - Legendado, 3D e D-BOX");
                f.setTipo("Legendado, 3D E D-BOX"); }            
            case 22 -> {   
                f.setTitulo(f.getTitulo() + " - Legendado 3D");
                f.setTipo("Legendado 3D"); }            
            case 23 -> { 
                f.setTitulo(f.getTitulo() + " - Legendado D-BOX");
                f.setTipo("Legendado D-BOX"); }            
            case 24 -> {    
                f.setTitulo(f.getTitulo() + " - Legendado");
                f.setTipo("Legendado");    } }
try{em.getTransaction().begin();
    TypedQuery<String> query = em.createQuery(textoQuery, String.class);    
    query.setParameter("titulo", f.getTitulo());     
    query.getSingleResult();    
    em.getTransaction().commit();    
    JOptionPane.showMessageDialog(null, "Não informe filmes com títulos e tipos repetidos!"); } 

catch (NoResultException o) {           
    try {
          em.persist(f);
          em.getTransaction().commit();
          JOptionPane.showMessageDialog(null, "Dados cadastrados com sucesso!"); }
    catch(Exception e){ em.getTransaction().rollback();   throw e; }  
    finally{ JPAUtil.closeEtityManager(); } 
 }
}   

public List<Filmes> listar(){
    EntityManager em = JPAUtil.getEntityManager();
    List filmes = null;
    switch(TelaInicial.conf) { 
    case 0 -> {
        try{
            String textoQuery = "SELECT f FROM Filmes f WHERE status = 'Em cartaz' ";
            
            Query consulta = em.createQuery(textoQuery);
              
            filmes = consulta.getResultList();
        } finally{  JPAUtil.closeEtityManager();  }
          }         
    default -> { 
       try {
       String textoQuery = "SELECT f FROM Filmes f";          
      Query consulta = em.createQuery(textoQuery);                  
      filmes = consulta.getResultList(); } 
      finally {JPAUtil.closeEtityManager();} 
               } 
   }
      return filmes; 
}
    
public void encerrar(int id){
      EntityManager em = JPAUtil.getEntityManager();
      
      try{
          Filmes f = em.find(Filmes.class, id);
          if(f != null){
          em.getTransaction().begin();

          TypedQuery<Integer> query = em.createQuery("SELECT s.id FROM Salas s WHERE s.id_filmes = :id)", Integer.class);
          query.setParameter("id", id);
          List<Integer> listaIds = query.getResultList();
          
          String sql3 = "UPDATE Filmes SET status = 'Encerrado' WHERE id = " + id;
          Query query3 = em.createNativeQuery(sql3); 
          
       for (Integer idd : listaIds) {
        Query query5 = em.createQuery("UPDATE Cadeiras SET ocupada = false WHERE id = :id");
        query5.setParameter("id", idd);
        query5.executeUpdate();     }
          
          String sql4 = "UPDATE Salas SET id_filmes = NULL WHERE id_filmes = " + id;
          Query query4 = em.createNativeQuery(sql4); 
          
          query3.executeUpdate(); 
          query4.executeUpdate();
          
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
