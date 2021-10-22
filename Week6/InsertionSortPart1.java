package Week6;

import java.util.Scanner;

public class InsertionSortPart1 {
    public static void print(int[] a) {
        for(int i = 0;i < a.length;i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i < n;i++)
            arr[i] = scan.nextInt();
        int value = arr[n-1];
        for(int i= n - 2;i >= 0;i--)
        {
            if(arr[i] < value)
            {
                arr[i+1] = value;
                print(arr);
                break;
            }
            else
            {
                arr[i+1] = arr[i];
                print(arr);
                if(i==0)
                {
                    arr[i] = value;
                    print(arr);
                }
            }

        }
    }
}
