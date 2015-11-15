package teste;

import model.Produto;
import dao.JPAProdutoDAO;

public class TestaProduto
{
	public static void main(String[] args)
	{
		Produto produto = new Produto(); 
		produto.setIdProduto((long) 1);
		produto.setDescricao("Produto teste");
		produto.setPreco(12.00);
		JPAProdutoDAO produtoDao = new JPAProdutoDAO();
		produtoDao.salva(produto);
		System.out.println("Gravado");
	}
}