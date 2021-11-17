import java.util.Scanner;

public class J1_03 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();

        while(true){
            if(a > b){
                a -= b;
            } else if(b > a){
                b -= a;
            } else{
                System.out.println(a);
                break;
            }
        }
        
        s.close();
    }
}
