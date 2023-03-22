package edu.ilstu;

import java.io.File;

import java.io.Serializable;
import java.util.Scanner;

/*
 * @author suhail Pradip Tailor
 * 
 * This code contains a morseTree methods
 * 
 * 
 */




public class MorseTree implements Serializable {
	protected boolean added;//variables declared
	protected Node root=null;
	/*@param none
	 *default constructor
	 * 
	 */
 public MorseTree() {
	 this.root=null;//sets tree root to null
	
 }
    /*@param initial Node 
	 * constructor
	 * 
	 */
 public MorseTree(Node root) {
	 this.root=root;//sets input node as root of tree
 }
    /*@param char data ,right and left MorseTree
	 *overloaded constructor
	 * 
	 */
 public MorseTree(char data,MorseTree leftTree, MorseTree rightTree) {
		this.root=new Node(data);//sets root
		if(leftTree!=null)
		this.root.left=leftTree.root;//sets left root
		if(rightTree!=null)
		this.root.right=rightTree.root;//sets right root
		
	}
 
 
    /*@param char data to be placed and String signal
	 * adds item to binary tree
	 * @return void
	 */
 public void add(char item,String signal) {
	
		
	this.root=recur(root,item,signal);//calls recurring method to add item to tree
		
		
	}
    /*@param char data Starting Node and String signal
	 * adds item to binary tree
	 * @return Node
	 */
	
	private Node recur(Node start,char item,String signal) 
	{ 
		if(signal!=null)	//checks if signal is empty
		{
	
		 if(start==null)//checks if Node is empty
		{

			return new Node(item);// returns new node with item
			
		}
		
	
		if (signal.substring(0, 1).equals("."))//checks signal for . 
	{   
	

			start.left= recur(start.left,item,signal.substring(1));//passes in start .left as next starting node and calls recurring method
			return start;//returns node 
		
	}
		else if (signal.substring(0, 1).equals("-"))//checks signal for -
	{ 

	start.right= recur(start.right,item,signal.substring(1));//passes in start .right as next starting node and calls recurring method
		return start;//returns node 
	}
	
		}
		
		return start;//returns node 
	}

 
	
	

/*
 * 
 * @param MorseTree ,String to check and String builder
 * @return String builder
 * 
 * Decodes the passed in Morse code
 *
 *
 *
 */
public StringBuilder decode(MorseTree m,String s,StringBuilder sb) {
	
	
	decoder(root,s,sb);//calls recursive method
	return sb;//return string builder
}
/*
 * 
 * @param Starting Node ,String to check and String builder
 * @return void
 * 
 * recursive method that decodes morse code string
 *
 *
 *
 */
private void decoder(Node start,String s,StringBuilder sb) {
	{		
	Node curr=start;//tracker node points to root of tree
	if(s.length()>=1) {//runs while string has values
	if(start==null) {//checks if node is empty
		sb.append("null");//adds null to String builder
		
	}
	else if(s.charAt(0)=='.') {//runs if first character matches .
		
        curr=start.left;//moves pointer
		decoder(start.left,s.substring(1),sb);//calls recursive decode method with new pointer passed as start
	}else if(s.charAt(0)=='-') {//runs if first character matches -
		
 curr=start.right;//moves pointer
		decoder(start.right,s.substring(1),sb);//calls recursive decode method with new pointer passed as start
	}

	}else//if end of String is reached
		sb.append(curr.data);//adds Pointers data to string builder
	}
}










	
	/*
	 * 
	 * 
	 * @param String file name
	 * @return String array
	 * Reads each line in given file and places it into array
	 * 
	 */
	
	
 
	/*
	 * 
	 * 
	 * Node class
	 * creates and declares Node variables and constructors
	 */
	
 
protected class Node implements Serializable{

	protected Node left;//Node on left of root
	protected Node right;//Node on right of root
	protected char data;//data stored
	/*
	 * 
	 * @param none
	 * @return none
	 * Default constructor
	 */
	
	public Node() {
		
	}
	/*
	 * 
	 * @param character to be stored
	 * @return none
	 * constructor
	 */
	
	public Node (char data) {
		this.data=data;//sets data
	}
	/*
	 * 
	 * @param character to be stored and start Node
	 * @return none
	 * overloaded constructor
	 */
	
	public Node (Node root,char data) {
	
		this.data=data;//sets data
	}
    
	

	
}
}