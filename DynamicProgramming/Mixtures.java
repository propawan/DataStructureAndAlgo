package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class Mixtures {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] mem = new int[2000][2000];
        for (int i = 0; i < mem.length; i++) {
            Arrays.fill(mem[i], -1);
        }
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(minSmoke(mem,0,n-1,arr));
    }

    public static int minSmoke(int[][] mem,int i,int j,int[] arr){
        if(i>=j){
            return 0;
        }

        if(mem[i][j]!=-1){
            return mem[i][j];
        }

        mem[i][j] = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            mem[i][j] = Math.min(mem[i][j],minSmoke(mem,i,k,arr)+minSmoke(mem,k+1,j,arr)+sum(i,k,arr)*sum(k+1,j,arr));
        }

        return mem[i][j];
    }

    private static int sum(int s, int e, int[] arr) {
        int sum = 0;
        for (int i = s; i <= e; i++) {
            sum += arr[i];
            sum = sum%100;
        }
        return sum;
    }
}
