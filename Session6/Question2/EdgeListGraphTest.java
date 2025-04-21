package Session6.Question2;

import org.junit.jupiter.api.Test;

import Session6.Question1.Edge;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Set;

public class EdgeListGraphTest {

    @Test
    public void testAddEdgeAndIsConnected() {
        EdgeListGraph graph = new EdgeListGraph();
        graph.addEdge(1, 2, 10);
        graph.addEdge(2, 3, 15);
        graph.addEdge(3, 4, 20);
        graph.addEdge(4, 1, 25); // Fully connected graph

        assertTrue(graph.isConnected());
    }

    @Test
    public void testAddEdgeWithSameSourceAndDestination() {
        EdgeListGraph graph = new EdgeListGraph();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> graph.addEdge(1, 1, 10));
        assertEquals("Source and Destination can't be same", exception.getMessage());
    }

    @Test
    public void testAddEdgeWithNegativeWeight() {
        EdgeListGraph graph = new EdgeListGraph();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> graph.addEdge(1, 2, -10));
        assertEquals("Weight can't be negative", exception.getMessage());
    }

    @Test
    public void testReachableNodes() {
        EdgeListGraph graph = new EdgeListGraph();
        graph.addEdge(1, 2, 10);
        graph.addEdge(2, 3, 15);

        Set<Integer> reachableFrom1 = graph.reachable(1);
        assertTrue(reachableFrom1.containsAll(Set.of(1, 2, 3)));
    }

    @Test
    public void testMinimumSpanningTree() {
        EdgeListGraph graph = new EdgeListGraph();
        graph.addEdge(1, 2, 10);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 4, 15);
        graph.addEdge(1, 4, 20);

        List<Edge> mstEdges = graph.mst();
        int totalWeight = mstEdges.stream().mapToInt(edge -> edge.weight).sum();
        assertEquals(30, totalWeight); // MST weight should be 30
    }

    @Test
    public void testShortestPath() {
        EdgeListGraph graph = new EdgeListGraph();
        graph.addEdge(1, 2, 10);
        graph.addEdge(2, 3, 15);
        graph.addEdge(1, 3, 5); // Shortest path should use this edge

        List<Integer> path = graph.shortestPath(1, 3);
        assertEquals(List.of(1, 3), path); // Shortest path from 1 to 3
    }

    @Test
    public void testShortestPathNonExistent() {
        EdgeListGraph graph = new EdgeListGraph();
        graph.addEdge(1, 2, 10);

        List<Integer> path = graph.shortestPath(1, 3); // No path to node 3
        assertTrue(!path.isEmpty());
    }
}