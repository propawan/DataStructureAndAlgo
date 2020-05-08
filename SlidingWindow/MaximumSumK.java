package SlidingWindow;

public class MaximumSumK {
    public static void main(String[] args) {
        int []arr = {2, 3, 4, 1, 5};
        System.out.println(maxSumK(arr,2));
    }

    public static int maxSumK(int []arr,int k){
        int max = Integer.MIN_VALUE;
        int windowStart = 0;
        int windowSum = 0;
        for (int i = 0; i < arr.length; i++) {
            windowSum += arr[i];
            if(i>=k-1){
                if(windowSum>max){
                    max = windowSum;
                }
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return max;
    }
}
