package Optional;

public class optional {
    public static void main (String[] args) {
        if (args.length != 1) { // see if there is one argument
            System.out.println("Not enough arguments or too many!");
            System.exit(-1);
        }
        else{
            int number=Integer.parseInt(args[0]); // from string to integer

            if ( number % 2 == 0) { // se if the number is not odd and display a message
                System.out.println("The number " + number + " is not an odd number.");
            }
            else { // the number is odd
                // creating the matrix of adjacency
                int[][] matrix = new int[number][number];

                for( int i = 0; i < number ; ++i)
                    for ( int j = 0; j < number ; ++j)
                        if ( i == j ) matrix[i][j] = 0; // on the main diagonal we'll have 0
                        else{
                            matrix[i][j]= (int)(Math.random() * 2); // a random number ( 0  or 1 )
                        }
                // drawing the top part of our box for matrix
                System.out.print("┏");
                for ( int k = 0; k < number*4; ++k) System.out.print("━");
                System.out.println("┓");
                // printing the actual matrix with the drawings
                for( int i = 0; i < number ; ++i) {
                    for ( int j = 0; j < number; ++j) System.out.print("┃ " + matrix[i][j] + " ");
                    System.out.println(" ┃");
                    if( i != number - 1 ) {
                        System.out.print("┃");
                        for (int j = 0; j < number*4; ++j) System.out.print("━");
                        System.out.println("┃");
                    }
                    else {
                        System.out.print("┗");
                        for ( int k = 0; k < number*4; ++k) System.out.print("━");
                        System.out.println("┛");
                    }
                }

                // see if the graph is connected or not with dfs
                boolean [] visited = new boolean[10];
                int count = 0;
                for(int i = 0; i < matrix.length; i++) {
                    if(!visited[i]) {
                        dfsSimple(i,matrix,visited);
                        ++count;
                    }
                }

                if(count == 1) System.out.println("The graph is connected!");
                else{  // if the graph is not connected we'll determine the connected components using dfs again
                    visited = new boolean[10];
                    count = 0;
                    for(int i = 0; i < matrix.length; i++) {
                        if(!visited[i]) {
                            System.out.println("Component: " );
                            dfs(i,matrix,visited);
                            System.out.println();
                            ++count;
                        }
                    }
                }
            }
        }
    }

    // will print the nodes for every connected component
    public static void dfs(int i, int[][] graph, boolean[] visited) {
        if(!visited[i]){
            visited[i] = true; // Mark node as "visited"
            System.out.print(i+1 + " ");

            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j]==1 && !visited[j]) {
                    dfs(j, graph, visited); // Visit node
                }
            }
        }
    }

    // used to see if the graph is connected
    public static void dfsSimple(int i, int[][] graph, boolean[] visited) {
        if(!visited[i]){
            visited[i] = true; // Mark node as "visited"
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j]==1 && !visited[j]) {
                    dfsSimple(j, graph, visited); // Visit node
                }
            }
        }
    }

}
