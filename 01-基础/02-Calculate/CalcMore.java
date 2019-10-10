public class CalcMore
{
    public static void main(String[] args) {
        /** 算数运算符
        int a = 1;
        int b = 2;
        int c = 3;
        int d = 10;

        int r = a*d +b*c + c*d*d;
        System.out.println(r);

        r = a%b;
        System.out.println(r);
        

        System.out.println(10/3);
        System.out.println(10.0/3);

        */

        /**  比较运算符
        System.out.println(10 > 1);
        System.out.println(10 >= 1);
        System.out.println(10 < 1);
        System.out.println(10 <= 1);
        System.out.println(10 != 1);
        System.out.println(10 == 1);
        */

        //布尔运算符
        // System.out.println(!true);
        // System.out.println(true&&false);
        // System.out.println(false||true);
        // System.out.println(true&false);
        // System.out.println(false|true);
        // || 和 |的区别(同理&&和&)
        //后面的错误表达式不会被执行
        System.out.println(true || (10 / 0 > 1));
        //后面的错误表达式会被执行
        System.out.println(true | (10 /0 > 1));
    }
}