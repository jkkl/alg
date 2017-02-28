package introduction_to_algorithms.chapter15;

/**
 * Created by yuanzhuo on 2017/2/28.
 * 动态规划 钢条切割问题
 * 给定长度为 n 的钢条，和钢条长度价目表 p1,p2...pn
 */
public class CutRod {

    public static void cutRod(int n, int[] price){
        int max_pric = 0;
        int[] r = new int[n+1];     //长度为n的钢条的，最大收益值
        int[] path = new int[n+1];  //最优切割方案，记录长度为n的钢条切下的i值，ri = max{pi + r[i-1]} 1<= i <= n

        for (int i = 0; i <= n; i++) {
            r[i] = 0;
        }

        for (int len = 1; len <= n ; len++) {   //自底向上，求长度为len的钢条的最大收益
            int r_len_max = 0;
            int i_max = 0;
            for (int i = 0; i <= len; i++) {    //遍历求解子结构的最大值
                if (r_len_max < price[i] + r[len-i]){
                    r_len_max = price[i] + r[len-i];
                    i_max = i;
                }
            }
            r[len] = r_len_max;
            path[len] = i_max;
        }

        System.out.println("最大收益：");
        for (int i = 0; i <= n; i++) {
            System.out.println(r[i]);
        }

        System.out.println("最优方案：");
        int i = n;
        while (i > 0){
            System.out.println(path[i]);
            i = i - path[i];
        }

    }

    public static void main(String[] args) {
        int n = 2;
        int[] p = {0,1,5,8,9,10,17,17,20,24,30};

        cutRod(n,p);
    }


}
