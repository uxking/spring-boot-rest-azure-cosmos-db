package info.hayslip.AlertHoarder.models;


public class Application {

    private String applicationId;
    private String appName;

    public Application(String appName) {
        this.applicationId = java.util.UUID.randomUUID().toString();
        this.appName = appName;
    }

    public Application() {
    }

    public String getApplicationId() {
        return applicationId;
    }

    public String getAppName() {
        return appName;
    }
}
