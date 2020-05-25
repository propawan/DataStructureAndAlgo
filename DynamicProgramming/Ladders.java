package DynamicProgramming;

public class Ladders {
    public static void main(String[] args) {
        int[] mem = new int[100];
        System.out.println(waysToReach(5,3,mem));
        System.out.println(waysToReach(5,3));
        System.out.println(waysToReachOptimized(5,3));
    }

    public static int waysToReach(int n,int k,int[] mem){
//        Top down Approach
        if(n==0){
            return 1;
        }

        if(mem[n]!=0){
            return mem[n];
        }

        int ways = 0;
        for (int i = 1; i <= k; i++) {
            if(n-i>=0){
                int sub = n-i;
                mem[sub] = waysToReach(sub,k,mem);
                ways += mem[sub];
            }
        }

        mem[n] = ways;

        return mem[n];
    }

    public static int waysToReach(int n,int k){
//        Bottom Up Approach
        int[] mem = new int[n+1];
        mem[0] = 1;

        for (int num = 1; num <= n; num++) {
            for (int i = 1; i <= k; i++) {
                if(num-i>=0){
                    mem[num] += mem[num-i];
                }
            }
        }

        return mem[n];
    }

    public static int waysToReachOptimized(int n,int k){
//        Optimized version
        int[] mem = new int[n+1];
        mem[0] = 1;
        mem[1] = 1;

        for (int i = 2; i <= k; i++) {
            mem[i] = 2*mem[i-1];
        }

        for (int i = k+1; i <= n; i++) {
            mem[i] = 2*mem[i-1] - mem[i-k-1];
        }

        return mem[n];
    }
}
