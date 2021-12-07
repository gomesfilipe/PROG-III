package J1_02;

public class J1_02 {
    public static void main(String[] args){
        int ab, cd, ef;
        for(int i = (int) Math.sqrt(1000) + 1; i * i < 9999; i++){
            cd = (i * i) % 100;
            ab = (i * i - cd) / 100;
            ef = ab + cd;
            
            if(ef * ef == i * i){
                System.out.println(i * i);
            }
        }
    }
}
