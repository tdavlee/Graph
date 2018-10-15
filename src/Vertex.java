import java.util.ArrayList;
import java.util.List;

public class Vertex {
    String name;
    List<Edge> edges;

    public Vertex(String name) {
        this.name = name;
        edges = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);

        for (Edge edge : edges) {
            sb.append(edge.toString());
        }
        return sb.toString();
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
}