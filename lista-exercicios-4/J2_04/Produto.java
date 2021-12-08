package J2_04;

import java.util.Formatter;

public class Produto {
	private String nome;
	private double preco;
	
	public Produto(String nome, double preco) {
		this.setNome(nome);
		this.setPreco(preco);
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
	
	@Override
	public String toString() {
		Formatter fmt = new Formatter();
		fmt.format("%s (R$ %.2f) - ", this.nome, this.preco);
		String s = fmt.out().toString();
		fmt.close();
		return s;
	}
}
