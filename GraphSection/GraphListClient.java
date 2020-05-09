package GraphSection;

public class GraphListClient {
    public static void main(String[] args) {
        GraphList<Character> integerGraphList = new GraphList<>();
        integerGraphList.addVertex('A');
        integerGraphList.addVertex('B');
        integerGraphList.addVertex('C');
        integerGraphList.addEdge('A','B');
        integerGraphList.addEdge('A','C');
        integerGraphList.addEdge('B','C');
        integerGraphList.display();
    }
}
