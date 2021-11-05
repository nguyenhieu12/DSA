package Week8;

import java.util.Scanner;

public class JavaStringReverse {
    public static String check(String s) {
        for(int i = 0;i < s.length()/2;i++) {
            if(s.charAt(i) != s.charAt(s.length() - 1 -i))
                return "No";
        }
        return "Yes";
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        System.out.println(check(s));

    }

}
