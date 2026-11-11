import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\n-- Menu --" +
                        "\n1. Read a file as a graph and run a BFS" +
                        "\n2. Exit application");
                String in = sc.next();
                if (Integer.parseInt(in) == 1){
                    while (true) {
                        try {
                            System.out.println("\n-- Read Graph --" +
                                    "\nEnter the filename of your CSV file located in src/TxtFiles, or enter 0 to cancel." +
                                    "\nExample: AGraph.csv\n");
                            System.out.print("Enter file name: ");
                            in = sc.next();
                            if (in.equals("0")) {
                                break;
                            }
                            else {Reader.Read("src/TxtFiles/" + in);}
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input");
                        }
                    }
                }
                else if (Integer.parseInt(in)== 2) {
                    break;
                }
                else {System.out.println("Invalid input");}

            } catch (Exception e) {
                System.out.println("Invalid input");;
            }
        }
    }

    public static void test() {
        Graph g = new AdjacencyList();

        g.addEdge("A", "B", 2);
        g.addEdge("A", "C", 3);
        g.addEdge("A","D", 5.5);
        g.addEdge("B", "E", 7);
        g.addEdge("C", "E", 3);
        g.addEdge("D", "F", 5);
        g.addEdge("E","G",5);
        g.addEdge("E", "H", 5.7);
        g.addEdge("F","H",4.4);
        g.addEdge("F","I",5);
        g.addEdge("G","J",4.3);
        g.addEdge("H","I",2.8);
        g.addEdge("H","J",4);

        g.printGraph();

        Graph h = new AdjacencyMatrix();

        h.addEdge("A", "B", 2);
        h.addEdge("A", "C", 3);
        h.addEdge("A","D", 5.5);
        h.addEdge("B", "E", 7);
        h.addEdge("C", "E", 3);
        h.addEdge("D", "F", 5);
        h.addEdge("E","G",5);
        h.addEdge("E", "H", 5.7);
        h.addEdge("F","H",4.4);
        h.addEdge("F","I",5);
        h.addEdge("G","J",4.3);
        h.addEdge("H","I",2.8);
        h.addEdge("H","J",4);

        h.printGraph();
    }
}
