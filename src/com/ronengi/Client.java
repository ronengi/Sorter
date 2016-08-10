package com.ronengi;

import java.io.File;
import java.util.Arrays;

/**
 * Created by stimpy on 8/3/16.
 */
public class Client {

    public static void main(String[] args) {

        String str = "justwhatdoyouthinkyouredoingdave";
        String[] a = str.split("");

        System.out.println();
        System.out.println(Arrays.deepToString(a));

        //int j = 13;
        //System.out.println();
        //System.out.println("The " + (j+1) + "th biggest item is: " + Quick.select(a, j));


        //Selection.sort(a);
        //Insertion.sort(a);
        //Shell.sort(a);
        //Merge.sort(a);
        //MergeBU.sort(a);
        //Quick.sort(a);
        Dijkstra3Way.sort(a);

        System.out.println();
        System.out.println(Arrays.deepToString(a));

    }

}
