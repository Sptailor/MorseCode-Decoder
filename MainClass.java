package edu.ilstu;

import java.io.File;
import java.util.Scanner;

/*
 * @author suhail Pradip Tailor
 * 
 * This code decodes a morse code
 * 
 * 
 */
public class MainClass {

	public static void main(String[] args) {
		MorseTree leftTree=new MorseTree();//creates left tree
		MorseTree rightTree=new MorseTree();//creates right tree

		MorseTree tree=new MorseTree(' ',leftTree, rightTree);//creates Main tree
	    biuldTree("input.txt",tree);//reads file and builds the binary tree
	    Scanner scan=new Scanner (System.in);//scanner object
	    System.out.println("Hello");//prompts user
	    System.out.println("welcome to the decoder");

	    String in=" ";
	    String []input=null;
	    Boolean iscode;//boolean to keep track of code validity
	    while(!in.equalsIgnoreCase("Stop"))//runs until user commands code to end
	    {
	    	iscode=true;
	    	System.out.println("Enter code or Stop to exit : ");//prompts user
	    	in =scan.nextLine();//scans input
	    	if(!in.equalsIgnoreCase("Stop")) //checks input 
	    	{
	    		
	    		for(int j=0;j<in.length();j++) //loops through input
	    		{
	    			
	    			if(in.charAt(j)!=' '&&in.charAt(j)!='.'&&in.charAt(j)!='-')//checks for valid characters 
	    			{
	    				iscode=false;
	    			}
	    		}
	    	if(!iscode) 
	    		{
	    		System.out.println("invalid morse code");//if code is invalid
	    		}
	    	if(iscode) 
	    	    {   
	    		input=in.split(" ", 0);//splits input into array
	    	decode(input,tree);	//calls decode method to decode input
	            }

	    	}
	    }
	    System.out.println("Thank you for using decoder");//informs user 
	   
	
			}
	
	/*
	 * @param String file name and MorseTree
	 * 
	 * Scans file line by line and places each character at respective position in binary tree
	 */
	
	
	public static MorseTree biuldTree(String fName,MorseTree m) {
		try {
			File file1=new File(fName);//creates file object
		
			Scanner scan=new Scanner(file1);//creates file scanner object
			String line=" ";
			int count=0;
			while(scan.hasNext()) {//loops while file has data
				
			line=scan.nextLine();//reads line
			
			String signal=line.substring(2);//reads respective morse code signal
			
			m.add(line.charAt(0),signal);//adds characters from  line to binary tree
			

			}
			
		}catch (Exception e) {//informs user if any errors occur in reading file
			System.out.println("Readin file error");
		
		}
		
       return m;
		
	}
	/*
	 * @param String array and MorseTree
	 * 
	 * Scans file line by line and places each character at respective position in binary tree
	 */
	private static void decode(String[] arr,MorseTree m) {
		StringBuilder sb=new StringBuilder();//String builder object
		try {
		for(int i=0;i<arr.length;i++) {//loops through array
			m.decode(m, arr[i],sb);//decodes each code in array of input
		}
		
		System.out.println("messege is : "+sb.toString());//displays decoded message
		System.out.println("  ");
		}catch(NullPointerException x) {//informs user if code entered is not found
			System.out.println("Code not Found");
		}
	}
	}