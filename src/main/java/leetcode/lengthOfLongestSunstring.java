package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuanzhuo on 2017/1/9.
 */
public class lengthOfLongestSunstring {

    /**
     * 54 ms for循环内部执行的少
     * 用哈希表来检查下一个字符是否在一边遍历的子串中，
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        if (s.length() < 2){
            return s.length();
        }
        int length = 0, sub_start = 0,sub_length = 1;
        Map<Character,Integer> char_hash = new HashMap<Character, Integer>();
        char_hash.put(s.charAt(0),0);
        for (int i = 1; i < s.length(); i++){
            if (char_hash.containsKey(s.charAt(i)) && char_hash.get(s.charAt(i)) >= sub_start){//不仅包含，且在正在检测的子串内
                sub_length = i - sub_start;
                if (sub_length > length){
                    length = sub_length;
                }
                sub_start = char_hash.get(s.charAt(i))+1;
            }
            char_hash.put(s.charAt(i),i);
        }
        if (s.length() - sub_start > length)
            length = s.length() - sub_start;
        return length;
    }

    /**
     * 62 ms
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() < 2){
            return s.length();
        }
        int length = 0, sub_start = 0,next = 1;
        Map<Character,Integer> char_hash = new HashMap<Character, Integer>();
        for (int i = 0; i + 1 < s.length(); i++){
            next = i + 1;
            char_hash.put(s.charAt(i),i);
            if (char_hash.containsKey(s.charAt(next)) && char_hash.get(s.charAt(next)) >= sub_start){
                sub_start = char_hash.get(s.charAt(next))+1;
            }
            if (next - sub_start + 1 > length){
                length = next - sub_start + 1;
            }
        }
       return length;
    }

    public static void main(String args[]){
        String s = "aabcdeb";
        System.out.println(lengthOfLongestSubstring(s));
    }


}
