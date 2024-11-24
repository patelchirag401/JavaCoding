package com.tree;



//Java program for inorder traversals
import java.util.*;

//Structure of a Binary Tree Node
class NodeIn {
 int data;
 NodeIn left, right;

 NodeIn(int v)
 {
     data = v;
     left = right = null;
 }
}

//Main class
class InOrderTree {

 // Function to print inorder traversal
 public static void printInorder(NodeIn node)
 {
     if (node == null)
         return;

     // First recur on left subtree
     System.out.println("First recur on left subtree:"+node.data);
     printInorder(node.left);

     // Now deal with the node
     System.out.println("Now deal with the node:"+node.data);
     System.out.println(node.data + " ");

     // Then recur on right subtree
     System.out.println("Then recur on right subtree:"+node.data);
     printInorder(node.right);
 }

 // Driver code
 public static void main(String[] args)
 {
	 NodeIn root = new NodeIn(1);
     root.left = new NodeIn(2);
     root.right = new NodeIn(3);
     root.left.left = new NodeIn(4);
     root.left.right = new NodeIn(5);
     root.right.right = new NodeIn(6);

     // Function call
     System.out.println(
         "Inorder traversal of binary tree is: ");
     printInorder(root);
 }
}
//This code is contributed by prasad264
