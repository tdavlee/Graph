package adjacencymatrix;

import java.util.ArrayList;
import java.util.List;

public class GraphM {
    private int vertices;
    private int[][] matrix;
    private List<Node> nodes;

    public GraphM(int vertices) {
        this.vertices = vertices;
        matrix = new int[vertices][vertices];

        for (int i = 0; i < vertices; i++) {
            for (int k = 0; k < vertices; k++) {
                matrix[i][k] = 0;
            }
        }

        nodes = new ArrayList<>();
    }

    public int getVertices() {
        return vertices;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void addEdge(int source, int destination, int weight) {
        matrix[source][destination] = weight;
        matrix[destination][source] = weight;
    }

    public void removeEdge(int source, int destination) {
        matrix[source][destination] = -1;
        matrix[destination][source] = -1;
    }

    public void printMatrix() {
        for (int i = 0; i < vertices; i++) {
            for (int k = 0; k < vertices; k++) {
                System.out.print(matrix[i][k] + " ");
            }
            System.out.println();
        }
    }

    public void addNode(String name, int id) {
        nodes.add(new Node(name, id));
    }

    public int[] DijkstrasAlgorithm(int start) {
        int[] dist = new int[vertices];
        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;

        for (int i = 0; i < vertices; i++) {
            int u = findNextMin(i, dist, visited);
            visited[u] = true;

            for (int v = 0; v < vertices; v++) {
                if (!visited[v] && matrix[u][v] != 0 &&
                    dist[u] != Integer.MAX_VALUE && dist[u] + matrix[u][v] < dist[v]) {
                    dist[v] = dist[u] + matrix[u][v];
                }
            }
        }

        return dist;
    }

    public int findNextMin(int source, int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < vertices; i++) {
            if (!visited[i] && dist[i] < min) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    class Node {
        String name;
        int id;

        Node(String name, int id) {
            this.name = name;
            this.id = id;
        }
    }
}
