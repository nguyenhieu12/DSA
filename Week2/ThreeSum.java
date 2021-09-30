package Week2;

import edu.princeton.cs.algs4.*;

public class ThreeSum {
    public static void main(String[] args) {
        In in = new In("D:\\algs4-data\\2Kints.txt");
        int[] a = in.readAllInts();
        for(int i = 0;i < a.length - 2;i++){
            for(int j = i + 1;j < a.length - 1;j++){
                for(int k = j + 1;k < a.length;k++){
                    if(a[i] + a[j] + a[k] == 0)
                        System.out.println(a[i] + " " + a[j] + " " + a[k]);
                }
            }
        }
    }
}
