package com.company.demo;

import java.util.Arrays;

public class RemoveEvenNumbersWithZero {

    public void removeEvenNumbers(int[] arr)
    {
        int count = 0;


        for (int i = 0; i < arr.length; i++) {

            if(arr[i]%2!=0)
            {
                arr[count] = arr[i];
                arr[i] = 0;
                count++;
            }

            if(arr[i]%2==0)
            {
                arr[i] = 0;
            }


        }


        System.out.println(Arrays.toString(arr));
    }

}
