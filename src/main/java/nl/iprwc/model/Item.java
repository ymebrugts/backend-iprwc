package nl.iprwc.model;

import java.util.List;

public class Item {
    private String name;
    private String description;
    private int price_cents;

    public Item (String name, String description, int price_cents) {
        this.name = name;
        this.description = description;
        this.price_cents = price_cents;
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
