package com.ronengi;

/**
 * Created by stimpy on 8/15/16.
 *
 * The heap uses array based at index 1.
 * This is taken care of in the less & exch methods, by decrementing the keys
 * as if the array is based at index 0.
 *
 */
public class Heap {

    public static void sort(Comparable[] pq) {
        int N = pq.length;
        for (int k = N/2; k >= 1; k--)
            sink(pq, k, N);
        while (N > 1) {
            exch(pq, 1, N);
            sink(pq, 1, --N);
        }
    }


    // fix state violation where parent is smaller than one or both it's children
    // k's children == 2*k, 2*k + 1
    private static void sink(Comparable[] pq, int k, int N) {
        while (2*k <= N ) {
            // set j to be the larger of the 2 children
            int j = 2*k;
            if (j < N  &&  less(pq, j, j+1))
                j++;
            if (!less(pq, k, j))
                break;
            exch(pq, k, j);
            k = j;
        }

    }


    private static boolean less(Comparable[] pq, int i, int j) {
        i--;
        j--;
        return pq[i].compareTo(pq[j]) < 0;
    }


    private static void exch(Comparable[] pq, int i, int j) {
        i--;
        j--;
        Comparable tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }



}
