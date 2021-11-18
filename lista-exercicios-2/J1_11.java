import java.util.Locale;
import java.util.Scanner;

class Produto {
	String nome;
	double preco;

	public Produto(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
}

class ProdutoNoCarrinho {
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

class CarrinhoDeCompras {
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

public class J1_11 {
	public static void main(String[] args) {
		Locale.setDefault(new Locale("en, US"));
		
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		scanner.nextLine(); // Despreza o \n.
		CarrinhoDeCompras c = new CarrinhoDeCompras(num);
		
		for (int i = 0; i < num; i++) {
			String nome = scanner.nextLine();
			double preco = scanner.nextDouble();
			scanner.nextLine(); // Despreza o \n.
			int qtd = scanner.nextInt();
			scanner.nextLine(); // Despreza o \n.
			c.adicionar(nome, preco, qtd);
		}

		c.imprimeCarrinho();

		scanner.close();
	}
}
