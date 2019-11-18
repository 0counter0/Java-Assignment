package ECB19S2;
/**
 * @version: V1.0
 * @author: Pingzhou Li
 * @className: Name
 * @packageName: ECB19S2
 * @description: Name class is used to check if the name is valid
 **/
public class Name {

    String firstName = "0";
    String surName = "0";
    String middleName = "0";
    String fullName;
	/**
	 * @description: Constructor
	 * @param: name
	 * */
    public Name(String name){ 
    fullName = name;
    }
	/**
	 * @description: Constructor
	 * @param: firN,surN
	 * */
    public Name(String firN, String surN){
    	firstName = firN;
    	surName = surN;
    	fullName = firN+" "+surN;
    }
	/**
	 * @description: Constructor
	 * @param: fn,mn,sn
	 * */
    public Name(String fn, String mn,String sn){
    	firstName = fn;
    	middleName = mn;
    	surName = sn;
    	fullName = fn+" "+mn+" "+sn;
    }

	/**
	 * @author:  Pingzhou Li
	 * @methodsName: getFirstName
	 * @description: get the first name of one person
	 * @param:  null
	 * @return: String
	 */
    public String getFirstName(){
    return firstName;
    }

	/**
	 * @author:  Pingzhou Li
	 * @methodsName: getSurName
	 * @description: get the surname of one person
	 * @param:  null
	 * @return: String
	 */
    public String getSurName(){
    return surName;
    }

	/**
	 * @author:  Pingzhou Li
	 * @methodsName: getMiddleName
	 * @description: get the middle name of one person
	 * @param:  null
	 * @return: String
	 */
    public String getMiddleName(){
    return middleName;
    }

	/**
	 * @author:  Pingzhou Li
	 * @methodsName: getFullName
	 * @description: get the full name of one person
	 * @param:  null
	 * @return: String
	 */
    public String getFullName(){
    		return fullName;	
    }

	/**
	 * @author:  Pingzhou Li
	 * @methodsName: isValidName
	 * @description: Check if the name is vaild
	 * @param:  null
	 * @return: boolean
	 */
    public boolean isValidName(){	
    	boolean first = false;
    	boolean middle = false;
    	boolean sur = false;
    	boolean full=false;
			if(firstName.matches("[a-zA-Z]+")){
				first = true;
			}
			if(middleName.matches("[a-zA-Z]+")||middleName.equals("0")){
				middle = true;
			}
			if(surName.matches("[a-zA-Z]+")||surName.equals("0")){
				sur = true;
			}
			if(fullName.matches("[a-zA-Z]+")){
				full=true;
			}
    	if((first==true&&middle==true&&sur==true)||full==true){
    		return true;
    	}
    	else{
    		return false;
    	}

   	}
 }
