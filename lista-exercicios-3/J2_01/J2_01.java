package J2_01;

public class J2_01 {
	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
			Aleatorio aleatorio = new Aleatorio();
			System.out.print(aleatorio.getSorteado() + " ");
		}
		
		System.out.println();
	}
}
