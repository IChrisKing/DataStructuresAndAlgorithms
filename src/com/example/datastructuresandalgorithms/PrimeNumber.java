package com.example.datastructuresandalgorithms;

import java.util.ArrayList;

import android.util.Log;

public class PrimeNumber {
	static public String TAG="PRIME";
	
	static public ArrayList<Integer> findPrimeNumbers(int begin,int end){
		ArrayList<Integer> primes = new ArrayList<Integer>();
		
		//primes = findPrime_one(begin,end);
		//printArray(primes);
		
		//primes = findPrime_two(begin,end);
		//printArray(primes);
		
		primes = findPrime_three(begin,end);
		printArray(primes);
		
		return primes;
		
	}
	
	private static void printArray(ArrayList<Integer> array){
		for(int i=0;i<array.size();i++){
			Log.d(TAG, array.get(i)+"");
		}
	}

	private static ArrayList<Integer> findPrime_one(int begin, int end) {
		// 从2试到n-1，最傻的办法
		ArrayList<Integer> primes = new ArrayList<Integer>();
		boolean isPrime = true;
		for(int i=begin;i<=end;i++){
			isPrime = true;
			for(int j=2;j<i;j++){
				if(i%j == 0){
					isPrime = false;
					break;
				}
			}
			if(isPrime){
				primes.add(i);
			}
		}
		return primes;
	}
	
	private static ArrayList<Integer> findPrime_two(int begin, int end) {
		// 从2试到sqrt n
		ArrayList<Integer> primes = new ArrayList<Integer>();
		boolean isPrime = true;
		for(int i=begin;i<=end;i++){
			isPrime = true;
			for(int j=2;j<=Math.sqrt(i);j++){
				if(i%j == 0){
					isPrime = false;
					break;
				}
			}
			if(isPrime){
				primes.add(i);
			}
		}
		return primes;
	}
	
	private static ArrayList<Integer> findPrime_three(int begin, int end) {
		// 从2试到sqrt n,去掉所有偶数
		ArrayList<Integer> primes = new ArrayList<Integer>();
		boolean isPrime = true;
		for(int i=begin;i<=end;i++){
			isPrime = true;
			if(i == 2 || i%2 ==0){
				isPrime = false;
				continue;
			}
			for(int j=3;j<=Math.sqrt(i);j+=2){
				if(i%j == 0){
					isPrime = false;
					break;
				}
			}
			if(isPrime){
				primes.add(i);
			}
		}
		return primes;
	}

}
