package junutil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ReadXlsxTest {
	 Workbook wb = null;  
	 List<String[]> dataList = new ArrayList<String[]>(100);  
	 
	 public void ExcelReader(String path){  
	   try {  
	     InputStream inp = new FileInputStream(path);  
	     wb = WorkbookFactory.create(inp);        
	   } catch (FileNotFoundException e) {  
	     e.printStackTrace();  
	   } catch (InvalidFormatException e) {  
	     e.printStackTrace();  
	   } catch (IOException e) {  
	     e.printStackTrace();  
	   }  
	     
	 }    
	   
	 
	 public static void main(String args[]){
		 ReadXlsxTest test=new ReadXlsxTest();
		 test.ExcelReader("d:/mm.xls");
		 test.getAllData(0);
	 }
	 /** 
	  * 取Excel锟斤拷锟斤拷锟斤拷荩锟斤拷锟絟eader 
	  * @return  List<String[]> 
	  */  
	public List<String[]> getAllData(int sheetIndex){  
	   int columnNum = 0;  
	   Sheet sheet = wb.getSheetAt(sheetIndex);  
	   if(sheet.getRow(0)!=null){  
	       columnNum = sheet.getRow(0).getLastCellNum()-sheet.getRow(0).getFirstCellNum();  
	   }  
	   if(columnNum>0){  
	     for(Row row:sheet){   
	         String[] singleRow = new String[columnNum];  
	         int n = 0;  
	         for(int i=0;i<columnNum;i++){  
	            Cell cell = row.getCell(i, Row.CREATE_NULL_AS_BLANK);  
	            switch(cell.getCellType()){  
	              case Cell.CELL_TYPE_BLANK:  
	                singleRow[n] = "";  
	                break;  
	              case Cell.CELL_TYPE_BOOLEAN:  
	                singleRow[n] = Boolean.toString(cell.getBooleanCellValue());  
	                break;  
	               //锟斤拷值   
	              case Cell.CELL_TYPE_NUMERIC:                 
	                if(DateUtil.isCellDateFormatted(cell)){  
	                  singleRow[n] = String.valueOf(cell.getDateCellValue());  
	                }else{   
	                  cell.setCellType(Cell.CELL_TYPE_STRING);  
	                  String temp = cell.getStringCellValue();  
	                  //锟叫讹拷锟角凤拷锟叫★拷锟姐，锟斤拷锟叫★拷锟姐，锟斤拷锟斤拷锟街凤拷锟饺★拷锟斤拷锟斤拷小锟斤拷悖拷锟阶拷锟轿狣ouble锟斤拷锟酵碉拷锟街凤拷   
	                  if(temp.indexOf(".")>-1){  
	                    singleRow[n] = String.valueOf(new Double(temp)).trim();  
	                  }else{  
	                    singleRow[n] = temp.trim();  
	                  }  
	                }  
	                break;  
	              case Cell.CELL_TYPE_STRING:  
	                singleRow[n] = cell.getStringCellValue().trim();  
	                break;  
	              case Cell.CELL_TYPE_ERROR:  
	                singleRow[n] = "";  
	                break;    
	              case Cell.CELL_TYPE_FORMULA:  
	                cell.setCellType(Cell.CELL_TYPE_STRING);  
	                singleRow[n] = cell.getStringCellValue();  
	                if(singleRow[n]!=null){  
	                  singleRow[n] = singleRow[n].replaceAll("#N/A","").trim();  
	                }  
	                break;    
	              default:  
	                singleRow[n] = "";  
	                break;  
	            }  
	            n++;  
	         }   
	         if("".equals(singleRow[0])){continue;}//锟斤拷锟斤拷一锟斤拷为锟秸ｏ拷锟斤拷锟�  
	         dataList.add(singleRow);  
	      }  
	    }  
	   
	   System.out.println("--------------------begin");
	   for(int i=1;i<dataList.size();i++){
		   String[] singleRow = dataList.get(i);
			  String uname=singleRow[0];
			  String pass=singleRow[1];
			
			  	System.out.println("insert into `pay_bank` (`bank_name`, `logo_path`, `status`, `create_date`) values"
			  			+ "('"+uname+"','"+pass+"',1,now());");
				 

	   }
	   System.out.println("--------------------end");
	    return dataList;  
	  }    
	  /** 
	   * 锟斤拷锟斤拷Excel锟斤拷锟斤拷锟絠ndex值锟斤拷实锟斤拷锟斤拷锟斤拷要锟斤拷1 
	   * @return 
	   */  
	  public int getRowNum(int sheetIndex){  
	    Sheet sheet = wb.getSheetAt(sheetIndex);  
	    return sheet.getLastRowNum();  
	  }  
	    
	  /** 
	   * 锟斤拷锟斤拷锟斤拷莸锟斤拷锟斤拷锟�
	   * @return  
	   */  
	  public int getColumnNum(int sheetIndex){  
	    Sheet sheet = wb.getSheetAt(sheetIndex);  
	    Row row = sheet.getRow(0);  
	    if(row!=null&&row.getLastCellNum()>0){  
	       return row.getLastCellNum();  
	    }  
	    return 0;  
	  }  
	    
	  /** 
	   * 锟斤拷取某一锟斤拷锟斤拷锟�
	   * @param rowIndex 锟斤拷锟斤拷锟�锟斤拷始锟斤拷rowIndex为0锟斤拷锟絟eader锟斤拷 
	   * @return 
	   */  
	    public String[] getRowData(int sheetIndex,int rowIndex){  
	      String[] dataArray = null;  
	      if(rowIndex>this.getColumnNum(sheetIndex)){  
	        return dataArray;  
	      }else{  
	        dataArray = new String[this.getColumnNum(sheetIndex)];  
	        return this.dataList.get(rowIndex);  
	      }  
	        
	    }  
	    
	  /** 
	   * 锟斤拷取某一锟斤拷锟斤拷锟�
	   * @param colIndex 
	   * @return 
	   */  
	  public String[] getColumnData(int sheetIndex,int colIndex){  
	    String[] dataArray = null;  
	    if(colIndex>this.getColumnNum(sheetIndex)){  
	      return dataArray;  
	    }else{     
	      if(this.dataList!=null&&this.dataList.size()>0){  
	        dataArray = new String[this.getRowNum(sheetIndex)+1];  
	        int index = 0;  
	        for(String[] rowData:dataList){  
	          if(rowData!=null){  
	             dataArray[index] = rowData[colIndex];  
	             index++;  
	          }  
	        }  
	      }  
	    }  
	    return dataArray;  
	      
	  }  

	
	
}
