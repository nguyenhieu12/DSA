package Week3;

import java.util.Scanner;

public class SherlockAndArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n, x;
        int[] a;
        n = scan.nextInt();
        for(int i = 0;i < n;i++)
        {
            x = scan.nextInt();
            a = new int[x];
            boolean check = false;
            for(int j = 0;j < x;j++)
                a[j] = scan.nextInt();
            for(int k = 0;k < x;k++)
            {
                int sum1 = 0, sum2 = 0;
                for(int p = 0;p < k;p++)
                    sum1 += a[p];
                for(int q = k + 1;q < x;q++)
                    sum2 += a[q];
                if(sum1 == sum2)
                {
                    check = true;
                    break;
                }
            }
            if(check == true)
                System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
