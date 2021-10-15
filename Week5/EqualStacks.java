package Week5;

import java.util.Scanner;

public class EqualStacks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1, n2, n3, sum1 = 0, sum2 = 0, sum3 = 0;
        n1 = scanner.nextInt();
        n2 = scanner.nextInt();
        n3 = scanner.nextInt();
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();
        int[] a1 = new int[n1];
        int[] a2 = new int[n2];
        int[] a3 = new int[n3];
        for(int i = 0;i < n1;i++) {
            a1[i] = scanner.nextInt();
        }
        for(int j = 0;j < n2;j++) {
            a2[j] = scanner.nextInt();
        }
        for(int k = 0;k < n3;k++) {
            a3[k] = scanner.nextInt();
        }
        while(n1 > 0) {
            s1.push(a1[n1-1]);
            sum1 += s1.peek();
            n1--;
        }
        while(n2 > 0) {
            s2.push(a2[n2-1]);
            sum2 += s2.peek();
            n2--;
        }
        while(n3 > 0) {
            s3.push(a3[n3-1]);
            sum3 += s3.peek();
            n3--;
        }
        while(sum1 != sum2 && sum1 != sum3) {
            if(sum1 > sum2 && sum1 > sum3) {
                sum1 -= s1.pop();
            }
            else if(sum2 > sum1 && sum2 > sum3) {
                sum2 -= s2.pop();
            }
            else if(sum3 > sum1 && sum3 > sum2) {
                sum3 -= s3.pop();
            }
        }

        System.out.println(sum1);
    }
}
