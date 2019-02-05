package nl.iprwc.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "deliver")
public class Deliver {

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

}
