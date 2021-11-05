package Week8;

import java.util.ArrayList;
import java.util.Scanner;

public class CountWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String paragraph = scanner.nextLine();
        String[] word = paragraph.split(" ");
        boolean[] check = new boolean[word.length];
        /*for(int i = 0;i < check.length;i++)
            check[i] = true;*/
        int count;
        ArrayList<String> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>();
        for(int i = 0;i < word.length;i++) {
            count = 1;
            if(!check[i]) {
                a1.add(word[i]);
                check[i] = true;
            }
            for(int j = i + 1;j < word.length;j++) {
                if(word[j].equals(word[i]) && !check[j]) {
                    count++;
                    check[j] = true;
                }
            }
            a2.add(count);
        }
        for(int i = 0;i < a1.size();i++) {
            System.out.println(a1.get(i) + " " + a2.get(i));
        }
    }
}
