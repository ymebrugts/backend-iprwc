package nl.iprwc.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "deliver")
public class Deliver implements Serializable {

    @Id
    @Column(name = "account_email", length = 100, nullable = false)
    @NotNull
    @JsonProperty
    private String accountEmail;

    @Id
    @Column(name = "product_id", nullable = false)
    @NotNull
    @JsonProperty
    private int productId;

    @Column(name = "amount", nullable = false)
    @NotNull
    @JsonProperty
    private int amount;

    public int getProductId() {
        return productId;
    }

    public String getAccountEmail() {
        return accountEmail;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
