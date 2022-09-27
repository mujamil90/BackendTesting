package org.api.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static org.apache.commons.lang3.StringUtils.repeat;

/**
 * @author mohammadmuzzamil
 *
 *
 * This Test listener listens on Test start, failure, skip and finish. For the time being we are just logging
 * some steps on above ponits.
 */

public class TestListener implements ITestListener {

    private static final Logger LOGGER = LogManager.getLogger (TestListener.class);

    private void logMessage (final String message) {
        this.LOGGER.info ("\n");
        this.LOGGER.info (repeat ("=", 75));
        this.LOGGER.info (message);
        this.LOGGER.info (repeat ("=", 75));
        this.LOGGER.info ("\n");
    }

    @Override
    public void onTestStart (final ITestResult result) {
        logMessage ("Test Execution Started is started for '" + result.getName ()+"' ...");
    }

    @Override
    public void onTestSuccess (final ITestResult result) {
        logMessage ("Test Case '"+ result.getName () + "' is passed successfully." );

    }

    @Override
    public void onTestFailure (final ITestResult result) {
        logMessage ("Test case '" + result.getName ()+ "' is Failed !!!");
    }

    @Override
    public void onFinish (final ITestContext context) {
        logMessage ("Test execution is completed successfully for all tests '" +context.getSuite ().getAllMethods ()+ "' !!!" );
    }

}