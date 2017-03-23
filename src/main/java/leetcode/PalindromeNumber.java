package leetcode;

/**
 * Created by yuanzhuo on 2017/3/22.
 * 判断数字是否是回文
 *
 *
 */
public class PalindromeNumber {
    public static boolean isPalindromeNumber(int a){
        if (a < 0)
            return false;
        if (a < 10)
            return true;
        int base = 10;
        //找出 a 的位数，用于同时比较a的前位和对称的后位
        while (a/base >= 10){ //等号，很重要
            base *= 10;
        }
        int i = 10;
        System.out.println(base);
        while (i <= base){
            if ((a / base)%10 != (a % i)*10/i)
                return false;
            base /= 10;
            i *= 10;
        }
        return true;

    }

    public static void main(String[] args) {
        int a = 100;
        System.out.println(isPalindromeNumber(a));


    }
}
