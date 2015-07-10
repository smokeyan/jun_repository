/**
 * 类名称:RadmonUtil.java
 * 功能描述: 生成随机数工具类
 * 作者: 李黎
 * 时间:2014年6月30日-上午11:08:40
 * 版本信息:V1.0
 * CopyRight(C)：2014民生电商-版权所有
 */
package junutil;

import java.util.Random;

public class RandomUtil {
	private static Random ran = new Random();
	/**
	 * 
	 * 创建人: 李黎  创建时间:2014年6月30日 上午11:10:08
	 * @Title: createRandomCode
	 * @Description: 产生一个指定位数的随机码(由数字或大小写字母构成)
	 * @param randomCodeLen 指定位数
	 * @param hasLetter 是否包括字母,true包括,false不包括
	 * @return 随机码
	 * @return: String
	 */
    public static String createRandomCode(int randomCodeLen, boolean hasLetter){
        // 存放结果
        StringBuilder result = null;
        if(randomCodeLen >= 1){
            result = new StringBuilder();
            if(hasLetter){
                for(int i = 0; i < randomCodeLen; i++){
                    // 产生0-2的随机数
                    int random = ran.nextInt(3);
                    switch(random){
                        case 0:
                            // 数字
                            result.append(createRandomNum());
                            break;
                        case 1:
                            // 小写字母
                            result.append(createRandomLowerLetter());
                            break;
                        case 2:
                            // 大写字母
                            result.append(createRandomUpperLetter());
                            break;
                    }
                }
            }else if(!hasLetter){
                for(int i = 0; i < randomCodeLen; i++){
                    result.append(createRandomNum());
                }
            }
            return result.toString();
        }
        return null;
    }
    /**
     * 
     * 创建人: 李黎  创建时间:2014年6月30日 上午11:09:22
     * @Title: createRandomNum
     * @Description: 产生0-9的随机数
     * @return 0-9
     * @return: String
     */
    private static String createRandomNum(){
        return String.valueOf(ran.nextInt(10));
    }
    /**
     * 
     * 创建人: 李黎  创建时间:2014年6月30日 上午11:11:15
     * @Title: createRandomLowerLetter
     * @Description: 产生a-z中任意小写字母
     * @return a-z,任意字母
     * @return: String
     */
    public static String createRandomLowerLetter(){
        // char类型a，转换为byte，数值为97
        int a = 97;
        // 97+26位随机数，小写字母byte范围
        int random = a + ran.nextInt(26);
        return String.valueOf((char)(byte)random);
    }
    /**
     * 
     * 创建人: 李黎  创建时间:2014年6月30日 上午11:11:44
     * @Title: createRandomUpperLetter
     * @Description: 产生A-Z中任意大写字母
     * @return A-Z中任意字母
     * @return: String
     */
    private static String createRandomUpperLetter(){
        // char类型A，转换为byte，数值为65
        byte A = 65;
        // 65+26位随机数，小写字母byte范围
        int random = A + ran.nextInt(26);
        return String.valueOf((char)(byte)random);
    }
    
    /**
     * 
     * 创建人:李井新  创建时间:2014年7月1日 上午9:27:53
     * @Title: getStringRandom
     * @Description: 生成随机数字和字母
     * @param length
     * @return
     * @return: String
     */
    public static String getStringRandom(int length) {  
          
        String val = "";  
        Random random = new Random();  
          
        //参数length，表示生成几位随机数  
        for(int i = 0; i < length; i++) {  
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";  
            //输出字母还是数字  
            if( "char".equalsIgnoreCase(charOrNum) ) {  
                //输出是大写字母还是小写字母  
                //int temp = random.nextInt(2) % 2 == 0 ? 65 : 97; 
            	//输出大写字母
            	int temp = 65;
                val += (char)(random.nextInt(26) + temp);  
            } else if( "num".equalsIgnoreCase(charOrNum) ) {  
                val += String.valueOf(random.nextInt(10));  
            }  
        }  
        return val;  
    }
    

}
