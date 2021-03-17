package junutil;


import java.io.File;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class TReadFile {

	public static void main(String[] args) {
		File file=new File("d:/javas");
		File[] child=file.listFiles();
		System.out.println("-----------------------------------begin");
		for(int i=0;i<child.length;i++){
			File cf=child[i];
			System.out.println("<class>com.bjb.entry."+cf.getName().replaceAll(".java", "")+"</class>");
		}
		
		System.out.println("-----------------------------------end123");
	}
}
