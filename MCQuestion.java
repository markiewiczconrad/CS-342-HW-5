/*
 * Name: Kashyapkumar Trivedi
 *  CS Account: ktrivedi
 * Net Id: ktrive4
 * Assignment: Third Homework Assignment
 * UIN: 660657541
 */

import java.io.PrintWriter;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Scanner;

import javax.swing.JTextArea;

public abstract class MCQuestion extends Question //Extends because it has sub trees
{
	
	protected ArrayList<MCAnswer>questions2 = new ArrayList<MCAnswer>(); //Protected arraylist of type MCAnswer
	
	
	public  MCQuestion(String text, double maxValue) 
	{
		super(text, maxValue); //Constructor that sets the string and the double
		maxValue = maxValue;
	}
	protected MCQuestion(Scanner quesFile)
	{
		super(quesFile); //from the parents
	}

	public void print()  //This will print
	{
		super.print();
		
		System.out.print("\n");	
		
		char c = 'A'; //For the options
		
		for(int i = 0; i < questions2.size() ; i++)  //Checks the whole array
		{
				System.out.print(c);
			    
				questions2.get(i).print();
			    
				c++;	
		}	
		System.out.println("\n\n");
	}
	public void print(JTextArea area)  //This will print
	{
		super.print(area);
		
		//System.out.print("\n");	
		
		char c = 'A'; //For the options
		
		for(int i = 0; i < questions2.size() ; i++)  //Checks the whole array
		{
				area.append(c + " ");
			    
				questions2.get(i).print(area);
			    
				c++;	
		}	
		System.out.println("\n\n");
		area.append("\n");
	}
	
	
	public void addAnswer(MCAnswer mcans) //This will add the answer in the arraylist
	{
		
		questions2.add(mcans);
		
	}
		
	public void reorderAnswers()  //This will reorder the ans
	{	
		Collections.shuffle(questions2); //Shuffles the whole array

	}
	public double getValue(MCAnswer ans) 
	{
		return 1.0;
	}
	
	public void save(PrintWriter writeInFile) 
	{
		
		writeInFile.print("\n"); //print the space, maxvalue, space, and the text
		
		writeInFile.print(maxValue);
		
		writeInFile.print("\n");
		
		writeInFile.print(text);
		
	}
}



