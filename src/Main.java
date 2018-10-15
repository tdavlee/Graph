public class Main {
    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph();

        graph.addVertex("SF");
        graph.addVertex("SEA");
        graph.addVertex("LA");
        graph.addVertex("CHI");
        graph.addVertex("NYC");

        graph.addEdge("SF", "SEA", 3, true);
        graph.addEdge("SF", "LA", 5, true);
        graph.addEdge("SEA", "CHI", 2, true);
        graph.addEdge("SEA", "LA", 1, true);
        graph.addEdge("LA", "CHI", 3, true);
        graph.addEdge("LA", "NYC", 6, true);
        graph.addEdge("CHI", "NYC", 4, true);


        graph.printAdjacencyList();

        Vertex start = graph.adjacencyList.get("SF");
        System.out.println(graph.DijkstrasAlgorithm(graph, start));
    }
}
