package teste;

import javax.persistence.EntityManager;

import model.Produto;
import dao.JPAUtil;

public class TestaEstadosJPA
{
	public static void main(String[] args)
	{
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		
		Produto p1 = em.find(Produto.class, (long) 1);
		System.out.println("1 - p1.descricao: " + p1.getDescricao());
		p1.setDescricao("Britadeiraaaa");
		
		em.detach(p1);
		System.out.println("2 - p1.descricao: " + p1.getDescricao());
		p1.setDescricao("Alicate");
		System.out.println("3 - p1.descricao: " + p1.getDescricao());
		
		Produto p2 = em.find(Produto.class, (long) 1);
		System.out.println("\n4 - p1.descricao: " + p1.getDescricao());
		System.out.println("5 - p2.descricao: " + p2.getDescricao());
		p2.setDescricao("Martelo");
		System.out.println("6 - p1.descricao: " + p1.getDescricao());
		System.out.println("7 - p2.descricao: " + p2.getDescricao());
		
		Produto p3 = em.merge(p1);
		System.out.println("\n8 - p1.descricao: " + p1.getDescricao());
		System.out.println("9 - p2.descricao: " + p2.getDescricao());
		System.out.println("10 - p3.descricao: " + p3.getDescricao());
		p3.setDescricao("Chave de fenda");
		System.out.println("\n11 - p1.descricao: " + p1.getDescricao());
		System.out.println("12 - p2.descricao: " + p2.getDescricao());
		System.out.println("13 - p3.descricao: " + p3.getDescricao());
		
		Produto p4 = em.merge(p1);
		System.out.println("\n14 - p1.descricao: " + p1.getDescricao());
		System.out.println("15 - p2.descricao: " + p2.getDescricao());
		System.out.println("16 - p3.descricao: " + p3.getDescricao());
		System.out.println("17 - p4.descricao: \n" + p4.getDescricao());
		
		System.out.println(p2 == p3);
		System.out.println(p3 == p4);
		System.out.println(p1 == p2);
		System.out.println(p1 == p3);
		System.out.println(p1 == p4);
		
		em.getTransaction().commit();
		em.close();
	}
}