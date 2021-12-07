package J1_01;

public class J1_01{
	public static void main(String[] args) {
		double s1, s2, s3;
		s1 = s2 = s3 = 0.0;
		
		double numerador, denominador;

		for(int i = 0; i < 50; i++){
			numerador = 2 * i + 1;
			denominador = i + 1;
			s1 += numerador / denominador;
		}

		for(int i=  0; i < 50; i++){
			numerador = Math.pow(2, i + 1);
			denominador = 50 - i;
			s2 += numerador / denominador;
		}

		for(int i=  0; i < 10; i++){
			numerador = i + 1;
			denominador = Math.pow(i + 1, 2);
			s3 += Math.pow(-1, i) * numerador / denominador;
		}

		System.out.println("S1 = " + s1);
		System.out.println("S2 = " + s2);
		System.out.println("S3 = " + s3);
	}
}
