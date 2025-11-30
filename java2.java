import java.util.*;
public class java2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == arr[i+1]){
                i++;
            }
            else{
                System.out.println(arr[i]);
            }
        }
    }
}
