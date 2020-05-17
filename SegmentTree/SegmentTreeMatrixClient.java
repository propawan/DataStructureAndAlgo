package SegmentTree;

import java.util.Scanner;

public class SegmentTreeMatrixClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int n = sc.nextInt();
        int q = sc.nextInt();
        int []arr = new int[4*n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        SegmentTreeMatrix treeMatrix = new SegmentTreeMatrix(arr,n);

        for (int i = 0; i < q; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            treeMatrix.query(start-1,end-1,r);
        }
    }
}
