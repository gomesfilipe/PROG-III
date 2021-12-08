package J2_08;

import java.util.Scanner;

public class J2_08 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		String input1 = s.nextLine();
		int n = Integer.parseInt(input1);
		
		Forma[] formas = new Forma[n];
		
		for(int i = 0; i < n; i++) {
			String[] input2 = s.nextLine().split(",");
			
			if(input2[0].equals("C")) {
				double raio = Double.parseDouble(input2[1]);
				formas[i] = new Circulo(raio);				
				
			} else if(input2[0].equals("R")) {
				double base = Double.parseDouble(input2[1]);
				double altura = Double.parseDouble(input2[2]);
				formas[i] = new Retangulo(base, altura);
				
			} else if(input2[0].equals("Q")) {
				double lado = Double.parseDouble(input2[1]);
				formas[i] = new Quadrado(lado);
			}
		}
		
		for(Forma i : formas) {
			System.out.println(i.toString());
		}
		
		s.close();
	}
}
