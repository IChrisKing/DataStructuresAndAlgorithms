package com.example.datastructuresandalgorithms;

public class Fibonacci {
	static public int FIB_BASE = 1;
	
	//递归
	static public int fibonacci(int index){
		if(index <= 0){
			return 0;
		}else if(index == 1 || index == 2){
			return FIB_BASE;
		}else{
			return fibonacci(index-2) + fibonacci(index-1);
		}
	}
	
	//递推
	static public int fibonacci_2(int index){
		if(index <= 0){
			return 0;
		}else if(index == 1 || index == 2){
			return FIB_BASE;
		}else{
			int f1,f2,f = 0;
			f1=f2=FIB_BASE;
			for(int i=3;i<=index;i++){
				f = f1+f2;
				f1=f2;
				f2=f;
			}
			return f;
		}
	}

}
