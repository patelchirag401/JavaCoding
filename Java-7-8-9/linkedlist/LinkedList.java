package com.linkedlist;

public class LinkedList {

	Node head;

	static class Node {

		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}
	
	public static void deleteByKey(LinkedList list, int key) {
		
		Node currentNode = list.head;
		
		while(currentNode!=null) {
			int data = currentNode.data;
			if(data==key && currentNode.next!=null) {
				//int tempdata = currentNode.next.next.data;
				currentNode.next = currentNode.next.next;
				//currentNode.data = tempdata;
				break;
			}
			currentNode = currentNode.next;
		}
		
	}

	public static LinkedList insert(LinkedList list, int data) {

		Node new_node = new Node(data);

		if (list.head == null) {
			list.head = new_node;

		} else {

			Node last = list.head;
			while (last.next != null) {
				last = last.next;
			}

			last.next = new_node;

		}

		return list;
	}

	public static void printlist(LinkedList list) {
		Node curr_node = list.head;
		while (curr_node != null) {
			System.out.println(curr_node.data + " ");
			curr_node = curr_node.next;
		}
		
	}
	
	public static void reverseList(LinkedList list) {
		Node curr_node = list.head;
		while (curr_node != null) {
			System.out.println(curr_node.data + " ");
			curr_node = curr_node.next;
		}
  }

	public static void main(String a[]) {
		LinkedList list = new LinkedList();
		//list = insert(list, 0);
		list = insert(list, 1);
		list = insert(list, 2);
		list = insert(list, 3);
		list = insert(list, 4);
		list = insert(list, 5);
		list = insert(list, 6);
		list = insert(list, 7);
		list = insert(list, 8);
		list = insert(list, 9);
		
		//deleteByKey(list,3);
		//deleteByKey(list,6);
		////deleteByKey(list,9);

		reverseList(list);
		
		printlist(list);
	}

}
