package Coursera.Percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private double mean;
    private double stddev;
    private int numberTest;
    private double[] stats;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if(n < 1 || trials < 1)
            throw new IllegalArgumentException("Illegal");
        numberTest = trials;
        stats = new double[trials];
        for(int i = 0;i < trials;i++) {
            Percolation cur = new Percolation(n);
            int countOpen = 0;
            int[] random = StdRandom.permutation(n * n);
            for(int j = 0;j < random.length;j++) {
                int row = random[j] / n + 1;
                int col = random[j] % n + 1;
                cur.open(row, col);
                countOpen++;
                if(countOpen >= n && cur.percolates())
                    break;
            }
            stats[i] = (double) countOpen / (n * n);
        }
        mean = StdStats.mean(stats);
        stddev = StdStats.stddev(stats);
    }

    // sample mean of percolation threshold
    public double mean() {
        return mean;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return stddev;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean - 1.96 * stddev / Math.sqrt(numberTest);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean - 1.96 * stddev / Math.sqrt(numberTest);
    }

    // test client (see below)
    public static void main(String[] args) {
        PercolationStats p = new PercolationStats(5, 10);
        System.out.println(p.mean());
        System.out.println(p.stddev());
        System.out.println(p.confidenceLo());
        System.out.println(p.confidenceHi());
    }

}
