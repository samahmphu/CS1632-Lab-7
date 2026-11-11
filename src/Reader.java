import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

public class Reader {
    public static boolean Read(String filename) {
        Graph adjMatrix = new AdjacencyMatrix();
        Graph adjList = new AdjacencyList();

        String[] StringArray = {};
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
                return false;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Invalid file name.");
            return false;
        }
        System.out.println("Successfully read the file." +
                "\n-- Adjacency List -- ");
        adjList.printGraph();
        System.out.println("\n-- Adjacency List -- ");
        adjMatrix.printGraph();
        return true;
    }
}
