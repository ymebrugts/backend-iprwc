package nl.iprwc.model;

import javax.persistence.*;

import java.util.List;
@Entity
@Table(name = "product")
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length=100, nullable = false)
    private String name;

    @Column(name = "description", length = 500, nullable = false)
    private String description;

    @Column(name = "price_cents", nullable = false)
    private int price_cents;

    /**
     * A no-argument constructor.
     */
    public Product() {
    }


    public Product(int id, String name, String description, int price_cents) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price_cents = price_cents;
    }

    public int getId() {
        return id;
    }

    public void setName(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice_cents() {
        return price_cents;
    }

    public void setPrice_cents(int price_cents) {
        this.price_cents = price_cents;
    }
}
