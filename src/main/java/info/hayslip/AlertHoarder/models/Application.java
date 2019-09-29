package info.hayslip.AlertHoarder.models;

import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Document(collection = "applicationCollection")
public class Application {

    @Id
    private String appId;
    @NotNull
    @NotBlank
    private String appName;
    @NotNull
    @NotBlank
    private String owner;

    public Application(@NotNull @NotBlank String appName, @NotNull @NotBlank String owner) {
        this.appId = java.util.UUID.randomUUID().toString();
        this.appName = appName;
        this.owner = owner;
    }

    public String getAppId() {
        return appId;
    }

    public String getAppName() {
        return appName;
    }

    public String getOwner() {
        return owner;
    }
}
