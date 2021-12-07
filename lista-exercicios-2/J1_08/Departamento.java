package J1_08;

import java.util.ArrayList;
import java.util.List;

public class Departamento {
	private String nome;
	private List <Funcionario> funcionarios;
	public Departamento(String nome){
		this.nome = nome;
		this.funcionarios = new ArrayList<Funcionario>();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public void aumentarSalarioDept(double porcentagem) {
		for(Funcionario i : this.funcionarios){
			i.aumentarSalario(porcentagem);
		}
	}

	public void adicionaFuncionario(Funcionario funcionario) {
		this.funcionarios.add(funcionario);
	}

	public Funcionario removeFuncionario() {
		return this.funcionarios.remove(0);
	}

	public double somarSalarios() {
		double soma = 0.0;
		
		for(Funcionario f : this.funcionarios){
			soma += f.getSalario();
		}

		return soma;
	}
}
