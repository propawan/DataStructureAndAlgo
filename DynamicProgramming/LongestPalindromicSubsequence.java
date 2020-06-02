package DynamicProgramming;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String word = "BBABCBCAB";
        int[][] mem = new int[word.length()][word.length()];
        System.out.println(lengthLps(word,0,word.length()-1,mem));
        System.out.println(lengthLps(word));
    }

    public static int lengthLps(String word,int start,int end,int[][] mem){
//        Top Down Approach
        if(start==end){
            return 1;
        }
        if(start>end){
            return 0;
        }
        if(mem[start][end]!=0){
            return mem[start][end];
        }
        if(word.charAt(start)==word.charAt(end)){
            mem[start][end] = 2+lengthLps(word,start+1,end-1,mem);
            return mem[start][end];
        }
        return Math.max(lengthLps(word,start+1,end,mem),lengthLps(word,start,end-1,mem));
    }

    public static int lengthLps(String word){
//        Bottom up Approach
        int[][] mem = new int[word.length()][word.length()];
        for (int i = 0; i < word.length(); i++) {
            mem[i][i] = 1;
        }

        for (int i = 1; i < word.length(); i++) {
            int row = 0;
            int col = i;
            while (col<=word.length()-1){
                if(word.charAt(row)==word.charAt(col)){
                    mem[row][col] = 2 + mem[row+1][col-1];
                }
                else{
                    mem[row][col] = Math.max(mem[row+1][col],mem[row][col-1]);
                }
                row++;
                col++;
            }
        }

        return mem[0][word.length()-1];
    }
}
