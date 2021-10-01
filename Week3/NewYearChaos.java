package Week3;

import java.util.Scanner;

public class NewYearChaos {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int result = 0, n, x;
        int[] a;
        n = scan.nextInt();
        for(int i = 0;i < n;i++) {
            x = scan.nextInt();
            a = new int[x];
            for(int j = 0;j < x;j++)
                a[i] = scan.nextInt();
            boolean check = false;
            for (int k = a.length - 1; k >= 0; k--) {
                if (a[k] - (k + 1) > 2) {
                    System.out.println("Too chaotic");
                    check = true;
                }
                if(check)
                    break;
                for (int l = Math.max(0, a[i] - 2); l < k; l++)
                    if (a[l] > a[i])
                        result++;
            }
            System.out.println(result);
        }
    }
}
