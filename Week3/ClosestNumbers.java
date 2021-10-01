package Week3;

import java.util.Arrays;
import java.util.Scanner;

public class ClosestNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        for(int i = 0;i < n;i++)
            a[i] = scan.nextInt();
        Arrays.sort(a);
        int min = a[1] - a[0];
        for(int i = 2;i < n;i++)
            if(a[i]-a[i-1] < min)
                min = a[i] - a[i-1];
        for(int i = 1;i < n;i++)
            if(a[i]-a[i-1]  == min)
                System.out.print(a[i-1] + " " + a[i] + " ");
    }
}