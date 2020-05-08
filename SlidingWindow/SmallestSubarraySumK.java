package SlidingWindow;

public class SmallestSubarraySumK {
    public static void main(String[] args) {
        int []arr = {2, 1, 5, 2, 8};
        int res = smallestWithSumK(arr,7);
        System.out.println(res);
    }

    public static int smallestWithSumK(int []arr,int S){
        int windowStart = 0;
        int windowSum = 0;
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            windowSum += arr[i];
            while (windowSum>=S){
                minLength = Math.min(minLength,i-windowStart+1);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0:minLength;
    }
}
