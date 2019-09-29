package info.hayslip.AlertHoarder.models;

import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Document(collection = "alertCollection")
public class Alert {

    @Id
    private String alertId;
    @NotNull
    @NotBlank
    private String originator;
    @NotNull
    @NotBlank
    private String message;
    @NotNull
    @NotBlank
    private String priority;
    private String alias;
    @Range(min = 1, max = 10, message = "Please select values between 1 and 10 Only")
    private int howActionable;
    private boolean isAcknowledged;
    private Date timeAlerted;
    private Date timeAcknowledged;
    @NotNull
    @NotBlank
    private Set<String> appIds;

    public Alert(String originator, String message, String priority, Set<String> appIds) {
        this.alertId = java.util.UUID.randomUUID().toString();
        this.originator = originator;
        this.message = message;
        this.priority = priority;
        this.howActionable = 5;
        this.isAcknowledged = false;
        this.timeAlerted = new java.util.Date();
        this.appIds = appIds;
    }

    public String getAlertId() {
        return alertId;
    }

    public String getOriginator() {
        return originator;
    }

    public String getMessage() {
        return message;
    }

    public String getPriority() {
        return priority;
    }

    public String getAlias() {
        return alias;
    }

    public int getHowActionable() {
        return howActionable;
    }

    public boolean isAcknowledged() {
        return isAcknowledged;
    }

    public Date getTimeAlerted() {
        return timeAlerted;
    }

    public Date getTimeAcknowledged() {
        return timeAcknowledged;
    }

    public Set<String> getAppIds() {
        return appIds;
    }
}
