package Week3;

import java.util.Scanner;

public class Pair {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n, k, count = 0;
        n = scan.nextInt();
        k = scan.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i < n;i++)
            arr[i] = scan.nextInt();
        for(int i = 0;i < arr.length;i++) {
            for(int j = i + 1;j < arr.length;j++) {
                if(Math.abs(arr[i] - arr[j]) == k)
                    count++;
            }
        }
        System.out.print(count);
    }
}
