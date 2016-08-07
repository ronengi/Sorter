package com.ronengi;

/**
 * Created by stimpy on 8/3/16.
 */
public class Insertion {

    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i; j > 0; --j) {
                if (less(a[j], a[j-1]))
                    exch(a, j, j-1);
                else
                    break;
            }
        }

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
