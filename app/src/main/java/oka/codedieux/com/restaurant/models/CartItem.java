package oka.codedieux.com.restaurant.models;

/**
 * Created by meliodas on 16/09/2019.
 */

public class CartItem {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
