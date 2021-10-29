package Week7;

import java.util.Scanner;

public class CountingSort1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[100];
        int[] b = new int[n];
        for(int i = 0;i < n;i++)
            b[i] = scanner.nextInt();
        for(int i = 0;i < n;i++)
            a[b[i]]++;
        for(int i = 0;i < 100;i++)
            System.out.print(a[i] + " ");
    }
}
