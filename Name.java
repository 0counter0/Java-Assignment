package ECB19S2;

public class Name {
	
	// Member variables of the class
    String firstName = "0";
    String surName = "0";
    String middleName = "0";
    String fullName;
   
 
    public Name(String name){ 
    fullName = name;
    }
 
    public Name(String firN, String surN){
    	firstName = firN;
    	surName = surN;
    	fullName = firN+" "+surN;
    }
 
    public Name(String fn, String mn,String sn){
    	firstName = fn;
    	middleName = mn;
    	surName = sn;
    	fullName = fn+" "+mn+" "+sn;
    }

    
    public String getFirstName(){
    return firstName;
    }
   
    public String getSurName(){
    return surName;
    }
    
    public String getMiddleName(){
    return middleName;
    }
    
    public String getFullName(){
    		return fullName;	
    }

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
    	if(first==true||full==true){
    		return true;
    	}
    	else{
    		return false;
    	}

   	}
 }
