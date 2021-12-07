package J1_07;

import java.util.Scanner;

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
