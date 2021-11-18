import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

class Aluno {
	String nome;
	double nota1;
	double nota2;
	double nota3;
	
	public Aluno(String nome, double nota1, double nota2, double nota3) {
		this.nome = nome;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getNota1() {
		return nota1;
	}

	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}

	public double getNota2() {
		return nota2;
	}

	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}

	public double getNota3() {
		return nota3;
	}

	public void setNota3(double nota3) {
		this.nota3 = nota3;
	}

	public double mediaAluno(){
		return (this.nota1 + this.nota2 + this.nota3) / 3.0;
	}

	public boolean aprovado() {
		return this.mediaAluno() >= 7.0;
	}
}

class Turma {
	List<Aluno> alunos;

	public Turma(){
		this.alunos = new ArrayList<Aluno>();
	}

	public void inserirAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}

	public double mediaTurma() {
		double media = 0.0;
		
		for(Aluno i : this.alunos) {
			media += i.mediaAluno();
		}

		return media / this.alunos.size();
	}

	public void imprimeTurma(PrintWriter pr) {
		double mediaTurma = this.mediaTurma();
		
		pr.println("Nome,Nota,Situacao,Media"); // Cabeçalho do csv.
		
		for(Aluno i : this.alunos) {
			double mediaAluno = i.mediaAluno();
			
			pr.printf("%s,%.1f,", i.nome, mediaAluno);

			if(i.aprovado()) {
				pr.print("Aprovado,");
			
			} else{
				pr.print("Prova Final,");
			}

			if(mediaAluno > mediaTurma) {
				pr.println("Acima");
			
			} else if(mediaAluno < mediaTurma) {
				pr.println("Abaixo");
			
			} else {
				pr.println("Na media");
			}

		}
	}
}

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
