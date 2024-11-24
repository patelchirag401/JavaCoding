package com.tree;

import java.util.ArrayList;
import java.util.Stack;

 class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class PreorderWithoutReccursion {
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> returnList = new ArrayList<Integer>();
		if (root == null)
			return returnList;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.empty()) {
			TreeNode n = stack.pop();
			returnList.add(n.val);
			if (n.right != null) {
				stack.push(n.right);
			}
			if (n.left != null) {
				stack.push(n.left);
			}
		}
		return returnList;
	}
	
	public static void main(String a[]) {
		
		PreorderWithoutReccursion preorderWithoutReccursion = new PreorderWithoutReccursion();
		TreeNode tree = new TreeNode(1);

	     // Constructing the binary tree
	   //  tree.root = new Node(1);
	     tree.left = new TreeNode(2);
	     tree.right = new TreeNode(3);
	     tree.left = new TreeNode(4);
	     tree.right = new TreeNode(5);
	     tree.right = new TreeNode(6);

	     // Function call
	     System.out.println("Preorder traversal of binary tree is: ");
	     preorderWithoutReccursion.preorderTraversal(tree);
		
	}
}