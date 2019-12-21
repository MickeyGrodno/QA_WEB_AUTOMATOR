package Task2;

import org.junit.Assume;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

public class UnstableTest {
  
  @Rule
  public TestRule runTwiceRule = new RunTwiceRule();
  
  private int attempt = 1;

  @Test
  @Unstable(20)
  public void randomlyFailingTest() {
    attempt++;
    Assume.assumeTrue(attempt-1 == 10);
  }
}
