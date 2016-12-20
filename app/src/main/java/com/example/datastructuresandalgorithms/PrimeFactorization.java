package com.example.datastructuresandalgorithms;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by jinwh on 16-12-20.
 */

public class PrimeFactorization {
    static public String TAG="PrimeFactorization";
    static ArrayList<Integer> primes = new ArrayList<Integer>();

    static public ArrayList<Integer> getPrimeFactorization(int num) {
        if(num < 1){
            Log.d(TAG,"The number must large than zero");
        }

        double sqrt = Math.sqrt(num);
        for(int i=2;i<sqrt;i++){
            while(num%i ==0){
                primes.add(i);
                num = num/i;
            }
        }

        return primes;
    }

}
