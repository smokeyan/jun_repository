package junutil;

import java.util.Random;

public class Sui {

   //设定几位数

   private static final int LENGTH = 15;

    /**

   　　* 这是典型的随机洗牌算法。

   　　* 流程是从备选数组中选择一个放入目标数组中，将选取的数组从备选数组移除（放至最后，并缩小选择区域）

   　　* 算法时间复杂度O（n）

   　　* @return 随机8为不重复数组

   　　*/

   public static String generateNumber() {

       String no = "";

       // 初始化备选数组

       int[] defaultNums = new int[10];

       for (int i = 0; i < defaultNums.length; i++) {

           defaultNums[i] = i;

       }

       Random random = new Random();

       int[] nums = new int[LENGTH];

       // 默认数组中可以选择的部分长度

       int canBeUsed = 10;

       // 填充目标数组

       for (int i = 0; i < nums.length; i++) {

           // 将随机选取的数字存入目标数组

           int index = random.nextInt(canBeUsed);

           nums[i] = defaultNums[index];

           // 将已用过的数字扔到备选数组最后，并减小可选区域

           swap(index, canBeUsed - 1, defaultNums);

           canBeUsed--;

       }

       if (nums.length > 0) {

           for (int i = 0; i < nums.length; i++) {

               no += nums[i];

           }

       }

       return no;

   }

   /**

    * 交换方法

    * @param i 交换位置

    * @param j 互换的位置

    * @param nums 数组

    */

   private static void swap(int i, int j, int[] nums) {

       int temp = nums[i];

       nums[i] = nums[j];

       nums[j] = temp;

   }

   /**

    * 获取8位数

    * @return

    */

   public static String generateNumber2() {

       String no = "";

       int num[] = new int[8];

       int c = 0;

       for (int i = 0; i < 8; i++) {

           num[i] = new Random().nextInt(10);

           c = num[i];

           for (int j = 0; j < i; j++) {

               if (num[j] == c) {

                   i--;

                   break;

               }

           }

       }

       if (num.length > 0) {

           for (int i = 0; i < num.length; i++) {

               no += num[i];

           }

       }

       return no;

   }

   

   public static void main(String[] agrs) {
	System.out.println(generateNumber());

}
   
   
}