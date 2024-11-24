package com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

import com.graph.Node.Edge;

class Node {
	public int data;
	public final HashSet<Edge> inEdges;
	public final HashSet<Edge> outEdges;

	public Node(int data) {
		this.data = data;
		inEdges = new HashSet<Edge>();
		outEdges = new HashSet<Edge>();
	}

	public Node addEdge(Node node) {
		Edge e = new Edge(this, node);
		outEdges.add(e);
		node.inEdges.add(e);
		return this;
	}

	@Override
	public String toString() {
		return "" + data;
	}

	public static class Edge {
		public final Node from;
		public final Node to;

		public Edge(Node from, Node to) {
			this.from = from;
			this.to = to;
		}

		@Override
		public boolean equals(Object obj) {
			Edge e = (Edge) obj;

			return e.from == from && e.to == to;
		}
	}
}



public class FindAGraphCycleDirected {
	public static void main(String[] args) {
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
//Adding dependencies to the nodes.
		three.addEdge(one).addEdge(five); // task 3 depends on 1 & 5.
		two.addEdge(five).addEdge(three); // Task 2 depends on 5 & 3.
		four.addEdge(three);
		five.addEdge(one);
		Node[] allNodes = { one, two, three, four, five, };
//L <- Empty list that will contain the sorted elements
		ArrayList<Node> L = new ArrayList<Node>();
//S <- Set of all nodes with no incoming edges
		HashSet<Node> S = new HashSet<Node>();
		for (Node n : allNodes) {
			if (n.inEdges.size() == 0) {
				S.add(n);
			}
		}
//while S is non-empty do
		while (!S.isEmpty()) {
//remove a node n from S
			Node n = S.iterator().next();
			S.remove(n);
//insert n into L
			L.add(n);
//for each node m with an edge e from n to m do
			for (Iterator<Node.Edge> it = n.outEdges.iterator(); it.hasNext();) {
//remove edge e from the graph
				Edge e = it.next();
				Node m = e.to;
				it.remove();// Remove edge from n
				m.inEdges.remove(e);// Remove edge from m
//if m has no other incoming edges then insert m into S
				if (m.inEdges.isEmpty()) {
					S.add(m);
				}
			}
		}

//Check to see if all edges are removed
		boolean cycle = false;
		for (Node n : allNodes) {
			if (!n.inEdges.isEmpty()) {
				cycle = true;
				break;
			}
		}
		if (cycle) {
			System.out.println("Cycle present, topological sort not possible");
		} else {
			System.out.println("Topological Sort: " + Arrays.toString(L.toArray()));
		}
	}
}