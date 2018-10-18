import adjacencylist.GraphL;
import adjacencylist.Vertex;
import adjacencymatrix.GraphM;

import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        GraphL graphL = new GraphL();
//
//        graphL.addVertex("SF");
//        graphL.addVertex("SEA");
//        graphL.addVertex("LA");
//        graphL.addVertex("CHI");
//        graphL.addVertex("NYC");
//
//        graphL.addEdge("SF", "SEA", 3, true);
//        graphL.addEdge("SF", "LA", 5, true);
////        graphL.addEdge("SEA", "CHI", 2, true);
//        graphL.addEdge("SEA", "LA", 1, true);
//        graphL.addEdge("LA", "CHI", 3, true);
//        graphL.addEdge("LA", "NYC", 8, true);
//        graphL.addEdge("CHI", "NYC", 4, true);
//
//
//
//        graphL.printAdjacencyList();
//
//        System.out.println();
//        System.out.println();
//
//
////
//        Vertex start = graphL.adjacencyList.get("NYC");
//        Vertex end = graphL.adjacencyList.get("SF");
//
//
//
//
//        List<Object> result = graphL.DijkstrasAlgorithm(graphL, start);
//        HashMap<Vertex, Vertex> paths = (HashMap<Vertex, Vertex>) result.get(1);
//
//        System.out.println(paths);
//        System.out.println(graphL.getShortestPath(paths, start, end));

//        GraphM graphM = new GraphM(5);
//        graphM.printMatrix();
//        graphM.addNode("SF", 0);
//        graphM.addNode("LA", 1);
//        graphM.addNode("SEA", 2);
//        graphM.addNode("CHI", 3);
//        graphM.addNode("NYC", 4);
//
//        graphM.addEdge(0, 1, 5);
//        graphM.addEdge(0, 2, 3);
//        graphM.addEdge(1, 2, 1);
//        graphM.addEdge(1, 3, 3);
//        graphM.addEdge(1, 4, 6);
//        graphM.addEdge(2, 3, 2);
//        graphM.addEdge(3, 4, 4);
//
//        System.out.println();
//        graphM.DijkstrasAlgorithm(0);



        GraphM movies = new GraphM(7);
        movies.addEdge(0, 1, -4);
        movies.addEdge(0, 2, -3);
        movies.addEdge(1, 2, -3);
        movies.addEdge(1, 3, -1);
        movies.addEdge(2, 3, -1);
        movies.addEdge(2, 4, -3);
        movies.addEdge(3, 4, -3);
        movies.addEdge(3, 5, -4);
        movies.addEdge(4, 5, -4);
        movies.addEdge(4, 6, 1);
        movies.addEdge(5, 6, 1);

//        int[] a = movies.DijkstrasAlgorithm(0);
//        for (int i = 0; i < a.length; i++) {
//            System.out.println("i: " + i + " d= " + a[i]);
//        }

        System.out.println(movies.findLongestPath() - 1);
    }
}
