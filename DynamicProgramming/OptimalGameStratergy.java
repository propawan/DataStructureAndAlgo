package DynamicProgramming;

import java.util.Scanner;

public class OptimalGameStratergy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int[][] mem = new int[arr.length][arr.length];
        System.out.println(maxProfit(arr,0,arr.length-1,mem));
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] arr,int start,int end,int[][] mem){
        if(start>end){
            return 0;
        }
        if(mem[start][end]!=0){
            return mem[start][end];
        }
        int first = arr[start] + Math.min(maxProfit(arr,start+2,end,mem),maxProfit(arr,start+1,end-1,mem));
        int second = arr[end] + Math.min(maxProfit(arr,start,end-2,mem),maxProfit(arr,start+1,end-1,mem));
        mem[start][end] = Math.max(first,second);
        return mem[start][end];
    }

    public static int maxProfit(int[] arr){
        int[][] mem = new int[arr.length][arr.length];
        for (int i = 1; i < arr.length; i++) {
            int row = 0;
            int col = i;
            while (col<=arr.length-1){
                if(col==row+1){
                    mem[row][col] = Math.max(arr[row],arr[col]);
                }
                else{
                    int first = arr[row]+Math.min(mem[row+2][col],mem[row+1][col-1]);
                    int second = arr[col] + Math.min(mem[row][col-2],mem[row+1][col-1]);
                    mem[row][col] = Math.max(first,second);
                }
                row++;
                col++;
            }
        }
        return mem[0][arr.length-1];
    }
}
