package edu.hawaii.ics211.uhLogger;

public class ConsoleLogger implements Logger {

	/**Allows the user to implement a message and writes it to the console
	 * @param logLevel Determines what Level the message will be stored under
	 * @param msg The message that which is being written to the console
	 */
	public void log(Level logLevel, String msg) {	
		System.out.println(msg); //Prints to the console
	}

	/**Provides an implementation to prefix a log entry with informative info.
	 * @param logLevel The logLevel that is being prefixed
	 */
	public String prefix(Level logLevel) {
		return ("[" + logLevel.toString() + "]" + " "); //[Brackets] the logLevel
	}

	/** Print the contents of log to console.
	 */
	public void print() {	
	}

}
