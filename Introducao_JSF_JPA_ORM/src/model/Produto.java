package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="produto")

public class Produto
{
	@Id
	@SequenceGenerator(name = "SEQ", sequenceName = "produto_idproduto_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
	
	private Long idproduto;
	private String descricao;
	private Double preco;

	public Long getIdProduto()
	{
		return idproduto;
	}

	public void setIdProduto(Long idproduto)
	{
		this.idproduto = idproduto;
	}

	public String getDescricao()
	{
		return descricao;
	}

	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}

	public Double getPreco()
	{
		return preco;
	}

	public void setPreco(Double preco)
	{
		this.preco = preco;
	}
}
