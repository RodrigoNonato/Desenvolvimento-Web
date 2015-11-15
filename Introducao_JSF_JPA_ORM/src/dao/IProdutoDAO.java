package dao;

import model.Produto;

import java.util.List;

public interface IProdutoDAO
{
	void salva(Produto p);
	void atualiza(Produto p);
	List<Produto> lista();
	void exclui (Produto p);
}
