package com.ronengi;

import java.io.File;

/**
 * Created by stimpy on 8/3/16.
 */
public class Client {

    public static void main(String[] args) {

        File directory = new File("/proc/1/");
        File[] files = directory.listFiles();

        System.out.println();
        for(int i = 0; i < files.length; ++i)
            System.out.println(files[i].getName());

        //Selection.sort(files);
        //Insertion.sort(files);
        //Shell.sort(files);
        //Merge.sort(files);
        //MergeBU.sort(files);
        Quick.sort(files);


        System.out.println();
        for(int i = 0; i < files.length; ++i)
            System.out.println(files[i].getName());

    }

}
