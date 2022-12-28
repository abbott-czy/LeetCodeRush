public class IsSubsequence392v1 {

    public static boolean isSubsequence(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        int[][] dp  = new int[len1 +1][len2 +1];
        for (int i = 1; i <= len1 ; i++) {
            for (int j = 1; j <= len2 ; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        if (dp[len1][len2] == len1){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        boolean subsequence = isSubsequence(s, t);
        System.out.println(subsequence);
    }
}
