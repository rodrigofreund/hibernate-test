package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.model.Categoria;
import br.com.alura.loja.model.Produto;

public class CadastroDeProdutos {

    public static void main(String[] args) {
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja");
        EntityManager em = factory.createEntityManager();

        Produto celular = new Produto();
        celular.setNome("Xaiomi Redmine");
        celular.setDescricao("Muito legal");
        celular.setPreco(BigDecimal.valueOf(23d));
        
        Categoria catCelular = new Categoria();
        celular.setNome("CELULAR");
        
        
        CategoriaDao categoriaDao = new CategoriaDao(em);
        ProdutoDao produtoDao = new ProdutoDao(em);

        em.getTransaction().begin();

        categoriaDao.cadastrar(catCelular);
        celular.setCategoria(catCelular);
        
        produtoDao.cadastrar(celular);
        
        em.getTransaction().commit();
        
        em.close();
    }

}
