package com.tree;



//Class containing left and right child of current
//node and key value
class Node1 {
 int key;
 Node1 left, right;

 public Node1(int item)
 {
     key = item;
     left = right = null;
 }
}

class PostOrderTree {

 // Root of Binary Tree
 Node1 root;

 PostOrderTree() { root = null; }

 // Given a binary tree, print its nodes according to the
 // "bottom-up" postorder traversal.
 void printPostorder(Node1 node)
 {
     if (node == null)
         return;

     // First recur on left subtree
     printPostorder(node.left);

     // Then recur on right subtree
     printPostorder(node.right);

     // Now deal with the node
     System.out.print(node.key + " ");
 }

 // Driver code
 public static void main(String[] args)
 {
	 PostOrderTree tree = new PostOrderTree();
     tree.root = new Node1(1);
     tree.root.left = new Node1(2);
     tree.root.right = new Node1(3);
     tree.root.left.left = new Node1(4);
     tree.root.left.right = new Node1(5);

     // Function call
     System.out.println(
         "Postorder traversal of binary tree is ");
     tree.printPostorder(tree.root);
 }
}
