package DynamicProgramming;

public class MinCoinsChange {
    public static void main(String[] args) {
        int[] coins = {1,7,10};
        System.out.println(minCoins(15,coins,new int[100]));
        System.out.println(minCoins(15,coins));
    }

    public static int minCoins(int n,int[] coins,int[] mem){
//        Top down Approach
        if(n==0){
            return 0;
        }

        if(mem[n]!=0){
            return mem[n];
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if(n-coins[i]>=0){
                int sub = minCoins(n-coins[i],coins,mem);
                ans = Integer.min(sub+1,ans);
            }
        }
        mem[n] = ans;
        return mem[n];
    }

    public static int minCoins(int n,int[] coins){
//        Bottom up Approach
        int[] mem = new int[100];
        int ans = Integer.MAX_VALUE;
        for (int num = 1; num <= n; num++) {
            mem[num] = Integer.MAX_VALUE;
            for (int i = 0; i < coins.length; i++) {
                if(num-coins[i]>=0){
                    mem[num] = Integer.min(mem[num],mem[num-coins[i]]+1);
                }
            }
        }
        return mem[n];
    }
}
