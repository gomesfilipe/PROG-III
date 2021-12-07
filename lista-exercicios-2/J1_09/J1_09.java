package J1_09;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class J1_09 {
	public static void main(String[] args) throws IOException {
		Locale.setDefault(new Locale("en, US"));
		
		Scanner s = new Scanner(System.in);
		Turma turma = new Turma();

		int qtdAlunos = s.nextInt();

		for(int i = 0; i < qtdAlunos; i++){
			Aluno a = new Aluno(s.next(), s.nextDouble(), s.nextDouble(), s.nextDouble());
			
			turma.inserirAluno(a);
		}

		try {
			FileOutputStream arq = new FileOutputStream("saida.csv");
			PrintWriter pr = new PrintWriter(arq);
			
			turma.imprimeTurma(pr);

			pr.close();
			arq.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Erro na abertura/escrita do arquivo.");
		}

		s.close();
	}
}
