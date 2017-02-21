package alg.chapter16;

/**
 * Created by yuanzhuo on 2017/2/21.
 * 动态规划01背包问题
 * 比较  选择 i 的形成的子问题的最优解 与 不选择 i 的子问题的最优解
 */
public class package01 {

    public static void packageSelect(int[] price, int[] weight, int capacity){
        int n = price.length;
        int[][] max_pric = new int[n+1][capacity+1];   //记录第i个物品，容量为j时的最大价值
        int[][] path = new int[n+1][capacity+1];    //记录取最优值的路径，用于回溯找出最优解
        for (int i = 0; i<n+1 ; i++){//背包承重为0时
            max_pric[i][0] = 0;
        }
        for (int j = 0; j<capacity+1; j++ ){
            max_pric[0][j] = 0;
        }
        for (int i=1; i<n+1; i++){
            for (int j = 1; j < capacity+1; j++ ){
                if (weight[i-1] > j || max_pric[i-1][j] > max_pric[i-1][j-weight[i-1]]+price[i-1]){
                    max_pric[i][j] = max_pric[i-1][j];
                    path[i][j] = 1;
                }else {
                    max_pric[i][j] = max_pric[i-1][j-weight[i-1]]+price[i-1];
                    path[i][j] = 2;
                }
            }
        }
        System.out.println(max_pric[n][capacity]);
        for (int i = n, j=capacity; i>0 && j>0; ){
                if (path[i][j] == 2){
                    System.out.println(i);
                    i = i -1;
                    j = j -weight[i-1];
                }else{
                    i = i -1;
                }
        }
    }

    public static void main(String[] args) {
        int[] weight = {2,2,6,5,4};
        int[] price = {6,3,5,4,6};

        packageSelect(price,weight,10);

    }

}
