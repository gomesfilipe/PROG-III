package J1_11;

import java.util.Locale;
import java.util.Scanner;

public class J1_11 {
	public static void main(String[] args) {
		Locale.setDefault(new Locale("en, US"));
		
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		scanner.nextLine(); // Despreza o \n.
		CarrinhoDeCompras c = new CarrinhoDeCompras(num);
		
		for (int i = 0; i < num; i++) {
			String nome = scanner.nextLine();
			double preco = scanner.nextDouble();
			scanner.nextLine(); // Despreza o \n.
			int qtd = scanner.nextInt();
			scanner.nextLine(); // Despreza o \n.
			c.adicionar(nome, preco, qtd);
		}

		c.imprimeCarrinho();

		scanner.close();
	}
}
