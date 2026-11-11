import java.util.*;

public abstract class Graph {
    protected ArrayList<Vertex> vertices;


    public abstract Vertex addVertex(String s);

    public abstract void addEdge(String from, String to, double weight);

    public abstract void printGraph();

    public abstract boolean isAVertex(String s);

    public abstract Vertex getVertexByName(String s);

    public void BFS(Vertex start) {
        Queue<Vertex> queue = new LinkedList<>();
        Set<Vertex> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            System.out.println("\tCurrent Vertex: " + current.getName());
            System.out.println("\tVertex ID" + current.toString());
            for (Edge edge : current.getEdges()) {
                Vertex neighbor = edge.getFrom() == current
                        ? edge.getTo() : edge.getFrom();

                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

}
