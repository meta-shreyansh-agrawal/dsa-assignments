package Session6.Question1;

import java.util.List;
import java.util.Set;

public interface UndirectedWeightedGraph {
    
    boolean isConnected();

    Set<Integer> reachable(int a);

    List<Edge> mst();

    List<Integer> shortestPath(int a, int b);
}
