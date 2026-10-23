package br.com.dao;

import br.com.model.Categoria;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CategoriaDao {
    private EntityManager em;

    public CategoriaDao(EntityManager em) {
        this.em = em;
    }

    // Metodo para cadastrar uma nova categoria no banco de dados.
    public void cadastrar(Categoria categoria) {
        this.em.getTransaction().begin(); // Inicia uma transação.
        this.em.persist(categoria); // Persiste a entidade no banco de dados.
        this.em.getTransaction().commit(); // Finaliza a transação e salva as alterações.
    }

    // Metodo para atualizar uma categoria existente no banco de dados.
    public void atualizar(Categoria categoria) {
        this.em.getTransaction().begin();// Inicia uma transação.
        this.em.merge(categoria);// Atualiza a entidade no banco de dados.
        this.em.getTransaction().commit();// Finaliza a transação e salva as alterações.
    }

    // Metodo para remover uma categoria do banco de dados.
    public void remover(Categoria categoria) {
        this.em.getTransaction().begin();// Inicia uma transação.
        this.em.remove(categoria);// Remove a entidade do banco de dados.
        this.em.getTransaction().commit();// Finaliza a transação e salva as alterações.
    }

    // Metodo para buscar uma categoria pelo seu ID.
    public Categoria buscarPorId(Long id) {
        return em.find(Categoria.class, id);// Busca a entidade Categoria pelo ID.
    }

    // Metodo para buscar todas as categorias no banco de dados.
    public List<Categoria> buscarTodos() {
        String jpql = "SELECT c FROM Categoria c"; // Consulta JPQL para retornar todas as categorias.
        return em.createQuery(jpql, Categoria.class).getResultList(); // Executa a consulta e retorna os resultados.
    }

    // Metodo para buscar categorias pelo nome.
    public List<Categoria> buscarPorNome(String nome) {
        String jpql = "SELECT c FROM Categoria c WHERE c.nome = :nome"; // Consulta JPQL para buscar categorias por nome.
        return em.createQuery(jpql, Categoria.class)
                .setParameter("nome", nome) // Define o parâmetro "nome" na consulta.
                .getResultList(); // Executa a consulta e retorna os resultados.
    }
}
