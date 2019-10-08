public class ProcessControl
{
    public static void main(String[] args) {
        /* int num = 0;
        while (num <= 100) {
            if ( num % 5 == 0) 
            {
                System.out.println(num + "可以被5整除，商为"+(num/5));
            }
            num ++;
        } */

        /* for (int i = 0; i < 100; i++) {
            if (i % 3 == 0)
            {
                System.out.println(i + "可以被3整除，商为：" + (i / 3));
            }else if(i == 3){
                System.out.println("i为3");
            }else {
                System.out.println("未命中条件，退出");
                break;
            }
        } */
        
        /* int i = 0;
        switch (i) {
            case 1:
                System.out.println("i为1");
                break;
            default:
            System.out.println("i不为1");
                break;
        } */
        int i = 0;
        do {
            System.out.println(i);
            i++;
        } while (i<10);
        
    }
}