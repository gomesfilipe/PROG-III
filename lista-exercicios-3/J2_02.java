import java.util.Random;
import java.util.Scanner;

class Aleatorio {
	private static Random random;
	private int sorteado;
	private int maximo;
	
	public static final int VALOR_MAXIMO_DEFAULT = 100;
	
	static {
		Scanner s = new Scanner(System.in);
		random = new Random(s.nextLong());
		s.close();
	}
	
	public Aleatorio(int maximo) {
		this.maximo = maximo;
		this.sorteado = random.nextInt(maximo);
	}
	
	public Aleatorio() {
		
		this.maximo = VALOR_MAXIMO_DEFAULT;
		this.sorteado = random.nextInt(maximo);
	}

	public static Random getRandom() {
		return random;
	}

	public static void setRandom(Random random) {
		Aleatorio.random = random;
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
	
	public int renovar() {
			int sorteado = random.nextInt(this.maximo);
			this.setSorteado(sorteado);
			return sorteado;
		}
}

class J2_01 {
	public static void main(String[] args) {
		for(int i = 0; i < 5; i++) {
			Aleatorio aleatorio = new Aleatorio();
			System.out.print(aleatorio.getSorteado() + " " + aleatorio.renovar() + " ");
		}
		
		System.out.println();
	}
}
