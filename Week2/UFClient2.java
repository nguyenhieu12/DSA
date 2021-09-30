package Week2;

import edu.princeton.cs.algs4.*;

public class UFClient2 {
    public static void main(String[] args) {
        boolean check = true;
        int count = 0;
        int N = StdIn.readInt();
        UF uf = new UF(N);
        while(!StdIn.isEmpty()){
            if(check) count++;
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(!uf.connected(p, q)){
                uf.union(p, q);
                if(uf.count() == 1)
                    check = false;
            }
        }
        if(check) StdOut.println("FAILED");
        else StdOut.println(count);
    }
}
