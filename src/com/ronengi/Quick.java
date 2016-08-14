package com.ronengi;

/**
 * Created by stimpy on 8/9/16.
 * Hoare's quick sort.
 * Partitioning stops at equal keys, to make sure performance don't degrades to n-square.
 *
 */
public class Quick {


    public static void sort(Comparable[] a) {
        Knuth.shuffle(a);
        sort(a, 0, a.length - 1);
    }


    public static Comparable select(Comparable[] a, int k) {
        Knuth.shuffle(a);
        int lo = 0, hi = a.length - 1;
        while (hi > lo) {
            int j = partition(a, lo, hi);
            if      (j < k)     lo = j + 1;
            else if (j > k)     hi = j - 1;
            else                return a[k];
        }
        return a[k];
    }


    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo)
            return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }


    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        while (i < j) {
            while (less(a[++i], a[lo])  &&  i < hi);
            while (less(a[lo], a[--j])  &&  j > lo);
            if (i < j)
                exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }


    private static void exch(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }


    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }


}
