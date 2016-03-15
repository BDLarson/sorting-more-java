package edu.hawaii.ics211.uhLogger;
/**
 * Logger interface.
 *
 * Defines a logging interface used by the Java Logger (Jog) class.
 */
interface Logger {
  /**
   * Logs a message string to the log.
   * @param logLevel Logging level message was logged as.
   * @param msg Message to be logged.
   */
  public void log(Level logLevel, String msg);

  /**
   * Provides an implemention to optionally prefix a log entry with informative info.
   *
   * This method is useful if time stamps, sequence numbers, thread iDs, etc. are 
   * desired to accompany log messages.  If no prefix is desired, this method 
   * should just return an empty string "".
   *
   * @param logLevel Logging level associated to the message prefix.
   * @return A prefix string or "" if nothing is provided by implementation.
   */
  public String prefix(Level logLevel);

  /**
   * Print the contents of log to console.
   */
  public void print();

}

