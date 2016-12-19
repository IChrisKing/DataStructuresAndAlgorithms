package com.example.BinTree;

public class BinTree {
	public BinTreeNode root;
	
	//以下变量用来在find中保存状态，这样，delete就可以直接调用find了进行待删除节点的查找工作。
	public BinTreeNode current;
	public BinTreeNode parent;
	boolean isLeftChild;
	
	public void insert(int data){
		BinTreeNode node = new BinTreeNode(data);
		if(root == null){
			root = node;
		}else{
			BinTreeNode current = root;
			BinTreeNode parent;
			while(true){
				parent = current;
				if(data < current.data){
					current = current.left;
					if(current == null){
						parent.left = node;
						return;
					}
				}else{
					current = current.right;
					if(current == null){
						parent.right = node;
						return;
					}
				}
			}
		}
	}
	
	public void displayTree(BinTreeNode root){
		inOrder(root);//中序遍历
	}
	
	public void inOrder(BinTreeNode root){
		if(root != null){
			inOrder(root.left);
			root.displayNode();
			inOrder(root.right);
		}
	}
	
	public BinTreeNode find(int data){
		current = root;
		parent = root;
		isLeftChild = false;
		
		while(current.data != data){
			parent = current;
			if(current.data < data){
				current = current.right;
				isLeftChild = false;
			}else{
				current = current.left;
				isLeftChild = true;
			}
			
			if(current == null)
				return null;
		}
		return current;
	}
	
	public void delete(int data){
		//首先找到这个删除结点，在这个过程中，会更新current，parent，isLeftChild三个全局变量
		find(data);
		
		//找到删除结点后，要分三种情况：
		if(current != null){
			//1.删除节点是叶子节点，直接删掉
			if(current.left == null && current.right == null){
				if(current == root){
					root = null;
				}else{
					if(isLeftChild){
						parent.left = null;
					}else{
						parent.right = null;
					}
				}
			}
			
			//2.删除节点只有一个子节点（只有左子节点，或者只有右子节点）
			else if(current.right == null){
				//只有左子节点
				if(current == root){
					root = current.left;
				}else if(isLeftChild){
					parent.left = current.left;
				}else{
					parent.right = current.left;
				}
			}
			else if(current.left == null){
				//只有右子节点
				if(current == root){
					root = current.right;
				}else if(isLeftChild){
					parent.left = current.right;
				}else{
					parent.right = current.right;
				}
			}
			
			//3.左右子节点都有
			//首先要找到它的后继节点，也就是中序的下一节点
			else{
				BinTreeNode successor = getSuccessor(current);
				successor.left = current.left;
				if(current == root){
					root = successor;
				}
				//把删除节点的左子树变成后继节点的左子树
				//并且让后继节点取代删除节点的位置
				else if(isLeftChild){
					parent.left = successor;
				}else{
					parent.right = successor;
				}
			}
		}
		
	}

	public BinTreeNode getSuccessor(BinTreeNode delNode) {
		// 这个函数用来给有右子树的节点寻找后继节点。
		// 可以想象，这个后继节点必然是删除节点的右子树中，最左最下的那个孩子
		// 也就是说，这个后继节点必然没有左子节点
		// 此外还负责调整树的结构，使后继节点成为一个只有右子树的，排序结构正确的树
		BinTreeNode successorParent = delNode;
		BinTreeNode successor = delNode;
		BinTreeNode current = delNode.right;
		
		while(current != null){
			successorParent = successor;
			successor = current;
			current = current.left;
		}
		
		if(successor != delNode.right){
			successorParent.left = successor.right;
			successor.right = delNode.right;
		}
		
		return successor;
	}
}
