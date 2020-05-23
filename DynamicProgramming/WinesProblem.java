package DynamicProgramming;

public class WinesProblem {
    public static void main(String[] args) {
        int[] price = {2,3,5,1,4};
        System.out.println(profit(price,0,price.length-1,new int[100][100],1));
    }

    public static int profit(int[] price,int start,int end,int[][] mem,int year){
        if(start>end){
            return 0;
        }
        if(mem[start][end]!=0){
            return mem[start][end];
        }

        int choice1 = price[start]*year + profit(price,start+1,end,mem,year+1);
        int choice2 = price[end]*year + profit(price,start,end-1,mem,year+1);

        return mem[start][end] = Integer.max(choice1,choice2);
    }
}
