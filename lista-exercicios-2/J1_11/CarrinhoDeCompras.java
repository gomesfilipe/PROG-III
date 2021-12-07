package J1_11;

public class CarrinhoDeCompras {
	ProdutoNoCarrinho[] produtos;
	int pos = 0;
	public CarrinhoDeCompras(int num) {
		this.produtos = new ProdutoNoCarrinho[num];
	}

	public ProdutoNoCarrinho[] getProdutos() {
		return produtos;
	}

	public void setProdutos(ProdutoNoCarrinho[] produtos) {
		this.produtos = produtos;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public void adicionar(String nome, double preco, int qtd) {
		Produto produto = new Produto(nome, preco);
		ProdutoNoCarrinho produtoNoCarrinho = new ProdutoNoCarrinho(produto, qtd);
		this.produtos[this.pos] = produtoNoCarrinho;
		this.pos++;
	}

	public double precoTotal() {
		double total = 0.0;

		for(ProdutoNoCarrinho i : this.produtos) {
			total += i.precoItem();
		}

		return total;
	}

	public void imprimeCarrinho() {
		System.out.println("No carrinho:");

		for(ProdutoNoCarrinho i : this.produtos) {
			i.imprimeItem();
		}

		System.out.printf("Total: R$ %.2f", this.precoTotal());
	}
}
