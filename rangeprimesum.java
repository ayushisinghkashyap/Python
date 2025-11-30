import java.util.Scanner;

import javax.swing.plaf.ScrollBarUI;

public class rangeprimesum {

    public static int check(int n){
        boolean count = true;
        for(int i = 2 ;i<=Math.sqrt(n);i++){
            if(n%i == 0){
                count = false;
                break;
            }
        }

        if(count){
            return n;
        }
        return 0;
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        for(int i = 2;i<=n;i++){
            int num = check(i);
            sum += num; 
        }

        System.out.println(sum);
    }


}
