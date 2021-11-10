package Week9;

import java.util.HashSet;
import java.util.Scanner;

public class JavaHashSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> hashSet = new HashSet<>();
        int n = scanner.nextInt();
        scanner.nextLine();
        String s;
        for(int i = 0;i < n;i++) {
            s = scanner.nextLine();
            String[] str = s.split(" ");
            if(str.length >= 2) {
                hashSet.add(str[0] + " " + str[1]);
            }
            System.out.println(hashSet.size());
        }
    }
}
