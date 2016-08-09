package com.ronengi;

/**
 * Created by stimpy on 8/9/16.
 */
public class Quick {


    public static void sort(Comparable[] a) {
        Knuth.shuffle(a);
        sort(a, 0, a.length - 1);
    }


    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo)
            return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }


    public static int partition(Comparable[] a, int lo, int hi) {
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
