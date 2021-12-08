package J2_08;

public abstract class Quadrilatero implements Forma {
	protected double l1;
	protected double l2;
	protected double l3;
	protected double l4;

	public Quadrilatero(double l1, double l2, double l3, double l4) {
		this.l1 = l1;
		this.l2 = l2;
		this.l3 = l3;
		this.l4 = l4;
	}
	
	public double perimetro() {
		return this.l1 + this.l2 + this.l3 + this.l4;
	}

	public double getL1() {
		return l1;
	}

	public double getL2() {
		return l2;
	}

	public double getL3() {
		return l3;
	}

	public double getL4() {
		return l4;
	}
}
