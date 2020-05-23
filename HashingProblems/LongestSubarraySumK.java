package HashingProblems;

import java.util.HashMap;
import java.util.Scanner;

public class LongestSubarraySumK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(longestSubarrayWithSumK(arr,k));
    }

    public static int longestSubarrayWithSumK(int[] arr,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int pre = 0;
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            pre += arr[i];
            if(pre==k){
                maxLength = Integer.max(maxLength,i+1);
            }
            if(map.containsKey(pre-k)){
                maxLength = Integer.max(maxLength,i-map.get(pre-k));
            }
            if(!map.containsKey(pre)){
                map.put(pre,i);
            }
        }
        return maxLength;
    }
}
