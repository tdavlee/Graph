package adjacencylist;

import java.util.*;

public class GraphL {
    public HashMap<String, Vertex> adjacencyList;

    public GraphL() {
        this.adjacencyList = new HashMap<>();
    }

    public void addVertex(String name) {
        adjacencyList.put(name, new Vertex(name));
    }

    public void addEdge(String source, String destination, double weight, boolean bidirectional) {
        Vertex sourceVertex = adjacencyList.getOrDefault(source, null);
        Vertex destinationVertex = adjacencyList.getOrDefault(destination, null);

        if (sourceVertex == null || destinationVertex == null) {
            return;
        }
        if (sourceVertex.hasEdge(destinationVertex)) {
            return;
        }

        sourceVertex.edges.add(new Edge(destinationVertex, weight));
        if (bidirectional) {
            destinationVertex.edges.add(new Edge(sourceVertex, weight));
        }
    }

    public void removeVertex(String name) {
        Vertex toRemove = adjacencyList.getOrDefault(name, null);
        if (toRemove == null)
            return;

        for (Vertex vertex : adjacencyList.values()) {
            vertex.removeEdge(toRemove);
        }
        adjacencyList.remove(name);
    }

    public void removeEdge(String source, String destination) {
        Vertex sourceVertex = adjacencyList.getOrDefault(source, null);
        Vertex destinationVertex = adjacencyList.getOrDefault(destination, null);

        if (sourceVertex == null || destinationVertex == null) {
            return;
        }

        sourceVertex.removeEdge(destinationVertex);
        destinationVertex.removeEdge(sourceVertex);
    }

    public void printAdjacencyList() {
        for (Vertex vertex : adjacencyList.values()) {
            System.out.print(vertex.getAdjacencyList() + "\n");
        }
    }

    public List<Object> DijkstrasAlgorithm(GraphL graphL, Vertex start) {
        HashMap<Vertex, Double> totalCosts = new HashMap<>();
        HashMap<Vertex, Vertex> prevNodes = new HashMap<>();
        HashSet<String> visited = new HashSet<>();
        PriorityQueue<Edge> minPQ = new PriorityQueue<>();

        Edge startingEdge = new Edge(start, 0);
        totalCosts.put(start, 0.0);
        prevNodes.put(start, start);
        minPQ.add(startingEdge);

        for (Vertex vertex : adjacencyList.values()) {
            if (vertex != start)
                totalCosts.put(vertex, Double.MAX_VALUE);
        }

        while (!minPQ.isEmpty()) {
            Edge newSmallest = minPQ.poll();
            visited.add(newSmallest.destination.name);

            for (Edge edge: newSmallest.destination.edges) {
                if (!visited.contains(edge.destination.name)) {
                    double newDistance = totalCosts.get(newSmallest.destination) + edge.weight;
                    if (newDistance < totalCosts.get(edge.destination)) {
                        totalCosts.replace(edge.destination, newDistance);
                        prevNodes.put(edge.destination, newSmallest.destination);
                    }


                    Edge pqEdge = getEdge(minPQ.iterator(), edge);
                    if (pqEdge == null) {
                        minPQ.add(edge);
                    } else {
                        if (pqEdge.compareTo(edge) > 0) {
                            minPQ.remove(edge);
                            minPQ.add(pqEdge);
                        }
                    }
                }
            }
        }

        return Arrays.asList(totalCosts, prevNodes);
    }

    public Edge getEdge(Iterator it, Edge target) {
        while (it.hasNext()) {
            Edge edge = (Edge) it.next();

            if (edge.destination.name.equals(target.destination.name)) {
                return edge;
            }
        }
        return null;
    }

    public String getShortestPath(HashMap<Vertex, Vertex> nodes, Vertex source, Vertex destination) {
        Vertex current = nodes.get(destination);
        StringBuilder sb = new StringBuilder();
        sb.append(current.name + " -> " + destination.name);

        int count = nodes.size();
        while (current != source) {
            if (count-- <= 0) {
                return "Path Not Found";
            }

            current = nodes.get(current);
            sb.insert(0, current.name + " -> ");
        }

        return sb.toString();
    }
}
