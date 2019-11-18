package ECB19S2;

public class ContactInfo {
  private Name name = new Name("0");
  private BirthDay birthday = new BirthDay("00-00-0000");
  private String phoneNumber= null;
  private String address= null;
  private String email=null;
  private String sdiv = null;
  private String ediv=null;

  public ContactInfo(){}
  
  public ContactInfo( Name name, BirthDay birthday, String phoneNum, String e, String addr){
	  this.name = name;
	  this.birthday = birthday;
	  phoneNumber = phoneNum;
	  address = addr;
	  email = e;
	  }
  
  public ContactInfo(String s){ // use a long string to create a Contact object based on what's in it.
	    
	  String[] tStr = s.trim().split("\\s*;\\s*"); //splitting using a ";"
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
						//System.out.println("temp :"+temp[j]);
			   			if(!temp[j].isBlank()){

							address += " "+temp[j];
						}
			   			//System.out.println("address is :"+address);
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
  
  public Name getName(){
	  return name;
	  }
	  
  public BirthDay getBirthDay(){
	  return birthday;
	  }
	  
  public String getPhoneNumber(){
	  return phoneNumber;
	  }

  public String getAddress(){
	  return address;
	  }
	  
  public String getEmail(){
	  return email;
	  }
  
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
  
  public void setQDiv(String a, String b){ sdiv = "====== query: "+a+" "+ b +" ======\n" ;}
  public void setEndQDiv(String a, String b){
	  ediv = "====== end of query: "+ a +" "+ b +" ====== \n\n" ;
  }
  public String getSDiv(){
	  return sdiv;
  }
  public String getEDiv(){
		return ediv;
	}
  
}
