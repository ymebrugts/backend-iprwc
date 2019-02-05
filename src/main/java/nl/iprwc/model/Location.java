package nl.iprwc.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @JsonProperty
    @Column(name = "account_email", length = 100, nullable = false)
    private int accountEmail;

    @JsonProperty
    @Column(name = "street_name", length = 100, nullable = false)
    private String streetName;

    @JsonProperty
    @Column(name = "house_nr", length = 10, nullable = false)
    private String houseNr;

    @JsonProperty
    @Column(name = "zipcode", length = 10, nullable = false)
    private String zipcode;

    @JsonProperty
    @Column(name = "city", length = 50, nullable = false)
    private String city;

}
