package ECB19S2;
import java.util.*;

/**
 * @version: V1.0
 * @author: Pingzhou Li
 * @className: RecordFile
 * @packageName: ECB19S2
 * @description: This class is used to do some more operations of record
 **/
public class RecordFile {
	private ArrayList<ContactInfo> rec_file;
	private ArrayList<ContactInfo> rep_file;
	
	public RecordFile(){
		rec_file = new ArrayList<ContactInfo>();
		rep_file = new ArrayList<ContactInfo>();
	}

	/**
	 * @author:  Pingzhou Li
	 * @methodsName: addRecord
	 * @description: add new record to exist record
	 * @param:  record
	 * @return: void
	 */
    public void addRecord(ContactInfo record){
		rec_file.add(record);
	}

	/**
	 * @author:  Pingzhou Li
	 * @methodsName: addRec
	 * @description: add new record to exist record
	 * @param:  s
	 * @return: void
	 */
    public void addRec(String s){
       ContactInfo m = new ContactInfo(s);
       
       if(m.getName().isValidName()&&m.getBirthDay().isValidBirthday()){
   
    	    int matchCount = 0;
    	    String n = m.getName().getFullName();
    	    String bd = m.getBirthDay().dateString();
    	    
    	    for(ContactInfo r: rec_file){
    	    	
				if(r.getName().getFullName().equals(n)
						&&r.getBirthDay().dateString().equals(bd)){
				matchCount++;		
				r.update(m);
				}
			}
    	   if (matchCount==0){
    		   rec_file.add(m);} 
       }   		  
    }

	/**
	 * @author:  Pingzhou Li
	 * @methodsName: delRec
	 * @description: delete record from existing record
	 * @param:  s
	 * @return: void
	 */
	public void delRec(String s){
		String[] dStr = s.trim().split("\\s*;\\s*");
		if (dStr.length==1)
		{
			  for(ContactInfo r: rec_file){
					if(r.getName().getFullName().equals(dStr[0]))
					{
						rec_file.remove(r);
					}
				}		
		}else if(dStr.length==2)
		{			
			BirthDay birthdelete = new BirthDay(dStr[1]); 
			for(int i=0;i<rec_file.size();i++){
				String tN= rec_file.get(i).getName().getFullName();
				String tB= rec_file.get(i).getBirthDay().dateString();
					if(tN.equals( dStr[0])&& tB.equals( birthdelete.dateString()))
					{
						rec_file.remove(i);
					}
				}		
		}	
	}

	/**
	 * @author:  Pingzhou Li
	 * @methodsName: searchRec
	 * @description: search record from existing record
	 * @param:  a,b
	 * @return: void
	 */
	public void searchRec(String a, String b){
		ArrayList<ContactInfo> sort = new ArrayList<>();
		b=b.trim();
		ContactInfo d = new ContactInfo();
        d.setQDiv(a, b);
        rep_file.add(d);
		if(a.equals("name"))
		{        
			 for(ContactInfo r: rec_file)
			 {		 
	    	    	if(r.getName().getFullName().equals(b))
	    	    	{
	    	    		//rep_file.add(r);
						sort.add(r);
					} 
	    	    }
			Collections.sort(sort,comparator);
			 for(int i=0;i<sort.size();i++){
			 	rep_file.add(sort.get(i));
			 }
			 }
		if(a.equals("birthday"))
		{
			 for(ContactInfo r: rec_file){		 
	    	    	if(r.getBirthDay().dateString().equals(b))
	    	    	{
	    	    		//rep_file.add(r);
						sort.add(r);
					} 
	    	    }
			Collections.sort(sort,comparator);
			for(int i=0;i<sort.size();i++){
				rep_file.add(sort.get(i));
			}
		}
		if(a.equals("phone")){
			 for(ContactInfo r: rec_file){
				 if(r.getPhoneNumber()!=null)
				 {
	    	    	if(r.getPhoneNumber().equals(b))
	    	    	{
	    	    		rep_file.add(r);
					} 
	    	    }
			 }
		}
		ContactInfo e = new ContactInfo();
		e.setEndQDiv(a, b);
		rep_file.add(e);
	}


	Comparator<ContactInfo> comparator=new Comparator<ContactInfo>() {

		@Override
		/**
		 * @author:  Pingzhou Li
		 * @methodsName: compare
		 * @description: This method is used to sort report file
		 * @param:  o1,o2
		 * @return: int
		 */
		public int compare(ContactInfo o1, ContactInfo o2) {
			int result=o1.getName().getFullName().compareTo(o2.getName().getFullName());
			if (o1.getBirthDay().getYear()>o2.getBirthDay().getYear()||result>0){
				return 1;
			}
			else
			{
				return -1;
			}
		}
	};

	/**
	 * @author:  Pingzhou Li
	 * @methodsName: getRecordList
	 * @description: get record in arraylist type
	 * @param:  null
	 * @return: ArrayList<ContactInfo>
	 */
	public ArrayList<ContactInfo> getRecordList(){
		return rec_file;
	}

	/**
	 * @author:  Pingzhou Li
	 * @methodsName: getReportList
	 * @description: get report in arraylist type
	 * @param:  null
	 * @return: ArrayList<ContactInfo>
	 */
	public ArrayList<ContactInfo> getReportList(){
		return rep_file;
	}

	/**
	 * @author:  Pingzhou Li
	 * @methodsName: toString
	 * @description: Modify the arraylist record to string type
	 * @param:  null
	 * @return: String
	 */
    public String toString(){
    	String a="";
    	for(ContactInfo r: rec_file){
	    	if (r.getName().isValidName())
	    	{
	    	a +="name: "+ r.getName().getFullName();
	    	}
	    	if (r.getBirthDay().isValidBirthday())
	    	{
	    		a+="birthday: "+r.getBirthDay().dateString();
	    	}
	    	if(r.getAddress()!=null)
	    	{
	    		a+="address: " + r.getAddress();
	    	}
	    	if(r.getPhoneNumber()!=null)
	    	{
	    		a+="phone: "+ r.getPhoneNumber();
			}
		    if(r.getEmail()!=null)
		    {
		    	a+="email: "+r.getEmail();
	    	}  	
	    }	 
    	return a;
    }
    
}
