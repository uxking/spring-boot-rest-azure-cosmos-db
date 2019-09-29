package info.hayslip.AlertHoarder.models;

import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Document(collection = "userCollection")
public class User {

    @Id
    private String userName;
    @NotNull
    @NotBlank
    private String password;
    @NotNull
    @NotBlank
    private String userRole;
    @AssertTrue
    private boolean isEnabled;

    public User(String userName, @NotNull String password, @NotNull String userRole, @AssertTrue boolean isEnabled) {
        this.userName = userName;
        this.password = password;
        this.userRole = userRole;
        this.isEnabled = isEnabled;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getUserRole() {
        return userRole;
    }

    public boolean getIsEnabled() {
        return isEnabled;
    }
}
