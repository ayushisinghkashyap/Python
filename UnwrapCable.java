
import java.util.*;

public class UnwrapCable {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int p= sc.nextInt();
            arr.add(p);
        }

        Collections.sort(arr);
        int count = 1;
        int p = arr.get(0)+ 1;
        int q = arr.get(1)+ 1;
        int r = arr.get(2)- 1;
        while(arr.contains(p) == false && arr.contains(q) == false && arr.contains(r) == false){
            arr.add(p);
            arr.add(q);
            arr.add(r);
            if(p == q && q == r){
                System.out.println(count);
                break;
            }
            else{
                p++;
                q++;
                r--;
                count++;
            }
        }

        if(p == q && q == r){
            System.out.println(count);
                
        }
        else{
            System.out.println(-1);
            System.out.println(count);
        }

        


        
        
        
        

    }
}