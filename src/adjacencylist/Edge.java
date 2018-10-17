package adjacencylist;

public class Edge implements Comparable{
    public Vertex destination;
    double weight;

    public Edge(Vertex destination, double weight) {
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return this.destination.name + ":" + this.weight + " ";
    }

    @Override
    public boolean equals(Object o) {
        Edge other = (Edge) o;
        return this.destination.name.equals(other.destination.name);
    }

    @Override
    public int compareTo(Object o) {
        Edge other = (Edge) o;

        if (this.weight == other.weight) {
            return 0;
        } else if (this.weight > other.weight) {
            return 1;
        } else {
            return -1;
        }
    }
}