package J1_08;
import java.util.Scanner;

public class J1_08 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		Empresa empresa = new Empresa(s.next(), s.next(), s.nextInt());
		
		for(int i = 0; i < empresa.getQtdDepartamentos(); i++){
			Departamento d = new Departamento(s.next());
			
			int qtdFuncionarios = s.nextInt();

			for(int j = 0; j < qtdFuncionarios; j++){
				Funcionario f = new Funcionario(s.next(), s.nextDouble(), s.next());
				d.adicionaFuncionario(f);
			}

			empresa.adicionarDepartamento(d);
		}
	
		s.close();

		empresa.aumentarSalarioDeptPos(0, 10); // Aumentando salários do departamento 1 em 10%.
		empresa.transfere(0, 1); // Transferindo o primeiro funcionário do dpto 1 para dpto 2.

		empresa.imprimirDepartamentos();
	}
}
		