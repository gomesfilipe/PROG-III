import java.util.Scanner;

class Cliente {
	String nome;
	String cpf;
	
	public Cliente(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		if(Cliente.verificarCPF(cpf)) {
			this.cpf = cpf;
		}
	}
	
	private static boolean verificarCPF(String cpf) {
		
		if (cpf == null || cpf.length() == 0) return false;
		
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < cpf.length(); i++) {
			char c = cpf.charAt(i);
			if (c >= '0' && c <= '9') builder.append(c);
		}
		
		if (builder.length() != 11) return false;
		
		int digito = calcularDigitoVerificador(builder, 9);
		
		if (digito != builder.charAt(9) - '0') return false;
			digito = calcularDigitoVerificador(builder, 10);
		
		if (digito != builder.charAt(10) - '0') return false;
			return true;
		}
	
	private static int calcularDigitoVerificador(StringBuilder builder, int indice) {
			int soma = 0, peso = indice + 1, digito;
			
			for (int i = 0; i < indice; i++, peso--) {
				digito = builder.charAt(i) - '0';
				soma += digito * peso;
			}
		
			digito = 11 - (soma % 11);
		
			if (digito > 9) digito = 0;
				return digito;
	}	
}

class J2_03 {
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
