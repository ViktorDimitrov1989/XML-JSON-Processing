package app.dto.viewModels;

import com.google.gson.annotations.Expose;

public class Seller {
    @Expose
    private String fullName;
    private String firstName;
    private String lastName;

    public Seller() {
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
