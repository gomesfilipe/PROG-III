package J1_08;

public class Empresa {
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
