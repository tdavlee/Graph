import adjacencylist.GraphL;
import adjacencylist.Vertex;
import adjacencymatrix.GraphM;

import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GraphL graphL = new GraphL();

        graphL.addVertex("SF");
        graphL.addVertex("SEA");
        graphL.addVertex("LA");
        graphL.addVertex("CHI");
        graphL.addVertex("NYC");

        graphL.addEdge("SF", "SEA", 3, true);
        graphL.addEdge("SF", "LA", 5, true);
        graphL.addEdge("SEA", "CHI", 2, true);
        graphL.addEdge("SEA", "LA", 1, true);
        graphL.addEdge("LA", "CHI", 3, true);
        graphL.addEdge("LA", "NYC", 8, true);
//        graphL.addEdge("CHI", "NYC", 4, true);



        graphL.printAdjacencyList();

        System.out.println();
        System.out.println();


//
        Vertex start = graphL.adjacencyList.get("NYC");
        Vertex end = graphL.adjacencyList.get("SEA");




        List<Object> result = graphL.DijkstrasAlgorithm(graphL, start);
        HashMap<Vertex, Vertex> paths = (HashMap<Vertex, Vertex>) result.get(1);

        System.out.println(paths);
        System.out.println(graphL.getShortestPath(paths, start, end));

        GraphM graphM = new GraphM(5);
    }
}
