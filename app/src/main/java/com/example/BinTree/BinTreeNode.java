package com.example.BinTree;

import android.util.Log;

public class BinTreeNode {
	public int data;
	public BinTreeNode left;
	public BinTreeNode right;

	public BinTreeNode(int data){
		this.data = data;
	}
	
	public void displayNode(){
		Log.d("BinTree", data+" ");
	}
}
