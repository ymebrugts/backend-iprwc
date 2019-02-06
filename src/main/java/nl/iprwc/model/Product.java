package nl.iprwc.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

import java.util.List;
@Entity
@Table(name = "product")
public class Product {

    @Id
    @JsonProperty
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonProperty
    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @JsonProperty
    @Column(name = "description", length = 500, nullable = false)
    private String description;

    @JsonProperty
    @Column(name = "price_cents", nullable = false)
    private int priceCents;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", priceCents=" + priceCents +
                '}';
    }
}
