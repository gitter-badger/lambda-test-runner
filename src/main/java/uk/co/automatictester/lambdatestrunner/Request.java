package uk.co.automatictester.lambdatestrunner;

public class Request {

    private String repoUri;
    private String command;

    public String getRepoUri() {
        return repoUri;
    }

    public void setRepoUri(String repoUri) {
        this.repoUri = repoUri;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
