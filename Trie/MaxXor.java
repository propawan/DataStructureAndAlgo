package Trie;

import java.util.Scanner;

public class MaxXor {

    private static Node root = new Node();
    private static int maxXor = Integer.MIN_VALUE;

    public static class Node{
        Node left;
        Node right;
    }

    public static void insert(int n){
        Node curr = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (n>>i)&1;
            if(bit==0){
                if(curr.left==null){
                    curr.left = new Node();
                }
                curr = curr.left;
            }
            else{
                if(curr.right==null){
                    curr.right = new Node();
                }
                curr = curr.right;
            }
        }
    }

    public static int findMaxXor(int elem){
        Node curr = root;
        int currXor = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (elem >>i)&1;
            if(bit==0){
                if(curr.right!=null){
                    curr = curr.right;
                    currXor += (int)Math.pow(2,i);
                }
                else{
                    curr = curr.left;
                }
            }
            else{
                if(curr.left!=null){
                    curr = curr.left;
                    currXor += (int)Math.pow(2,i);
                }
                else{
                    curr = curr.right;
                }
            }
        }
        if(currXor>maxXor){
            maxXor = currXor;
        }
        return maxXor;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = Integer.MIN_VALUE;
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
            int curr = findMaxXor(arr[i]);
            result = Math.max(curr, result);
        }
        System.out.println(result);
    }
}
