package J1_09;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Turma {
	private List<Aluno> alunos;

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
			
			pr.printf("%s,%.1f,", i.getNome(), mediaAluno);

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
