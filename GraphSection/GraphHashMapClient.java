package GraphSection;

public class GraphHashMapClient {
    public static void main(String[] args) {
        GraphHashMap<Integer> graph = new GraphHashMap<>();

//        Topological sort BFS
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addEdge(0,2,false,1);
        graph.addEdge(1,2,false,1);
        graph.addEdge(1,4,false,1);
        graph.addEdge(2,5,false,1);
        graph.addEdge(2,3,false,1);
        graph.addEdge(4,5,false,1);
        graph.addEdge(3,5,false,1);
//        graph.topSortBfs();
//        System.out.println(graph.isTree());

//        Topological Sort Example that what should be learnt first
//        graph.addVertex("Python");
//        graph.addVertex("Data Pre-processing");
//        graph.addVertex("PyTorch");
//        graph.addVertex("Ml Basics");
//        graph.addVertex("Deep Learning");
//        graph.addVertex("Face Recognition");
//        graph.addVertex("Dataset");
//        graph.addEdge("Python","Data Pre-processing",false,10);
//        graph.addEdge("Python","Ml Basics",false,10);
//        graph.addEdge("Python","PyTorch",false,10);
//        graph.addEdge("PyTorch","Deep Learning",false,10);
//        graph.addEdge("Ml Basics","Deep Learning",false,10);
//        graph.addEdge("Deep Learning","Face Recognition",false,10);
//        graph.addEdge("Dataset","Face Recognition",false,10);
//        graph.topSort();

//        Has Cycle check
//        (Add a Vertex of 6 if not present)
//        graph.addEdge(0,1,false,1);
//        graph.addEdge(2,3,false,1);
//        graph.addEdge(1,3,false,1);
//        graph.addEdge(0,2,false,1);
//        graph.addEdge(4,5,false,1);
//        graph.addEdge(5,6,false,1);
//        graph.addEdge(6,4,false,1);
//        System.out.println(graph.hasCycle());

//        graph.addVertex('A');
//        graph.addVertex('B');
//        graph.addVertex('C');
//        graph.addVertex('D');
//        graph.addVertex('E');
//        graph.addVertex('F');
//        graph.addVertex('G');
//        graph.addVertex('H');
//        graph.addVertex('I');
//        graph.addEdge('A','B',true,10);
//        graph.addEdge('B','C',true,20);
//        graph.addEdge('C','D',true,30);
//        graph.addEdge('D','A',true,10);
//        graph.addEdge('D','E',true,15);
//        graph.addEdge('E','F',true,10);
//        graph.addEdge('G','H',true,10);
//        graph.display();
//        graph.bft('B');
//        System.out.println(graph.sSsp('A','E'));
//        graph.dfs('A');
//        graph.connectedComp();


//        Cycle Detection in Directed Graph
//        ( Add vertex 6 if not present )
//        graph.addEdge(0,1,false,1);
//        graph.addEdge(1,2,false,1);
//        graph.addEdge(1,5,false,1);
//        graph.addEdge(2,3,false,1);
//        graph.addEdge(4,2,false,1);
//        graph.addEdge(3,4,false,1);
//        graph.addEdge(4,5,false,1);
//        graph.addEdge(5,6,false,1);
//        System.out.println(graph.hasCycleDirected());


//        Example Test Case for Bipartite Check
//        graph.addVertex(1);
//        graph.addVertex(2);
//        graph.addVertex(3);
//        graph.addVertex(4);
//        graph.addVertex(5);
//        graph.addEdge(1,2,true,1);
//        graph.addEdge(2,3,true,1);
//        graph.addEdge(3,1,true,1);
//        graph.addEdge(3,4,true,1);
//        graph.addEdge(4,5,true,1);
//        System.out.println(graph.isBipartite());

//        For Snake And Ladders

//        int []board = new int[50];
//        board[2] = 13;
//        board[5] = 2;
//        board[9] = 18;
//        board[18] = 11;
//        board[17] = -13;
//        board[20] = -14;
//        board[24] = -8;
//        board[25] = 10;
//        board[32] = -2;
//        board[34] = -22;
//
//        for (int i = 0; i < 36; i++) {
//            graph.addVertex(i);
//            for (int j = 1; j <= 6; j++) {
//                int k = i+j;
//                k += board[k];
//                if(k<=36){
//                    graph.addVertex(k);
//                    graph.addEdge(i,k,false,1);
//                }
//            }
//        }
//        graph.addVertex(36);
//        graph.addEdge(36,36,false,1);
//        System.out.println(graph.sSsp(0,36));
    }
}
