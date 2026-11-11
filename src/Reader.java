import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    public static void Read(String filename) {
        Graph adjMatrix = new AdjacencyMatrix();
        Graph adjList = new AdjacencyList();

        String[] StringArray;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            try {
                String line;
                while ((line = br.readLine()) != null) {
                    StringArray = line.split(" ");
                    adjList.addEdge(StringArray[0], StringArray[1], Double.parseDouble(StringArray[2]));
                    adjMatrix.addEdge(StringArray[0], StringArray[1], Double.parseDouble(StringArray[2]));
                }
            } catch (IOException e) {
                System.out.println("There was a problem reading the text.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Invalid file name.");
        }
        System.out.println("Successfully read the file."
        //  +      "\n-- Adjacency List -- "
        );

        // printGraph() is not a super good representation for adj list, so it is commented out
        // all it did was print information about every connection, which was useful for testing,
        // but it isn't really helpful for anything else

        // adjList.printGraph();
        System.out.println("\n-- Adjacency List BFS -- ");
        adjList.BFS(adjList.vertices.getFirst());
        System.out.println("\n-- Adjacency Matrix Graph -- ");
        adjMatrix.printGraph();
        System.out.println("\n-- Adjacency Matrix BFS -- ");
        adjMatrix.BFS(adjMatrix.vertices.getFirst());
    }
}
