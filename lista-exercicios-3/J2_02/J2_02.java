package J2_02;

public class J2_02 {
	public static void main(String[] args) {
		for(int i = 0; i < 5; i++) {
			Aleatorio aleatorio = new Aleatorio();
			System.out.print(aleatorio.getSorteado() + " " + aleatorio.renovar() + " ");
		}
		
		System.out.println();
	}
}
