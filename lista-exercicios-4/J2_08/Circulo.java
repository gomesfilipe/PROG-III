package J2_08;

import java.util.Formatter;

public class Circulo implements Forma {
	private double raio;
	
	public Circulo(double raio) {
		this.raio = raio;
	}
	
	@Override
	public double perimetro() {
		return 2.0 * PI * this.raio;
	}

	@Override
	public double area() {
		return PI * this.raio * this.raio;
	}
	
	@Override
	public String toString() {
		Formatter fmt = new Formatter();
		fmt.format("Circulo de raio %.2f - perimetro: %.2f; area: %.2f.", this.raio, this.perimetro(), this.area());
		String s = fmt.out().toString();
		fmt.close();
		return s;
	}
}
