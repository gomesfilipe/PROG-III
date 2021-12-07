package J1_07;

public class J1_07 {
	public static void main(String[] args) {		
		Triangulo t = new Triangulo();
		
		t.lerTriangulo();
		
		System.out.printf("%.5f", t.calcularPerimetro());
	}
}
