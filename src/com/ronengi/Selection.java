package com.ronengi;

/**
 * Created by stimpy on 8/3/16.
 */
public class Selection {

    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; ++i) {
            int min = i;
            for (int j = i + 1; j < n; ++j) {
                if (less(a[j], a[min]))
                    min = j;
            }
            exch(a, i, min);
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
