package Session6.Question2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Session6.Question1.Edge;
import Session6.Question1.UndirectedWeightedGraph;

public class EdgeListGraph implements UndirectedWeightedGraph {

    private List<Edge> edges;
    private Set<Integer> nodes;

    public EdgeListGraph() {
        edges = new ArrayList<Edge>(); 
        nodes = new HashSet<Integer>(); 
    }

    public void addEdge(int source,int destination,int weight)throws IllegalArgumentException{
        if(source == destination)throw new IllegalArgumentException("Source and Destination can't be same"); 
        if(weight<0)throw new IllegalArgumentException("Weight can't be negative"); 
        edges.add(new Edge(source, destination, weight)); 
        nodes.add(source); 
        nodes.add(destination); 
    }

    @Override
public boolean isConnected() {
    Set<Integer> visited = new HashSet<>();
    explore(nodes.iterator().next(), visited);
    return visited.size() == nodes.size(); // Check if all nodes are visited
}

private void explore(int node, Set<Integer> visited) {
    visited.add(node);
    for (Edge edge : edges) {
        if (edge.source == node && !visited.contains(edge.destination)) {
            explore(edge.destination, visited);
        } else if (edge.destination == node && !visited.contains(edge.source)) {
            explore(edge.source, visited);
        }
    }
}

@Override
public Set<Integer> reachable(int a) {
    Set<Integer> reachableNodes = new HashSet<>();
    explore(a, reachableNodes);
    return reachableNodes; // All nodes reachable from 'a'
}

@Override
public List<Edge> mst() {
    List<Edge> mstEdges = new ArrayList<>();
    edges.sort((e1, e2) -> e1.weight - e2.weight); // Sort edges by weight
    Map<Integer, Integer> parent = new HashMap<>();
    for (int node : nodes) parent.put(node, node); // Initialize parents

    for (Edge edge : edges) {
        int rootSource = findParent(edge.source, parent);
        int rootDestination = findParent(edge.destination, parent);

        if (rootSource != rootDestination) {
            mstEdges.add(edge);
            parent.put(rootSource, rootDestination); // Union
        }
    }
    return mstEdges; // Return Minimum Spanning Tree
}

private int findParent(int node, Map<Integer, Integer> parent) {
    while (node != parent.get(node)) node = parent.get(node);
    return node;
}

@Override
public List<Integer> shortestPath(int a, int b) {
    Map<Integer, Integer> distances = new HashMap<>();
    Map<Integer, Integer> previous = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    for (int node : nodes) distances.put(node, Integer.MAX_VALUE);
    distances.put(a, 0); // Distance to start is 0

    while (visited.size() < nodes.size()) {
        int current = getClosestNode(distances, visited);
        visited.add(current);

        for (Edge edge : edges) {
            if (edge.source == current || edge.destination == current) {
                int neighbor = edge.source == current ? edge.destination : edge.source;
                if (!visited.contains(neighbor)) {
                    int newDistance = distances.get(current) + edge.weight;
                    if (newDistance < distances.get(neighbor)) {
                        distances.put(neighbor, newDistance);
                        previous.put(neighbor, current);
                    }
                }
            }
        }
    }

    return buildPath(previous, a, b); // Build the path from 'a' to 'b'
}

private int getClosestNode(Map<Integer, Integer> distances, Set<Integer> visited) {
    int minDistance = Integer.MAX_VALUE;
    int closestNode = -1;
    for (int node : nodes) {
        if (!visited.contains(node) && distances.get(node) < minDistance) {
            minDistance = distances.get(node);
            closestNode = node;
        }
    }
    return closestNode;
}

private List<Integer> buildPath(Map<Integer, Integer> previous, int start, int end) {
    List<Integer> path = new ArrayList<>();
    int current = end;
    while (current != start && previous.containsKey(current)) {
        path.add(0, current);
        current = previous.get(current);
    }
    path.add(0, start);
    return path.get(0) == start ? path : new ArrayList<>(); // Return path or empty if no path
}
    
}
