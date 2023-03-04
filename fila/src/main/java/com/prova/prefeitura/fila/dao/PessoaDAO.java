package com.prova.prefeitura.fila.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.prova.prefeitura.fila.entidades.Pessoa;



public class PessoaDAO {
	Session session;
    
    public PessoaDAO(Session session){
        this.session = session;
    }

    public Pessoa salvar(Pessoa pessoa){
        Transaction tx = null; 
        try{ 
            tx = session.beginTransaction(); 
            session.save(pessoa); 
            session.getTransaction().commit(); 
            return pessoa;
            
        }catch (HibernateException e) {
           if (tx!=null) 
               tx.rollback();
                   e.printStackTrace(); 
        }finally { 
            session.flush();
            session.close(); 
        }
        return null;
    }

    public Pessoa buscarPeloId(long id){
        return (Pessoa) session.get(Pessoa.class, id);
    }

    public Pessoa atualizarPeloId(long id, Pessoa novaPessoa){
        Transaction tx = null; 
        try{ 
            tx = session.beginTransaction(); 
            Pessoa antigaPessoa = (Pessoa) session.get(Pessoa.class, id);
            antigaPessoa.setNome(novaPessoa.getNome());
            antigaPessoa.setIdade(novaPessoa.getIdade());
            antigaPessoa.setPosicaoNaFila(novaPessoa.getPosicaoNaFila());
            session.update(antigaPessoa); 
            session.getTransaction().commit();
            return antigaPessoa;
        }catch (HibernateException e) { 
           if (tx!=null) tx.rollback();
               e.printStackTrace(); 
        }finally { 
            session.close();
        }
        return null; 
    }

    public Pessoa removerPeloId(long id){
        Transaction tx = null; 
        try{ 
            tx = session.beginTransaction(); 
            Pessoa pessoa = (Pessoa) session.get(Pessoa.class, id); 
            session.delete(pessoa); 
            session.getTransaction().commit(); 
            return pessoa;
        }catch (HibernateException e) { 
           if (tx!=null) tx.rollback();
               e.printStackTrace(); 
        }finally { 
            session.close(); 
        } 
        return null;
    }
 
    @SuppressWarnings({ "unchecked", "deprecation" })
	public List<Pessoa> buscarTodas(){
        return session.createQuery("from Pessoa").list();
    }
}


