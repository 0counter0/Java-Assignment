package ECB19S2;
import java.io.*;
import java.util.*;

/**
 * @version: V1.0
 * @author: Pingzhou Li
 * @className: ProcessFile
 * @packageName: ECB19S2
 * @description: This class is used to process read and write function
 **/
public class ProcessFile {

	 private File inputFile;
	 private File instruction; 
	 private File outputFile;
	 private File reportFile;
	  
	 private RecordFile recordList;

	/**
	 * @description: Constructor
	 * @param: f
	 * */
	 public ProcessFile(String[]f){
	 inputFile = new File(f[0]);
	 instruction = new File(f[1]);
	 outputFile = new File(f[2]);
	 reportFile = new File(f[3]);

	 recordList = new RecordFile();
	  }

	/**
	 * @author:  Pingzhou Li
	 * @methodsName: readContact
	 * @description: read contact information from file
	 * @param:  null
	 * @return: void
	 */
	public void readContact(){ // reading existing contact record file
	  try{
	   Scanner fileScan = new Scanner(inputFile);
	   String dataStr = "" ;
	     while(fileScan.hasNextLine()) { // Reading a line a time.
			String ContactLine = fileScan.nextLine();
			 
			  if(!ContactLine.isEmpty()){
				  Scanner lineScan = new Scanner(ContactLine);
					 String keyWordIn = lineScan.next();
			   if(keyWordIn.equals("name")||keyWordIn.equals("birthday")
				||keyWordIn.equals("phone")||keyWordIn.equals("address")
				||keyWordIn.equals("email")){
				    if(dataStr.equals("")){
				    	dataStr = ContactLine;
				      }else{
			    	  dataStr += ";"+ContactLine;}
			        }else {
			        	dataStr += ContactLine;}
			      lineScan.close();
		         }else{ 
		            	// once line is empty, print out the whole dataStream
		           recordList.addRec(dataStr);
		           dataStr="";//clean the dataStream to read next record
		         } 
			  
	       }
	       //System.out.println(dataStream); // print out the last record(has no empty line at the end)
	       recordList.addRec(dataStr);
	      fileScan.close();    
      }catch(FileNotFoundException a){
    	  a.printStackTrace();
     }
   }

	/**
	 * @author:  Pingzhou Li
	 * @methodsName: readInst
	 * @description: read instructions from file and process record
	 * @param:  null
	 * @return: void
	 */
	public void readInst(){  // reading instruction file.
		  try{
		   Scanner instructionScan = new Scanner(instruction);
		   boolean hasReport = false;
		   
		     while(instructionScan.hasNextLine()) { // reading one line at a time
				String instruLine = instructionScan.nextLine();
				Scanner sc = new Scanner(instruLine);
				String keyword, queryword, param;
				
				  if(sc.hasNext()){
					 keyword = sc.next();
				
			           if(sc.hasNextLine()){
					       			            
					       if (keyword.equals("add")){  // addcontact
					    	   param= sc.nextLine();
					    	   recordList.addRec(param); 
					       } else if (keyword.equals("delete")){
					    	   param= sc.nextLine();
					    	   recordList.delRec(param); // deleteContact
					       } else if (keyword.equals("query")){
					    	   queryword = sc.next();
					    	   param =sc.nextLine();
					    	   recordList.searchRec(queryword,param);
					    	   hasReport = true;
					       }
			            }else{ 
			            	if (keyword.equals("save")){
			            		saveResult();
			            		
			            		if(hasReport==true){
			            		saveReport();
			            		}
			            	}
			            	continue;} //No parameters
			           sc.close();
		           }else { // When the line is empty.
	                     continue;
	                	}
	                }
		      instructionScan.close();    
	      }catch(FileNotFoundException c){
	    	  c.printStackTrace();
	      }
	   }

	/**
	 * @author:  Pingzhou Li
	 * @methodsName: saveResult
	 * @description: save record to resut file
	 * @param:  null
	 * @return: void
	 */
	public void saveResult(){ // outputs to file
		try{
			PrintWriter output = new PrintWriter(new FileOutputStream(outputFile));
			int num=0;
		    for(ContactInfo r: recordList.getRecordList()){
		    		num++;
			    	if (r.getName().isValidName()){
			    	output.println("name: "+ r.getName().getFullName() );}
			    	if (r.getBirthDay().isValidBirthday()){
			    		output.println("birthday: "+r.getBirthDay().dateString());}
			    	if(r.getAddress()!=null){
			    		output.println("address:" + r.getAddress());}
			    	if(r.getPhoneNumber()!=null){
			    		output.println("phone: "+ r.getPhoneNumber());}
				    if(r.getEmail()!=null){
				    	output.println("email: "+r.getEmail());}  	
				    if(r.getQDiv()!=null){
				    	output.print(r.getQDiv());
				    }else{
						if(!(num==recordList.getRecordList().size())){
							output.print("\n");
						}
						//output.print("\n");
					}		    
		    }	 	    
		    	    	
			output.close();
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
	}

	/**
	 * @author:  Pingzhou Li
	 * @methodsName: saveReport
	 * @description: save record to report file
	 * @param:  null
	 * @return: void
	 */
	public void saveReport(){ // output to file
		try{
			PrintWriter reportOut = new PrintWriter(new FileOutputStream(reportFile));
			int num=0;
			for(ContactInfo r: recordList.getReportList()){
		    	
		    	if (r.getName().isValidName()){
		    	reportOut.print("name: "+ r.getName().getFullName()+ "\n");}
		    	if (r.getBirthDay().isValidBirthday()){
		    	reportOut.print("birthday: "+r.getBirthDay().dateString()+ "\n");}
		    	if(r.getAddress()!=null){
		    	reportOut.print("address:" + r.getAddress()+ "\n");}
		    	if(r.getPhoneNumber()!=null){
		    	reportOut.print("phone: "+ r.getPhoneNumber()+ "\n");}
			    if(r.getEmail()!=null){
			    reportOut.print("email: "+r.getEmail()+ "\n");}  	
		   
			    if(r.getQDiv()!=null){
			    reportOut.print(r.getQDiv());
				if(num==4||num==9){
						reportOut.print("\n");
					}
			    }
				else{
					if(!(num==3||num==8||num==11||num==recordList.getRecordList().size())){
					reportOut.print("\n");
						}
				}
				num++;
	    }	    	
			reportOut.close();
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
	}

	/**
	 * @author:  Pingzhou Li
	 * @methodsName: getRecordList
	 * @description: get recordlist object
	 * @param:  null
	 * @return: RecordFile
	 */
	public RecordFile getRecordList(){
		return recordList;
	}
	
}
