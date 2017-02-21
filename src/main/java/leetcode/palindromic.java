package leetcode;

/**
 * Created by yuanzhuo on 2017/1/20.
 * 最长回文子串
 * 令 dp[i][j]表示，子串ij是否是回文，
 */

public class palindromic {
    public static String longetestPalindromic(String s){
        if (s.length()<=1){
            return s;
        }
        int len = s.length();
        int dp[][] = new int[len][len];

        dp[0][0] = 1;
        for (int i = 1; i < len; i++){
            dp[i][i] = 1;
            dp[i][i-1] = 1; //用于子串长度为2时，判断第二个条件时使用，
        }
        int max_len= 1; //当字符串长度大于1时，回文子串的长度至少为1
        int start_index = 0;
        for (int sublen = 2; sublen <= len; sublen++){//子串长度，最优子结构，自底向上构建
            for (int i = 0; i < len-sublen+1; i++){//子串起始位置
                if (s.charAt(i) == s.charAt(i+sublen-1) && dp[i+1][i+sublen-2] == 1){//比较回文串的两端，依赖内部以求出的最优子结构。
                    dp[i][i+sublen-1] = 1;
                    max_len = sublen;
                    start_index = i;
                }
            }
        }
        return s.substring(start_index,start_index+max_len);
    }

    public static void main(String args[]){
        String s = "waabwswfd";
        System.out.print(longetestPalindromic(s));
    }


}
