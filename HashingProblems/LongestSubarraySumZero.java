package HashingProblems;

import java.util.HashMap;
import java.util.Scanner;

public class LongestSubarraySumZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(longestSubarrayWithSumZero(arr));
    }

    public static int longestSubarrayWithSumZero(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        int pre = 0;
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            pre += arr[i];
            if(arr[i]==0&&maxLength==0){
                maxLength = 1;
            }
            if(pre==0){
                maxLength = Integer.max(maxLength,i+1);
            }
            if(map.containsKey(pre)){
                maxLength = Integer.max(i-map.get(pre),maxLength);
            }
            if(!map.containsKey(pre)){
                map.put(pre,i);
            }
        }
        return maxLength;
    }
}
