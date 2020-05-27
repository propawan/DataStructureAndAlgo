package DynamicProgramming;

import java.util.Scanner;

public class CellMitosis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        System.out.println(minCost(n,x,y,z));
    }

    public static int minCost(int n,int x,int y,int z){
        int[] mem = new int[n+1];
        mem[0] = 0;
        mem[1] = 0;

        for (int i = 2; i < mem.length; i++) {
            if(i%2==0){
                mem[i] = Math.min(mem[i-1]+y,mem[i/2]+x);
            }
            else{
                mem[i] = Math.min(mem[(i+1)/2]+x+z,mem[i-1]+y);
            }
        }
        return mem[n];
    }
}
