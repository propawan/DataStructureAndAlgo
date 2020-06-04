package DynamicProgramming;

public class TotalBSTWithNNodes {
    public static void main(String[] args) {
        int n = 4;
        int[] mem = new int[n+1];
        System.out.println(totalBST(4));
        System.out.println(totalBSTRec(4,mem));
    }

    public static int totalBST(int N){
//        Bottom Up Approach
        int[] mem = new int[N+1];
        for (int i = 0; i <= N; i++) {
            if(i<=1){
                mem[i] = 1;
            }
            else{
                for (int j = 0; j < i; j++) {
                    mem[i] += mem[j]*mem[i-j-1];
                }
            }
        }
        return mem[N];
    }

    public static int totalBSTRec(int n,int[] mem){
//        Top Down Approach
        if(n<=1){
            return 1;
        }

        if(mem[n]!=0){
            return mem[n];
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += totalBSTRec(i-1,mem)*totalBSTRec(n-i,mem);
        }
        mem[n] = ans;
        return ans;
    }
}
