package com.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


//Definition for a binary tree node.
 class TreeNodeD {
    int val;
    TreeNodeD left;
    TreeNodeD right;
    TreeNodeD() {}
    TreeNodeD(int val) { this.val = val; }
    TreeNodeD(int val, TreeNodeD left, TreeNodeD right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BinaryTreeDiameter {
	
	
	public static int diameterOfBinaryTree(TreeNodeD root) {
		Map<TreeNodeD, Integer> map = new HashMap<>();  /// map of node and it's diameter
		Stack<TreeNodeD> S1 = new Stack<>();
		int diameter = 0;

		// post order traversal
		if (root != null) {
			S1.push(root);
		}

		while (!S1.isEmpty()) {

			TreeNodeD node = S1.peek();

			if (node.left != null && !map.containsKey(node.left)) {
				System.out.println("LEFT PUSH DONE:"+node.left.val);
				S1.push(node.left);

			} else if (node.right != null && !map.containsKey(node.right)) {
				System.out.println("RIGHT PUSH DONE:"+node.right.val);
				S1.push(node.right);
			} else {

				System.out.println("POPPING:"+S1.peek().val);
				S1.pop();
				int leftdepth = map.getOrDefault(node.left, 0);
				int rightdepth = map.getOrDefault(node.right, 0);

				map.put(node, 1 + Math.max(leftdepth, rightdepth));
			//	System.out.println("Node Depth :"+S1.peek().val);

				diameter = Math.max(diameter, leftdepth + rightdepth);

			}
		}
		return diameter;

	}
	
	
	public static void InOrderOfBinaryTree(TreeNodeD root) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		Stack<TreeNodeD> S1 = new Stack<>();

		// post order traversal
		//if (root != null) {
		//	S1.push(root);
		//}

		TreeNodeD current = root;

		while (!S1.empty() || current != null) {

			if (current != null) {
				S1.push(current);
				current=current.left;

			} else {
				//p = 
				TreeNodeD node = S1.pop();
				//S1.push(root);
				al.add(node.val);
				current = node.right;
			}
		}

		System.out.println("Inorder: " + al.toString());

	}
	
	
	public static void PostOrderOfBinaryTree(TreeNodeD root) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		Stack<TreeNodeD> S1 = new Stack<>();

		// post order traversal
		//if (root != null) {
		//	S1.push(root);
		//}

		TreeNodeD p = root;

		while (!S1.empty() || p != null) {

			if (p != null) {
				S1.push(p);
				p=p.left;

			} else {
				//p = 
				TreeNodeD node = S1.pop();
				//S1.push(root);
				al.add(node.val);
				p = node.right;
			}
		}

		System.out.println("Inorder: " + al.toString());

	}



	public static void main(String[] args) {
		TreeNodeD root = new TreeNodeD(1);
		root.left = new TreeNodeD(2);
		root.right = new TreeNodeD(3);
		root.left.left = new TreeNodeD(4);
		root.left.right = new TreeNodeD(5);
		//root.right.right = new TreeNodeD(6);

		// Function call
		System.out.println("Diameter: " + diameterOfBinaryTree(root));
		//InOrderOfBinaryTree(root);

	}

}
      