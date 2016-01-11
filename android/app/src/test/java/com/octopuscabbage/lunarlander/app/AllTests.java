package com.octopuscabbage.lunarlander.app;

import android.test.suitebuilder.TestSuiteBuilder;
import junit.framework.Test;

/**
 * Created by octopuscabbage on 1/10/16.
 */
public class AllTests {
    public static Test suite() {
        return new TestSuiteBuilder(AllTests.class).includeAllPackagesUnderHere().build();
    }
}
