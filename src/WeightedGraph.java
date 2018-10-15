import java.util.*;

public class WeightedGraph {
    HashMap<String, Vertex> adjacencyList;

    public WeightedGraph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addVertex(String name) {
        adjacencyList.put(name, new Vertex(name));
    }

    public void addEdge(String source, String destination, double weight, boolean bidirectional) {
        Vertex sourceVertex = adjacencyList.getOrDefault(source, null);
        Vertex destinationVertex = adjacencyList.getOrDefault(destination, null);

        if (sourceVertex == null || destinationVertex == null) {
            return;
        }
        if (sourceVertex.hasEdge(destinationVertex)) {
            return;
        }

        sourceVertex.edges.add(new Edge(destinationVertex, weight));
        if (bidirectional) {
            destinationVertex.edges.add(new Edge(sourceVertex, weight));
        }
    }

    public void removeVertex(String name) {
        Vertex toRemove = adjacencyList.getOrDefault(name, null);
        if (toRemove == null)
            return;

        for (Vertex vertex : adjacencyList.values()) {
            vertex.removeEdge(toRemove);
        }
        adjacencyList.remove(name);
    }

    public void removeEdge(String source, String destination) {
        Vertex sourceVertex = adjacencyList.getOrDefault(source, null);
        Vertex destinationVertex = adjacencyList.getOrDefault(destination, null);

        if (sourceVertex == null || destinationVertex == null) {
            return;
        }

        sourceVertex.removeEdge(destinationVertex);
        destinationVertex.removeEdge(sourceVertex);
    }

    public void printAdjacencyList() {
        for (Vertex vertex : adjacencyList.values()) {
            System.out.print(vertex.toString() + "\n");
        }
    }

    public List<Object> DijkstrasAlgorithm(WeightedGraph graph, Vertex start) {
        HashMap<Vertex, Double> totalCosts = new HashMap<>();
        HashMap<Vertex, Vertex> prevNodes = new HashMap<>();
        PriorityQueue<Vertex> minPQ = new PriorityQueue<>();
        HashSet<Integer> visited = new HashSet<>();

        totalCosts.put(start, 0.0);
        minPQ.add(start);

        for (Vertex vertex : graph.adjacencyList.values()) {
            if (vertex != start) {
                totalCosts.put(vertex, Double.MAX_VALUE);
            }
        }

        while (!minPQ.isEmpty()) {
            Vertex newSmallest = minPQ.poll();
        }
        return null;
    }
}
