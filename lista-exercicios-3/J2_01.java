import java.util.Random;
import java.util.Scanner;

class Aleatorio {
	private Random random;
	private int sorteado;
	private int maximo;
	
	public static final int VALOR_MAXIMO_DEFAULT = 100;
	
	public Aleatorio(int maximo) {
		this.maximo = maximo;
		
	}
	
	public Aleatorio() {
		this.maximo = VALOR_MAXIMO_DEFAULT;
	}

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}

	public int getSorteado() {
		return sorteado;
	}

	public void setSorteado(int num) {
		this.sorteado = num;
	}

	public int getMaximo() {
		return maximo;
	}

	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}

	public static int getValorMaximoDefault() {
		return VALOR_MAXIMO_DEFAULT;
	}
	
	public int sorteiaNumero() {
		int sorteado = this.random.nextInt(this.maximo);
		this.setSorteado(sorteado);
		return sorteado;
	}
}

class J2_01 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Aleatorio aleatorio = new Aleatorio();
		Random gerador = new Random(s.nextLong());
		aleatorio.setRandom(gerador);
		
		for(int i = 0; i < 10; i++) {
			System.out.print(aleatorio.sorteiaNumero());
			System.out.print(" ");
		}
		
		System.out.println();
		
		s.close();
	}
}