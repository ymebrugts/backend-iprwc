package nl.iprwc.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Entity
@Table(name = "account")
public class Account {

    @Id
    @Column(name = "email", length=100, nullable = false)
    private String email;

    @Column(name = "password", length=32, nullable = false)
    private String password;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name = "is_admin", nullable = false)
    private boolean is_admin;

    /**
     * A no-argument constructor.
     */
    public Account() {
    }


    public Account(String email , String password , boolean is_admin ) {
        this.email = email;
        this.password = password;
        this.is_admin = is_admin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }
}