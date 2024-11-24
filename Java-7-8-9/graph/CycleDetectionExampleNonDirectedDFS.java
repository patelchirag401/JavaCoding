package com.graph;

import java.util.*;

/*
 * Detecting cycles in a graph is a fundamental problem in graph theory. 
 * One common algorithm to detect cycles in an undirected graph is Depth-First Search (DFS). 
 * Here's a sample Java program to find a cycle in an undirected graph using DFS:
 */
class Graph {
    private int V; // Number of vertices
    private List<List<Integer>> adj; // Adjacency list representation

    public Graph(int v) {
        V = v;
        adj = new ArrayList<>(v);
        for (int i = 0; i < v; ++i) {
            adj.add(new LinkedList<>());
        }
    }

    // Function to add an edge to the graph
    public void addEdge(int v, int w) {
        adj.get(v).add(w);
        adj.get(w).add(v); // For an undirected graph
    }

    // Recursive DFS function to detect cycles
    private boolean isCyclicUtil(int v, boolean[] visited, int parent) {
        visited[v] = true;
        for (Integer i : adj.get(v)) {
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, v)) {
                    return true;
                }
            } else if (i != parent) {
                return true;
            }
        }
        return false;
    }

    // Function to detect cycles in the graph
    public boolean isCyclic() {
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }
}

public class CycleDetectionExampleNonDirectedDFS {
    public static void main(String[] args) {
        // Create a graph with 5 vertices
        Graph graph = new Graph(5);
        
        // Add edges to create a cycle
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);

        if (graph.isCyclic()) {
            System.out.println("Graph contains a cycle.");
        } else {
            System.out.println("Graph does not contain a cycle.");
        }
    }
}


