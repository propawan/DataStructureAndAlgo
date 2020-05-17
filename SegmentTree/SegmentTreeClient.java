package SegmentTree;

public class SegmentTreeClient {
    public static void main(String[] args) {
        int []arr = {3,8,7,6,-2,-8,4,9};
        SegmentTree segmentTree = new SegmentTree(arr);
        segmentTree.display();
        System.out.println("$$$$$$$$$$$");
        System.out.println("Sum of query is " + segmentTree.query(2,6));
        System.out.println("Sum of query is " + segmentTree.query(1,5));
        segmentTree.update(3,14);
        System.out.println("$$$$$$$$$$$");
        segmentTree.display();
        System.out.println();
        System.out.println("Sum of query is " + segmentTree.query(2,6));
    }
}
