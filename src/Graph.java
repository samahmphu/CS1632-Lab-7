import java.util.ArrayList;

public abstract class Graph {
    protected ArrayList<Vertex> vertices;


    public abstract Vertex addVertex(String s);

    public abstract void addEdge(String from, String to, double weight);

    public abstract void printGraph();

    public abstract boolean isAVertex(String s);

    public abstract Vertex getVertexByName(String s);
}
