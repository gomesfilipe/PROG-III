package J2_07;

import java.util.Formatter;

public class Cd extends Produto {
	private int faixas;
	
	public Cd(String nome, double preco, int faixas) {
		super(nome, preco);
		this.setFaixas(faixas);
	}

	public int getFaixas() {
		return faixas;
	}

	public void setFaixas(int faixas) {
		this.faixas = faixas;
	}
	
	@Override
	public String toString() {
		Formatter fmt = new Formatter();
		fmt.format("%d faixas", this.faixas);
		String s = fmt.out().toString();
		fmt.close();
		return super.toString() + s;
	}
}
