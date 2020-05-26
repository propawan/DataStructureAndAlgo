package DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {10,22,9,33,21,50,41,60,80,6};
        System.out.println(lis(arr));
    }

    public static int lis(int[] arr){
        int[] mem = new int[arr.length];

        Arrays.fill(mem, 1);
        int maximum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[j]<=arr[i]){
                    int currLongest = 1 + mem[j];
                    mem[i] = Math.max(mem[i],currLongest);
                }
            }
            maximum = Math.max(maximum,mem[i]);
        }

        return maximum;
    }
}
