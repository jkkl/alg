/**
 * Created by yuanzhuo on 2017/1/17.
 */
public class dynamic_programming <T,K extends Comparable<?>> {
    private Class<T> type;

    /**
     * 利用自底向上的动态规划方法来求解钢条的最大收益问题
     * @param price     钢材价目表
     * @param n          钢条长度
     */
    public static int buttom_up_rod(int[] price,int n){
        int r[] = new int[n+1];   //记录长度为n的钢条的最大收益为 r[n]
        r[0] = 0;                //长度为0的钢材，收益为0

        for (int j=0; j <= n ; j++){ //由小到大的求解子问题的最优值
            int p = Integer.MIN_VALUE;
            for (int i=0; i <= j; i++){  //将子问题分解为更小的子问题
                p = Math.max(p,price[i]+r[j-i]);
            }
            r[j] = p;
        }
        return r[n];
    }


    public static void main(String args[]){
        int[] p = {0,1,5,8,9,10,17,17,20,24,30};
        for (int i = 0; i<11;i++){
            int r = buttom_up_rod(p,i);
            System.out.println(i+" "+r);
        }
    }

}
