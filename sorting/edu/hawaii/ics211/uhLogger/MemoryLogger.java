package edu.hawaii.ics211.uhLogger;

public class MemoryLogger implements Logger {
  private static final int    DEFAULT_LOG_SIZE = 10;

  private String[]            messages;
  private int                 logSize;
  private int                 pos = 0;
  private boolean             wrapped = false;

  MemoryLogger() {
    logSize = DEFAULT_LOG_SIZE;
    messages = new String [logSize];
  }

  MemoryLogger(int logSize) {
    this.logSize = logSize;
    this.messages = new String [logSize];
  }

  public void log(Level level, String msg) {
    messages[pos] = msg;

    pos++;
    if (pos == logSize) {
      wrapped = true;
      pos = 0;
    }
  }

  public String prefix(Level level) {
    return "[" + level.toString() + "] ";
  }


  public void print() {
    int currentPosition = 0;

    if (wrapped == true) {
      currentPosition = (pos + 1) % logSize;
    }

    while (currentPosition != pos) {
      System.out.println(messages[currentPosition]);
      currentPosition = (currentPosition + 1) % logSize;
    }

    if (wrapped) {
      System.out.println(messages[pos]);
    }


  }

  public int getLogSize() {
    return logSize;
  }
}

