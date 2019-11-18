package ECB19S2;

/**
 * @version: V1.0
 * @author: Pingzhou Li
 * @className: ContactInfo
 * @packageName: ECB19S2
 * @description: This class is used to save detail information
 **/
public class ContactInfo {
  Name name = new Name("0");
  BirthDay birthday = new BirthDay("00-00-0000");
  String phoneNumber= null;
  String address= null;
  String email=null;
  String div = null; 
  
  public ContactInfo(){}

	/**
	 * @description: Constructor
	 * @param: name, birthday,phoneNum, e, addr
	 * */
  public ContactInfo( Name name, BirthDay birthday, String phoneNum, String e, String addr){
	  this.name = name;
	  this.birthday = birthday;
	  phoneNumber = phoneNum;
	  address = addr;
	  email = e;
	  }

	/**
	 * @description: Constructor
	 * @param: s
	 * */
  public ContactInfo(String s){ // use a long string to create a Contact object
	    
	  String[] tStr = s.trim().split("\\s*;\\s*"); //splitting tStr using ";"
		
	    for(int i=0; i<tStr.length;i++){
		   String[] temp = tStr[i].trim().split("\\s");
		
		   
		    if(temp[0].equals("name")){ //check if the string is name
		    	 if(temp.length==2){
		      	name = new Name(temp[1]);
		      	
				 }else if(temp.length==3){
				 name = new Name(temp[1],temp[2]);
				 
		
			 }else if(temp.length==4){
				 name = new Name(temp[1],temp[2],temp[3]);
			 }
		   }else if(temp[0].equals("birthday")){ //check if the string is a birthday
			  birthday= new BirthDay(temp[1]); 
		   }else if(temp[0].equals("phone")){  //check if the string is a phone
			   if (temp[1].matches("[0-9]+")){
				   String phNo= temp[1].replaceFirst("^0+(?!$)", "");// removes zeros at the beginning of the string.
			   phoneNumber = phNo; 
			   }
		   }else if(temp[0].equals("address")){ //check if the string is an address
			 
			   int last = temp.length-1;
			   if (temp[last].matches("[0-9]+")){
				address=""; 
			   for(int j=1;j<temp.length;j++){
			   		if(!temp[j].isBlank())
					{address += " "+temp[j];} 
			    }
			   }
			   
		   }else if(temp[0].equals("email")){     //check if the string is an email.
			  
			   
			  int count =0;
			  for (int j = 0; j < temp[1].length(); j++) {
				    if (temp[1].charAt(j) == '@') {
				        count++;
				    }
				}
			  if (count ==1){email = temp[1]; }
		   }
	   }
  }

	/**
	 * @author:  Pingzhou Li
	 * @methodsName: getName
	 * @description: get the name of one person
	 * @param:  null
	 * @return: Name
	 */
  public Name getName(){
	  return name;
	  }

	/**
	 * @author:  Pingzhou Li
	 * @methodsName: getBirthday
	 * @description: get the birthday of one person
	 * @param:  null
	 * @return: birthday
	 */
  public BirthDay getBirthDay(){
	  return birthday;
	  }

	/**
	 * @author:  Pingzhou Li
	 * @methodsName: getPhoneNumber
	 * @description: get the phoneNumber of one person
	 * @param:  null
	 * @return: String
	 */
  public String getPhoneNumber(){
	  return phoneNumber;
	  }

	/**
	 * @author:  Pingzhou Li
	 * @methodsName: getAddress
	 * @description: get the address of one person
	 * @param:  null
	 * @return: String
	 */
  public String getAddress(){
	  return address;
	  }

	/**
	 * @author:  Pingzhou Li
	 * @methodsName: getEmail
	 * @description: get the email of one person
	 * @param:  null
	 * @return: String
	 */
  public String getEmail(){
	  return email;
	  }

	/**
	 * @author:  Pingzhou Li
	 * @methodsName: update
	 * @description: update the information of one person
	 * @param:  r
	 * @return: void
	 */
  public void update(ContactInfo r){
	  if(r.getPhoneNumber()!=null){
		  phoneNumber = r.getPhoneNumber();
	  }
	  if(r.getAddress()!=null){
		  address = r.getAddress();
	  }
	  if(r.getEmail()!=null){
		  email= r.getEmail();
	  }
  }

	/**
	 * @author:  Pingzhou Li
	 * @methodsName: setQDive
	 * @description: set the start dividing line
	 * @param:  a,b
	 * @return: void
	 */
  public void setQDiv(String a, String b){
	  div = "====== query: "+a+" "+ b +" ======\n" ;
  }

	/**
	 * @author:  Pingzhou Li
	 * @methodsName: setQDive
	 * @description: set the end dividing line
	 * @param:  a,b
	 * @return: void
	 */
  public void setEndQDiv(String a, String b){
	  div = "====== end of query: "+ a +" "+ b +" ======\n" ;
  }

	/**
	 * @author:  Pingzhou Li
	 * @methodsName: getQDive
	 * @description: get the dividing line
	 * @param:  null
	 * @return: String
	 */
  public String getQDiv(){
	  return div;
  }
  
}
