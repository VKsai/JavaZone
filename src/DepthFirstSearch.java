import java.util.LinkedList;

public class DepthFirstSearch {

    static class Graph {
        int v;
        LinkedList<Integer>[] adjacencyList;

        public Graph(int v) {
            this.v = v;
            this.adjacencyList = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adjacencyList[i] = new LinkedList<>();
            }
        }

        private void addEdge(int v, int u) {
            adjacencyList[v].add(u);
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(1,0);
        g.addEdge(0,2);
        g.addEdge(2,1);
        g.addEdge(0,3);
        g.addEdge(1,4);
    }
}
