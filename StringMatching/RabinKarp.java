package StringMatching;

public class RabinKarp {
    public static void main(String[] args) {
        String line = "ababcabdab";
        String pattern = "abd";
        stringMatch(line,pattern);
    }

    public static void stringMatch(String line,String pattern){
        int patHash = hashFunction(pattern,pattern.length());
        int lineHash = hashFunction(line,pattern.length());
        for (int i = 0; i <= line.length()-pattern.length(); i++) {
            if(patHash==lineHash){
                String curr = line.substring(i,i+pattern.length());
                if(areEqual(curr,pattern)){
                    System.out.println("Index: "+i);
                }
            }
            if(i<line.length()-pattern.length()){
                lineHash = calReHashValue(line,lineHash,pattern,i,i+pattern.length());
            }
        }
    }

    public static int hashFunction(String word,int n){
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += word.charAt(i)*Math.pow(3,i);
        }
        return ans;
    }

    public static int calReHashValue(String word,int oldHash,String pattern,int oldIndex,int newIndex){
        int newHash = oldHash-word.charAt(oldIndex);
        newHash /= 3;
        newHash += word.charAt(newIndex)*Math.pow(3,pattern.length()-1);
        return newHash;
    }

    public static boolean areEqual(String first,String second){
        if(first.length()!=second.length()){
            return false;
        }
        int count = 0;
        for (int i = 0; i < first.length(); i++) {
            if(first.charAt(i)!=second.charAt(i)){
                break;
            }
            count += 1;
        }
        return count == first.length();
    }
}
