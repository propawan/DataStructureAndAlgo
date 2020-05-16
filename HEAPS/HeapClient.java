package HEAPS;

public class HeapClient {
    public static void main(String[] args) throws Exception{
        Heap<Integer> heap = new Heap<>();
        heap.add(5);
        heap.add(10);
        heap.add(7);
        heap.add(9);
        heap.add(12);
        heap.add(1);
        heap.add(3);
        heap.display();
        heap.remove();
        heap.display();
        System.out.println(heap.heapSort());
    }
}
