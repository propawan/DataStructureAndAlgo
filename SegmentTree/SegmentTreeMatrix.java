package SegmentTree;

import java.util.Arrays;

public class SegmentTreeMatrix {
    Node root;

    private class Node{
        int [][]matrix = new int[2][2];
        int startInterval;
        int endInterval;
        Node left;
        Node right;
    }

    public SegmentTreeMatrix(int []arr,int n){
        this.root = constructTree(arr,0,n-1);
    }

    public Node constructTree(int []arr,int start,int end){
        if(start==end){
            Node leafNode = new Node();
            int s = start*4;
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    leafNode.matrix[j][k] = arr[s++];
                }
            }
            leafNode.startInterval = start;
            leafNode.endInterval = end;
            return leafNode;
        }

        Node node = new Node();
        node.startInterval = start;
        node.endInterval = end;

        int mid = (start+end)/2;
        Node left = constructTree(arr,start,mid);
        Node right = constructTree(arr,mid+1,end);
        node.left = left;
        node.right = right;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    node.matrix[i][j] += node.left.matrix[i][k] * node.right.matrix[k][j];
                }
            }
        }
        return node;
    }

    public void query(int start,int end,int r){
        int [][]matrix;
        matrix = query(start,end,root);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]%r+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private int[][] query(int start, int end, Node node) {
        if(node.startInterval>=start&&node.endInterval<=end){
            return node.matrix;
        }

        else if(node.startInterval>end||node.endInterval<start){
            return new int[][]{{1,0},{0,1}};
        }

        else{
            int [][]left = this.query(start,end,node.left);
            int [][]right = this.query(start,end,node.right);
            int [][]res = new int[2][2];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    for (int k = 0; k < 2; k++) {
                        res[i][j] += left[i][k] * right[k][j];
                    }
                }
            }
            return res;
        }
    }
}
