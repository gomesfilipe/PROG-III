package J1_07;

import java.util.Scanner;

public class Ponto {
	private double x;
	private double y;
	
	public double calcularDistancia(Ponto p) {
		return Math.sqrt((this.x - p.x) * (this.x - p.x) + (this.y - p.y) * (this.y - p.y));
	}
	
	public void lerPonto(Scanner s) {
		this.x = s.nextDouble();
		this.y = s.nextDouble();
	}
}
