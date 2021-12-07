package J1_11;

public class ProdutoNoCarrinho {
	Produto produto;
	int qtd;

	public ProdutoNoCarrinho(Produto produto, int qtd) {
		this.produto = produto;
		this.qtd = qtd;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public int getQtd() {
		return qtd;
	}
	
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public double precoItem() {
		return this.produto.getPreco() * this.qtd;
	}

	public void imprimeItem() {
		System.out.printf("* %dx %s = R$ %.2f\n", this.qtd, this.produto.getNome(), this.precoItem());
	}
}
