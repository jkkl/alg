package alg.chapter16;

/**
 * Created by yuanzhuo on 2017/2/21.
 * ��̬�滮01��������
 * �Ƚ�  ѡ�� i ���γɵ�����������Ž� �� ��ѡ�� i ������������Ž�
 */
public class package01 {

    public static void packageSelect(int[] price, int[] weight, int capacity){
        int n = price.length;
        int[][] max_pric = new int[n+1][capacity+1];   //��¼��i����Ʒ������Ϊjʱ������ֵ
        int[][] path = new int[n+1][capacity+1];    //��¼ȡ����ֵ��·�������ڻ����ҳ����Ž�
        for (int i = 0; i<n+1 ; i++){//��������Ϊ0ʱ
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
