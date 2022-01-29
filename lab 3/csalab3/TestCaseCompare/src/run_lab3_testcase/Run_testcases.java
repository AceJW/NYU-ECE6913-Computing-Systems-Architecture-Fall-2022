package run_lab3_testcase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Run_testcases {
	public static boolean run() {
		File f = new File("trace.out"); 
		File f2 = new File("trace.txt.out"); 
		FileReader fr = null;
		FileReader fr2 = null;
		boolean flag = true;
		int count = 1;
		try {
			fr = new FileReader(f);
			fr2 = new FileReader(f2);
			BufferedReader in = new BufferedReader(fr);
			BufferedReader in2 = new BufferedReader(fr2);
	    	String ln = in.readLine();
	    	String ln2 = in2.readLine();
	    	int index = 0;
	    	
	    	while (ln2 != null && ln != null) {
	    		//System.out.println(ln);
	    		
	    		if(ln2.contains("X")) {
	    			ln2 = in2.readLine();	
		    		ln = in.readLine();
		    		count++;
		    		continue;
	    		}
	    		if(!ln2.equals(ln)) {	
	    			System.out.println(count);
	    			index++;
	    			System.out.println("wrong");
	    			flag = false;
	    			//return false;
	    		}
	    		
	    		ln2 = in2.readLine();	
	    		ln = in.readLine();
	    		count++;
	    	}
	    	System.out.println("total difference: "+ index);
	    	if(ln2 != null || ln != null) {
	    		System.out.println("length isn't same");
	    		return false;
	    	}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found: " + e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IO error reading file:" + e.getMessage());
		}
		
		return flag;
	}
	public static void main(String[] args) { 
		System.out.println(run());
	}
}
