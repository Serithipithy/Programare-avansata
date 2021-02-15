package Optional;

public class optional {
    public static void main (String[] args) {
        if (args.length != 1) {
            System.out.println("Not enough arguments or too many!");
            System.exit(-1);
        }
        else{
            int number=Integer.parseInt(args[0]);

            if ( number % 2 == 0) {
                System.out.println("The number " + number + " is not an odd number.");
            }
            else {
                int[][] matrix = new int[number][number];

                for( int i = 0; i < number ; ++i)
                    for ( int j = 0; j < number ; ++j)
                        if ( i == j ) matrix[i][j] = 0;
                        else{
                            matrix[i][j]= (int)(Math.random() * 2);
                        }
                System.out.print("┏");
                for ( int k = 0; k < number*4; ++k) System.out.print("━");
                System.out.println("┓");
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


                boolean [] visited = new boolean[10];
                int count = 0;
                for(int i = 0; i < matrix.length; i++) {
                    if(!visited[i]) {
                        dfsSimple(i,matrix,visited);
                        ++count;
                    }
                }
                if(count == 1) System.out.println("The graph is connected!");
                else{
                    visited = new boolean[10];
                    count = 0;
                    for(int i = 0; i < matrix.length; i++) {
                        if(!visited[i]) {
                            System.out.println("Compnent: " );
                            dfs(i,matrix,visited);
                            System.out.println();
                            ++count;
                        }
                    }
                }
            }
        }
    }

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
