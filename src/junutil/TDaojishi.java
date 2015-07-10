package junutil;

public class TDaojishi extends Base{

   private String str=null;

   public TDaojishi(){
	 System.out.println("sub 舒适化");
     str="1234";
   }

   public void method(){
     System.out.println(str);
   }

   public static void main(String[] args){
	   long fullSecs=863209;
		  int fullHour = (int)(fullSecs/(60*60));            //时
		  int fullMinute=(int)(fullSecs%(60*60)/(60));  //分
		  int fullSecond=(int)(fullSecs-(fullHour*(60*60))-(fullMinute*60));//秒
		 System.out.println(fullHour);
		 System.out.println(fullMinute);
		 System.out.println(fullSecond);
	//   secToTime(863209);
   }
   
   
   public static String secToTime(int time) {
	   System.out.println("qq");
       String timeStr = null;
       int hour = 0;
       int minute = 0;
       int second = 0;
       if (time <= 0)
           return "00:00";
       else {
           minute = time / 60;
           if (minute < 60) {
               second = time % 60;
               timeStr = unitFormat(minute) + ":" + unitFormat(second);
           } else {
               hour = minute / 60;
               minute = minute % 60;
               second = time - hour * 3600 - minute * 60;
               timeStr = unitFormat(hour) + ":" + unitFormat(minute) + ":" + unitFormat(second);
               System.out.println(timeStr);
           }
       }
       System.out.println(timeStr);
       return timeStr;
   }
   
   public static String unitFormat(int i) {
       String retStr = null;
       if (i >= 0 && i < 10)
           retStr = "0" + Integer.toString(i);
       else
           retStr = "" + i;
       return retStr;
   }
   
}
