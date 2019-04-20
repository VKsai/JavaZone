import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class Graph {
    int noOfVertices;
    LinkedList[] adjList;

    public Graph(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        this.adjList = new LinkedList[noOfVertices];

        for (int i=0; i<adjList.length; i++) {
            adjList[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int u, int v) {
        adjList[u].add(v);
    }

    /*public boolean isCyclic() {
        boolean containsCycle = false;
        int o = 0;
        while (o < adjList.length) {
            List<Integer> adjacents = adjList[o];
            for (int vertex: adjacents) {
                if (adjList[vertex].contains(o)) {
                    containsCycle = true;
                    break;
                }
            }
            o++;
        }
        return containsCycle;
    }*/

    // A recursive function that uses visited[] and parent to detect
    // cycle in subgraph reachable from vertex v.
    public Boolean isCyclicUtil(int v, Boolean visited[], int parent)
    {
        // Mark the current node as visited
        visited[v] = true;
        Integer i;

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> it = adjList[v].iterator();
        while (it.hasNext())
        {
            i = it.next();

            // If an adjacent is not visited, then recur for that
            // adjacent
            if (!visited[i])
            {
                if (isCyclicUtil(i, visited, v))
                    return true;
            }

            // If an adjacent is visited and not parent of current
            // vertex, then there is a cycle.
            else if (i != parent)
                return true;
        }
        return false;
    }

    // Returns true if the graph contains a cycle, else false.
    public Boolean isCyclic()
    {
        // Mark all the vertices as not visited and not part of
        // recursion stack
        Boolean visited[] = new Boolean[noOfVertices];
        for (int i = 0; i < noOfVertices; i++)
            visited[i] = false;

        // Call the recursive helper function to detect cycle in
        // different DFS trees
        for (int u = 0; u < noOfVertices; u++)
            if (!visited[u]) // Don't recur for u if already visited
                if (isCyclicUtil(u, visited, -1))
                    return true;

        return false;
    }
}


public class GraphCycleDetection {

    public static void main(String args[])
    {
        // Create a graph given in the above diagram
        Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 0);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        if (g1.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");

        Graph g2 = new Graph(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        if (g2.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");
    }
}
