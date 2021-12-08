package J2_08;

import java.util.Formatter;

public class Retangulo extends Quadrilatero {
	public Retangulo(double base, double altura) {
		super(base, base, altura, altura);
	}

	@Override
	public double area() {
		return this.l1 * this.l3;
	}
	
	@Override
	public String toString() {
		Formatter fmt = new Formatter();
		fmt.format("Retangulo de base %.2f e altura %.2f - perimetro: %.2f; area: %.2f.", this.l1, this.l3, this.perimetro(), this.area());
		String s = fmt.out().toString();
		fmt.close();
		return s;
	}
}
