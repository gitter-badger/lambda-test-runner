package uk.co.automatictester.lambdatestrunner;

import org.testng.annotations.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.testng.Assert.assertEquals;

public class ProcessRunnerTest {

    @Test
    public void testRunProcess() {
        List<String> command = Arrays.asList("./mvnw", "clean", "test", "-Dtest=SmokeTest");
        File workDir = new File(System.getProperty("user.dir"));
        ProcessResult processResult = ProcessRunner.runProcess(command, workDir);
        assertEquals(processResult.getExitCode(), 0);
        assertThat(processResult.getOutput(), containsString("Running uk.co.automatictester.lambdatestrunner.SmokeTest"));
        assertThat(processResult.getOutput(), containsString("Tests run: 1, Failures: 0, Errors: 0, Skipped: 0"));
    }
}
