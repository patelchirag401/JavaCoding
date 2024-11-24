package com.test;

public class LinkedList {
	
	static Node head;
	
	static void setHead(Node head) {
		LinkedList.head = head;
	}
	
	static Node getHead() {
		return head;
	}
	
	public static void main(String a[]) {
		
		Node node = new Node();
		//node.data = 01;
		//node.head = node;		
		Push(1);Push(3);Push(5);Push(7);
		//insertNodeAtStart(100);
		Push(9);Push(11);
		removeNode(5);
		printList();
	}
	
	static class Node {
		int data;
		//Node head;
		Node next;
	}
	
	static void printList() {
		Node ptr =  head;
		System.out.println(" "+ptr.data);
		while(ptr.next!=null) {
			ptr = ptr.next;
			System.out.println(" "+ptr.data);
			
		}
	}
	
	static void removeNode(int nodeValue) {
		//Node ptr = head;
		
		if(head == null) return;
		
		if(head.data==nodeValue) {
			head = head.next;
			return;
		}
		
		Node current =  head;
		while (current.next !=null && current.next.data!=nodeValue) {
			current = current.next;
		}
		
		while(current.next!=null) {
			current.next = current.next.next;
		}
		
		
		/*head = head.next;
		while (head != null) {
			if (head.data == nodeValue) {
				//ptr = null;
				head.next = head.next.next;
				break;
			}
			head = head.next;
		}	

		
		
		setHead(head);
		*/
		
		//setHead(current);
	}
	
	static void insertNodeAtStart(int nodeValue) {
		Node newNode  = new Node();
		newNode.data = nodeValue;
		
		//Node ptr = head;
		newNode.next = head;
		head = newNode;
		
	}
	
	static void Push(int nodeValue){
	
		if(head == null ) {
			Node newNode  = new Node();
			newNode.data = nodeValue;
			head = newNode;
		} else {
			Node ptr =  head;
			while(ptr.next!=null) {
				ptr =  ptr.next;
			}
			Node newNode  = new Node();
			newNode.data = nodeValue;
			ptr.next = newNode;
		}
		
	}

}
