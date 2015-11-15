package controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.IProdutoDAO;
import dao.JPAProdutoDAO;

import model.JSFUtil;
import model.Produto;

@ManagedBean(name="produtoBean")
@ViewScoped

public class ProdutoBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Produto produto = new Produto();
	private IProdutoDAO produtoDao;
	private List<Produto> produtos;
	private Produto[] produtosSelecionados;
	private Produto produtoSelecionado;
	
	public Produto getProduto()
	{
		return produto;
	}
	
	public void setProduto(Produto produto)
	{
		this.produto = produto;
	}
	
	public void setProdutos(List<Produto> produtos)
	{
		this.produtos = produtos;
	}
	
	public List<Produto> getProdutos()
	{
		if (this.produtos == null)
		{
			produtoDao = new JPAProdutoDAO();
			produtos = produtoDao.lista();
		}
		return produtos;
	}
	
	public Produto[] getProdutosSelecionados()
	{
		return produtosSelecionados;
	}
	
	public void setProdutosSelecionados(Produto[] produtosSelecionados)
	{
		this.produtosSelecionados = produtosSelecionados;
	}
	
	public Produto getProdutoSelecionado()
	{
		return produtoSelecionado;
	}
	
	public void setProdutoSelecionado(Produto produtoSelecionado)
	{
		this.produtoSelecionado = produtoSelecionado;
	}
	
	public String salva()
	{
		produtoDao = new JPAProdutoDAO();
		produtoDao.salva(produto);
		produto = new Produto();
		JSFUtil.mensagem("Mensagem", "Produto gravado");
		
		return null;
	}
	
	public void atualiza()
	{
		produtoDao = new JPAProdutoDAO();
		produtoDao.atualiza(produtoSelecionado);
		JSFUtil.mensagem("Mensagem", "Produto atualizado");
	}
	
	public String exclui(Produto produto)
	{
		produtoDao = new JPAProdutoDAO();
		produtoDao.exclui(produto);
		produtos.remove(produto);
		
		return null;
	}
	
	public void exclui()
	{
		produtoDao = new JPAProdutoDAO();
		produtoDao.exclui(produtoSelecionado);
		produtos.remove(produtoSelecionado);
	}
}