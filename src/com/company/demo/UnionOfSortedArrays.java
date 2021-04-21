package com.company.demo;

import java.util.Arrays;

public class UnionOfSortedArrays {

    public void unionOfSortedArrays(int[] a, int[]b)
    {
        int[] c = new int[a.length+b.length];
        int count = 0;

        int  i=0, j=0;

        while (i<a.length && j<b.length)
        {
            if(a[i]==b[j])
            {
                c[count++] = a[i];
            }
            else if(a[i]>b[j])
            {
                while (a[i]>b[j])
                {

                    c[count++] =b[j];
                    j++;
                }
                c[count++] = a[i];
            }
            else if(a[i]<b[j])
            {
                while (a[i]<b[j])
                {

                    c[count++] =a[i];
                    i++;
                }
                c[count++] = b[j];

            }

            i++;
            j++;
        }

        for (int k = i; k < a.length; k++) {
            c[count++] = a[k];
        }

        for (int k = j; k < b.length; k++) {
            c[count++] = b[k];
        }



        System.out.println(Arrays.toString(c));
    }

}
