package Task2;

import org.junit.Assert;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class RunTwiceRule implements TestRule {

  @Override
  public Statement apply(Statement base, Description desc) {
    return new RunTwiceStatement(base, desc);
  }

  public class RunTwiceStatement extends Statement {

    private final Statement base;
    private Description desc;

    public RunTwiceStatement(Statement base, Description desc) {
      this.base = base;
      this.desc = desc;
    }

    @Override
    public void evaluate() throws Throwable {
      Unstable unstable = desc.getAnnotation(Unstable.class);
      if (unstable != null) {
        for (int iteration = 1; iteration <= unstable.value(); iteration++) {
          System.out.println("Итерация №" + iteration);
          try {
            base.evaluate();
            System.out.println("Тест пройден");
            break;
          } catch (Exception error) {
            if (iteration == unstable.value()) {
              Assert.fail("Тест не пройден");
            }
          }
        }
      }
    }
  }
}
