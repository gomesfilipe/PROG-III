package J2_07;

import java.util.Formatter;

public class Dvd extends Produto {
	private int duracao;
	
	public Dvd(String nome, double preco, int duracao) {
		super(nome, preco);
		this.setDuracao(duracao);
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	@Override
	public String toString() {
		Formatter fmt = new Formatter();
		fmt.format("%d minutos", this.duracao);
		String s = fmt.out().toString();
		fmt.close();
		return super.toString() + s;
	}
}
