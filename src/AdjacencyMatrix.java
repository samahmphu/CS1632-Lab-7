import java.util.ArrayList;

public class AdjacencyMatrix extends Graph {

    private String[][] matrix;
    public AdjacencyMatrix() {
        this.vertices = new ArrayList<Vertex>();
        matrix = new String[][]{{}};
    }

    @Override
    public Vertex addVertex(String s) {
        if (isAVertex(s)) {
            return getVertexByName(s);
        }

        Vertex nVertex = new Vertex(s);
        vertices.add(nVertex);

        int size = vertices.size();
        String[][] nMatrix = new String[size][size];

        for (int x = 0; x < size - 1; x++) {
            for (int y = 0; y < size - 1; y++) {
                nMatrix[x][y] = matrix[x][y];
            }
        }

        matrix = nMatrix;

        return nVertex;
    }

    @Override
    public void addEdge(String from, String to, double weight) {
        Vertex source = addVertex(from);
        Vertex destination = addVertex(to);

        Edge nEdge = new Edge(source,destination,weight);

        int startIndex = vertices.indexOf(source);
        int goalIndex = vertices.indexOf(destination);

        source.getEdges().add(nEdge);
        destination.getEdges().add(nEdge);

        matrix[startIndex][goalIndex] = String.valueOf(weight);
        matrix[goalIndex][startIndex] = String.valueOf(weight);

    }

    @Override
    public void printGraph() {
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix.length; y++) {
                System.out.print(matrix[x][y] + " \t");
            }
            System.out.println();
        }
    }

    @Override
    public boolean isAVertex(String s) {
        for (Vertex v : vertices) {
            if (v.getName().equals(s)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Vertex getVertexByName(String s) {
        for (Vertex v : vertices) {
            if (v.getName().equals(s)) {
                return v;
            }
        }
        return null;
    }
}
