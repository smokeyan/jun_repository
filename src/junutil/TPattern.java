package junutil;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TPattern {

	
	public static void main(String args[]){
		
		
		// TODO Auto-generated method stub
		String s = "^[A-Za-z]+";
	       Pattern  pattern=Pattern.compile(s);  
	       Matcher  ma=pattern.matcher("GC12334444");  
	       String result = "";
	       while(ma.find()){  
	           result = ma.group();  
	       }  
	System.out.println(result);
		
	}
}
