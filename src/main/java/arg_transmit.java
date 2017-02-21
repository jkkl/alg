/**
 * Created by yuanzhuo on 2017/2/20.
 */
public class arg_transmit {



    public static void swapInt(Integer a, Integer b){
        a = 11;
        b = 22;
        System.out.println("as" + a);
        System.out.println("bs"+b);
    }

    public static void main(String args[]){
        Integer a = 4;
        Integer b = 5;

        swapInt(a,b);
        System.out.println("a" + a);
        System.out.println("b"+b);
    }
}

class People
{
    public Integer age;
    public static void Swap(People a1, People a2)
    {
        People tem;
        tem = a1;
        a1 = a2;
        a2 = tem;
    }
    public static void Change(People a1, People a2)
    {
        a1.age = 250;
        a2.age = 250;
    }
}
class Empty
{
    public static void main(String[]args)
    {
        People a1 = new People();
        People a2 = new People();
        a1.age = 1;
        a2.age = 2;

        //这里没能交换，看起来是按值传递
        People.Swap(a1, a2);
        System.out.printf("%d \t %d", a1.age, a2.age);
        System.out.println();

        //这里修改了变量，看起来是按引用传递
        People.Change(a1, a2);
        System.out.printf("%d \t %d", a1.age, a2.age);
    }
}
