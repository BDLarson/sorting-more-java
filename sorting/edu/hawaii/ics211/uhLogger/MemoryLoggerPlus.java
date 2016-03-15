package edu.hawaii.ics211.uhLogger;

public class MemoryLoggerPlus extends MemoryLogger {

	int increment = 0;

	/** Constructs a MemoryLoggerPlus that inherits from MemoryLogger
	 * @param logSize The size of the storage for MemoryLoggerPlus
	 */
	public MemoryLoggerPlus(int logSize) { 
		super(logSize);
		  }
	
	/** Provides an implementation to override the prefix method to a log entry with informative info.
	 * @param Level The Level that is being prefixed
	 */
	public String prefix(Level level){ //Override the superclass method
		return ("[" + (increment++) + ":" + level.toString() + "] ");
	}
	
}
