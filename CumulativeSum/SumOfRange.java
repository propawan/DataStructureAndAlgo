package CumulativeSum;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int sum = sumOfRange(arr,2,6);
        System.out.println(sum);
    }

    public static int sumOfRange(int []arr,int i,int j){
        for (int k = 1; k < arr.length; k++) {
            arr[k] = arr[k-1] + arr[k];
        }
        System.out.println(Arrays.toString(arr));
        return arr[j] - arr[i-1];
    }
}
