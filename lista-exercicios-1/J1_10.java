import java.util.Scanner;

public class J1_10 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); 
        int n = s.nextInt();
        
        int f1 = 0, f2 = 1, fn;
        
        if(n > 0) System.out.print(f1 + " ");
        if(n > 1) System.out.print(f2 + " ");

        for(int i = 0; i < n - 2; i++){
            fn = f1 + f2;
            f1 = f2;
            f2 = fn;
            System.out.print(fn + " ");
        }

        s.close();
    }
}
