package junutil;

import java.util.Random;

public class TRandomStr {
	public static void main(String[] args) {
		String a ="523456";
		int f=0;
		while(f==0){
			String m=generateNumber2();
			System.out.println(m);
			if(m.equals(a)){
				System.out.println("YYYYYYYYYYYYYYYYYYYYY");
				f=1;
			}
		}
	}
	
	
	

	   public static String generateNumber2() {

	       String no = "";

	       int num[] = new int[6];

	       int c = 0;

	       for (int i = 0; i < 6; i++) {

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
}
