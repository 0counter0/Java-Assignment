package ECB19S2;

public class ECB {

	public static void main(String[] args) {

	    ProcessFile fp = new ProcessFile(args);
	    fp.readContact();
	    fp.readInst();

	}

}
