package lista2;

import java.util.Scanner;

class Ponto {
	double x;
	double y;
	
	double calcularDistancia(Ponto p) {
		return Math.sqrt((this.x - p.x) * (this.x - p.x) + (this.y - p.y) * (this.y - p.y));
	}
	
	void lerPonto(Scanner s) {
		this.x = s.nextDouble();
		this.y = s.nextDouble();
	}
}

class Triangulo {
	Ponto a = new Ponto();
	Ponto b = new Ponto();
	Ponto c = new Ponto();
	
	double calcularPerimetro() {
		double ladoA =  this.a.calcularDistancia(this.b);
		double ladoB =  this.b.calcularDistancia(this.c);
		double ladoC =  this.c.calcularDistancia(this.a);
		
		return ladoA + ladoB + ladoC;
	}
	
	void lerTriangulo() {
		Scanner s = new Scanner(System.in);
		this.a.lerPonto(s);
		this.b.lerPonto(s);
		this.c.lerPonto(s);
		s.close();
	}
}

public class J1_07 {
	public static void main(String[] args) {		
		Triangulo t = new Triangulo();
		
		t.lerTriangulo();
		
		System.out.printf("%.5f", t.calcularPerimetro());
	}
}
