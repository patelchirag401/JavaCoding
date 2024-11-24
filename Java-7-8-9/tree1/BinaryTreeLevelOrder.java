package com.tree1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

 class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int item) {
        data = item;
        left = right = null;
    }
}

public class BinaryTreeLevelOrder {
	
	TreeNode root;

	// Function to perform level order traversal
    public ArrayList<ArrayList<Integer>> levelOrderTraversal() {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (root == null) {
            System.out.println("The tree is empty.");
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            ArrayList<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                currentLevel.add(current.data);

                if (current.left != null)
                    queue.add(current.left);

                if (current.right != null)
                    queue.add(current.right);
            }

            result.add(currentLevel);
        }

        return result;
    }
    
    public static void main(String args[]) {
    	BinaryTreeLevelOrder tree = new BinaryTreeLevelOrder();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);

        System.out.println("Level Order Traversal of Binary Tree:");
        ArrayList<ArrayList<Integer>> result = tree.levelOrderTraversal();

        // Print the result
        for (ArrayList<Integer> level : result) {
            System.out.println(level);
        }
    
    }
}
