package StringMatching;

import java.util.Arrays;

public class NaiveAlgorithm {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(stringMatch("aabaacaadaabaaabaa","aaba")));
    }

    public static int[] stringMatch(String first,String second){
        int[] occ = new int[first.length()];

        int i = 0;
        int j = 0;
        int p = 0;
        while (i<first.length()){
            int currI = i;
            while (j<second.length()&&i<first.length()){
                if(first.charAt(i)!=second.charAt(j)){
                    break;
                }
                i++;
                j++;
            }
            if(j==second.length()){
                occ[p] = currI;
                p++;
            }
            j = 0;
            i = currI+1;
        }
        return occ;
    }
}
