/**
 * projectName: COMP9103 Assignment
 * packageName: ECB19S2
 * date: 10/11/2019
 */
package ECB19S2;
/**
 * @version: V1.0
 * @author: Pingzhou Li
 * @className: ECB
 * @packageName: ECB19S2
 * @description: This is the main class used to receive arguments
 **/
public class ECB {
	/**
	 * @author:  Pingzhou Li
	 * @methodName: main
	 * @description: This is the main method read arguments
	 * @param:  String args[]
	 * @return: void
	 */
	public static void main(String[] args) {
	    ProcessFile fp = new ProcessFile(args);
	    fp.readContact();
	    fp.readInst();
	    
	}

}
