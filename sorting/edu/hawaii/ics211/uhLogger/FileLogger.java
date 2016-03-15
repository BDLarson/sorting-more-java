package edu.hawaii.ics211.uhLogger;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class FileLogger implements Logger {
	String fileName = ""; //Declaring the fileName String, and what the file is
	FileWriter fW;
	BufferedWriter bW;
	FileReader fR = new FileReader("LogFile");
	BufferedReader bR = new BufferedReader(fR);
	
	/** Constructs a FileLogger to create a new text file and allows it to be written to
	 * @param fN The text file name that is being written to.
	 * @throws IOException If the file name is not found or doesn't exist
	 */
	public FileLogger(String fN) throws IOException {
		try{
			this.fileName = fN;
			fW = new FileWriter(fN);
			bW = new BufferedWriter(fW);
			}
		catch (IOException e) {
			System.out.println("There is an error");
			}
	}
	
	/** Allows the user to implement a message and writes it to a text file
	 * @param logLevel Determines what Level the message will be stored under
	 * @param msg The message that which is being written to the text file
	 */
	public void log(Level logLevel, String msg){
		try {
			bW.write("[" + logLevel +"]" + msg); //Writes the first message
			bW.newLine(); //Then tabs down a line to start over
			} 
		catch (IOException e) {
			System.out.println("There is an error");
			}	
		 
	}
	
	/** Provides an implementation to optionally prefix a log entry with informative info.
	 * @param Level The Level that is being prefixed
	 */
		public String prefix(Level logLevel) {
		return (" "); //Returns an empty String
	}

	/** Prints the current content of the log file to the console
	 */
	public void print() {	
		
		try {
			bW.close(); //Closes the buffered reader, in order to not cause an infinite loop
			} 
		catch (IOException e) {
			System.out.println("There is an error");
		}
		
		try{
			Scanner scan = new Scanner(new FileReader(fileName)); //Creates a scanner to read the text file
			while(scan.hasNextLine()){ //Checks whether there are tokens on each line
				String i = scan.nextLine(); //Creates a String variable for each token read
				System.out.println(i + " ");
				}
			
			scan.close(); //Closes the scanner
			}
		catch(IOException e){		
			System.out.println("There is an error");
			}		
	}
}
