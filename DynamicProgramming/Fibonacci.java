package DynamicProgramming;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacciN(6,new int[10]));
        System.out.println(fibonacciN(6));
    }

    public static int fibonacciN(int n,int[] mem){
//        Top Down Approach
        if(n==0||n==1){
            return n;
        }
        if(mem[n]!=0){
            return mem[n];
        }
        int ans = fibonacciN(n-1,mem) + fibonacciN(n-2,mem);
        mem[n] = ans;
        return ans;
    }

    public static int fibonacciN(int n){
//        Bottom up approach
        int[] mem = new int[100];
        mem[1] = 1;
        for (int i = 2; i < mem.length; i++) {
            mem[i] = mem[i-1] + mem[i-2];
        }
        return mem[n];
    }
}
