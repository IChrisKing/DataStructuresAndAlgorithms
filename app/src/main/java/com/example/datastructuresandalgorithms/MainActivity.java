package com.example.datastructuresandalgorithms;

import com.example.BinTree.BinTree;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;


public class MainActivity extends Activity {
	public static String TAG = "ALGORITHMS";
	ArrayList<Integer> arr = new ArrayList<Integer>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//二叉樹
		//BinTree();
		
		//Fibonacci
		//int f1 = Fibonacci.fibonacci(10);
		//int f2 = Fibonacci.fibonacci_2(12);
		//Log.d(TAG,"f1 is " + f1 + "  f2 is " + f2);
		
		//寻找素数
		//PrimeNumber.findPrimeNumbers(2, 100);
		
		//阶乘
		//Factorial.Factorial(5);

		//分解质因数
		//arr = PrimeFactorization.getPrimeFactorization(90);
		//printArray(arr);

		//最大公约数，最小公倍数
		int[] intArr = new int[]{2,3,4,6,8};
		GCDAndLCM.getGCDAndLCM(intArr);

	}
	
	private void BinTree(){
		//二叉树
		BinTree binTree = new BinTree();
		//插入数据
		int[] binTreeArray = new int[]{7,15,3,65,9,247,2,6,13,43,98,295,0,1,345};
		for(int i = 0;i<binTreeArray.length;i++){
			binTree.insert(binTreeArray[i]);
		}
		//排序（二叉树形成后，只需中序输出，就是排序后的结果）
		binTree.inOrder(binTree.root);
		//删除
		binTree.delete(43);
		//查看删除效果
		binTree.inOrder(binTree.root);
	}

	public static void printArray(ArrayList<Integer> array){
		for(int i=0;i<array.size();i++){
			Log.d(TAG, array.get(i)+"");
		}
	}

}
