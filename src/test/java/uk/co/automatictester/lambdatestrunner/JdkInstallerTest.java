package uk.co.automatictester.lambdatestrunner;

import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JdkInstallerTest {

//    @Test
    public void testInstallJdk() {
        ProcessResult processResult = JdkInstaller.installJdk();
        Path path = Paths.get(System.getenv("JAVA_HOME"));
        assertEquals(processResult.getExitCode(), 0);
        assertTrue(Files.exists(path));
    }
}