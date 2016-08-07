package com.ronengi;

/**
 * Created by stimpy on 8/4/16.
 */
public class Shell {

    public static void sort(Comparable[] a) {
        int n = a.length;

        int h = 1;
        while (h < n/3)
            h = 3 * h + 1;      // 1, 4, 13, 40, 121, 364, ...

        while (h >= 1) {        // h-sort the array
            for (int i = h; i < n; ++i) {
                for (int j = i; j >= h  &&  less(a[j], a[j - h]); j-= h)
                    exch(a, j, j - h);
            }
            h = h / 3;
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
