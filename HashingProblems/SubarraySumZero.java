package HashingProblems;

import java.util.HashSet;
import java.util.Set;

public class SubarraySumZero {
    public static void main(String[] args) {
        int[] arr = {1,2,3,-1,1};
        System.out.println(containsSubArrayZero(arr));
    }

    public static boolean containsSubArrayZero(int[] arr){
        int pre = 0;
        Set<Integer> set = new HashSet<>();
        for (int val:arr) {
            pre += val;
            if(pre==0||set.contains(pre)){
                return true;
            }
            set.add(pre);
        }
        return false;
    }
}
