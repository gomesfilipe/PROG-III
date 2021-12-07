package J1_08;

public class Funcionario {
	private String nome;
	private double salario;
	private String data;

	public Funcionario(String nome, double salario, String data){
		this.nome = nome;
		this.salario = salario;
		this.data = data;
	}
		
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void aumentarSalario(double porcentagem) {
		porcentagem = porcentagem / 100.0 + 1; 
		this.salario *= porcentagem;
	}
}
