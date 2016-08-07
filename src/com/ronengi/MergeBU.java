package com.ronengi;

/**
 * Created by stimpy on 8/7/16.
 *
 * Bottom-up Mergesort
 */
public class MergeBU {

    private static Comparable[] aux;

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        assert isSorted(a, lo, mid);    // precondition: a[lo .. mid]   sorted
        assert isSorted(a, mid+1, hi);  // precondition: a[mid+1 .. hi] sorted

        // copy
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];

        // merge
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)                        a[k] = aux[j++];    // copy the remaining right half
            else if (j > hi)                    a[k] = aux[i++];    // copy the remaining left half
            else if (less(aux[j], aux[i]))      a[k] = aux[j++];    // move the element from right half
            else                                a[k] = aux[i++];    // move the element from left half
        }

        assert isSorted(a, lo, hi);     // postcondition: a[lo .. hi] sorted
    }


    public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];

        for (int sz = 1; sz < N; sz = sz+sz) {
            for (int lo = 0; lo < N-sz; lo += sz+sz) {
                merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
            }
        }
    }


    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (less(a[i], a[i - 1]))
                return false;
        }
        return true;
    }


    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }


}
