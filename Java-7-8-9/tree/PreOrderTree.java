package com.tree;




//Java program for preorder traversals

class NodePre {
 int data;
 NodePre left, right;

 public NodePre(int item) {
     data = item;
     left = right = null;
 }
}

public class PreOrderTree {
	NodePre root;

 PreOrderTree() {
     root = null;
 }

 // Function to print preorder traversal
 void printPreorder(NodePre node) {
     if (node == null)
         return;

     // Deal with the node
     System.out.print(node.data + " ");

     // Recur on left subtree
     printPreorder(node.left);

     // Recur on right subtree
     printPreorder(node.right);
 }

 // Driver code
 public static void main(String[] args) {
	 PreOrderTree tree = new PreOrderTree();

     // Constructing the binary tree
     tree.root = new NodePre(1);
     tree.root.left = new NodePre(2);
     tree.root.right = new NodePre(3);
     tree.root.left.left = new NodePre(4);
     tree.root.left.right = new NodePre(5);
     tree.root.right.right = new NodePre(6);

     // Function call
     System.out.println("Preorder traversal of binary tree is: ");
     tree.printPreorder(tree.root);
 }
}
