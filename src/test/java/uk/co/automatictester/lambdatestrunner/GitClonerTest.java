package uk.co.automatictester.lambdatestrunner;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.testng.Assert.assertTrue;

public class GitClonerTest {

    private static final File REPO_DIR = new File(System.getProperty("REPO_DIR"));

    @BeforeMethod
    public void deleteDir() throws IOException {
        FileUtils.deleteDirectory(REPO_DIR);
    }

    @Test
    public void testCloneRepo() {
        String repoUri = "https://github.com/automatictester/lambda-test-runner.git";
        String branch = "master";
        GitCloner.cloneRepo(repoUri, branch, REPO_DIR);

        String readmeFile = REPO_DIR.toString() + "/README.md";
        Path path = Paths.get(readmeFile);
        assertTrue(Files.exists(path));
    }

    @Test
    public void testCloneRepoCheckoutNonDefaultBranch() {
        String repoUri = "https://github.com/automatictester/lambda-test-runner.git";
        String branch = "unit-testing";
        GitCloner.cloneRepo(repoUri, branch, REPO_DIR);

        String branchSpecificUnitTest = REPO_DIR.toString() + "/src/test/java/uk/co/automatictester/lambdatestrunner/YetAnotherSmokeTest.java";
        Path path = Paths.get(branchSpecificUnitTest);
        assertTrue(Files.exists(path));
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void testCloneRepoEx() {
        String repoUri = "https://github.com/automatictester/lambda-test-runner-2.git";
        String branch = "master";
        GitCloner.cloneRepo(repoUri, branch, REPO_DIR);
    }
}
