package DynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String first = "\0aabcekkyes";  // aabcekkyes aggtab
        String second = "\0azbcfezzyes";  //  azbcfezzyes gxtxayb
        int[][] mem = new int[first.length()][second.length()];
        System.out.println(lcs(first,second,first.length()-1,second.length()-1,mem));
        System.out.println(lcs("aabcekkyes","azbcfezzyes"));
    }

    public static int lcs(String first,String second,int f,int s,int[][] mem){
//        Top Down Approach
        if(first.charAt(f)=='\0'||second.charAt(s)=='\0'){
            return 0;
        }

        if(mem[f][s]!=0){
            return mem[f][s];
        }

        if(first.charAt(f)==second.charAt(s)){
            int ans = 1 + lcs(first,second,f-1,s-1,mem);
            mem[f][s] = ans;
            return ans;
        }

        else{
            int ans = Math.max(lcs(first,second,f-1,s,mem),lcs(first,second,f,s-1,mem));
            mem[f][s] = ans;
            return ans;
        }
    }

    public static int lcs(String first,String second){
        int[][] mem = new int[first.length()+1][second.length()+1];
        for (int i = 0; i < mem.length; i++) {
            for (int j = 0; j < mem[i].length; j++) {
                if(i==0||j==0){
                    mem[i][j] = 0;
                }
                else{
                    if(first.charAt(i-1)==second.charAt(j-1)){
                        mem[i][j] = 1 + mem[i-1][j-1];
                    }
                    else{
                        mem[i][j] = Math.max(mem[i-1][j],mem[i][j-1]);
                    }
                }
            }
        }
        return mem[first.length()][second.length()];
    }
}
