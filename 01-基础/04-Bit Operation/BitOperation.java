public class BitOperation
{
    public static void main(String[] args)
    {
        int a = 05;  //  101
        int b = 011; // 1001
        int c = 0xF; // 1111 =15  00001111
        int d = 0x11;

        // System.out.println(a);
        // System.out.println(b);
        // System.out.println(c);
        // System.out.println(d);
        //位运算符
        System.out.println(a & b); //1
        System.out.println(a | b); //1101
        System.out.println(a ^ b); //1100
        System.out.println(~c);  // 按位取反 11110000 由于是负数(最大位为1)，则取反的结果为补码 补码转换反码(补码=原码取反，尾+1，取反过程中，符号位不变) ：尾-1 按位取反 得反码 
        // -1 得到 11101111 取反 10010000(原码，此值为-16) 
        
        //位移运算符
        System.out.println(a >> 1); // 101 -> 10 = 2
        System.out.println(a >>> 2); // 101 -> 1 = 1
        System.out.println(a << 1); // 101 -> 1010 = 10

        byte i = -5; // 10000101
        System.out.println(i >> 1); // ? Todo
        System.out.println(i >> 2); // ?
        System.out.println(i >>> 2); // 右移2位 00100001  ？
        System.out.println(i << 1); // 10001010 -10 

        System.out.println(Integer.toBinaryString(i >> 1)); // 10000101 -> 1000010 = -3
        System.out.println(Integer.toBinaryString(i >>> 2)); // 0010....0001 
        System.out.println(Integer.toBinaryString(i << 1)); // 10001010 -10
        
    }
}