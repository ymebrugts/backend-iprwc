package nl.iprwc.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.security.Principal;

@Entity
@Table(name = "account")
public class Account implements Principal {

    @Id
    @JsonProperty
    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "password", length = 32, nullable = false)
    @JsonProperty
    private String password;

    @JsonProperty
    @Column(name = "is_admin", nullable = false)
    private boolean is_admin;

    public String getPassword() {
        return password;
    }

    public String getName() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
