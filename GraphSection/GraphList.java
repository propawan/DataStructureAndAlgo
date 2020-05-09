package GraphSection;

import java.util.LinkedList;

public class GraphList<T extends Comparable<T>> {
    LinkedList<Vertex> vertices = new LinkedList<>();

    private class Vertex{
        T value;
        LinkedList<Vertex> neighbours;

        public Vertex(T value){
            this.value = value;
            this.neighbours = new LinkedList<>();
        }
    }

    public void addVertex(T val){
        vertices.add(new Vertex(val));
    }

    public void addEdge(T f,T s){
        Vertex first = checkVertex(f);
        Vertex second = checkVertex(s);

        if((first!=null)&&(second!=null)){
            first.neighbours.add(second);
            second.neighbours.add(first);
        }
    }

    public Vertex checkVertex(T x){
        for (Vertex vertex:this.vertices) {
            if(vertex.value.equals(x)){
                return vertex;
            }
        }
        return null;
    }

    public void display(){
        for (Vertex vertex:this.vertices) {
            System.out.print("Vertex:"+vertex.value+"-> ");
            for (Vertex neighbour:vertex.neighbours) {
                System.out.print(neighbour.value+" ");
            }
            System.out.println();
        }
    }
}
