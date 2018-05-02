/*
 * Name: Kashyapkumar Trivedi
 * CS Account: ktrivedi
 * Net Id: ktrive4
 * Assignment: Fifth Homework Assignment
 * Group Members: Conrad Markiewicz & Jay Patel
 * UIN: 660657541
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.plaf.TextUI;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JToolBar;
import javax.swing.JSplitPane;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;


public class ExamBuilder 
{
	private static JFrame frame; //Private static Jframe out of main
	private static Scanner s1; //Private static scanner out of main
	private static Exam exambuild = new Exam("Software Design"); //Private static main out of main
	private JTextField textField; ////Private static JTextField out of main
	
	
	public static void main(String[] args) 
	{
		
		File f = new File("ExamDataFile.txt"); //To load the exam in this file
		frame = new JFrame(); //create a new JFrame
		frame.getContentPane().setBackground(SystemColor.textHighlight); //for the text color highlight
		frame.getContentPane().setForeground(Color.BLACK); //It will show as BLACK
		frame.setBounds(100, 100, 1000, 1000); //Set the bounds to show in appropriate size
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Exit if it hit the red X to close on the screen
		frame.getContentPane().setLayout(null); //The layout to be null
		
		JLabel lblExamTime = new JLabel("Exam Time"); //Create a JLabel to show the title to the user
		lblExamTime.setFont(new Font("Arial", Font.BOLD, 22)); //To set the font
		lblExamTime.setBounds(289, 35, 152, 29); //Set the bounds to show it appropriate to the screen
		frame.getContentPane().add(lblExamTime); //To add the JLabel to the frame
		
		
		JLabel lblNewLabel = new JLabel("1. Load the exam"); //Did the same as the first JLabel.
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(39, 98, 126, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("2. Add questions"); //Did the same as the first JLabel.
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setBounds(39, 163, 126, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("3. Remove questions"); //Did the same as the first JLabel.
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setBounds(39, 224, 152, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("4. Reorder Questions"); //Did the same as the first JLabel.
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3.setBounds(39, 290, 152, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblPrintThe = new JLabel("5. Print the Exam"); //Did the same as the first JLabel.
		lblPrintThe.setFont(new Font("Arial", Font.BOLD, 14));
		lblPrintThe.setBounds(39, 354, 136, 16);
		frame.getContentPane().add(lblPrintThe);
		
		JLabel lblSaveThe = new JLabel("6. Save the Exam"); //Did the same as the first JLabel.
		lblSaveThe.setFont(new Font("Arial", Font.BOLD, 14));
		lblSaveThe.setBounds(39, 411, 126, 16);
		frame.getContentPane().add(lblSaveThe);
		
		JLabel lblQuit = new JLabel("7. Quit"); //Did the same as the first JLabel.
		lblQuit.setFont(new Font("Arial", Font.BOLD, 14));
		lblQuit.setBounds(39, 464, 61, 16);
		frame.getContentPane().add(lblQuit);
		
		
		
		JButton btnClickToLoad = new JButton("LOAD!!"); //Made a button for the JLabel 1.
		btnClickToLoad.setFont(new Font("Arial", Font.BOLD, 13)); //font
		btnClickToLoad.setBounds(289, 93, 126, 29); //set the bounds for the JLabel
		frame.getContentPane().add(btnClickToLoad); //add the button to the frame
		
		JTextArea textArea = new JTextArea(); //Did the same as the first JLabel.
		textArea.setForeground(new Color(255, 69, 0)); //Selected the color for the JTextArea it should show the little blue on the screen
		textArea.setBounds(486, 93, 508, 392); //Set the bounds for it
		frame.getContentPane().add(textArea); //Add it to the frame
		textArea.setBackground(Color.DARK_GRAY); //Made a textArea to show what it happens when each buttons is being pressed
		textArea.setVisible(true); //To show it on the screen, have to make it setVisible(true)
					
		btnClickToLoad.addActionListener(new ActionListener() //Have to use addActionListener to work on inside the buttons
		{
			public void actionPerformed(ActionEvent e) //Action performed for the addActionListener
			{		
				try //have to use try and catch since we are dealing with the files
				{
					s1 = new Scanner(f); //new scanner
					  
				} 
				catch (FileNotFoundException e2)  //Catch
				{
					e2.printStackTrace();
					
				}
				exambuild = new Exam(s1); //Make a new exam according to the scanner
				
				exambuild.print(textArea); //print the exam with textArea to show loading it for file
			   
			}
		});
		
		
		JButton btnClickToAdd = new JButton("ADD!!"); //Made a button for the JLabel 2.
		btnClickToAdd.setFont(new Font("Arial", Font.BOLD, 13));
		btnClickToAdd.setBounds(289, 158, 126, 29);
		frame.getContentPane().add(btnClickToAdd);
		btnClickToAdd.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				textArea.setText(null); //Set it to null to show the blank in the screen
				int addQuestion = Integer.parseInt(JOptionPane.showInputDialog(null, "There are 4 types of questions in this exam which are: \n\n 1.SAQuestion\n 2.MCSAQuestion\n"
						+ " 3.MCMAQuestion\n 4.NumQuestion\n\n Which Question would you like to add?")); //The dialog box to the user
				// int addingQuestion = Integer.parseInt(addQuestion);

				  switch(addQuestion) //for the input of the user
				  {
					  case 1: //For the SAQuestion
						  
						 // System.out.println("1.SAQuestion");
						 // Scanner s2 = new Scanner(System.in); //user input
						 // System.out.println("Please enter the question text: ");
						//  String saques = s2.nextLine(); //for the question
						  
						  String saques = JOptionPane.showInputDialog(null, "Please enter the question text: "); //String of Dialog box to get the question
						 // System.out.println("Please enter the question value: ");
						  //Double d = s2.nextDouble(); //for the points for the question
						  //s2.nextLine();
						 // System.out.println("Please enter the correct answer: ");
						  //String a = s2.nextLine(); //the correct ans
						  
						  double d = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter the question value: ")); //Double of Dialog box to get the question value
						  String a = JOptionPane.showInputDialog(null, "Please enter the right answer: "); //String of Dialog box to get the right answer
						  
						  SAQuestion qa=new SAQuestion(saques, d); //For the new SAQuestion
						  SAAnswer saa = new SAAnswer(a); //For the new SAAnswer
						  qa.setRightAnswers(saa); //set the right answer
						  exambuild.addQuestion(qa); //add the question
						  
						  
						  
						  
						  break;
		
						  
					  case 2://For the MCSAQuestion
						  
						  
						  String mcsaques = JOptionPane.showInputDialog(null, "Please enter the question text: "); //String of Dialog box to get the question
						  double d1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter the question value: ")); //Double of Dialog box to get the question value
						  MCSAQuestion qb=new MCSAQuestion(mcsaques, d1); //new MCSAQuestion
						  int ab = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of options for answer: ")); //to get the options according to the user's choice
						  int done2 = 0; //set it equal to 0 first
						 
						  while (done2 < ab) //so the user input is greater then 0
						  {
							  String mcsa = JOptionPane.showInputDialog(null, "Please enter a possible answer: "); //String of Dialog box to get the possible answer
							  double d2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter its value: ")); //Double of Dialog box to get its value
							  MCSAAnswer mcsaa = new MCSAAnswer(mcsa, d2); //new MCSAAnswer
							  qb.addAnswer(mcsaa); //add the answer
							  done2++; //increment it so we can all the options
						  }
						  exambuild.addQuestion(qb); //add the question
						  
						  break;
						  
					  case 3: //For the MCMAQuestion
						  
						  String mcmaques = JOptionPane.showInputDialog(null, "Please enter the question text: ");  //String of Dialog box to get the question
						  double d2 = Double.parseDouble(JOptionPane.showInputDialog( "Please enter the question value: ")); //Double of Dialog box to get the question value
						  int  d4 = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of options for answer: ")); //to get the options according to the user's choice
						  double d3 = Double.parseDouble(JOptionPane.showInputDialog("Please enter the question base value: ")); //Double of Dial log Box to get the base credit
						  MCMAQuestion qc=new MCMAQuestion(mcmaques, d2, d3); //new MCMAQuestion
						  int done3 = 0; //set it equal to 0 first
						 
						  while(done3 < d4) //so the user input is greater then 0
						  {
							  String mcma = JOptionPane.showInputDialog(null, "Please enter the answer text: "); //String of Dialog box to get the answer
							  double d44 = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter the answer value: ")); //Double of Dialog box to get its value
							  MCMAAnswer mcmaa = new MCMAAnswer(mcma, d44); //new MCMAAnswer
							  qc.addAnswer(mcmaa); //add the answer
							  done3++; //increment it so we can all the options
						  }
						  exambuild.addQuestion(qc); //add the question
						 
						  break;
					
						  
					  case 4:  //For the NumQuestion
						  String numques = JOptionPane.showInputDialog(null, "Please enter the question text: "); //String of Dialog box to get the question
						  double d5 = Double.parseDouble(JOptionPane.showInputDialog( "Please enter the question value: ")); //Double of Dialog box to get the question value
						  double d6 = Double.parseDouble(JOptionPane.showInputDialog("Please enter the tolerance: ")); //to get the tolerance value
						  double s7 = Double.parseDouble(JOptionPane.showInputDialog("Please enter the right answer: ")); //to get the right answer
						 
				//		  NumQuestion qd = new NumQuestion(numques, d5, d6); //new NumQuestion
						  NumAnswer numa = new NumAnswer(s7); //get the NumAnswer
					//	  qd.setRightAnswers(numa); //get the answer
					//	  exambuild.addQuestion(qd); //add the question
						
						  break;
					
				  }
			
			}
		});
		
		JButton btnClickToRemove = new JButton("REMOVE!!"); //Made a button for the JLabel 3.
		btnClickToRemove.setFont(new Font("Arial", Font.BOLD, 13));
		btnClickToRemove.setBounds(289, 219, 126, 29);
		frame.getContentPane().add(btnClickToRemove);
		btnClickToRemove.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				textArea.setText(null); //Set it to null to show the blank in the screen
				String userInput = JOptionPane.showInputDialog(null, "Which questions would you like to remove? Enter -999 to stop"); //to get the userInput for the remove questions
				int num = Integer.parseInt(userInput); //to convert from string to integer
				
				exambuild.removeQuestion(num - 1); //call the method removeQuestion from the exam class - 1 to remove it
				
				exambuild.print(textArea); //print it with textArea to the screen
				
			}
		});
		
		JButton btnClickToReorder = new JButton("REORDER!!"); //Made a button for the JLabel 4.
		btnClickToReorder.setFont(new Font("Arial", Font.BOLD, 13));
		btnClickToReorder.setBounds(289, 285, 126, 29);
		frame.getContentPane().add(btnClickToReorder);
		btnClickToReorder.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				exambuild.reorderQuestions();  //Reorder the Questions
				  
				exambuild.reorderMCAnswers(-1); //Reorder the answers
				
				exambuild.print(textArea); //print it with textArea to the screen
				
			}
		});
		
		JButton btnClickToPrint = new JButton("PRINT!!"); //Made a button for the JLabel 5.
		btnClickToPrint.setFont(new Font("Arial", Font.BOLD, 13));
		btnClickToPrint.setBounds(289, 349, 126, 29);
		frame.getContentPane().add(btnClickToPrint);
		btnClickToPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				textArea.setText(null); //Set it to null to show the blank in the screen
				
				exambuild.print(textArea); //print it with textArea to the screen
				
			}
		});
		
		JButton btnClickToSave = new JButton("SAVE!!"); //Made a button for the JLabel 6.
		btnClickToSave.setFont(new Font("Arial", Font.BOLD, 13));
		btnClickToSave.setBounds(289, 407, 126, 29);
		frame.getContentPane().add(btnClickToSave);
		btnClickToSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				PrintWriter p; //To print write
				try {
					p = new PrintWriter("makeExam.txt"); //To save in this file
					exambuild.save(p); //save it 
					  p.close(); //then close it
					System.out.print("\nSaving!!!\n");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} //write in the file
			      
			}
		});
		
		JButton btnGiveUp = new JButton("GIVE UP!!"); //Made a button for the JLabel 7.
		btnGiveUp.setFont(new Font("Arial", Font.BOLD, 13));
		btnGiveUp.setBounds(289, 459, 126, 29);
		frame.getContentPane().add(btnGiveUp);
		btnGiveUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); //Exit if pressed this button
			}
		});
		frame.setVisible(true); //make it visbible so we see the frame since we added all to the frame
	}
}
