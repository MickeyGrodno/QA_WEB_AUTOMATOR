package listeners;

import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.engine.reporting.ReportEntry;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;
import org.junit.platform.launcher.TestPlan;
import org.apache.log4j.Logger;

public class TestListenerJU5 implements TestExecutionListener {
    Logger logger = Logger.getLogger(TestListenerJU5.class);

    @Override
    public void testPlanExecutionStarted(TestPlan testPlan) {
        logger.info("Test testPlanExecutionStarted");
    }

    @Override
    public void testPlanExecutionFinished(TestPlan testPlan) {
        logger.info("Test testPlanExecutionFinished");
    }

    @Override
    public void dynamicTestRegistered(TestIdentifier testIdentifier) {
        logger.info("Test dynamicTestRegistered");
    }

    @Override
    public void executionSkipped(TestIdentifier testIdentifier, String reason) {
        logger.info("Test executionSkipped");
    }

    @Override
    public void executionStarted(TestIdentifier testIdentifier) {
        logger.info("Test executionStarted");
    }

    @Override
    public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
        logger.info("Test executionFinished");
    }

    @Override
    public void reportingEntryPublished(TestIdentifier testIdentifier, ReportEntry entry) {
        logger.info("Test reportingEntryPublished");
    }
}
