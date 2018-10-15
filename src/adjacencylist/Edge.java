package adjacencylist;

public class Edge{
    Vertex destination;
    double weight;

    public Edge(Vertex destination, double weight) {
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "-> {" + this.destination.name + ":" + this.weight + "}";
    }

    @Override
    public boolean equals(Object o) {
        Edge other = (Edge) o;
        return this.destination.name.equals(other.destination.name) && this.weight == other.weight;
    }
}