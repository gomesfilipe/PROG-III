package J2_03;

import java.util.Scanner;

public class J2_03 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		String cpf;
		
		while(true) {
			Cliente cliente = new Cliente(s.nextLine());
			while(true) {
				cpf = s.nextLine();
				
				if(cpf.equals("+") || cpf.equals(".")) {
					break;
				} else {
					cliente.setCpf(cpf);
				}
			}
			
			System.out.print(cliente.getNome() + " ");
			
			if(cliente.getCpf() != null) {
				System.out.println(cliente.getCpf());
			} else {
				System.out.println();
			}
			
			if(cpf.equals(".")) {
				break;
			}
		}
		
		s.close();
	}
}
