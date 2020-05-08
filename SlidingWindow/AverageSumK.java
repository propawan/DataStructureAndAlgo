package SlidingWindow;

import java.util.Arrays;

public class AverageSumK {
    public static void main(String[] args) {
        int []arr = {1,3,2,6,-1,4,1,8,2};
        System.out.println(Arrays.toString(averageEveryK(arr,5)));
    }

    public static double[] averageEveryK(int []arr,int k){
        double []res = new double[arr.length-k+1];
        double windowSum = 0;
        int windowStart = 0;
        for (int i = 0; i < arr.length; i++) {
            windowSum += arr[i];

            if(i>=k-1){
                res[windowStart] = windowSum/k;
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return res;
    }
}
