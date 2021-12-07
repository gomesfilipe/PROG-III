package lista4;

import java.util.Formatter;

public class Livro extends Produto {
	private String autor;
	
	public Livro(String nome, double preco, String autor) {
		super(nome, preco);
		this.setAutor(autor);
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	@Override
	public String toString() {
		Formatter fmt = new Formatter();
		fmt.format("%s", this.autor);
		String s = fmt.out().toString();
		fmt.close();
		return super.toString() + s;
	}
}
