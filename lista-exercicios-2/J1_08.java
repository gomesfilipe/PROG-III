import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Funcionario {
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

class Departamento {
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

class Empresa {
	private String nome;
	private String cnpj;
	private Departamento[] departamentos;
	private int pos = 0;

	public Empresa(String nome, String cnpj, int qtdDepartamentos) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.departamentos = new Departamento[qtdDepartamentos];
	}

	public void adicionarDepartamento(Departamento d) {
		this.departamentos[this.pos] = d;
		this.pos++;
	}

	public void imprimirDepartamentos() {
		for(Departamento d : this.departamentos){
			System.out.printf("%s R$ %.2f\n", d.getNome(), d.somarSalarios());
		}
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public Departamento[] getDepartamentos() {
		return departamentos;
	}
	
	public void setDepartamentos(Departamento[] departamentos) {
		this.departamentos = departamentos;
	}

	public int getQtdDepartamentos(){
		return this.departamentos.length;
	}

	public void transfere(int dep1, int dep2) {
		Funcionario f = this.departamentos[dep1].removeFuncionario();
		this.departamentos[dep2].adicionaFuncionario(f);
	}

	public void aumentarSalarioDeptPos(int pos, double porcentagem) {
		this.departamentos[pos].aumentarSalarioDept(porcentagem);
	}
}

class J1_08 {
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
		