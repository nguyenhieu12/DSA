package Week11;

import java.util.*;

public class Pairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> set = new HashSet<Integer>();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int count = 0;
        for(int i = 0;i < n;i++)
            set.add(scanner.nextInt());
        for(Integer cur : set)
            if(set.contains(cur + k))
                count++;

        System.out.println(count);
    }
}
