import java.util.Arrays;

/**
 * @file: ArrayTest.java
 * @author: atinosun@yeah.net
 * @date: 2019-09-20
 * @brief：数组
 */
public class ArrayTest {
    @Override
    public String toString() {
        return getClass().getName() + "{object}";
    }

    public static void main(String[] args) {
        Integer[] testArray = new Integer[6];
        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = i + 100;
        }
        for (var i : testArray) {
            System.out.println("当前value：" + i);
        }

        System.out.println(testArray.length);
        System.out.println(Arrays.toString(testArray));
        ArrayTest objClass = new ArrayTest();
        System.out.println(objClass);
    }

}