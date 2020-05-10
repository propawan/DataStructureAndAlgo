package GraphSection;

import java.util.*;

public class GraphHashMap<T> {

    HashMap<T, Vertex> vertexMap;

    public GraphHashMap() {
        this.vertexMap = new HashMap<>();
    }

    public class Vertex {
        T value;
        HashMap<Vertex, Integer> neighbours;

        public Vertex(T value) {
            this.value = value;
            this.neighbours = new HashMap<>();
        }
    }

    public void addVertex(T value) {
        if (!vertexMap.containsKey(value)) {
            vertexMap.put(value, new Vertex(value));
        }
    }

    public void addEdge(T x, T y, boolean isBidirectional, int weight) {
        if (vertexMap.containsKey(x) && vertexMap.containsKey(y)) {
            vertexMap.get(x).neighbours.put(vertexMap.get(y), weight);
        }
        if (isBidirectional) {
            vertexMap.get(y).neighbours.put(vertexMap.get(x), weight);
        }
    }

    public void display() {
        for (T val : vertexMap.keySet()) {
            System.out.print(val + "-> ");
            for (Vertex neighbour : vertexMap.get(val).neighbours.keySet()) {
                System.out.print(neighbour.value + " " + vertexMap.get(val).neighbours.get(neighbour) + ", ");
            }
            System.out.println();
        }
    }

    public void bft(T source) {
        Vertex vertex = vertexMap.get(source);
        Set<Vertex> set = new HashSet<>();
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(vertex);
        set.add(vertex);
        while (!queue.isEmpty()) {
            Vertex curr = queue.remove();
            System.out.print(curr.value + " ");
            for (Vertex neighbour : curr.neighbours.keySet()) {
                if (!set.contains(neighbour)) {
                    set.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
        System.out.println();
    }

    public int sSsp(T source, T dest) {
        Vertex vertex = vertexMap.get(source);
        HashMap<T, Integer> map = new HashMap<>();
        Queue<Vertex> q = new LinkedList<>();
        q.add(vertex);

        HashMap<T, T> parent = new HashMap<>();

        for (T val : vertexMap.keySet()) {
            map.put(val, Integer.MAX_VALUE);
        }
        map.put(source, 0);
        parent.put(source, source);

        while (!q.isEmpty()) {
            Vertex curr = q.remove();
            for (Vertex neighbour : curr.neighbours.keySet()) {
                if (map.get(neighbour.value) == Integer.MAX_VALUE) {
                    q.add(neighbour);
                    parent.put(neighbour.value, curr.value);
                    map.put(neighbour.value, map.get(curr.value) + 1);
                }
            }
        }

//        for (T val:vertexMap.keySet()) {
//            System.out.println("Vertex: "+source+" Distance from: "+val+" is "+map.get(val));
//        }

        T temp = dest;

        while (temp != source) {
            System.out.print(temp + "<-");
            temp = parent.get(temp);
        }
        System.out.println(source);
        return map.get(dest);
    }

    public void dfs(T source) {
        Set<T> visited = new HashSet<>();
        dfsHelper(source, visited);
    }

    public void dfsHelper(T source, Set<T> visited) {
        System.out.print(source + " ");
        visited.add(source);
        for (Vertex vertex : vertexMap.get(source).neighbours.keySet()) {
            if (!visited.contains(vertex.value)) {
                dfsHelper(vertex.value, visited);
            }
        }
    }

    public void connectedComp() {
        Set<T> visited = new HashSet<>();
        int count = 0;
        System.out.println();
        for (T val : vertexMap.keySet()) {
            if (!visited.contains(val)) {
                System.out.print("Component " + count + " ");
                dfsHelper(val, visited);
                count++;
                System.out.println();
            }
        }
    }

    public void topSort() {
        Set<T> visited = new HashSet<>();
        LinkedList<T> list = new LinkedList<>();

        for (T val : vertexMap.keySet()) {
            if (!visited.contains(val)) {
                topSortHelper(val, visited, list);
            }
        }

        for (T val : list) {
            System.out.println(val);
        }
    }

    public void topSortHelper(T source, Set<T> visited, LinkedList<T> list) {
        visited.add(source);

        for (Vertex vertex : vertexMap.get(source).neighbours.keySet()) {
            if (!visited.contains(vertex.value)) {
                topSortHelper(vertex.value, visited, list);
            }
        }
        list.addFirst(source);
    }

    public void topSortBfs() {
        HashMap<T, Integer> inDegree = new HashMap<>();
        Queue<T> queue = new LinkedList<>();

        for (T val : vertexMap.keySet()) {
            inDegree.put(val, 0);
        }

        for (T val : vertexMap.keySet()) {
            for (Vertex vertex : vertexMap.get(val).neighbours.keySet()) {
                inDegree.put(vertex.value, inDegree.get(vertex.value) + 1);
            }
        }

        for (T val : vertexMap.keySet()) {
            if (inDegree.get(val) == 0) {
                queue.add(val);
            }
        }

        while (!queue.isEmpty()) {
            T curr = queue.remove();
            System.out.println(curr);
            for (Vertex vertex : vertexMap.get(curr).neighbours.keySet()) {
                inDegree.put(vertex.value, inDegree.get(vertex.value) - 1);
                if (inDegree.get(vertex.value) == 0) {
                    queue.add(vertex.value);
                }
            }
        }

    }

    public boolean isTree() {
        Set<T> visited = new HashSet<>();
        Queue<T> queue = new LinkedList<>();
        Map<T, T> parent = new HashMap<>();

        visited.add(vertexMap.get(0).value);
        queue.add(vertexMap.get(0).value);

        for (T val : vertexMap.keySet()) {
            parent.put(val, val);
        }

        while (!queue.isEmpty()) {
            T val = queue.remove();
            for (Vertex vertex : vertexMap.get(val).neighbours.keySet()) {
                if (visited.contains(vertex.value) && parent.get(val) != vertex.value) {
                    return false;
                } else if (!visited.contains(vertex.value)) {
                    queue.add(vertex.value);
                    visited.add(vertex.value);
                    parent.put(vertex.value, val);
                }
            }
        }
        return true;
    }

    public boolean hasCycle() {
        Set<T> visited = new HashSet<>();
        for (T val : vertexMap.keySet()) {
            if (!visited.contains(val)) {
                boolean flag = hasCycleHelper(val, visited, val);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasCycleHelper(T val,Set<T> visited,T parent){
        visited.add(val);
        Vertex vertex = vertexMap.get(val);

        for (Vertex neighbour: vertex.neighbours.keySet()) {
            if(!visited.contains(neighbour.value)){
                boolean has_cycle = hasCycleHelper(neighbour.value,visited,val);
                if(has_cycle){
                    return true;
                }
            }
            else if(!parent.equals(val)){
                return true;
            }
        }
        return false;
    }


    public boolean hasCycleDirected(){
        Set<T> visited = new HashSet<>();
        Map<T,Boolean> path = new HashMap<>();

        for (T val:vertexMap.keySet()) {
            path.put(val,false);
        }

        for (T val:vertexMap.keySet()) {
            if(hasCycleDirectedHelper(val,visited,path)){
                return true;
            }
        }

        return false;
    }

    public boolean hasCycleDirectedHelper(T src,Set<T> visited,Map<T,Boolean> path){
        visited.add(src);
        path.put(src,true);

        for (Vertex vertex:vertexMap.get(src).neighbours.keySet()) {
            if(path.get(vertex.value)){
                return true;
            }
            else if(!visited.contains(vertex.value)){
                boolean foundCycle = hasCycleDirectedHelper(vertex.value,visited,path);
                if(foundCycle){
                    return true;
                }
            }
        }

        path.put(src,false);
        return false;
    }

    public boolean isBipartite(){
        Map<T,Integer> visited = new HashMap<>();
        for (T val:vertexMap.keySet()) {
            visited.put(val,0);
        }
        LinkedList<T> list = new LinkedList<>(vertexMap.keySet());
        T start = list.get(0);
        return isBipartiteHelper(start,start,visited,1);
    }

    public boolean isBipartiteHelper(T src,T parent,Map<T,Integer> visited,int color){
        visited.put(src,color);
        for (Vertex neighbour:vertexMap.get(src).neighbours.keySet()) {
            if(visited.get(neighbour.value)==0){
                boolean isIt = isBipartiteHelper(neighbour.value,src,visited,3-visited.get(src));
                if(!isIt){
                    return false;
                }
            }
            else if(neighbour.value!=parent&&color==visited.get(neighbour.value)){
                return false;
            }
        }
        return true;
    }
}

