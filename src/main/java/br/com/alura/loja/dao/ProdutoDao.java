package br.com.alura.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.model.Produto;

public class ProdutoDao {

    private EntityManager em;

    public ProdutoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Produto produto) {
        this.em.persist(produto);
    }
    
    public void atualizar(Produto produto) {
        produto = this.em.merge(produto);
    }
    
    public void remover(Produto produto) {
        this.em.remove(produto);
    }
    
    public Produto buscar(Long id) {
        return this.em.find(Produto.class, id);
    }
    
    public List<Produto> pesquisar(String nome) {
        return this.em.createQuery("SELECT p WHERE Produto p WHERE p.nome LIKE '%:nome%'", Produto.class)
                .setParameter("nome", nome)
                .getResultList();
        
    }

}
