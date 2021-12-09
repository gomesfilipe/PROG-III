package J2_08;

import java.util.Formatter;

public class Quadrado extends Quadrilatero {
	public Quadrado(double l) {
		super(l, l, l, l);
	}

	@Override
	public double area() {
		return this.l1 * this.l1;
	}
	
	@Override
	public String toString() {
		Formatter fmt = new Formatter();
		fmt.format("Quadrado de lado %.2f - perimetro: %.2f; area: %.2f.", this.l1, this.perimetro(), this.area());
		String s = fmt.out().toString();
		fmt.close();
		return s;
	}
	
	public double getLado() {
		return super.l1;
	}
}
