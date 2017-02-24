package leetcode;

/**
 * Created by yuanzhuo on 2017/2/24.
 */
public class Atoi {
    public static int atoi(String src){
        if (src == null)
            return 0;

        if (src.length() > 10)
            return 0;

        long result = 0;
        int flag = 1;
        for (int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);
            if (i == 0){
                if (c == '-'){
                    flag = -1;
                    continue;
                }else if (c == '+'){
                    continue;
                }
            }
            if (c >= '0' && c <= '9'){
                    result = result * 10 + c - '0';
            }
        }

        if (result > Integer.MAX_VALUE){
            return 0;
        }
        return (int)result*flag;

    }


    public static void main(String[] args) {
        System.out.println(atoi("123"));
        System.out.println(atoi("-123"));
        System.out.println(atoi("+123"));
        System.out.println(atoi("+afadfad"));
        System.out.println(atoi(""));
        System.out.println(atoi("54654654654654654654645654654645646546"));
    }
}
