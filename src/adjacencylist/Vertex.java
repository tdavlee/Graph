package adjacencylist;

import java.util.ArrayList;
import java.util.List;

public class Vertex{
    public String name;
    public List<Edge> edges;

    public Vertex(String name) {
        this.name = name;
        edges = new ArrayList<>();
    }

    public String getAdjacencyList() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);

        for (Edge edge : edges) {
            sb.append(edge.toString());
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return this.name;
    }

    public boolean hasEdge(Vertex vertex) {
        for (Edge edge : edges) {
            if (edge.destination.name.equals(vertex.name)) {
                return true;
            }
        }
        return false;
    }

    public boolean removeEdge(Vertex vertex) {
        for (Edge edge : edges) {
            if (edge.destination.name.equals(vertex.name)) {
                edges.remove(edge);
                return true;
            }
        }
        return false;
    }

    public Edge findEdge(Vertex other) {
        for (Edge edge: edges) {
            if (edge.destination == other) {
                return edge;
            }
        }
        return null;
    }

}