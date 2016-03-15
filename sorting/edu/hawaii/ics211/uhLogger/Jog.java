package edu.hawaii.ics211.uhLogger;
import java.util.ArrayList;
import java.util.HashMap;



/**
 * Java Log (Jog) facility that provides basic logging for debugging.
 *
 */
public class Jog {

  private static Logger                   logger = null;
  private static HashMap<Level, Boolean>  levels = new HashMap<Level, Boolean>();

  /**
   * Enable a specific logging level.
   * @param level Level of logging to enable.
   */
  public static void enableLevel(Level level) {
    levels.put(level, true);
  }

  /**
   * Disables a specific logging level.
   * @param level Log level to disable.
   */
  public static void disableLevel(int level) {
    levels.remove(level);
  }

  /**
   * Adds a logging facility.
   * @param logger Instance of a class that implements "Logger" interface.
   */
  public static void setLogger(Logger newLogger) {
    logger = newLogger;
  }

  /**
   * Logs DEBUG info.
   * @param msg Message to log.
   */
  public static void debug(String msg) {
    // Check if DEBUG logging is enabled.
    if (logger != null && levels.get(Level.DEBUG) != null) {
      logger.log(Level.DEBUG, logger.prefix(Level.DEBUG) + msg);
    }
  }

  /**
   * Logs INFO messages.
   * @param msg Message to log.
   */
  public static void info(String msg) {
    if (logger != null && levels.get(Level.INFO) != null) {
      logger.log(Level.INFO, logger.prefix(Level.INFO) + msg);
    }
  }

  /**
   * Logs WARNing info.
   * @param msg Message to log.
   */
  public static void warn(String msg) {
    if (logger != null && levels.get(Level.WARN) != null) {
      logger.log(Level.WARN, logger.prefix(Level.WARN) + msg);
    }
  }

  /**
   * Logs ERROR info.
   * @param msg Message to log.
   */
  public static void error(String msg) {
    if (logger != null && levels.get(Level.ERROR) != null) {
      logger.log(Level.ERROR, logger.prefix(Level.ERROR) + msg);
    }
  }

  /**
   * Prings the current content of a log.
   *
   * Dumps the current contents of a log to the console or does nothing if the
   * logger doesn't support this.
   */
  public static void printLog() {
    logger.print();
  }

  /**
   * Dumps the current runtime stack as a DEBUG-level log.
   */
  public static void dumpStack() {
    for (StackTraceElement ste : Thread.currentThread().getStackTrace()) {
      logger.log(Level.DEBUG, ste.toString());
    }
  }

}
