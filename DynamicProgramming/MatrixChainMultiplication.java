package DynamicProgramming;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int []arr = {4,2,3,1,3};
        System.out.println(mcm(arr));
    }

    public static int mcm(int[] arr){
        int[][] mem = new int[200][200];

        int numMatrix = arr.length-1;
        for (int i = 1; i < numMatrix; i++) {
            int row = 0,col=i;
            while (col<numMatrix){
                int val = Integer.MAX_VALUE;
                for (int pivot = row; pivot < col; pivot++) {
                    val = Math.min(val,(mem[row][pivot])+(mem[pivot+1][col])+(arr[row]*arr[pivot+1]*arr[col+1]));
                }

                mem[row][col] = val;
                row++;
                col++;
            }
        }
        return mem[0][numMatrix-1];
    }
}
