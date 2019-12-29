import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginTest.class,
        CreateCouponTest.class,
        SearchAndDeleteCouponTest.class,
        LogOutTest.class
})
public class SuiteTest {
}
