/**
 * Created by yuanzhuo on 2017/1/17.
 */
public class dynamic_programming <T,K extends Comparable<?>> {
    private Class<T> type;

    /**
     * �����Ե����ϵĶ�̬�滮�������������������������
     * @param price     �ֲļ�Ŀ��
     * @param n          ��������
     */
    public static int buttom_up_rod(int[] price,int n){
        int r[] = new int[n+1];   //��¼����Ϊn�ĸ������������Ϊ r[n]
        r[0] = 0;                //����Ϊ0�ĸֲģ�����Ϊ0

        for (int j=0; j <= n ; j++){ //��С�������������������ֵ
            int p = Integer.MIN_VALUE;
            for (int i=0; i <= j; i++){  //��������ֽ�Ϊ��С��������
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
