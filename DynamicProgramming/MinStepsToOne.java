package DynamicProgramming;

import java.util.Arrays;

public class MinStepsToOne {
    public static void main(String[] args) {
        System.out.println(minStep(9,new int[100]));
        System.out.println(minStep(10));
    }

    public static int minStep(int n,int[] mem){
//        Top Down Approach
        if(n==1){
            return 0;
        }
        if(mem[n]!=0){
            return mem[n];
        }
        int one = Integer.MAX_VALUE;
        int two = Integer.MAX_VALUE;
        if(n%3==0){
            one = minStep(n/3,mem)+1;
        }
        if(n%2==0){
            two = minStep(n/2,mem)+1;
        }
        int three = minStep(n-1,mem)+1;
        int min = Integer.min(one,Integer.min(two,three));
        mem[n] = min;
        return min;
    }

    public static int minStep(int n){
//        Bottom Up Approach
        int[] mem = new int[100];
        mem[1] = 0;
        for (int i = 2; i <= n; i++) {
            int one = Integer.MAX_VALUE;
            int two= Integer.MAX_VALUE;
            if(i%3==0){
                one = mem[i/3];
            }
            if(i%2==0){
                two = mem[i/2];
            }
            int three = mem[i-1];
            mem[i] = Integer.min(one,Integer.min(two,three))+1;
        }
        return mem[n];
    }
}
