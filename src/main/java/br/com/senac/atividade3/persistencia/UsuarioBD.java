package br.com.senac.atividade3.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Renato Rodrigues
 */ 
/* Classe para manipular a tabela "Usuario" do banco de dados - TDS */
public class UsuarioBD {
    EntityManager em = JPAUtil.getEntityManager();
    
public void cadastrar(Usuario u){
    try {
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
  }catch(Exception e){
        em.getTransaction().rollback();
         throw e;
 }
   finally{
     JPAUtil.closeEtityManager();
          } }

public String getMD5Hash(String s) throws NoSuchAlgorithmException {
String result = s;
if (s != null) {
    MessageDigest md = MessageDigest.getInstance("MD5");
    md.update(s.getBytes());
    BigInteger hash = new BigInteger(1, md.digest());
    result = hash.toString(16);
    while (result.length() < 32) {
        result = "0" + result;
    }
}

return result; }

public List<Usuario> listar(){    
 List<Usuario> contas = new ArrayList<Usuario>();
      try{
          Query consulta = em.createQuery("SELECT u FROM Usuario u");
          contas = consulta.getResultList();
  }catch(Exception e){
          em.getTransaction().rollback();
          throw e;
 }
      finally{
          JPAUtil.closeEtityManager();
   }
      return contas;
  }

public Usuario validarUsuario(String l, String s) {
    try {
List<Usuario> usuarioEncontrados = em
            .createQuery("SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = MD5(:senha)", Usuario.class)
            .setParameter("login", l)
            .setParameter("senha", s)
            .getResultList(); 
    if(!usuarioEncontrados.isEmpty()) { return usuarioEncontrados.get(0); } 
} catch (Exception e) { JOptionPane.showMessageDialog(null, "Houve um erro! " + e.getMessage()); }
 finally { JPAUtil.closeEtityManager(); }
 return null; }
}
