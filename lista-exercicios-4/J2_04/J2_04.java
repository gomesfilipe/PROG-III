package J2_04;

import java.util.Scanner;

public class J2_04 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		String numero = s.nextLine();
		int n = Integer.parseInt(numero);
		
		Produto[] produtos = new Produto[n];
		
		for(int i = 0; i < n; i++) {
			String line = s.nextLine();
			
			String[] dados = line.split(",");
			
			String nome = dados[1];
			double preco = Double.parseDouble(dados[2]);
			
			if(dados[0].equals("L")) {
				String autor = dados[3];
				produtos[i] = new Livro(nome, preco, autor);
				
			} else if(dados[0].equals("C")) {
				int faixas = Integer.parseInt(dados[3]);
				produtos[i] = new Cd(nome, preco, faixas);
				
			} else if(dados[0].equals("D")) {
				int duracao = Integer.parseInt(dados[3]);
				produtos[i] = new Dvd(nome, preco, duracao);
			}
		}
		
		s.close();
		
		for(int i = 0; i < n; i++) {
			System.out.println(produtos[i].toString());
		}
	}
}
