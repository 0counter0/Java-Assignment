package ECB19S2;
import java.text.*;
import java.util.*;

/**
 * @version: V1.0
 * @author: Pingzhou Li
 * @className: Birthday
 * @packageName: ECB19S2
 * @description: This class is used to check if the birthday is valid and modify the format
 **/
public class BirthDay{ 
 private int day=0;
 private int month=0;
 private int year=0;
 private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
 private Date date;
 private String dateStr;

    /**
     * @description: Constructor
     * @param: s
     * */
  public BirthDay(String s){ 
     dateStr = s;
     String[]temp;  
  if(dateStr.matches("\\d+\\D\\d+\\D\\d+")){ 
	  temp = dateStr.split("\\D");
	  if (temp.length == 3){
		  for(int i=0;i<2;++i){
			  if(temp[i].length()<2){
				  temp[i] = "0" + temp[i];
			  }
			  dateStr = temp[0] + "-" + temp[1]+"-"+ temp[2];
			  year = Integer.parseInt(temp[2]);
			  month= Integer.parseInt(temp[1]);
			  day= Integer.parseInt(temp[0]);
			  
			  //validating the BirthDay 
			  if (year<=1800||year>=2018){dateStr="00-00-00";}
			  
			  if (month<1||month>12){dateStr="00-00-00";}
			 
			  if (month==1||month==3||month==5||month==7||month==8||month==10||month==12){
				  if(day<1||day>31){dateStr="00-00-00";}
			  }else if(month==4||month==6||month==9||month==11){
				  if(day<1||day>30){dateStr="00-00-00";}
			  }else if (month==2){
				  if(year%4==0){
					  if(day<1||day>28){dateStr="00-00-00"; }
				  }else{
					  if(day<1||day>29){dateStr="00-00-00";}		 
			  }			 			 
		    }
	      }
        }
	  }
   try{
	   date = dateFormat.parse(dateStr);
   } catch(ParseException e){
	   date = null;
   }
 }

 /**
  * @author:  Pingzhou Li
  * @methodsName: getDay
  * @description: get day data in birthday
  * @param:  null
  * @return: int
  */
  public int getDay(){
     return day;
}

    /**
     * @author:  Pingzhou Li
     * @methodsName: getMonth
     * @description: get month data in birthday
     * @param:  null
     * @return: int
     */
  public int getMonth(){
     return month;
   }

    /**
     * @author:  Pingzhou Li
     * @methodsName: geYear
     * @description: get year data in birthday
     * @param:  null
     * @return: int
     */
  public int getYear(){
     return year;
   }

    /**
     * @author:  Pingzhou Li
     * @methodsName: getDate
     * @description: get date in birthday
     * @param:  null
     * @return: Date
     */
  public Date getDate(){
     return date;
   }

    /**
     * @author:  Pingzhou Li
     * @methodsName: dateString
     * @description: get date in String type
     * @param:  null
     * @return: String
     */
  public String dateString(){
	  return dateFormat.format(date);
  }

    /**
     * @author:  Pingzhou Li
     * @methodsName: isValidBirthday
     * @description: check if it is a valid birthday
     * @param:  null
     * @return: boolean
     */
public boolean isValidBirthday(){
	if(date!=null&&dateStr!="00-00-00"){
	   return true;
    }else{
	     return false;
    }
  }
}
