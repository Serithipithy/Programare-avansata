package Optional;

public class Graph extends Prim{
    public static void main(String[] args) {
        if (args.length != 1) { // see if there is one argument
            System.out.println("Not enough arguments or too many!");
            System.exit(-1);
        } else {
            int number = Integer.parseInt(args[0]); // from string to integer

            if (number % 2 == 0) { // se if the number is not odd and display a message
                System.out.println("The number " + number + " is not an odd number.");
            } else { // the number is odd
                // creating the matrix of adjacency
                int[][] matrix = new int[number][number];
                generate_random_matrix(matrix, number);
                //draw_matrix(matrix, number);

                if (is_connected(matrix, number) == 1) {
                    System.out.println("The graph is connected!");
                    Prim t = new Prim();
                    int [][] weighted_matrix = new int [number][number];

                    weightingGraph(weighted_matrix,matrix, number); // adds weight to our graph
                    t.primMST(weighted_matrix,number); // displays MTS using Prims algorithm ( this is also a partial tree)

                }
                else {
                    determine_components(matrix, number);
                }
            }
        }
    }

    private static void weightingGraph(int[][] weighted_matrix, int [][] matrix, int number) {
        for (int i = 0; i < number -1 ; ++i)
            for (int j = i+ 1; j < number; ++j)
                if(matrix[i][j] == 1){
                    weighted_matrix[i][j] = (int) (Math.random() * 8);
                    weighted_matrix[j][i] = weighted_matrix[i][j];
                }
    }

    public static void generate_random_matrix(int[][] matrix, int number) {
        for (int i = 0; i < number -1 ; ++i)
            for (int j = i+ 1; j < number; ++j)
                if (i == j) matrix[i][j] = 0; // on the main diagonal we'll have 0
                else {
                    matrix[i][j] = (int) (Math.random() * 2); // a random number ( 0  or 1 )
                    matrix[j][i] = matrix[i][j];
                }
    }

    public static void draw_matrix(int[][] matrix, int number) {
        // drawing the top part of our box for matrix
        System.out.print("┏");
        for (int k = 0; k < number * 4; ++k) System.out.print("━");
        System.out.println("┓");

        // printing the actual matrix with the drawings
        for (int i = 0; i < number; ++i) {
            for (int j = 0; j < number; ++j) System.out.print("┃ " + matrix[i][j] + " ");
            System.out.println(" ┃");
            if (i != number - 1) {
                System.out.print("┃");
                for (int j = 0; j < number * 4; ++j) System.out.print("━");
                System.out.println("┃");
            } else {
                System.out.print("┗");
                for (int k = 0; k < number * 4; ++k) System.out.print("━");
                System.out.println("┛");
            }
        }
    }

    // will print the nodes for every connected component
    public static void dfs(int i, int[][] graph, boolean[] visited) {
        if (!visited[i]) {
            visited[i] = true; // Mark node as "visited"
            System.out.print(i + 1 + " ");

            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == 1 && !visited[j]) {
                    dfs(j, graph, visited); // Visit node
                }
            }
        }
    }

    // used to see if the graph is connected
    public static void dfsSimple(int i, int[][] graph, boolean[] visited) {
        if (!visited[i]) {
            visited[i] = true; // Mark node as "visited"
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == 1 && !visited[j]) {
                    dfsSimple(j, graph, visited); // Visit node
                }
            }
        }
    }

    public static int is_connected(int[][] matrix, int number) {
        // see if the graph is connected or not with dfs
        boolean[] visited = new boolean[1000];
        int count = 0;
        for (int i = 0; i < number; i++) {
            if (!visited[i]) {
                dfsSimple(i, matrix, visited);
                ++count;
            }
        }
        return count;
    }

    public static void determine_components(int[][] matrix, int number) {
        // if the graph is not connected we'll determine the connected components using dfs again
        boolean[] visited = new boolean[1000];
        for (int i = 0; i < number; i++) {
            if (!visited[i]) {
                System.out.println("Component: ");
                dfs(i, matrix, visited);
                System.out.println();
            }
        }
    }
}
