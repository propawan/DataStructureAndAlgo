package DynamicProgramming;

public class EditDistance {
    public static void main(String[] args) {
        String first = "abcdef";
        String second = "azced";
        int[][] mem = new int[first.length()][second.length()];
        System.out.println(editDist(first,second,first.length()-1,second.length()-1,mem));
        System.out.println(editDist(first,second));
    }

    public static int editDist(String first,String second,int i,int j,int[][] mem){
//        Top Down Approach
        if(i==-1){
            return j+1;
        }
        if(j==-1){
            return i+1;
        }
        if(mem[i][j]!=0){
            return mem[i][j];
        }
        if(first.charAt(i)==second.charAt(j)){
            mem[i][j] = editDist(first,second,i-1,j-1,mem);
        }
        else{
            int cond1 = 1+editDist(first,second,i-1,j-1,mem);
            int cond2 = 1+editDist(first,second,i-1,j,mem);
            int cond3 = 1+editDist(first,second,i,j-1,mem);
            mem[i][j] = Math.min(cond1,Math.min(cond2,cond3));
        }
        return mem[i][j];
    }

    public static int editDist(String first,String second){
//        Bottom Up Approach
        int[][] mem = new int[first.length()+1][second.length()+1];

        for (int i = 0; i < mem[0].length; i++) {
            mem[0][i] = i;
        }

        for (int i = 0; i < mem.length; i++) {
            mem[i][0] = i;
        }

        for (int i = 1; i < mem.length; i++) {
            for (int j = 1; j < mem[i].length; j++) {
                if(first.charAt(i-1)==second.charAt(j-1)){
                    mem[i][j] = mem[i-1][j-1];
                }
                else{
                    mem[i][j] = 1+Math.min(mem[i-1][j-1],Math.min(mem[i-1][j],mem[i][j-1]));
                }
            }
        }

        return mem[first.length()][second.length()];
    }
}
