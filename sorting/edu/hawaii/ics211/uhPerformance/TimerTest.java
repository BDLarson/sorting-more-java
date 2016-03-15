package edu.hawaii.ics211.uhPerformance;

import org.junit.Test;

public class TimerTest {

  @Test
  public void testBasicTimer() {
    Timer timer = new Timer("First test");
    timer.start();
    timer.stop();

    org.junit.Assert.assertTrue("The timer is positive", timer.getDurationNs() > 0);

    System.out.println("Duration of [" + timer.getDescription() + "] in ns = " + timer.getDurationNs());
  }


  @Test (expected = RuntimeException.class)
  public void testStartTimerWhenAlreadyRunning() {
    Timer timer = new Timer("Test");
    timer.start();
    timer.start();
  }


  @Test (expected = RuntimeException.class)
  public void testStopTimerWhenNotRunning() {
    Timer timer = new Timer("Test");
    timer.stop();
  }


  @Test
  public void testTimerTwice() {
    Timer timer1 = new Timer("Test once");
    timer1.start();
    timer1.stop();

    Timer timer2 = new Timer("Test twice");
    timer2.start();
    timer2.stop();
    timer2.start();
    timer2.stop();

    org.junit.Assert.assertTrue("The timer is positive", timer1.getDurationNs() > 0);
    org.junit.Assert.assertTrue("The timer is positive", timer2.getDurationNs() > 0);

    System.out.println("Duration of [" + timer1.getDescription() + "] in ns = " + timer1.getDurationNs());
    System.out.println("Duration of [" + timer2.getDescription() + "] in ns = " + timer2.getDurationNs());
  }



}
