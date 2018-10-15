package adjacencymatrix;

public class GraphM {
    private int vertices;
    private Edge[][] maxtrix;

    public GraphM(int vertices) {
        this.vertices = vertices;
        maxtrix = new Edge[vertices][vertices];

//        for (int i = 0; i < vertices; i++) {
//            for (int k = 0; k < vertices; k++) {
//                maxtrix[i][k] = null;
//            }
//        }
    }

    public int getVertices() {
        return vertices;
    }

    public Edge[][] getMaxtrix() {
        return maxtrix;
    }

    public boolean addEdge(Edge node) {

    }

    class Edge {
        String name;
        int to, from;
        double weight;

        Edge(String name, int from, int to, double weight) {
            this.name = name;
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
