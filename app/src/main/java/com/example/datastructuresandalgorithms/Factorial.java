package com.example.datastructuresandalgorithms;

import android.util.Log;

public class Factorial {
	static public String TAG="FACTORIAL";
	
	static public void Factorial(int index){
		int result = factorial_one(index);
		Log.d(TAG, "Factorial "+ index + "  is "+ result);

		result = factorial_two(index);
		Log.d(TAG, "Factorial "+ index + "  is "+ result);
	}

	//递归
	private static int factorial_one(int index){
		if(index < 1){
			return -1;
		}else if(index == 1){
			return 1;
		}else{
			return index * factorial_one(index-1);
		}
	}

	//递推
	private static int factorial_two(int index){
		if(index < 1){
			return -1;
		}
		int result = 1;
		for(int i=1;i<=index;i++){
			result = result * i;
		}
		return result;
	}
}
