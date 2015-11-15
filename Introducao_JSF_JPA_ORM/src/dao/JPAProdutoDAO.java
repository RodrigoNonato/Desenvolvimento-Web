package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Produto;

public class JPAProdutoDAO implements IProdutoDAO
{
	public void salva(Produto p)
	{
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}
	
	public void atualiza(Produto p)
	{
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		Produto pAtualizar = em.merge(p);
		em.persist(pAtualizar);
		em.getTransaction().commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> lista()
	{
		EntityManager em = JPAUtil.getEntityManager();
		Query q = (Query) em.createQuery("SELECT p FROM Produto p", Produto.class);
		List<Produto> produtos = q.getResultList();
		em.close();
		
		return produtos;
	}
	
	public void exclui(Produto p)
	{
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		Produto pExcluir = em.find(Produto.class, p.getIdProduto());
		em.remove(pExcluir);
		em.getTransaction().commit();
		em.close();
	}
}