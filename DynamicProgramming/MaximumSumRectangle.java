package DynamicProgramming;

import java.util.Arrays;

public class MaximumSumRectangle {
    public static void main(String[] args) {
        int[][] matrix = {{6,-5,-7,4,-4},
                {-9,3,-6,5,2},
                {-10,4,7,-6,3},
                {-8,9,-3,3,-7}};

        System.out.println(computeMaxSumRect(matrix));
    }

    public static int computeMaxSumRect(int[][] matrix){
        int[] currRowSum = new int[matrix.length];
        int maxSum = Integer.MIN_VALUE;
        for (int left = 0; left < matrix[0].length; left++) {
           int right = left;
//           Resetting all the value to zero because this is a new left
           Arrays.fill(currRowSum, 0);
//           Trying every possible right for the current left
           while (right<matrix[0].length){
//               Computing sum of every row from curr left to right
               for (int j = 0; j < matrix.length; j++) {
                   currRowSum[j] += matrix[j][right];
               }
//               Kadane's Algorithm for max sum
               int sum = 0;
               for (int j = 0; j < currRowSum.length; j++) {
                   sum += currRowSum[j];
                   maxSum = Math.max(maxSum,sum);
                   sum = Math.max(sum,0);
               }
               right++;
           }
            System.out.println(maxSum);
        }
        return maxSum;
    }
}
