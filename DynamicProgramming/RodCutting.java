package DynamicProgramming;

public class RodCutting {
    public static void main(String[] args) {
        int[] profit = {2,3,2,5};
        System.out.println(maxProfit(4,profit,new int[100]));
        System.out.println(maxProfit(4,profit));
    }

    public static int maxProfit(int n,int[] profit,int[] mem){
        if(n==0){
            return 0;
        }

        if(mem[n]!=0){
            return mem[n];
        }

        int max = Integer.MIN_VALUE;
        int currProfit;
        for (int i = 1; i <= n; i++) {
            int sub = maxProfit(n-i,profit,mem);
            currProfit = sub + profit[i-1];
            max = Math.max(currProfit,max);
        }

        mem[n] = max;

        return max;
    }

    public static int maxProfit(int n,int[] profit){
        int[] mem = new int[n+1];
        mem[0] = 0;
        mem[1] = profit[0];

        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= i; j++) {
                int currProfit = profit[j-1] + mem[i-j];
                max = Math.max(currProfit,max);
            }
            mem[i] = max;
        }

        return mem[n];
    }
}
