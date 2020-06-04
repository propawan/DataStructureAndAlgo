package DynamicProgramming;

public class FriendsPairing {
    public static void main(String[] args) {
        int n = 4;
        int[] mem = new int[n+1];
        System.out.println(computeWays(n,mem));
        System.out.println(computeWays(n));
    }

    public static int computeWays(int n, int[] mem){
//        Top Down Approach
        if(n<=2){
            return n;
        }
        if(mem[n]!=0){
            return mem[n];
        }
        mem[n] = computeWays(n-1,mem)+ ((n-1)* computeWays(n-2,mem));
        return mem[n];
    }

    public static int computeWays(int n){
//        Bottom Up Approach
        int[] mem = new int[n+1];

        for (int i = 0; i <= n; i++) {
            if(i<=2){
                mem[i] = i;
            }
            else{
                mem[i] = mem[i-1] + ((i-1)*mem[i-2]);
            }
        }

        return mem[n];
    }
}
