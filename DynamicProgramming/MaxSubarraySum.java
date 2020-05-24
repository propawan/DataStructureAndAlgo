package DynamicProgramming;

public class MaxSubarraySum {
    public static void main(String[] args) {
//        int[] arr = {-3,2,5,-1,6,3,-2,7,-5,2};
        int[] arr = {-3,-2,-5,-1,-4};
        System.out.println(maxSubArraySumOptimized(arr));
        System.out.println(maxSubArraySum(arr));
    }

    public static int maxSubArraySum(int[] arr){
        int[] mem = new int[100];
        mem[0] = Math.max(arr[0], 0);
        int maxSum = Integer.MIN_VALUE;

        for (int i = 1; i < arr.length; i++) {
            mem[i] = mem[i-1] + arr[i];
            maxSum = Math.max(maxSum,mem[i]);
            if(mem[i]<0){
                mem[i] = 0;
            }
        }

        return maxSum;
    }

    public static int maxSubArraySumOptimized(int[] arr){
//        Kadane's Algorithm
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            ans = Math.max(sum,ans);
            sum = Math.max(sum,0);
        }
        return ans;
    }
}
