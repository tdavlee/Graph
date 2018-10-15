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
}